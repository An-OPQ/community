<!--热度分类功能-->
$(".nav-tabs .new").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'new')
})

$(".nav-tabs .hot7").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'hot7')
})
$(".nav-tabs .hot").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'hot')
})

$(".nav-tabs .red").click(function (){
    $(this).parent().addClass("active").siblings().removeClass("active")
    searchQuestion(1,'red')
})