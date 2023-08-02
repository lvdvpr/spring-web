<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<title>애플리케이션</title>
</head>
<body>
<c:set var="menu" value="post" />
<%@ include file="../common/navbar.jsp" %>
<div class="container my-3">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4 border p-2 bg-light">게시글 등록</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p>제목과 내용을 입력하세요</p>
			<form id="form-post" class="border bg-light p-3" method="post" action="insert" enctype="multipart/form-data">
				<div class="mb-2">
					<label class="form-label">제목</label>
					<input type="text" class="form-control" name="title" />
				</div>
				<div class="mb-2">
					<label class="form-label">내용</label>
					<textarea rows="4" class="form-control" name="content"></textarea>
				</div>
				<div class="mb-2">
					<label class="form-label">첨부파일</label>
					<input type="file" class="form-control" name="upfile" />
				</div>
				<div class="mb-2">
					<label class="form-label">태그</label>
					<input type="text" class="form-control" id="tag-input" />
					<div id="tag-btn-box" class="me-3 pt-1 ps-1 mt-1"></div>
					<div id="tag-box" class="me-3 pt-1 ps-1"></div>
				</div>
				<div class="text-end">
					<a href="list" class="btn btn-secondary btn-sm">취소</a>
					<button type="submit" class="btn btn-primary btn-sm">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function() {
	let $tagInput = $("#tag-input");
	let $tagBtnBox = $("#tag-btn-box");
	let $tagBox = $("#tag-box");
	
	$("#tag-input").keydown(function(event) {
		if (event.which == 13) {
			let value = $tagInput.val();
			if (value == "") {
				return false;
			}
			let tagBtn = `
				<small class="border rounded bg-secondary p-1 text-white">#\${value} <a href="" class="text-white text-decoration-none"><i class="bi bi-x"></i></a></small>
			`;
			let tag = `
				<input type="hidden" name="tags" value="\${value}">
			`
			$tagBtnBox.append(tagBtn);
			$tagBox.append(tag);
			$tagInput.val("");
			
			return false;
		}
		return true;
	})
	
	$("#form-post").submit(function() {
		let title = $("#form-post input[name=title]").val();
		let content = $("#form-post textarea[name=content]").val();
		
		if (title == "") {
			alert("제목을 입력하세요");
			return false;
		}
		
		if (content == "") {
			alert("내용을 입력하세요");
			return false;
		}
		return true;
	});
});
</script>
</body>
</html>