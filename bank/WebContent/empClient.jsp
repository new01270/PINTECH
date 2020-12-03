<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empClient.jsp</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script>
	$(function() {
		var url = "EmpServ";
		//바로 url주소를 넣을 경우 CORS policy Error -> 제공자서버,브라우저설정변경,servlet, jsonp 조치 중 servlet으로 조치함.
		$.ajax(url).done(function(response) {
			console.log(response);
			$("#result").append(response.name + " : " + response.addr); //json type으로 읽어옴.
		})
	}); //end of ready
</script>
</head>
<body>
	<div id="result"></div>
</body>
</html>