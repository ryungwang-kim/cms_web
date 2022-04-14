<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<style>
	</style>
<title>Mainpage</title>
</head>
<body>
	<h2>메인 페이지</h2>
	<div style="text-align: right;">
		<button type="button" onclick="location.href='/board/boardList.do'" class="btn">게시판</button>
		<button type="button" onclick="location.href='/member/memberList.do'" class="btn">회원리스트</button>
		<button type="button" onclick="location.href='/member/login.do'" class="btn">로그인</button>
	</div>
			<div style="text-align: center;">
		<c:forEach var ="main" items="${mainMenu}" varStatus="status">	
				<div class="bg_ct" style="display: inline-block;border: 1px solid black;">${main.lg_cg_nm}
				<c:forEach var ="md" items="${mdMenu}" varStatus="status">
					<c:if test="${md.cg_no eq main.cg_no}">
						<div class="bg_ct" style="border: 1px solid black;">${md.md_cg_nm}</div>	
						<c:forEach var ="sm" items="${smMenu}" varStatus="status">	
							<c:if test="${sm.md_cg_no eq md.md_cg_no}">
								<div class="bg_ct" style="border: 1px solid black;">${sm.sm_cg_nm}</div>	
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
				</div>
	   	</c:forEach>
		   	</div>
</body>
</html>
