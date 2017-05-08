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

<script src="<c:url value="/assets/genel.js"  />" type="text/javascript"></script>
<script src="<c:url value="/assets/jquery.alertable.js" />"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.alertable.min.js" />"
	type="text/javascript"></script>
<link href="<c:url value="/assets/jquery.alertable.css"/>"
	rel="stylesheet">
</head>
<body>

	<script type="text/javascript">
		jq(document).ready(function() {

			jq("#vergiNo").mask("99999999999", {
				placeholder : "TC No yada Vergi No Giriniz"
			});

			$('#eMail').mask("A", {
				translation : {
					"A" : {
						pattern : /[\w@\-.+]/,
						recursive : true
					}
				}
			});

		});
	</script>
	<fieldset>
		<legend>Arama Sekmesi</legend>
		<form:form action="isyeriBul" method="get" commandName="isyeriBulma"
			autocomplete="off" class="form-inline">
			<label>Aranacak Kelime Giriniz</label>
			<input name="searchString" id="searchString" type="text" value=""
				class="form-control">
			<input type="submit" value="Ara" class="btn btn-success">
		</form:form>
		<legend></legend>
		<c:if test="${!empty arananKelime}">
			<label class="form"> Aradığınız Kelime:</label>
			<br />
			<label class="form"> <span style="color: red;">"${arananKelime}"
			</span> ile ilgili ${isyeriListesi.size()} adet kayıt bulundu...
			</label>
		</c:if>
	</fieldset>
	<form:form action="isyeriEkle" method="post" commandName="isyeri"
		class="form-horizontal">
		<form:hidden path="id" />
		<div class="container">
			<fieldset>
				<legend>İşyeri Bilgileri</legend>

				<table>
					<tr>
						<td>VERGİ NO / TC NO</td>
						<td><form:input path="vergiNo" class="form-control input-sm"
								id="vergiNo" /></td>

						<td>MERSİS NO</td>
						<td><form:input path="mersisNo" class="form-control input-sm"
								id="mersisNo" data-mask-reverse="true" /></td>

						<td>İŞYERİ ADI</td>
						<td><form:input path="isyeriAdi" id="isyeriAdi"
								class="form-control input-sm" /></td>
					</tr>
					<tr>
						<td>İLÇE</td>
						<td><form:select path="ilce.id" id="ilce"
								class="form-control input-sm" onchange="numunekodu(this.value);">
								<form:option value="0" selected="true" disabled="true"> Seçiniz----</form:option>
								<form:options items="${ilceListesi}" itemLabel="isim"
									itemValue="id" />
							</form:select></td>
						<td>YETKİLİ ADI-SOYADI</td>
						<td><form:input path="yetkiliAdiSoyadi" id="yetkiliAdiSoyadi"
								class="form-control input-sm" /></td>

						<td>SORUMLU ADI-SOYADI</td>
						<td><form:input path="sorumluAdiSoyadi" id="sorumluAdiSoyadi"
								class="form-control input-sm" /></td>
					</tr>

					<tr>
						<td>E-MAIL ADRESİ</td>
						<td><form:input type="email" path="eMail" id="eMail"
								placeholder="ornek@deneme.com.tr" class="form-control input-sm" /></td>
					</tr>
					<tr>
						<td>İŞYERİ ADRESİ</td>
						<td colspan="5"><form:textarea path="isyeriAdresi"
								id="isyeriAdresi" class="form-control input-sm" cols="160" /></td>
					</tr>
					<tr>
						<td>DEPO ADRESİ</td>
						<td colspan="5"><form:textarea path="depoAdresi"
								id="depoAdresi" class="form-control input-sm" rows="2"
								cols="160" /></td>
					</tr>
					<tr>

						<c:if test="${tusYazisi !='Güncelle'}">
							<td colspan="5"></td>
						</c:if>

						<c:if test="${tusYazisi =='Güncelle'}">
							<td colspan="4"></td>
							<td><input type="button" value="Vazgeç"
								class="form-control btn-danger btn-sm"
								onclick="javascript:location.href='./isyeriDuzenleVazgec'"></td>
						</c:if>

						<td><input type="button" value="${tusYazisi}"
							onclick="isyeriFormControl();"
							class="form-control btn-info btn-sm"></td>


					</tr>
				</table>
			</fieldset>



		</div>
	</form:form>
	<br>
	<div class="container">
		<table class="table table-hover table-condense">
			<caption>
				İŞYER TABLOSU
				<h6>
					Toplam <span style="color: red;">${isyeriListesi.size()}</span>
					kayıt listeleniyor
				</h6>


			</caption>
			<thead>
				<tr class="active">
					<th>#</th>
					<th>Düzenle</th>
					<th>İlce</th>
					<th>İşyeri Adı</th>
					<th>Sorumlu Adı-Soyadı</th>
					<th>Yetkili Adı-Soyadı</th>
					<th>İşyeri Adresi</th>
					<th>Depo Adresi</th>
					<th>Vergi No</th>
					<th>Mersis No</th>
					<th>İlce Kodu</th>
					<th>İl Kodu</th>
					<th>Sil</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${isyeriListesi}" var="isyeri" varStatus="sira">
					<tr id="satirNo${isYeri.id}">
						<td>${sira.count}</td>
						<td><a
							href="${pageContext.request.contextPath}/isyeriGetir/${isyeri.id}"
							class="btn btn-primary btn-sm">Düzenle</a></td>
						<td>${isyeri.ilce.isim}</td>
						<td>${isyeri.isyeriAdi }</td>
						<td>${isyeri.sorumluAdiSoyadi }</td>
						<td>${isyeri.yetkiliAdiSoyadi}</td>
						<td>${isyeri.isyeriAdresi }</td>
						<td>${isyeri.depoAdresi }</td>
						<td>${isyeri.vergiNo }</td>
						<td>${isyeri.mersisNo }</td>
						<td>${isyeri.ilce.ilceKodu }</td>
						<td>${isyeri.ilce.il.ilKodu }</td>
						<td><a href="./isyeriSil/${isyeri.id}"
							class="btn btn-warning btn-sm"> SİL</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>