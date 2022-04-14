<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
	tbody{
	 	border:2px;
	}
	h2{
		text-align:center;
	}
	.table_write{
		text-align:center; 
		border:1px solid #ddd;
		width:800px;
		border-collapse: collapse; 
		margin:0 auto;
	}
	.write{
		background-color:#aaa;
		text-aglin:center;
		width:100%;
	}
	.container{
		position:relative; 
		width:800px; 
		height:500px; 
		margin:0 auto;
	}
	.btn{
		width:200px; 
		position:absolute;
		top:220px;
		right:0;	
	}
	td{
		text-align:center; 
		border:1px normal #ddd;
		width:800px;
		margin:0 auto;
	}
	

	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<div class="container"> 
			<form method="post" action="/content/writeIns" id="writer">
				<table class="table_write"> 
				<thead>
					<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
					<tr>
						<th class="write" colspan="2" size="60" maxlength="100">게시판 글쓰기 양식</th>
					</tr>				
				</thead>
				<tbody>
					<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
					<tr>
	    				<td align="center">제목</td>
	   					<td><input id="b_title" name="b_title" size="60" maxlength="100" required="required"></td>
	  				</tr>
	  
	  				<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
	   				<tr>
				    	<td align="center">이름</td>
				    	<td><input id ="b_name" name="b_name" size="60" maxlength="100"></td>
				    </tr>
	   
				   <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
				   <tr>
					    <td align="center">내용</td>
					    <td><textarea id="b_content" name="b_content" cols="60" rows="13" ></textarea></td>
				   </tr>
	   
	  			   <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
	  			</tbody>
					<tr align="right">
						<td colspan="2">
						<input type="button" onclick="check();" value="등록">
						<input type="button" onclick="cancle();" value="취소">
				 	</tr>
    		</table>			
		</form>
	</div>
	
	<script>
		function cancle(){
			location.href = "/";
		}
		function check(){
			if($.trim($("#b_title").val())==''){
				alert("제목을 입력하세요");
				return ;
			}else if($.trim($("#b_name").val())==''){
				alert("이름을 입력하세요");
				return ;
			}else if($.trim($("#b_content").val())==''){
				alert("내용을 입력하세요");
				return ;
			}
			
			var data = {
				"b_title" : $("#b_title").val(),
				"b_name" : $("#b_name").val(),
				"b_content" : $("#b_content").val()
			}
			
			$.ajax({
				url:"/board/writeIns.do",
				type:"POST",
				data:data,
				dataType:"json",
				success:function(){
					location.href="/";
				}
			
			})
	}
	</script>
	
</body>
</html>
