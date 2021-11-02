<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./includes/header.jsp" %>

<div class="container">
  <h2>${board.writer } 글보기</h2>
    <div class="form-group">
      <label for="num"> 글번호 :</label>
      <input type="text" class="form-control" id="num"  value="${board.num }" name="num" readonly="readonly">
    </div>
     <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" value="${board.title }"  name="title" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="writer">작성자:</label>
      <input type="text" class="form-control" id="writer"  value="${board.writer }" name="writer" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="content">내용:</label>
      <textarea class="form-control" rows="5" id="content" name="content" readonly="readonly">${board.content }</textarea>
    </div>
    
     <div class="form-group text-right">
 		<button type="button" class="btn btn-secondary btn-sm" id="btnUpdate">수정하기</button>
 		<button type="button" class="btn btn-secondary btn-sm" id="btnDelete">삭제하기</button>
    </div>
  
    
   	<div class="container mt-5">
		<div class="form-group">
			<label for="comment">Comment:</label>
			<textarea class="form-control" rows="5" id="msg" name="text"></textarea>
		</div>
		<button type="button" class="btn btn-success" id="commentBtn">Comment Write</button>
	</div>
	<div id="replyResult"></div>
    
</div>
<script>

var init = function(){
	$.ajax({
		type:"get",
		url : "/reply/commentList",
		data : {"bnum" : $("#num").val()}
	})
	.done(function(resp){
		var str="<table class='table table-hover mt-3'>";
		$.each(resp, function(key, val){
			str +="<tr>"
			str +="<td>"+ val.userid +"</td>"
			str += "<td>"+val.content +"</td>"
			str += "<td>"+val.regdate+"</td>"
	        str += "<td><a href='javascript:fdel("+val.cnum+")'>삭제</a></td>"
			str +="</tr>"
		})
		str+="</table>"
		$("#replyResult").html(str);
	})
}
//댓글삭제
function fdel(cnum){
	$.ajax({
		  type:"delete",
		  url:"/reply/del/"+cnum
		})
		.done(function(resp){
			alert(resp+"번 글 삭제완료");
			init();
		})
		.fail(function(){
			alert("댓글삭제 실패")
		})
	
}
//댓글추가
$("#commentBtn").click(function(){
	if($("#msg").val()==""){
		alert("댓글을 입력하세요")
		return;
	}
	data = {
			"bnum" : $("#num").val(),
			"content" :$("#msg").val()
	}
	$.ajax({
		type:"post",
		url : "/reply/commentInsert",
		contentType:"application/json;charset=utf-8",
		data : JSON.stringify(data)
	})
	.done(function(resp){
		alert("댓글 추가 성공")
		$("#msg").val("")
		init();
	})
	.fail(function(){
		alert("댓글 추가 실패")
	})
})



$("#btnUpdate").click(function(){
	if(confirm('정말 수정할까요?')){
		location.href="/update/${board.num}"
	}
})

$("#btnDelete").click(function(){
	if(!confirm('정말 삭제할까요?')) return false;
	$.ajax({
		type:"delete",
		url:"/delete/${board.num}",
		success:function(resp){
			if(resp=="success"){
				alert("삭제성공")
				location.href="/list"
			} //if
		}//success
	})//ajax
})//btnDelete


init();
</script>
