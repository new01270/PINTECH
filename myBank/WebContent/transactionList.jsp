<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transactionList.jsp</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<c:forEach items="${transaction_list }" var="transaction">
		<div>
			<span class="bname"></span>거래일자 : ${transaction.tran_date }<br>
			<span>거래시간 : ${transaction.tran_time }</span><br>
			<span>입출금구분 : ${transaction.inout_type }</span><br>
			<span>거래구분 : ${transaction.getTran_type() }</span><br>
			<span>통장인자내용 : ${transaction.print_content }</span><br>
			<span>거래금액 : ${transaction.tran_amt }</span><br>
			<span>거래후잔액 : ${transaction.after_balance_amt }</span><br>
			<span>거래점명 : ${transaction.branch_name }</span><br>
			
		</div>

	</c:forEach>
</body>
</html>