$("body").css("display", "none");
$("body").fadeIn(2000);
$("a.transition").click(function(event){
    event.preventDefault();
    linkLocation = this.href;
    $("body").fadeOut(1000, redirectPage);
});
function redirectPage() {
    window.location = linkLocation;
}
var p = null;

var soCheck = 0;
var soName2;
var dataPerPage = 7;
var pageCount = 5; 

var crCheck = 0;
var mainIndex = 0;
var subIndex = 0;
var wrapper = null;
var dataList = [];
var hdfsDataList = [];
var dataUrlList = [
    {dataURL: "/getData/crarea", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList1'}},
    {dataURL: "/getData/cras", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList2'}},
    {dataURL: "/getData/crday", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList3'}},
    {dataURL: "/getData/creducational", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList4'}},
    {dataURL: "/getData/crhideout", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList5'}},
    {dataURL: "/getData/crjob", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList6'}},
    {dataURL: "/getData/crmotive", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList7'}},
    {dataURL: "/getData/crtime", Option: {options: {'title': 'Number Of Case'}, containerId: 'chartList8'}}
];
var option = {};

// 좌표 객체를 생성합니다.
var msoCoordinate = "서울 금천구 가산디지털2로 115";
var msoName = "현재 위치";
/*****************************************스크립트 시작*****************************************/
$(document).ready(function(){
    $("html").animate({scrollTop:0}, 1000);
    $("#blink").hide();
    $("#fourthTest").css("display","none");
    $(".soSer").css("cursor", "Default");
    $(function() {
        setTimeout(function() {
            $('.ismc').addClass('fadeIn');
        }, 1000);
    });
/*****************************************스크롤 네비게이터*****************************************/
    var topoff;
    $(".cta").on("click", function(){
        topoff = $("#fourth").offset();
        $("html").animate({scrollTop:topoff.top-70}, 1000);
    });
    $(".raise").on("click", function(){
        if($(this).text() == "Home"){
            $("html").animate({scrollTop:0}, 1000);
        }else if($(this).text() == "Introduce"){
            topoff = $("#insertSecond").offset();
            $("html").animate({scrollTop:topoff.top-70}, 1000);
        }else if($(this).text() == "Select"){
            topoff = $("#second").offset();
            $("html").animate({scrollTop:topoff.top-70}, 1000);
        }else if($(this).text() == "Comment"){
            topoff = $("#fifth").offset();
            $("html").animate({scrollTop:topoff.top-70}, 1000);
        }
    });
    $("#blink").click(function(){
         $.ajax({type: "post", url: "/mrCall"});
         topoff = $("#insertSecond").offset();
         $("html").animate({scrollTop:topoff.top-70}, 1000);
    });
/*****************************************차트 함수*****************************************/
    //성범죄자 데이터 그리기
    function getHdfsData(){
        var hdfsList =[
            {"data":"/result/sexOffender2/part-r-00000"},
            {"data":"/result/sexOffender3/part-r-00000"}
        ];
        hdfsDataList = [];
        $.each(hdfsList, function(index, value) {
            setHdfsDataList(index, value);
        });
        
    }
    function setHdfsDataList(index, params){
        $.ajax({
            type : "get",
            url : "/con",
            data : params
        }).done(function(data){
            var resultMap = {"index": index, "data": data};
            hdfsDataList.push(resultMap);
            if(index == 0) drawChart(index);
        });
    }            
    function drawChart(index){
        var result = hdfsDataList[index]["data"].result;
        var chartData = new google.visualization.DataTable();
        chartData.addColumn("string", "sido");
        chartData.addColumn("number", "numberOfcases");
        $.each(result, function(index, value){
            var row = [];
            for(var i = 0; i < 2; i++){
                row[i] = (i != 0) ? Number(value[i]) : value[i];
            }
            chartData.addRows([ row ]);
        });
        var option = [{
                chartType : 'PieChart',
                options : {title: '지역별 성범죄자 수', pieHole : 0.4},
                containerId : 'chartList1'
            },{
                chartType : 'ColumnChart',
                options : {title: '세부지역별 성범죄자 수'},
                containerId : 'chartList2'
            }];
        var op = option[index];
        op.dataTable = chartData;
        var wrapper = new google.visualization.ChartWrapper(op);
        wrapper.draw();
    }
    //범죄 데이터 그리기
    function crmChart(row, index){
        var dataURL = row.dataURL;
        option[index] = row.Option;
        
        if(dataList.length != 0){
            console.log(dataList[index]);
        }else {
            $.each(dataList, function(index, value) {
                if(value.index == index) {
                    return false;
                }
            });
            $.post(dataURL).done(function(data) {
                var resultMap = {"index" : index, "data": data};  
                dataList.push(resultMap);
                if(index == 0){
                    createChartView(dataUrlList[mainIndex]["Option"], dataList[mainIndex]["data"]);
                }
            });
        }
    }
    function drawVisualization() {
        $.each(dataUrlList, function(index, value) {
            crmChart(value, index);
        });
    }
/*****************************************성범죄자 데이터 시각화*****************************************/
    $("#sexOffender").on("click", function(){
        crCheck = 0;
        mainIndex = 0;
        $(".chartList").empty();
        $(".labelMenu").css("display", "none");
        $("#fourthTest").css("display","none");
        $("#label1").text("지역별 성범죄자 수");
        $("#label2").text("세부지역별 성범죄자 수");
        $("#slide-1-trigger").prop("checked", true);
        google.charts.load('current');
        google.charts.setOnLoadCallback(getHdfsData);    
        $("#label label").off().on("click", function(){
            mainIndex = $("#label label").index(this); 
            drawChart(mainIndex);
        });
    });
/*****************************************범죄 데이터 시각화*****************************************/
    $("#ciriminalAnalytics").on("click", function(){
        crCheck = 1;
        mainIndex = 0;
        $(".chartList").empty();
        $(".labelMenu").css("display", "inline-block");
        $("#label1").text("범죄발생장소");
        $("#label2").text("연령 및 성별");
        $("#label3").text("범죄자 교육수준");
        $("#label4").text("범죄발생요일");
        $("#label5").text("범죄자 직업");
        $("#label6").text("범죄발생시간");
        $("#label7").text("범행동기");
        $("#label8").text("범행 후 은신처");
        $("#fourthTest").css("display","block");
        $("#slide-1-trigger").prop("checked", true);
        google.charts.load('current');
        google.charts.setOnLoadCallback(drawVisualization);
        
        $("#label label").off().on("click", function(){
            mainIndex = $("#label label").index(this);
            subIndex = 0;
            createChartView(dataUrlList[mainIndex]["Option"], dataList[mainIndex]["data"]);
        });
    });
/*****************************************차트 타입 버튼*****************************************/
    $("#fourthTest a").on("click", function(){
        subIndex = $("#fourthTest a").index(this); 
        createChartView(dataUrlList[mainIndex]["Option"], dataList[mainIndex]["data"]);
    });
    function createChartView(option, data){
            // json 데이터 변수 담기
            var result = data.result;
            var columns = data.columns;
            var size = data.size;
            // 컬럼 정보 확인 (예외처리)
            if(columns.length == 0){
                alert("데이터가 잘못되었습니다.");
                return false;
            }
            // 구글 차트에 사용 할 데이터 만들기
            var chartData = new google.visualization.DataTable();
            // 컬럼 데이터 설정
            $.each(columns, function(index, value) {
                chartData.addColumn(value.type, value.value);
            });
            // 차트 데이터 설정
            $.each(result, function(index, value) {
                var row = [];
                for(var i = 0; i < columns.length; i++){
                    row[i] = value[columns[i].column];
                }
                chartData.addRows([ row ]);
            });
            option.dataTable = chartData;
            if(subIndex == 0){
                option.chartType = 'BarChart';
            }else if(subIndex == 1){
                option.chartType = 'ColumnChart';
            }else if(subIndex == 2){
                option.chartType = 'PieChart';
            }else if(subIndex == 3){
                option.chartType = 'ComboChart';
            }else if(subIndex == 4){
                option.chartType = 'BubbleChart';
            }
            wrapper = new google.visualization.ChartWrapper(option);
            wrapper.draw();
    }
/*****************************************차트 크기 조절*****************************************/
    $( window ).resize(function() {
          if(crCheck == 0){
              drawChart(mainIndex);
          }else {
              createChartView(dataUrlList[mainIndex]["Option"], dataList[mainIndex]["data"]);
          }
    });
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
/*****************************************검색 기능*****************************************/
    $("#containerSearch").submit(function(event){
        var pageNum = 0;
        event.preventDefault();
        if($("#so-search").text() == "다음"){
            if($("#so-name").val() == "" || $("#so-name").val() == null){
                alert("검색할 내용이 없습니다. 정확히 입력해주세요.");
            } else {
                soName2 = $("#so-name").val();
                $("#so-name").val("");
                $("#so-name").attr("placeholder", "이제 이름을 입력하세요.");
                $("#so-search").text("검색");
            }
        } else {
            if($("#so-name").val() == "" || $("#so-name").val() == null){
                alert("검색할 내용이 없습니다. 정확히 입력해주세요.");
            } else {
                createHTML(1, pageNum, soCheck);
            }    
        }
    });
/*****************************************페이징 함수*****************************************/
    $("input:radio[name=radio3]").click(function(){
        $("#so-name").val("");
        checkRadio3();
    });
    $("#so-name").keyup(function(event) {
        if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
            var inputVal = $(this).val();
           $(this).val(inputVal.replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"\\]/g,""));
        }
    });
    function checkRadio3(){
        var chRadio = $("input:radio[name=radio3]:checked").val();
        if(chRadio == "지역"){
            soCheck = 0;
            $("#so-name").attr("placeholder", "지역을 입력하세요.");
            $("#so-search").text("검색");
        }else if(chRadio == "이름"){
            soCheck = 1;
            $("#so-name").attr("placeholder", "이름을 입력하세요.");
            $("#so-search").text("검색");
        }else if(chRadio == "지역/이름"){
            soCheck = 2;
            $("#so-name").attr("placeholder", "먼저 지역을 입력하세요.");
            $("#so-search").text("다음");
        }
    }
    function createHTML(page, pageNum, soCheck){
        var soName = $("#so-name").val();
//        $("#so-name").val("");
        var d = {"soName" : soName, "soName2" : soName2, "pageNum" : pageNum, "soCheck" : soCheck};
        $.ajax({
            type : "post",
            url : "/soName",
            data : d
        }).done(function(data){
            var d = JSON.parse(data);
            var totalData = d.result.cnt;
            var result = d.result2;
            if(totalData == null || totalData == 0){
                alert("성범죄자로 등록되지 않은 이름입니다.");
            }else {
                paging(totalData, dataPerPage, page);
                $(".roAl").empty();
                $(".tdAl").empty();
                $(".centerAl").empty();
                for(var i = 0; i < result.length; i++){
                    $.each(result[i],function(key,value){
                        if(key == "name"){
                            $(".roAl").eq(i).text(value);
                        } else if(key == "realResidence"){
                            $(".tdAl").eq(i).text(value);
                        } else if(key == "date") {
                            $(".centerAl").eq(i).text(value);
                        }
                    });
                }
                $(".soSer").css("cursor", "pointer");
                $(".soSer").hover(function() {
                    $(this).css("color", "red");
                }, function(){
                    $(this).css("color", "black");
                });
            }
        });
    }
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
        for(var i=first; i <= last; i++){
            html += "<a class='soListNumber' id=" + i + ">" + i + "</a> ";
        }
        $("#paging").html(html);    // 페이지 목록 생성
        $("#paging a").css({"color":"black", "text-decoration":"none"});
        $("#paging a#" + currentPage).css({"color":"red", "font-weight":"bold"});    // 현재 페이지 표시
        $("#paging a").off().on("click",function(){
            var $item = $(this);
            var $id = $item.attr("id");
            pageNum = (Number($id) - 1) * dataPerPage;
            createHTML($id, pageNum, soCheck);
        });
    }
/*****************************************좌표 표시 이벤트*****************************************/
    $(".soSer").on("click", function(){
        var firstCd = $(".soSer").eq($(this).index());
        var finalCd = firstCd.children(".tdAl").text();
        if(finalCd == null || finalCd == ""){
            alert("잘못된 좌표입니다. 다시 클릭해주세요.");
        } else {
            mapDraw(finalCd, firstCd.children(".roAl").text());
        }
    });
/*****************************************지도 함수*****************************************/
    function mapDraw(msoCoordinate, msoName){
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 1 // 지도의 확대 레벨
        };
        // 지도를 생성합니다    
        var map = new daum.maps.Map(mapContainer, mapOption); 
        // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new daum.maps.services.Geocoder();
        // 주소로 좌표를 검색합니다
        geocoder.addressSearch(msoCoordinate, function(result, status) {
        // 정상적으로 검색이 완료됐으면 
        if (status === daum.maps.services.Status.OK) {
            var coords = new daum.maps.LatLng(result[0].y, result[0].x);
            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new daum.maps.Marker({
                map: map,
                position: coords
            });
            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new daum.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">'+ msoName + '</div>'
            });
            infowindow.open(map, marker);
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
            } 
        });
    }
    mapDraw(msoCoordinate, msoName);
/*****************************************스크롤 이동*****************************************/
    $(".secondB").click(function(){
        var test = $(this).index();
        if(test == 0){
            var topoff = $("#third").offset();
            $("html").animate({scrollTop:topoff.top-70}, 1000);                    
        } else {
            var topoff = $("#fourth").offset();
            $("html").animate({scrollTop:topoff.top-70}, 1000);
        }
    });
/*****************************************footer 보이기*****************************************/
    $(window).scroll(function(){
        if($(this).scrollTop() >= 4000){
            $("#footer").css("display","block");
        } else {
            $("#footer").css("display","none");
        }
    });
/*****************************************로그인*****************************************/
    $.ajax({url:"/session"}).done(function(data){
        var d = JSON.parse(data);
        var html = "";
        if(d != null){
            p = d.userEmail;
            html += "<div class='headLogin' id='headLogout'>Logout</div>";
            $("#head").append(html);
            $("#blink").show();
//            $("html").easeScroll();
            $(".headMenu").css("display", "block");
            $(".buttons").css("display", "block");
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
/*****************************************메일 보내기*****************************************/
    $("#singo").on("click", function(event){
        event.preventDefault();
        var email = p;
        var password = $("#singop").val();
        var subject = $("#singos").val();
        var contents = $("#singoc").val();
        var d = {"userEmail" : email, "userPassword" : password, "subject" : subject, "contents" : contents}
        $.ajax({
            type : "post",
            url : "/mailSender",
            data : d,
            beforeSend : function(){$("#contactForm").css("display", "none");$(".loading-bro").css("display", "block");},
            complete : function(){$("#contactForm").css("display", "block");$(".loading-bro").css("display", "none");},
            timeout : 100000
        }).done(function(data){
            var d = JSON.parse(data);
            if(d.result == 0){
                alert("전송에 실패했습니다. 비밀번호를 확인해주세요.");
                $("#singop").focus();
            } else if(d.result == 1){
                alert("신고가 정상적으로 완료되었습니다.");
                $("#singop").val("");
                $("#singos").val("");
                $("#singoc").val("");
            } else {
                alert("올바르지 못한 요청입니다.");
                return false;
            }
        });
    });
/*****************************************FINISH*****************************************/
});