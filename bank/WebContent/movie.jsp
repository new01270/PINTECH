<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>movie.jsp</title>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function () {
			url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20201202";
			$.ajax(url, {
				success: function (response) {
					console.log(response); //결과 자체가 json구조라서 dataType 필요없음.

					$("#result").html(response.boxOfficeResult.dailyBoxOfficeList[0].movieNm);

					var list = response.boxOfficeResult.dailyBoxOfficeList;
					/*
					for (i in list) {
						$("#result").append($("<p>").html(list[i].movieNm + list[i].movieCd));
					}
					*/
					for (i of list) {
						$("#result").append($("<p>").html(i.movieNm));
						$("#result").append($("<p>").addClass("mcd").html(i.movieCd));
					}
				}
			})
			
			//영화정보 조회
			$("#result").on("click",".mcd", function() {
				var movieCd = $(this).html();
				var url ="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=430156241533f1d058c603178cc3ca0e&movieCd=" + movieCd;
				$.ajax(url, {
					success: function(response) {
						//영화 출연배우를 출력
						console.log(response)
						console.log(response.movieInfoResult.movieInfo.actors);
						var list = response.movieInfoResult.movieInfo.actors
						$("#actor").empty();
						for (i of list) {
							$("#actor").append($("<p>").html(i.peopleNm));
						}
					}
				})
			})
			
			
			
		}); // end of ready
	</script>
</head>

<body>
	박스오피스 순위
	<div id="result"></div>
	<div id="actor"></div>
</body>

</html>