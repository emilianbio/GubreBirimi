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
<script type="text/javascript">
	var jq = jQuery.noConflict();

	jq(document).ready(function() {

		//alert("asdasd");
	});
</script>
<body>
	<form:form action="ilceEkle" method="post" commandName="ilce"
		class="form-horizontal col-smd-1">
		<form:hidden path="id" />
		<div class="container">
			<fieldset>
				<legend>${legend}</legend>
				<table>
					<tr>
						<td>İL</td>
						<td><form:select path="il.id" class="form-control input-sm"
								id="ilID" data-mask="00/00/0000" data-mask-reverse="true">
								<form:option value="0">--Seçiniz...</form:option>
								<form:options items="${ilListesi}" itemLabel="isim"
									itemValue="id" />
							</form:select></td>
					</tr>
					<tr>
						<td>İLÇE</td>
						<td><form:input path="isim" class="form-control input-sm"
								id="isim" data-mask-reverse="true" /></td>
					</tr>
					<tr>
						<td>İLÇE KODU</td>
						<td><form:input path="ilceKodu" class="form-control input-sm"
								id="ilceKodu" /></td>

						<c:if test="${tusYazisi== 'Güncelle'}">
							<td><input type="submit" value="Vazgeç"
					onclick="javascript:location.href='./ilceVazgec'"
					class="btn btn-danger"></td>
						</c:if>
						<td><input type="submit" value="${tusYazisi}"
							class="btn btn-info"></td>
					</tr>

				</table>
			</fieldset>
		</div>
	</form:form>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>İLÇE TABLOSU</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Sıra</td>
					<td>İl</td>
					<td>İlce</td>
					<td>İlce Kodu</td>
				</tr>
				<c:forEach items="${ilceListesi}" var="ilce" varStatus="sira">
					<tr id="satirNo${ilce.id}">
						<td><a
							href="${pageContext.request.contextPath}/ilceDuzenle/${ilce.id}">${sira.count }</a></td>
						<td>${ilce.il.isim}</td>
						<td>${ilce.isim }</td>
						<td>${ilce.ilceKodu }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>