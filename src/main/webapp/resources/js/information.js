$("a.transition").click(function(event){
    event.preventDefault();
    linkLocation = this.href;
    $("body").fadeOut(1000, redirectPage);
});
function redirectPage() {
    window.location = linkLocation;
}

var dataPerPage = 13;
var pageCount = 5;

$(document).ready(function(){
    var pageNum = 0;
/*****************************************HTML 스크립트*****************************************/
    $("#toggle").click(function() {
        $(this).toggleClass("active");
        $("#overlay").toggleClass("open");
        if($(".blink").css("display") == "none"){
            $(".blink").show();
        }else{
            $(".blink").hide();
        }
    });
/*****************************************로그인*****************************************/
    $.ajax({url:"/session"}).done(function(data){
        var d = JSON.parse(data);
        var html = "";
        if(d != null){
            html += "<div class='headLogin' id='headLogout'>Logout</div>";
            $("#head").append(html);
            $("#blink").show();
        } else {
            html += "<div class='headLogin' id='headLogin'>Login</div>";
            $("#head").append(html);
        }
        $("#headLogin").click(function(){
            window.open("6login.html", "", "width=600,height=400,left=100, top=100");
        });
        $("#headLogout").on("click", function(){
            $.ajax({url:"/sessionDel"}).done(function(data){
                alert("로그아웃 되었습니다.");
                location.href="/";
            });
        });
    });
/*****************************************리스트 호출*****************************************/
    function createHTML(page, pageNum){
        $.ajax({
            type : "post",
            url : "/soList",
            data : {"pageNum" : pageNum}
        }).done(function(data){
            var d = JSON.parse(data);
            var totalData = d.result.cnt;
            var result = d.result2;
            if(totalData == null || totalData == 0){
                alert("목록이 없거나, 불러올 수 없습니다.");
            }else {
                paging(totalData, dataPerPage, page);
                for(var i = 0; i < result.length; i++){
                    $.each(result[i],function(key,value){
                        if(key == "no"){
                            $(".list1").eq(i).text(value);
                        } else if(key == "name"){
                            $(".list2").eq(i).text(value);
                        } else if(key == "residence"){
                            $(".list3").eq(i).text(value);
                        } else if(key == "realResidence"){
                            $(".list4").eq(i).text(value);
                        } else if(key == "date") {
                            $(".list5").eq(i).text(value);
                        }
                    });
                }
            }
        });
    }
    createHTML(1, pageNum);
/*****************************************페이징*****************************************/
    function paging(totalData, dataPerPage, currentPage){
        var totalPage = Math.ceil(totalData/dataPerPage);    // 총 페이지 수
        var first = 1;
        var last = 0;
        if(totalPage >= pageCount){
            first = Number(currentPage);
            last = (first + pageCount) - 1;
        }else {
            last = totalPage;
        }
        if(first < pageCount){
            first = 1;
            last = 5;
            if(totalPage  < last){
                 last = totalPage;
             }
        }else {
            first = first - 2;
            last = (first + pageCount) - 1;
            if(totalPage  < last){
                 last = totalPage;
             }
            if(last >= (totalPage - 4)){
                first = last - 4;
            }
        }
        var $pingingView = $("#paging");
        var html = "";
        for(var i = first; i <= last; i++){
            html += "<a class='soListNumber' id=" + i + ">" + i + "</a> ";
        }
        $("#paging").html(html);    // 페이지 목록 생성
        $("#paging a").css({"color":"black", "text-decoration":"none"});
        $("#paging a#" + currentPage).css({"color":"red", "font-weight":"bold"});    // 현재 페이지 표시
        $("#paging a").off().on("click",function(){
            var $item = $(this);
            var $id = $item.attr("id");
            pageNum = (Number($id) - 1) * dataPerPage;
            createHTML($id, pageNum);
        });
    }
/*****************************************FINISH*****************************************/
});