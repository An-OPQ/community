/**
 * 问题搜索按钮
 * search 为input中的值
 */
$("#searchSubmit").click(function () {
    searchQuestion(1,null,null)
})
var modelID=null;

function searchQuestion(pageNum,classifyVal,modelId) {
    modelID=modelId;
    var pageNo = 1;
    if (undefined != pageNum) {
        pageNo = pageNum;
    }
    var classify=null;
    if (undefined !=classifyVal){
        classify=classifyVal
    }
    var search = $("#search").val();
    var json = {
        title: search,
        classify:classify,
        typeid:modelId,
        pageNo: pageNo
    }
    var jsonStr = JSON.stringify(json)
    $.ajax({
        url: "publish/searchQuestion",
        type: "POST",
        data: jsonStr,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            initTable2(response.list)
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
                spliteStr += "<li onclick='searchQuestion(" + (response.pageNum - 1) + ",\""+classify+"\")'>\n" +
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
                    spliteStr += "<li onclick='searchQuestion(" + i + ",\""+classify+"\")'><a href=\"#\">" + i + "</a></li>\n";
                }
            }
            if (response.isLastPage) {
                spliteStr += "<li class=\'disabled\'>\n" +
                    "   <a href=\"#\" aria-label=\"Previous\">\n" +
                    "      <span aria-hidden=\"true\">&gt;</span>\n" +
                    "    </a>\n" +
                    "</li>";
            } else {
                spliteStr += "<li onclick='searchQuestion(" + (response.pageNum + 1) + ",\""+classify+"\")'>\n" +
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

function initTable2(response) {
    var tbodyObj = $("#tbody")
    var bodyStr = "";
    tbodyObj.empty();
    for (let i = 0; i < response.length; i++) {
        var questions = response[i];
        bodyStr += "<div class=\"media\">\n" +
            "<div class=\"media-left\">\n";
        if (questions.icon != null && questions.icon != undefined) {
            bodyStr += " <a href=\"#\">\n" +
                "<img class=\"media-object img-rounded\" width='100' height='100'\n" +
                "      src=\"static/upload/" + questions.icon + "\">\n" +
                "</a>"
        } else {
            bodyStr += " <a href=\"#\">\n" +
                "<img class=\"media-object img-rounded\" width='100' height='100'\n" +
                "     src=\"./img/25213266.png\">\n" +
                "</a>"
        }
        bodyStr += "</div>\n" +
            "<div class=\"media-body\">\n" +
            "    <h4 class=\"media-heading\">\n" +
            "        <a href=\"questionView.html?id=" + questions.question.id + "\">" + questions.question.title + "</a>\n" +
            "    </h4>\n" +
            "    <span class=\"text-desc\"><span>" + questions.question.commentCount + "</span> 个回复 • <span>" + questions.question.viewCount + "</span> 次浏览 • " +
            "<span>" + questions.question.createDate + "</span></span>\n" +
            "</div>\n" +
            "</div>\n"
    }
    if (response.length===0){
        bodyStr = "<div><div class=\"alert alert-info\" role=\"alert\">可能近期没有帖子，呜呜呜！</div></div>";
    }
    tbodyObj.append(bodyStr);
}
