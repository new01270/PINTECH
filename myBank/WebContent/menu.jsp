<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>menu.jsp</title>
	<style>
		h1 {
			color:lime;
		}
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
			overflow: hidden;
			background-color: lightsalmon;
		}

		li {
			float: left;
			border-right: 1px solid #bbb;
		}

		li:last-child {
			border-right: none;
		}

		li a {
			display: block;
			color: white;
			font-weight: bold;
			text-align: center;
			padding: 20px 25px;
			text-decoration: none;
		}

		li a:hover:not(.active) {
			background-color: lightsteelblue;
		}

		.active {
			background-color: #4CAF50;
		}
	</style>
</head>

<body>
	<div align="center">
		<div>
			<br>
			<h1>행복한 금요일</h1>
			<br>
			<ul>
				<li><a href="#">로그인</a></li>
				<li><a href="#">입출금</a></li>
				<li><a href="AuthAccount">계좌등록</a></li>
				<li><a href="GetAccountList">등록계좌조회(다른은행)</a></li>
				<li><a href="#">ABOUT</a></li>
			</ul>
		</div>
	</div>
</body>

</html>