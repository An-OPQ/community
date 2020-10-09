document.writeln("<!--编辑弹出框-->");
document.writeln("<div class=\"modal fade\" id=\"mySearchModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">");
document.writeln("    <div class=\"modal-dialog\" role=\"document\">");
document.writeln("        <div class=\"modal-content\">");
document.writeln("            <div class=\"tbody\">");
document.writeln("                <div class=\"modal-header\">");
document.writeln("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span");
document.writeln("                            aria-hidden=\"true\">×</span></button>");
document.writeln("                    <h4 class=\"modal-title\" id=\"myEditModalLabel\"><span class=\"glyphicon glyphicon-search\"></span> 编辑");
document.writeln("                    </h4>");
document.writeln("                </div>");
document.writeln("                <div class=\"modal-body\">");
document.writeln("                    <div class=\"alert alert-info\" role=\"alert\">");
document.writeln("                        <strong>技巧提示：</strong>皆支持模糊搜索");
document.writeln("                    </div>");
document.writeln("                    <div>");
document.writeln("                        <div class=\"form-group\">");
document.writeln("                            <label for=\"username\">用户名</label>");
document.writeln("                            <input type=\"text\" class=\"form-control\" id=\"usernameBySearch\" placeholder=\"请输入用户名\" value=''/>");
document.writeln("                        </div>");
document.writeln("                        <div class=\"form-group\">");
document.writeln("                            <label for=\"email\">邮箱</label>");
document.writeln("                            <input type=\"text\" class=\"form-control\" id=\"emailBySearch\" placeholder=\"请输入邮箱\" value=''/>");
document.writeln("                        </div>");
document.writeln("                        <div class=\"form-group\">");
document.writeln("                            <label for=\"userRole\">用户角色</label>");
document.writeln("                            <select id=\"userRole\" class=\"form-control\" disabled>");
document.writeln("                                <option value=\"3\">用户</option>");
document.writeln("                            </select>");
document.writeln("                        </div>");
document.writeln("                    </div>");
document.writeln("                </div>");
document.writeln("                <div class=\"modal-footer\">");
document.writeln("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\"><span");
document.writeln("                            class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>关闭");
document.writeln("                    </button>");
document.writeln("                    <button type=\"button\" id=\"search\" class=\"btn btn-primary\" data-dismiss=\"modal\"><span");
document.writeln("                            class=\"glyphicon glyphicon-floppy-disk\" aria-hidden=\"true\"></span>查询");
document.writeln("                    </button>");
document.writeln("                </div>");
document.writeln("            </div>");
document.writeln("        </div>");
document.writeln("    </div>");
document.writeln("</div>");

$("#search").click(function () {
    searchUser(1)
})


function searchUser(pageNum) {
    var pageNo = 1;
    if (pageNum !== undefined) {
        pageNo = pageNum
    }
    var username = $("#usernameBySearch").val();
    var email = $("#emailBySearch").val();
    var userRole = $("#userRole option:selected").val();
    var json = {
        accountName: username,
        email: email,
        roleid: userRole,
        pageNo: pageNo
    }
    var jsonStr = JSON.stringify(json)
    $.ajax({
        url: "management/searchUser",
        type: "POST",
        data: jsonStr,
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            initTable(response.list)
            var pageObj = $(".pagination");
            pageObj.empty();
            var spliteStr = "";
            //判断是否为首页
            if (response.isFirstPage) {
                spliteStr += "<li class=\'disabled\'>\n" +
                    "   <a href=\"#\" aria-label=\"Previous\">\n" +
                    "      <span aria-hidden=\"true\">&lt;</span>\n" +
                    "    </a>\n" +
                    "</li>";
            } else {
                spliteStr += "<li onclick='searchUser(" + (response.pageNum - 1) + ")'>\n" +
                    "   <a href=\"#\" aria-label=\"Previous\">\n" +
                    "      <span aria-hidden=\"true\">&lt;</span>\n" +
                    "    </a>\n" +
                    "</li>";
            }

            for (let i = 1; i <= response.pages; i++) {
                if (response.pageNum == i) {
                    spliteStr += "<li class=\"active\">\n" +
                        "<a>" + i + "<span class=\"sr-only\">(current)</span></a>" +
                        " </li>";

                } else {
                    spliteStr += "<li onclick='searchUser(" + i + ")'><a href=\"#\">" + i + "</a></li>\n";
                }
            }
            if (response.isLastPage) {
                spliteStr += "<li class=\'disabled\'>\n" +
                    "   <a href=\"#\" aria-label=\"Previous\">\n" +
                    "      <span aria-hidden=\"true\">&gt;</span>\n" +
                    "    </a>\n" +
                    "</li>";
            } else {
                spliteStr += "<li onclick='searchUser(" + (response.pageNum + 1) + ")'>\n" +
                    "   <a href=\"#\" aria-label=\"Previous\">\n" +
                    "      <span aria-hidden=\"true\">&gt;</span>\n" +
                    "    </a>\n" +
                    "</li>";
            }
            pageObj.append(spliteStr);

        },
        error: function (response) {
            console.log(response)
        }
    })
}
