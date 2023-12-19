<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 상대경로를 유일하게 쓰는 곳 -->
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Register</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					Board Register
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<form action="/board/register" method="post" role="form">
					
                       <div class="form-group">
                           <label>Title</label>
                           <input class="form-control" name="title">
                           <p class="help-block">Example block-level help text here.</p>
                       </div>
                       
                       <div class="form-group">
                           <label>Contents</label>
                           <textarea class="form-control" rows="5" cols="40" name="content"></textarea>
                       </div>
                       
                       <div class="form-group">
                           <label>Writer</label>
                           <input class="form-control" name="writer">
                           <p class="help-block">Example block-level help text here.</p>
                       </div>
                       
                       <button type="submit" class="btn btn-default">Submit Button</button>
                       <button type="reset" class="btn btn-default">Reset Button</button>
					</form>
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

<%@include file="../includes/footer.jsp"%>