<!--热度分类功能-->
$(".nav-tabs .new").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'new',modelID)
})

$(".nav-tabs .hot7").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'hot7',modelID)
})
$(".nav-tabs .hot").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'hot',modelID)
})

$(".nav-tabs .red").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'red',modelID)
})