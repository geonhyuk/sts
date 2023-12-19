<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 상대경로를 유일하게 쓰는 곳 -->
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Tables</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					DataTables Advanced Tables
					<button id="regBtn" type="button" class="btn btn-xs pull-right">글 작성</button>	
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>bno</th>
								<th>title</th>
								<th>content</th>
								<th>writer</th>
								<th>regdate</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo" items="${boardList}">
								<tr>
									<td><c:out value="${vo.bno}" /></td>
									<td><c:out value="${vo.title}" /></td>
									<td><a href="/board/get?bno=${vo.bno}"><c:out value="${vo.content}" /></a></td>
									<td><c:out value="${vo.writer}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${vo.regdate }"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- /.table-responsive -->

				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<!-- /.row -->

	<!-- /#page-wrapper -->
	<!-- 사용자에게 보여줄 안내 문구 창 -->
	
</div>
<div id="myModal" class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- /#wrapper -->

<script type="text/javascript">
	$(document).ready(function() {
		let result = "${result}";
		checkModal(result);
		
		
		
		$("#regBtn").click(function(){
			self.location = "/board/register";	
		});
		
	});
	
	function checkModal(result){			
		if(result == ''){
			return;
		}
		// 수정, 삭제 시 메세지
		if(result == "success"){
			$(".modal-body").html("정상적으로 처리 되었습니다.");	
		// 글 등록 시 메세지
		}else if(parseInt(result) > 0){
			$(".modal-body").html(parseInt(result)+"번 글이 등록 되었습니다.");
		}
		$("#myModal").modal("show");
		
		
	}
</script>

<%@include file="../includes/footer.jsp"%>