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
document.writeln("                    <input type=\'text\' id='search' class=\'form-control\' placeholder=\'搜索\' value=\'\'>");
document.writeln("                </div>");
document.writeln("                <button type=\'button\' class=\'btn btn-default\' id='searchSubmit'>搜索</button>");
document.writeln("            </form>");
document.writeln("            <ul class=\'nav navbar-nav model\' id=\'model\'>");
document.writeln("            </ul>");
document.writeln("            <ul class=\'nav navbar-nav navbar-right\'>");
document.writeln("                <li><a id=\'publish\' href=\'#\'>发帖</a></li>");
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
            initModel();
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
        success: function () {
            window.location.href = 'login.html'
        },
        error: function (response) {
        }
    })
})

function initModel() {
    $.ajax({
        url: 'user/initModel',
        type: 'GET',
        contentType: 'application/json;charset=utf-8',
        success: function (response) {
            var modelObj = $("#model");
            modelObj.empty();
            var modelStr = "";
            for (let i = 0; i < response.length; i++) {
                var model = response[i];
                modelStr += "<li><a onclick='jumpToModel("+model.typeId+")'>" + model.typeName + "</a></li>"
            }
            modelObj.append(modelStr);
        },
        error: function (response) {
        }
    })
}

function jumpToModel(typeId) {
    window.location.href="main_Model.html?typeId="+typeId;
}
var email;
function getSession () {
    $.ajax({
        async:false,
        url: "user/getSession",
        type: "GET",
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            email = response;
            jumpToAdvertmanager(email)
        }
    })
}
getSession()
var Uid
function jumpToAdvertmanager(email) {
    $.ajax({
        async:false,//设置同步：代码没有执行完就 不执行下面的代码
        url: "user/getIdByEmail?email=" + email,
        type: "GET",
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            Uid = response;
        }
    })
}

$("#publish").click(function (){
    window.location.href="publish.html?id="+Uid;
})