<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./includes/header.jsp" %>

<div class="container">
  <h2>${board.writer } 글수정하기</h2>
    <div class="form-group">
      <label for="num"> 글번호 :</label>
      <input type="text" class="form-control" id="num"  value="${board.num }" name="num" readonly="readonly">
    </div>
     <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" value="${board.title }"  name="title" >
    </div>
    <div class="form-group">
      <label for="writer">작성자:</label>
      <input type="text" class="form-control" id="writer"  value="${board.writer }" name="writer" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="content">내용:</label>
      <textarea class="form-control" rows="5" id="content" name="content" >${board.content }</textarea>
    </div>
     <div class="form-group text-right">
 		<button type="button" class="btn btn-secondary btn-sm" id="btnModify">수정하기</button>
 	  </div>
</div>
<script>
 $("#btnModify").click(function(){
	 data = {
			 "num"   : $("#num").val(),
			 "title"    :$("#title").val(),
			 "content" :$("#content").val()
	 }
	 $.ajax({
		 type:"put",
		 url :"/update",
		 contentType : "application/json;charset=utf-8",
		 data: JSON.stringify(data),
		 success:function(resp){
			 if(resp=="success"){
				 alert("수정성공")
				 location.href="/list"
			 } //if
		 }// success
	 })//ajax
 }) //btnModify


</script>
