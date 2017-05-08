<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="ustbaslik.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<c:url value="/assets/jquery-3.1.1.min.js" />"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.mask.js" />"
	type="text/javascript"></script>

<script src="<c:url value= "/assets/jquery.mask.min.js"/>"
	type="text/javascript"></script>

</head>
<body>
	<form:form action="ilEkle" method="post" commandName="il"
		class="form-horizontal col-smd-1">
		<form:hidden path="id" />
		<div class="container">
			<fieldset>
				<legend>İl Bilgileri</legend>

				<table>
					<tr>
						<td>İL İSMİ</td>
						<td><form:input path="isim" class="form-control input-sm"
								id="vergiNo" data-mask="00/00/0000" data-mask-reverse="true" /></td>
						<td><input type="submit" value="Kaydet" class="btn btn-info">
						</td>
					</tr>
				</table>
			</fieldset>

		</div>
	</form:form>




</body>
</html>