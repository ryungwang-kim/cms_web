<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	h2{
		text-align:center;
	}
	.div{
		text-align:center; 
		border:1px solid #ddd;
		width:800px;
		border-collapse: collapse; 
		margin:0 auto;
	}
	tbody{
	 	border:2px;
	}
	td{
		text-align:left; 
		border:1px normal #ddd;
		width:800px;
		margin:0 auto;
	}
	.write{
		text-align:right; 
		border:1px normal #ddd;
		width:800px;
		margin:0 auto;
	}
	.join{
		text-align:center; 
		border:1px solid #ddd;
		width:800px;
		border-collapse: collapse; 
		margin:0 auto;
	}
	.join_{
		text-align:center
	}
</style>
</head>
<body>
<div class ="join">
	<form  method="post" action="/user/userins">
		<table calss="table_join">
		<thead>
			<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
			<tr>
				<h2>회원가입</h2>
			</tr>
		</thead>	
		<tbody>
			<tr>
				<th class="write">아이디</th>
				<td><input type="text" name= "b_id" placeholder ="아이디를 입력하세요" ></td>
			</tr>
			<tr>
				<th class="write">비밀번호</th>
				<td><input type="password" name= "b_pw" placeholder ="비밀번호를 입력하세요"></td>
			</tr>
			<tr>
				<th class="write">이름</th>
				<td><input type="text" name= "b_name" placeholder ="이름을 입력하세요"></td>
			</tr>
			<tr>
				<th class="write">전화번호</th>
				<td><input type="text" name= "b_phone" placeholder ="전화번호를 입력하세요"></td>
			</tr>
			<tr>
				<td class ="join_" colspan="2" aling="center">
					<input type="submit" class="btn2" value="등록">
					<input type="button" onclick="cancle();" value="취소">
				</td>
			</tr>
			
		</tbody>	
		</table>
	</form>	
</div>
	
	<script>
		function cancle(){
			location.href = "/";
		}
		
		
	</script>


</div>
</body>
</html>