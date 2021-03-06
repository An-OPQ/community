document.writeln("<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">");
document.writeln("    <div class=\"modal-dialog\" role=\"document\">");
document.writeln("        <div class=\"modal-content\">");
document.writeln("            <div class=\"modal-header\">");
document.writeln("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span>");
document.writeln("                </button>");
document.writeln("                <h4 class=\"modal-title\" id=\"myModalLabel\"><span class=\"glyphicon glyphicon-send\"></span> 新增</h4>");
document.writeln("            </div>");
document.writeln("            <div class=\"modal-body\">");
document.writeln("                <form>");
document.writeln("                    <input type=\"hidden\" id=\'userId\' name=\"id\" value=\'\'>");
document.writeln("                    <div class=\"form-group\">");
document.writeln("                        <label for=\"addName\">用户名</label>");
document.writeln("                        <input type=\"text\" name='addName' id=\"addName\" class=\"form-control\" onblur='checkAccountName()' placeholder=\"请输入用户名\" value=\"\"/>");
document.writeln("                         <span class=\"pull-right\" id=\"checkResult2\" style=\"margin-right: 20px\">&nbsp;&nbsp;</span>");
document.writeln("                    </div>");
document.writeln("                    <div class=\"form-group\">");
document.writeln("                        <label for=\"email\">邮箱</label>");
document.writeln("                        <input type=\"text\" name='email' id=\"email\" class=\"form-control\" onblur='check()' placeholder=\"请输入密码\" value=\"\"  />");
document.writeln("                         <span class=\"pull-right\" id=\"checkResult\" style=\"margin-right: 20px\">&nbsp;&nbsp;</span>");
document.writeln("                    </div>");
document.writeln("                    <div class=\"form-group\">");
document.writeln("                        <label for=\"addpsw\">密码</label>");
document.writeln("                        <input type=\"text\" name='addpsw' id=\"addpsw\" class=\"form-control\" placeholder=\"请输入确认密码\" value=\"\"/>");
document.writeln("                    </div>");
document.writeln("                    <div class=\"form-group\">");
document.writeln("                        <label for=\"addmobile\">电话号码</label>");
document.writeln("                        <input type=\"text\" name='addmobile' id=\"addmobile\" class=\"form-control\" placeholder=\"请输入邮箱\" value=\"\"/>");
document.writeln("                    </div>");
document.writeln("                    <div class=\"form-group\">");
document.writeln("                        <label for=\"addzu\">角色</label>");
document.writeln("                        <select id=\"addzu\" name='addzu' class=\"form-control\">");
document.writeln("                            <option value=\"3\">普通用户</option>");
document.writeln("                        </select>");
document.writeln("                    </div>");
document.writeln("                </form>");
document.writeln("            </div>");
document.writeln("            <div class=\"modal-footer\">");
document.writeln("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\"><span");
document.writeln("                        class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>关闭");
document.writeln("                </button>");
document.writeln("                <button type=\"button\" name='submit' id=\"btn_submit1\" class=\"btn btn-primary\" data-dismiss=\"modal\">");
document.writeln("                        保存");
document.writeln("                </button>");
document.writeln("            </div>");
document.writeln("        </div>");
document.writeln("    </div>");
document.writeln("</div>");
$(function () {
    $.toastr.config({
        time: 2000,
        size: 'lg',
        position: 'top-center',
    });
})

$(function () {
    $.ajax({
        url: 'user/getAccountName',
        type: 'GET',
        contentType: 'application/json;charset=utf-8',
        success: function (response) {
            if (response.roleInfo.roleid=="2"){
                $("#addzu").append("<option value=\"2\">管理员</option>")
            }else if (response.roleInfo.roleid=="1"){
                $("#addzu") .append("<option value=\"2\">管理员</option>").append("<option value=\"1\">超级管理员</option>")
            }
        },
        error: function (response) {
        }
    })
})

$("#btn_submit1").click(function () {
    var addName = $("#addName").val()
    var email = $("#email").val()
    var addpsw = $("#addpsw").val()
    var addmobile = $("#addmobile").val()
    var addzu = $("#addzu option:selected").val()
    var json = {
        accountName: addName,
        email: email,
        password: addpsw,
        mobile: addmobile,
        roleid: addzu
    }
    var jsonStr = JSON.stringify(json)
    $.ajax({
        url: "management/addUserInfo",
        type: "POST",
        contentType: "application/json;charset=utf-8",
        data: jsonStr,
        success: function (response) {
            if (response) {
                $.toastr.success('添加成功');
                $("#addName").val("")
                $("#email").val("")
                $("#addpsw").val("")
                $("#addmobile").val("")
                $("#addzu option:selected").val("")
                $("#checkResult").html("")
                $("#checkResult2").html("")
            } else {
                $.toastr.warning("添加失败！")
            }
        },
        error: function () {
            $.toastr.success('添加失败');
        }
    })
})


var xmlhttp; //定义xmlhttp
function check() {
    var email = document.getElementById("email").value;
    if (email === "") {
        email = null
    }
    var url = "/community/user/findUserByEmail/" + email; //创建访问检查用户名是否存在的url
    xmlhttp = new XMLHttpRequest(); //初始化xmlhttp为XMLHttpRequest对象
    xmlhttp.onreadystatechange = checkResult; //设置响应函数
    xmlhttp.open("GET", url, true);   //设置访问的页面
    xmlhttp.send(null);  //执行访问
}

function checkResult() { //在这个函数里处理响应
    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
        document.getElementById('checkResult').innerHTML = xmlhttp.responseText;
    }
}

function checkAccountName() {
    var addName = document.getElementById("addName").value;
    if (addName === "") {
        addName = null
    }
    var url = "/community/user/findUserByName/" + addName; //创建访问检查用户名是否存在的url
    xmlhttp = new XMLHttpRequest(); //初始化xmlhttp为XMLHttpRequest对象
    xmlhttp.onreadystatechange = checkResult2; //设置响应函数
    xmlhttp.open("GET", url, true);   //设置访问的页面
    xmlhttp.send(null);  //执行访问
}

function checkResult2() { //在这个函数里处理响应
    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
        document.getElementById('checkResult2').innerHTML = xmlhttp.responseText;
    }
}