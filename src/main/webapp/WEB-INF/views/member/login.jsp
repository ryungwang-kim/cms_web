<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	h2{
 		text-align:center;
	}
	.login_{
		text-align:center;
	}
	.login{
		text-align:center; 
		border:1px solid #ddd;
		width: 20%;
		border-collapse: collapse; 
		margin:0 auto;
	}
	.loginpage{
		text-align:center;
		margin: 0 auto;
	}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<div class ="login">
		<h2>LOGIN</h2>
		<table class="table_login" style="width: 100%;">
			<tr>
				<th>아이디</th>
				<td><input id="memId" type="text" name= "memId" size=30></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input id="memPw" type="password" name= "memPw" size=30></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="2">
					<input id="btn" type="button" onclick="loginChe();" value="로그인">
					<input type="submit" onclick="location.href='/member/join_'" value="회원가입"></input>
				</td>
			</tr>
		</table>
	</div>
	<script> 
		function loginChe(){
			var data={
					memId : $('#memId').val(),
					memPw : $('#memPw').val()	
				}
				
			$.ajax({
				url:"/member/loginAction.do",
				type:"POST",
				data: data,
				dataType:"json",
				success:function(result){
					if(result.check == true){
						location.href="/";
					}else{
						alert(result.message);
					}
				}		
			})
		}
	</script>
</body>
</html>