<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 상대경로를 유일하게 쓰는 곳 -->
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Get</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					Board Get
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					
                   <div class="form-group">
                       <label>Title</label>
                       <input class="form-control" name="title" readonly="readonly" value="${vo.title}">
                   </div>
                   
                   <div class="form-group">
                       <label>Contents</label>
                       <textarea class="form-control" rows="5" cols="40" name="content" readonly="readonly" >
                        ${vo.content }
                       </textarea>
                   </div>
                   
                   <div class="form-group">
                       <label>Writer</label>
                       <input class="form-control" name="writer" readonly="readonly" value="${vo.writer}">
                   </div>
                   
                   <button type="button" class="btn btn-default" data-oper="list">List</button>
                   <button type="button" class="btn btn-default" data-oper="modify">Modify</button>
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
	


</div>
<!-- /#wrapper -->


<script type="text/javascript">

	$(document).ready(function() {
		$(".btn").click(function(){
			
			let operation = $(this).data("oper");
			if(operation == "list"){
				self.location = "/board/list";
			}else if(operation == "modify"){
				self.location = "/board/modify?bno=${vo.bno}";
			}
		});
	});
	
</script>

<%@include file="../includes/footer.jsp"%>