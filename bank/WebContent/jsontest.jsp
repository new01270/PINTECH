<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>jsontest.jsp</title>
	<script>
		//json : 배열['','',''], 객체{}
		obj = ['kim', 'park', 'choi'];
		console.log('두번째 이름 ' + obj[1]);
		emp = {
			name: 'scott',
			age: 20,
			addr: '대구'
		};
		console.log('나이 ' + emp.age); // 또는 emp["age"]
		emparr = [{
			name: 'scott',
			age: 20,
			addr: '대구'
		}, {
			name: 'king',
			age: 30,
			addr: ['대구', '서울']
		}]
		console.log('두번째사원의 두번째 주소 ' + emparr[1].addr[1])

		// 객체 -> string
		str = JSON.stringify(obj) // "["kim","park","choi"]"
		// strint -> 객체
		obj2 = JSON.parse(str) // ["kim", "park", "choi"]
	</script>
</head>

<body>
	<h3>json test</h3>
</body>

</html>