package com.cn.wanxi.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Upload extends HttpServlet {

    public String fileImg(HttpServletRequest req) {
        String savePath = "D:/step-four/jianshen01/out/artifacts/jianshen01_war_exploded";
        String imgPath = "/loadImg/";
        File file = new File(savePath + imgPath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String message = "";
        try {
            // 1.创建磁盘文件项工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            // 2. 创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
            upload.setHeaderEncoding("UTF-8");
            if (!ServletFileUpload.isMultipartContent(req)) {
                return "";
            }
            //4 使用ServletFileUpload解析器来解析上传数据，解析结果返回的是一个List<FileItem>
            //集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(req);

            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    stringBuilder.append(value + "@@");
                }else {
                    String fileName = fileItem.getName();
                    if (fileName == null || "".equals(fileName.trim())) {
                        continue;
                    }
                    // 获取文件名    如/a/b/c.txt  获取c.txt
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    // 获取item的输入流
                    InputStream inputStream = fileItem.getInputStream();
                    // 存入数据库的路径
                    String href = imgPath + fileName;
                    // 表示图片存储的路径
                    String imgurl = savePath + href;
                    stringBuilder.append(href + "@@");
                    FileOutputStream fileOutputStream = new FileOutputStream(imgurl);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流是否已经读完的标识
                    int len = 0;
                    while ((len = inputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    inputStream.close();
                    fileOutputStream.close();
                    fileItem.delete();
                    message = "文件上传成功";
                }

            }
        } catch (Exception e) {
            message = "文件上传失败";
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
