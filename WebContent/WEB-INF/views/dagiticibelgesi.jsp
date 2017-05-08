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
<script src="<c:url value="/assets/genel.js" />" type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.mask.js" />"
	type="text/javascript"></script>

<script src="<c:url value= "/assets/jquery.mask.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/assets/genel.js"  />" type="text/javascript"></script>
<script src="<c:url value="/assets/jquery.alertable.js" />"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.alertable.min.js" />"
	type="text/javascript"></script>
<link href="<c:url value="/assets/jquery.alertable.css"/>"
	rel="stylesheet">
</head>
<body>
	<fieldset>
		<legend>Arama Sekmesi</legend>
		<form:form action="dagiticiBul" method="get"
			commandName="dagiticiBulma" autocomplete="off" class="form-inline">
			<label>Aranacak Kelime Giriniz</label>
			<input name="searchString" id="searchString" type="text" value=""
				class="form-control">
			<input type="submit" value="Ara" class="btn btn-success">
		</form:form>

		<form:form action="ilceyeGoreDagiticiGetir" method="get"
			commandName="dagiticiBulma" autocomplete="off" class="form-inline">
			<form:select path="isyeri.ilce.id">
				<form:option value="0">Seçiniz----</form:option>
				<c:forEach items="${dagiticiListesi}" var="dagitici">
					<%-- <form:options items="${dagitici}"
						itemLabel="${dagitici.isyeri.ilce.isim}"
						itemValue="${dagitici.isyeri.ilce.id}" /> --%>
					<form:option value="${dagitici.isyeri.ilce.id }">${dagitici.isyeri.ilce.isim }</form:option>
				</c:forEach>
				<input type="submit" value="Listele" class="btn btn-default">
			</form:select>
		</form:form>
		<legend></legend>
		<c:if test="${!empty arananKelime}">
			<label class="form"> Aradığınız Kelime:</label>
			<br />
			<label class="form"> <span style="color: red;">"${arananKelime}"
			</span> ile ilgili ${dagiticiListesi.size()} adet kayıt bulundu...
			</label>
		</c:if>
	</fieldset>
	<form:form action="dagiticiBelgesiEkle" method="post"
		commandName="dagitici" class="form-horizontal col-smd-1">
		<form:hidden path="id" />
		<div class="container">
			<fieldset>
				<legend>Dağıtıcı Bilgileri</legend>

				<table>
					<tr>
						<td>İŞYERİ ADI</td>
						<td><form:select path="isyeri.id" id="isyeriAdi"
								onchange="isyeriGetir(this.value)" class="form-control input-sm">
								<form:option disabled="true" value="0">---Seçiniz...</form:option>
								<form:options items="${isyeriListesi}" itemLabel="isyeriAdi"
									itemValue="id" />
							</form:select></td>
						<td>BELGE NO</td>

						<td>&nbsp;<span id="lblBelgeNo"></span></td>
						<td><form:input path="belgeNo" class="form-control input-sm"
								id="belgeNo" data-mask="00/00/0000" data-mask-reverse="true" /></td>

						<td>DÜZELTME TARİHİ</td>
						<td><form:input path="duzeltmeTarihi" type="date"
								class="form-control input-sm" id="duzeltmeTarihi"
								data-mask="0000-00-00" data-mask-reverse="true" /></td>

						<c:if test="${tusYazisi=='Güncelle'}">
							<td><input type="button" value="Vazgeç"
								class="btn btn-danger"
								onclick="location.href='./dagiticiDuzenleVazgec'"></td>
						</c:if>

						<td><input type="button" value="${tusYazisi}"
							onclick="dagiticiFormControl();" class="btn btn-info"></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form:form>
	<br>
	<div class="container">
		<div class="table-responsive">
			<c:if test="${!empty dagiticiListesi}">
				<table class="table table-hover table-condense">
					<caption>
						DAĞITICI LİSTESİ
						<h6>
							Toplam <span style="color: red;">${dagiticiListesi.size()}</span>
							kayıt listeleniyor
						</h6>
					</caption>
					<thead>
						<tr class="active">
							<th>#</th>
							<th>Düzenle</th>
							<th>Belge No</th>
							<th>Düzeltme Tarihi</th>
							<th>Adı Soyadı</th>
							<th>Ticari Ünvanı</th>
							<th>TC Kimlik / Vergi No</th>
							<th>Mersis Numarası</th>
							<th>İşyeri Adresi</th>
							<th>Depo Adresi</th>
							<th>Sil</th>
							<th>Belge Yazdır</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ dagiticiListesi}" var="dagitici"
							varStatus="sira">
							<tr>
								<td>${sira.count}</td>
								<td><a href="./dagiticiGetir/${dagitici.id}"
									class="btn btn-primary">Düzenle</a></td>

								<c:if test="${dagitici.belgeNo lt 10}">
									<td>${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.000${dagitici.belgeNo}</td>
								</c:if>

								<c:if
									test="${dagitici.belgeNo ge 10 and dagitici.belgeNo lt 100}">
									<td>${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.00${dagitici.belgeNo}</td>
								</c:if>

								<c:if
									test="${dagitici.belgeNo ge 100 and dagitici.belgeNo lt 1000 }">
									<td>${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.0${dagitici.belgeNo}</td>
								</c:if>

								<c:if test="${dagitici.belgeNo ge 1000}">
									<td>${dagitici.isyeri.ilce.il.ilKodu}.${dagitici.isyeri.ilce.ilceKodu}.${dagitici.belgeNo}</td>
								</c:if>
								<td>${dagitici.duzeltmeTarihi}</td>
								<td>${dagitici.isyeri.yetkiliAdiSoyadi}</td>
								<td>${dagitici.isyeri.isyeriAdi}</td>
								<td>${dagitici.isyeri.vergiNo}</td>
								<td>${dagitici.isyeri.mersisNo}</td>
								<td>${dagitici.isyeri.isyeriAdresi}</td>
								<td>${dagitici.isyeri.ilce.isim}</td>
								<td><a href="./dagiticiSil/${dagitici.id}"
									class="btn btn-warning"> SİL</a></td>
								<td><a href="#"
									onclick='javascript:window.open("./dagiticiBelgesiYazdir?id=${dagitici.id}", "_blank", "height=500,width=450");'
									class="btn btn-success"> Yazdır</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>