document.writeln("<nav class=\'navbar navbar-default\'>");
document.writeln("    <div class=\'container-fluid\'>");
document.writeln("        <div class=\'navbar-header\'>");
document.writeln("            <button type=\'button\' class=\'navbar-toggle collapsed\' data-toggle=\'collapse\'");
document.writeln("                data-target=\'#bs-example-navbar-collapse-1\' aria-expanded=\'false\'>");
document.writeln("                <span class=\'sr-only\'>Toggle navigation</span>");
document.writeln("                <span class=\'icon-bar\'></span>");
document.writeln("                <span class=\'icon-bar\'></span>");
document.writeln("                <span class=\'icon-bar\'></span>");
document.writeln("            </button>");
document.writeln("            <a class=\'navbar-brand\' href=\'main.html\'>首页</a>");
document.writeln("        </div>");
document.writeln("        <div class=\'collapse navbar-collapse\' id=\'bs-example-navbar-collapse-1\'>");
document.writeln("            <form class=\'navbar-form navbar-left\'>");
document.writeln("                <div class=\'form-group\'>");
document.writeln("                    <input type=\'text\' class=\'form-control\' placeholder=\'搜索\'>");
document.writeln("                </div>");
document.writeln("                <button type=\'submit\' class=\'btn btn-default\'>搜索</button>");
document.writeln("            </form>");
document.writeln("            <ul class=\'nav navbar-nav\'>");
document.writeln("                <li class=\'active\'><a href=\'#\'>技术<span class=\'sr-only\'>(current)</span></a></li>");
document.writeln("                <li><a href=\'#\'>学术</a></li>");
document.writeln("            </ul>");
document.writeln("            <ul class=\'nav navbar-nav navbar-right\'>");
document.writeln("                <li><a id=\'publish\' href=\'publish.html\'>发帖</a></li>");
document.writeln("");
document.writeln("                <li class=\'dropdown\'>");
document.writeln("                    <a id=\'dLabel\' href=\'#\' type=\'button\' data-toggle=\'dropdown\' aria-haspopup=\'true\'");
document.writeln("                        aria-expanded=\'false\'>admin<span class=\'caret\'></span>");
document.writeln("                    </a>");
document.writeln("                    <ul class=\'dropdown-menu\' aria-labelledby=\'dLabel\'>");
document.writeln("                        <li>");
document.writeln("                            <a id=\'config\' href=\'config.html\'>");
document.writeln("                                <span class=\'glyphicon glyphicon-cog\'></span>&nbsp;&nbsp;个人设置</a>");
document.writeln("                        </li>");
document.writeln("                        <li>");
document.writeln("                            <a href=\'profile_questions.html\'>");
document.writeln("                                <span class=\'glyphicon glyphicon-question-sign\'></span>&nbsp;&nbsp;我的问题</a>");
document.writeln("                        </li>");
document.writeln("                        <li>");
document.writeln("                            <a href=\'profile_replies.html\'>");
document.writeln("                                <span class=\'glyphicon glyphicon-envelope\'></span>&nbsp;&nbsp;最新回复</a>");
document.writeln("                        </li>");
document.writeln("                        <li role=\'separator\' class=\'divider\'></li>");
document.writeln("                        <li><a id=\'logout\'>");
document.writeln("                                <span class=\'glyphicon glyphicon-off\'></span>&nbsp;&nbsp;退出登录</a></li>");
document.writeln("                    </ul>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </div>");
document.writeln("    </div>");
document.writeln("</nav>");

$(function () {
    $.ajax({
        url: 'user/getAccountName',
        type: 'GET',
        contentType: 'application/json;charset=utf-8',
        success: function (response) {
            $("#dLabel").html(response + '<span class=\'caret\'></span>');
        },
        error: function (response) {
        }
    })
})

$('#logout').click(function () {
    $.ajax({
        url: 'user/logout',
        type: 'GET',
        contentType: 'application/json;charset=utf-8',
        success: function (response) {
            window.location.href = 'login.html'
        },
        error: function (response) {
        }
    })
})
