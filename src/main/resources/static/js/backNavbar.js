document.writeln("<nav class=\'navbar navbar-default\'>");
document.writeln("		<div class=\'container-fluid\'>");
document.writeln("			<div class=\'navbar-header\'>");
document.writeln("				<button type=\'button\' class=\'navbar-toggle collapsed\' data-toggle=\'collapse\'");
document.writeln("					data-target=\'#bs-example-navbar-collapse-1\' aria-expanded=\'false\'>");
document.writeln("					<span class=\'sr-only\'>Toggle navigation</span>");
document.writeln("					<span class=\'icon-bar\'></span>");
document.writeln("					<span class=\'icon-bar\'></span>");
document.writeln("					<span class=\'icon-bar\'></span>");
document.writeln("				</button>");
document.writeln("				<a class=\'navbar-brand\' href=\'backIndex.html\' >求知论坛管理</a>");
document.writeln("			</div>");
document.writeln("			<div class=\'collapse navbar-collapse\'>");
document.writeln("				<ul class=\'nav navbar-nav navbar-left text-center\' id=\'navbarObj\'>");
document.writeln("					<li class=\'backIndex\'>");
document.writeln("						<a href=\'backIndex.html\'>");
document.writeln("							<span class=\'glyphicon glyphicon-home\'></span>&nbsp;&nbsp;后台首页</a>");
document.writeln("					</li>");
document.writeln("					<li class=\'userManger\'>");
document.writeln("						<a href=\'userManger.html\'>");
document.writeln("							<span class=\'glyphicon glyphicon-user\'></span>&nbsp;&nbsp;用户管理</a>");
document.writeln("					</li>");
document.writeln("					<li class=\'adminManger\'>");
document.writeln("						<a href=\'adminManger.html\'>");
document.writeln("							<span class=\'glyphicon glyphicon-user\'></span>&nbsp;&nbsp;管理员管理</a>");
document.writeln("					</li>");
document.writeln("					<li  class=\'contentManager\'>");
document.writeln("						<a href=\'contentManager.html\'>");
document.writeln("							<span class=\'glyphicon glyphicon-folder-open\'></span>&nbsp;&nbsp;内容管理</a>");
document.writeln("					</li>");
document.writeln("					<li class=\'tagManager\'>");
document.writeln("						<a href=\'tagManager.html\'>");
document.writeln("							<span class=\'glyphicon glyphicon-tag\'></span>&nbsp;&nbsp;板块管理</a>");
document.writeln("					</li>");
document.writeln("					<li class=\'advertmanager\'>");
document.writeln("						<a>");
document.writeln("							<span class=\'glyphicon glyphicon glyphicon-bullhorn\'></span>&nbsp;&nbsp;公告管理</a>");
document.writeln("					</li>");
document.writeln("				</ul>");
document.writeln("				<ul class=\"nav navbar-nav navbar-right text-center\">");
document.writeln("					<li class=\"dropdown\">");
document.writeln("						<a id=\"dLabel\" href=\"#\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"");
document.writeln("							aria-expanded=\"false\">");
document.writeln("							admin");
document.writeln("							<span class=\"caret\"></span>");
document.writeln("						</a>");
document.writeln("						<ul class=\"dropdown-menu\" aria-labelledby=\"dLabel\">");
document.writeln("							<li>");
document.writeln("								<a href=\"#\">");
document.writeln("									<span class=\"glyphicon glyphicon-asterisk\"></span>&nbsp;&nbsp;前台首页</a>");
document.writeln("							</li>");
document.writeln("							<li>");
document.writeln("								<a href=\"personalIndex.html\">");
document.writeln("									<span class=\"glyphicon glyphicon-user\"></span>&nbsp;&nbsp;个人主页</a>");
document.writeln("							</li>");
document.writeln("							<li>");
document.writeln("								<a href=\"personalSet.html\">");
document.writeln("									<span class=\"glyphicon glyphicon-cog\"></span>&nbsp;&nbsp;个人设置</a>");
document.writeln("							</li>");
document.writeln("						</ul>");
document.writeln("					</li>");
document.writeln("					<li>");
document.writeln("						<a href=\"#\" id=\'logout\'>");
document.writeln("							<span class=\"glyphicon glyphicon-off\"></span>&nbsp;&nbsp;退出</a>");
document.writeln("					</li>");
document.writeln("				</ul>");
document.writeln("			</div>");
document.writeln("		</div>");
document.writeln("	</nav>");

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
        success: function () {
            window.location.href = 'login.html'
        },
        error: function (response) {
        }
    })
})
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

var id
function jumpToAdvertmanager(email) {
    $.ajax({
        async:false,//设置同步：代码没有执行完就 不执行下面的代码
        url: "user/getIdByEmail?email=" + email,
        type: "GET",
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            id = response;
        }
    })
}
$(".advertmanager").click(function () {
    window.location.href="advertmanager.html?id="+id
})