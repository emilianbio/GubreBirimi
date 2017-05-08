<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <jsp:include page="ustbaslik.jsp"></jsp:include> --%>
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
<script src="<c:url value="/assets/genel.js" />" type="text/javascript"></script>

<script src="<c:url value= "/assets/jQuery-dateFormat.js"/>"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery-dateFormat.min.js"/>"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.mask.js" />"
	type="text/javascript"></script>

<script src="<c:url value= "/assets/jquery.mask.min.js"/>"
	type="text/javascript"></script>
<style type="text/css">
/* html, body, .container-table {
	height: 100%;
} */
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 15px;
	line-height: 1.42857143;
	color: #333;
	background-color: #fff
}

.noPadding {
	padding: 0px;
}

.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th,
	.table>thead>tr>td, .table>thead>tr>th {
	padding: 10px;
	line-height: 1.42857143;
	vertical-align: top;
	text-align: left;
	border-top: 1px none #ddd
}

.justify {
	text-align: justify;
}

.container {
	margin-top: 45%;
	margin-left: 7%;
}

.gap {
	padding-bottom: 50px;
	padding-top: 50px;
}
</style>

<script type="text/javascript">
	var jq = jQuery.noConflict();
	console.log(new Date());

	jq(document).ready(function() {

		jq(".tarih").text(jq.format.date(new Date(), 'dd.MM.yyyy'));
		jq(".tarih2").text(jq.format.date(new Date(), '.... MM.yyyy'));

	});
	function printDiv(box) {
		//Get the HTML of div
		var divElements = document.getElementById('tableDiv').innerHTML;
		//Get the HTML of whole page
		var oldPage = document.body.innerHTML;
		var src = "${pageContext.request.contextPath}/assets/gthbLogo.png";
		//Reset the page's HTML with div's HTML only
		document.body.innerHTML = "<html><head><title>ADASDASD</title></head><body><table border=0 align='center'> <tr><td align=center> <image src="+src+"/>"
				+ "</td></tr></table>" + divElements + "</body>";

		//Print Page
		window.print();

		//Restore orignal HTML
		document.body.innerHTML = oldPage;
	}

	function paraflariKaldir() {
		jq(".paraf").remove();
	}
</script>


</head>
<body>

	<div id="tableDiv">
		<div class="container">
			<table class="table">
				<tr>
					<th colspan="2">Belge Numarası</th>

					<c:if test="${dagitici.belgeNo lt 10}">
						<td colspan="2">${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.000${dagitici.belgeNo}</td>
					</c:if>

					<c:if test="${dagitici.belgeNo ge 10 and dagitici.belgeNo lt 100}">
						<td colspan="2">
							${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.00${dagitici.belgeNo}</td>
					</c:if>

					<c:if
						test="${dagitici.belgeNo ge 100 and dagitici.belgeNo lt 1000 }">
						<td colspan="2">${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.0${dagitici.belgeNo}</td>
					</c:if>

					<c:if test="${dagitici.belgeNo ge 1000}">
						<td colspan="2">${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.${dagitici.belgeNo}</td>
					</c:if>
				</tr>
				<tr>
					<th colspan="2">Düzeltme Tarihi</th>
					<td colspan="2">: <fmt:formatDate
							value="${dagitici.duzeltmeTarihi}" pattern="dd.MM.yyyy" />
					</td>
				</tr>
				<tr>
					<th rowspan="1" colspan="4">Dağıtıcının</th>

				</tr>
				<tr>
					<th></th>

				</tr>
				<tr>
					<th rowspan="1" style="" colspan="2">Adı Soyadı/Ticari Ünvanı</th>
					<td colspan="2">:${dagitici.isyeri.isyeriAdi} -
						${dagitici.isyeri.yetkiliAdiSoyadi}</td>
				</tr>
				<tr>
					<th></th>

				</tr>

				<tr>
					<th colspan="2">T.C Kimlik No / Vergi No</th>
					<td colspan="2">:${dagitici.isyeri.vergiNo}</td>
				</tr>
				<tr>
					<th colspan="2">Mersis Numarası</th>
					<td colspan="2">:${dagitici.isyeri.mersisNo}</td>
				</tr>


				<tr>
					<th colspan="2">İşyeri Adresi</th>
					<td colspan="2">:${dagitici.isyeri.isyeriAdresi}</td>
				</tr>
				<tr>
					<th colspan="2">Depo Adresi</th>
					<td colspan="2">:${dagitici.isyeri.depoAdresi}</td>
				</tr>
				<tr>
					<td rowspan="3" colspan="4" class="justify">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Yukarıda bilgileri yer alan ${dagitici.isyeri.isyeriAdi} -
						${dagitici.isyeri.yetkiliAdiSoyadi} 09.03.2014 tarih ve 28956<br>
						sayılı Resmi Gazetede yayımlanan Gübrelerin Piyasa Gözetimi ve
						Denetimi Yönetmeliği<br> Hükümlerine göre
						yetkilendirilmiştir.
					</td>
				</tr>

				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: right; padding-bottom: 0px;">Muhammet
						Ali Tekin</td>
				</tr>
				<tr>
					<td colspan="4"
						style="text-align: right; padding-top: 0em; margin-right: 0px">İl
						Müdürü&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr class="paraf">
					<td style="text-align: left; padding: 0;"><span class="tarih"></span></td>
					<td style="text-align: left; padding: 0;">Ziraat Mühendisi</td>
					<td style="text-align: left; padding: 0;">Esma Geylani</td>
					<td></td>
				</tr>
				<tr class="paraf">
					<td style="text-align: left; padding: 0;"><span class="tarih"></span></td>
					<td style="text-align: left; padding: 0;">Ziraat Mühendisi</td>
					<td style="text-align: left; padding: 0;">Esma Geylani</td>
					<td></td>
				</tr>
				<tr class="paraf">
					<td class="noPadding" style="text-align: left; padding: 0;"><span
						class="tarih2"></span></td>
					<td class="noPadding" style="text-align: left; padding: 0;">Ziraat
						Mühendisi</td>
					<td style="text-align: left; padding: 0;">Esma Geylani</td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>

	<input type="button" onclick="paraflariKaldir()"
		value="Parafları Kaldır">
	<input type="button" id="toExcel" onclick="javascript:printDiv('box')"
		class="btn btn-success" value="Yazdır">
</body>
</html>