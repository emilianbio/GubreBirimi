<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="ustbaslik.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form:form action="personelEkle" method="post" commandName="personel"
		class="form-horizontal">
		<form:hidden path="id" />
		<div class="container">
			<fieldset>

				<table>
					<tr>
						<td>Adı:</td>
						<td><form:input path="adi" class="form-control" /></td>

						<td>Soyadi:</td>
						<td><form:input path="soyadi" class="form-control" /></td>
					<tr>
					<tr>
						<td>Unvanı</td>
						<td><form:select path="unvan" class="form-control">
								<form:option value="0">Seçiniz---</form:option>
								<form:option value="Mühendis">Mühendis</form:option>
								<form:option value="Tekniker">Tekniker</form:option>
							</form:select></td>
					<tr>
					<tr>
						<td>Denetçi No</td>
						<td><form:input path="denetciNo" class="form-control" /></td>
					<tr>
				</table>

				<input type="submit" value="KAYDET" class="form-control btn-info">

			</fieldset>
		</div>
	</form:form>
</body>
</html>