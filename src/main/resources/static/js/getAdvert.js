$(function () {
    var $sponsor = $(".sponsor");
    var $advertImg = $(".advertImg")
    $sponsor.empty();
    $advertImg.empty();
    $.ajax({
        url: "user/getAdvert",
        type: "GET",
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            console.log(response)
            if (response != null && response !== '') {
                $sponsor.html(response.advertName);
                $advertImg.attr("src", "static/upload/" + response.pictureAddress + "")
                $sponsor.attr("href","https://"+response.advertURL+"")
            } else {
                $sponsor.html("暂无");
                $advertImg.attr("alt", "暂无广告推广")
            }
        }
    })
})