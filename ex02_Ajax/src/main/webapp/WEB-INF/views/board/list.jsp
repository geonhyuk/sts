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
					<table id="boardTable" width="100%"
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
						<tbody></tbody>
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
<div id="myModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- /#wrapper -->

<script type="text/javascript">
	$(document).ready(function() {
		loadTableData();
		
		
		let result = "${result}";
		checkModal(result);		
		
		$("#regBtn").click(function(){
			self.location = "/board/register";	
		});
		
		function loadTableData(){
			// Ajax : 비동기 통신
			// - 프로세스의 완료를 기다리지 않고 동시에 여러 작업을 처리
			// - 전체 페이지를 새로고침 하지 않고 필요한 부분만을 업데이트 할 수 있다
			// - 자원과 시간을 절약, 깜박거리거나 멈추지 않고 부드럽게 작동
			$.ajax({
				url: "/board/getList",
				type: "POST",
				dataType: "json",
				success: function(data){
					let boardTbody = $("#boardTable tbody");
					
					// Ajax가 반환한 데이터를 '순회'(=='반복자')하여 처리
					// for(let item of items) -> items == data, item == board 역할
					$.each(data, function(index, board){
						// 날짜 형태로 전환
						 let regDate = new Date(board.regdate);
						// numeric : 숫자 형식, 2-digit: 두자리 숫자 형식
						 let options = {year:"numeric", month:"2-digit", day:"2-digit", hour:"2-digit", minute:"2-digit"};
						// 한국 시간 형식으로 변환
						 let formatDate = regDate.toLocaleString("ko-KR", options);
						 
						// 데이터를 순회하여 테이블 목록을 불러와 테이블 바디에 추가
						// 동적으로 데이터 처리
						 let row = $("<tr>");
						 row.append($("<td>").text(board.bno));
						 
						 let titleLink = $("<a>").attr("href", "/board/get?bno="+board.bno).text(board.title);
						 let titleTd = $("<td>").append(titleLink)
						 
						 row.append(titleTd);
						 row.append($("<td>").text(board.content));
						 row.append($("<td>").text(board.writer));
						 row.append($("<td>").text(formatDate));
						
						 boardTbody.append(row);
					});
				},
				error: function(e){
					console.log(e);
				}
			});
		} // loadTableData end
		
		
	}); // (document).ready end
	
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