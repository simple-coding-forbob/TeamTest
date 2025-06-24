/**
 * 
 */
/* 자동완성 + debouncing(성능업, 입력후 0.5초 이후에 AJAX 실행) */
$(function () {
	let timer;
    $("#searchKeyword").keyup(function () {
    	clearTimeout(timer);  // 이전 타이머 취소
    	timer=setTimeout(function() {fn_ajax();},500)
    });
});
function fn_ajax() {
	let searchKeyword = $("#searchKeyword").val();
    $.ajax({
        url: "/api/faq/faq.do",
        type: "GET",
        dataType: "json",
        data: {"searchKeyword":searchKeyword},
        success: function (data) {
        	console.log(data);
        	$("#result").empty();
        	if(searchKeyword !="") {
        		/* 화면에 보이기 */
        		fn_view(data);
        	}
        },
        error: function (request) {
            console.error(request);
        }
    });			
}
function fn_view(data) {
   	let res="";
       $.each(data, function (index, value) {
			res+=value.title + "<br>";
	})
	$("#result").html(res);		
}