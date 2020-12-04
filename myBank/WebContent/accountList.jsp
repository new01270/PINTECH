<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accountList.jsp</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<c:forEach items="${account_list }" var="account">
		<div>
			<span class="bname">bank_name : ${account.bank_name }</span><br>
			<span>계좌번호 : ${account.account_num_masked }</span><br>
			<span>계좌번호 별칭 : ${account.account_alias }</span><br>
		</div>

	</c:forEach>

</body>
</html>