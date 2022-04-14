<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<html>
<head>
	<style>
	.bg_a{
		background-color:#aaa; 
		color:#000;
	}
	.bg_a1{width:30px}
	.bg_a2{width:150px}
	.bg_a3{width:60px}
	.bg_a4{width:400px}
	.table{
		width:800px;border-collapse: collapse; 
		margin:0 auto;
	}
	.table th, .table td {
		padding: 10px;
		border: 1px solid #ddd;
    }
    .bg_ct{font-weight:normal;}
	h2{
		text-align:center;
	}
	.ma{
		position:relative; 
		width:800px; 
		height:500px; 
		margin:0 auto;
	}
	.btn{
		width:195px; 
		position:absolute;
		top:20px;
		right:0;	
	}	
	.btn1{
		width:195px; 
		position:absolute;
		top:20px;
		lift:0;	
	}
	</style>
</head>
<body>
<div class="ma">
 <table class="table">
	<h2> 게시판 만들기 </h2>
 	<input type="submit" onclick="location.href='/content/login'" class="btn1" value="로그인"></input>
	<thead>
	    <tr class ="bg_a" style="border-top:3px solid #000;">
	    	<th class="bg_a1">NO.</th>
			<th class="bg_a2">제목</th>
			<th class="bg_a3">작성자</th>
			<th class="bg_a4">내용</th>
			<th class="bg_a5">수정</th>
			<th class="bg_a6">삭제</th>
	    </tr>
    </thead>
    <tbody>
    	<c:forEach var ="item" items="${list}" varStatus="status">	
    		<tr id= "bid" >	   	
				<th class="bg_ct">${status.count}</th>
				<th class="bg_ct">${item.bd_title}</th>
				<th class="bg_ct">${item.bd_content}</th>
				<th class="bg_ct">${item.bd_title}</th>
				<th class="bg_ct"><input type="button" onclick="upda();" value="수정"></th>
				<th class="bg_ct"><input type="button" onclick="del();" value="삭제"></th>
			</tr>
    	</c:forEach>
    </tbody>
</table>
	<input type="submit" onclick="location.href='/board/write.do'" class="btn" value="글쓰기"></input>
 </div>
		<script>
			function upda(){
				
			}
			function del(){
				var data={
						bid : $('#bid').val()
				}
				$.ajax({
					url:"/content/loginsel",
					type:"POST",
					data: data,
					dataType:"json",
					success:function(result){
						alert(result.message);
						if(result.url == null){
							location.reload();
						}else{
							location.href=result.url;
						}
					}		
				})
				
			}
		
		</script>
</body>
</html>