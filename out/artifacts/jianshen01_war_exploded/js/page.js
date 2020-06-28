function paging(type) {
    let pageNum = $.trim($("#pageNum").val()); // 当前页
    pageNum = pageNum == "" ? 1 : parseInt(pageNum);
    let pageSize = $("#pageSize").val(); // 一页几条
    pageSize = pageSize == "" ? 10 : parseInt(pageSize);
    let pageCount = $("#pageCount").html(); // 条数
    pageCount = pageCount == "" ? 0 : parseInt(pageCount);
    let totalPages = pageCount % pageSize != 0 ? Math.ceil(pageCount / pageSize) : (pageCount / pageSize);
    console.log("totalPages:" + totalPages);
    console.log("pageCount:" + pageCount);
    console.log("pageNum:" + pageNum);
    if (pageNum > totalPages) {
        pageNum = totalPages;
    }
    if (pageNum < 1) {
        pageNum = 1;
    }
    // console.log("最先pageNum:" + pageNum);
    switch (type) {
        case 'go':
            // console.log("点击go的pageNum:" + pageNum);
            break;
        case 'first':
            pageNum = 1;
            break;
        case 'previous':
            if (pageNum != 1) pageNum--;
            // console.log("向前pageNum:" + pageNum);
            break;
        case 'next':
            if (pageNum == totalPages ) pageNum=totalPages;
            else pageNum += 1;
            console.log("向后pageNum:" + pageNum);
            break;
        case 'end':
            pageNum = pageCount % pageSize != 0 ? Math.ceil(pageCount / pageSize) : (pageCount / pageSize);
            break;

    }
    // console.log("pagesize:" + pageSize);
    $("#pageSize").val(pageSize);
    $("#pageNum").val(pageNum);
    // $("#totalPage").val(totalPages);
    console.log("最后的pageNum:" + pageNum);
    console.log("=-===============================");
    find();
}