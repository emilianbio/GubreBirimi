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
<!-------------------------------------------------------------------------------------------->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-------------------------------------------------------------------------------------------->

<script src="<c:url value="/assets/jquery-3.1.1.min.js" />"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.mask.js" />"
	type="text/javascript"></script>

<script src="<c:url value= "/assets/jquery.mask.min.js"/>"
	type="text/javascript"></script>

<script src="<c:url value= "/assets/jquery.mask.min.js"/>"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.alertable.js" />"
	type="text/javascript"></script>

<script src="<c:url value="/assets/jquery.alertable.min.js" />"
	type="text/javascript"></script>

<link href="<c:url value="/assets/jquery.alertable.css"/>"
	rel="stylesheet">
</head>
<body>
	<script type="text/javascript">
		var jq = jQuery.noConflict();
		var sonNumuneKodu = parseInt('${sonNumuneKodu}');
		console.log("Son Numune Kodu: " + sonNumuneKodu);
		jq(document).ready(function() {
			console.log(jq("#ilce").val());

			jq("#gubreSonKullanmaTarihi").mask("99/9999", {
				placeholder : "aa/yyyy"
			});
			jq("#gubreUretimTarihi").mask("99/9999", {
				placeholder : "aa/yyyy"
			});
		});

		function numunekodu(ilce) {

			if (ilce == "0") {
				console.log(ilce);
				jq("#lblNumuneKodu").text("");
			} else if (ilce == 2) {
				console.log(ilce);
				jq("#lblNumuneKodu").text("01.SEY.0");
			} else if (ilce == 13) {
				console.log(ilce);
				jq("#lblNumuneKodu").text("01.SAR.0");
			} else if (ilce == 14) {
				console.log(ilce);
				jq("#lblNumuneKodu").text("01.ÇUK.0");
			} else if (ilce == 11) {
				console.log(ilce);
				jq('#lblNumuneKodu').text('01.YÜR.0');
			}

		}

		function formControl() {
			console.log(jq("#denetimSekli").val());
			console.log(jq("#ureticiID").val());
			console.log(jq("#ilce").val());

			if (jq("#denetimSekli").val() == null) {

				return jq.alertable.alert('Denetim Şekli Seçmelisiniz..!');

			} else if (jq("#ilce").val() == null) {
				return jq.alertable.alert("İlçe Seçmelisiniz!!");
			} else if (jq("#ureticiID").val() == null) {

				return jq.alertable.alert("Üretici Seçiniz...");

				/* prompt('Üretici Seçiniz...').then(

				function(data) {
					jq("#ureticiLisansNo").mask("9999999999999999999999");
					jq("#ureticiLisansNo").val(data.value);
					console.log(jq("#ureticiLisansNo").val());
					//numune.submit();
				}, function() {
					console.log('Prompt canceled');
				}); */

			} else if (jq("#gubreID").val() == null) {

				return jq.alertable.alert("Gübre Seçiniz...");
			}

			else if (jq("#numuneAlmaTarihi").val() == "") {

				//jq.alertable.alert("Tarih Seçmelisiniz!!");

				return jq.alertable.alert('Tarih Giriniz...!').then(

				function(data) {
					jq("#numuneAlmaTarihi").mask("9999999999999999999999");
					jq("#numuneAlmaTarihi").val(data.value);
					console.log(jq("#numuneAlmaTarihi").val(data.value));
					//numune.submit();
				}, function() {
					console.log('Prompt canceled');
				});

			} else if (jq("#denetimSekli").val() == "0") {

			} else {
				numune.submit();
			}
		}

		function ara() {

			numuneBulma.submit();

		}
	</script>
	<fieldset>
		<legend>Arama Sekmesi</legend>
		<form:form action="numuneBul" method="get" commandName="numuneBulma"
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
			</span> ile ilgili ${numuneListesi.size()} adet kayıt bulundu...
			</label>
		</c:if>
	</fieldset>

	<form:form action="numuneEkle" method="post" commandName="numune"
		autocomplete="off" class="form-horizontal">
		<form:hidden path="id" />
		<div class="col-md-15 container">
			<fieldset>
				<legend>Numune Bilgileri</legend>
				<table>
					<tr>
						<td>Durum</td>
						<td><form:select path="durum" id="durum"
								class="form-control input-sm">
								<form:option value="1">Aktif</form:option>
								<form:option value="0">Pasif</form:option>
							</form:select></td>
					</tr>
					<tr>
						<td>Denetim Şekli</td>
						<td><form:select path="denetimSekli" id="denetimSekli"
								class="form-control input-sm">
								<form:option value="0" selected="true" disabled="true">Seçiniz----</form:option>
								<form:option value="Piyasa">Piyasa</form:option>
								<form:option value="Şikayet">Şikayet</form:option>
							</form:select></td>
						<td>İl</td>
						<td><form:select path="il.id" id="il"
								class="form-control input-sm">
								<%-- <form:option value="0" selected="true" disabled="true">--Seçiniz____</form:option> --%>
								<form:options items="${ilListesi}" itemLabel="isim"
									itemValue="id" />
							</form:select></td>
						<td>İlçe</td>
						<td><form:select path="ilce.id" id="ilce"
								class="form-control input-sm" onchange="numunekodu(this.value);">
								<form:option value="0" selected="true" disabled="true"> Seçiniz----</form:option>
								<form:options items="${ilceListesi}" itemLabel="isim"
									itemValue="id" />
							</form:select></td>
						<td>Numune Kodu:<form:label path="numuneKodu"
								id="lblNumuneKodu"></form:label></td>
						<td><form:input path="numuneKodu" id="numuneKodu"
								value="${sonNumuneKodu}" class="form-control input-sm" /> <form:label
								path="numuneKodu" id="lblNumuneKodu"></form:label></td>
					</tr>

					<tr>
						<td>Üretici Adı</td>
						<td><form:select path="gubreUretici.id" id="ureticiID"
								class="form-control input-sm">
								<form:option value="0" disabled="true" selected="true"> --Seçiniz...</form:option>
								<form:options items="${ureticiListesi}" itemLabel="ureticiAdi"
									itemValue="id" />

							</form:select></td>

						<td>Gübrenin Ticari Adı</td>
						<td><form:select path="gubre.id"
								class="form-control input-sm" id="gubreID">
								<form:option value="0" selected="true" disabled="true"> --Seçiniz...</form:option>
								<form:options items="${gubreListesi}" itemLabel="gubreTescilAdi"
									itemValue="id" />
							</form:select></td>
						<%-- <td>Gübrenin Tip İsmi</td>
					<td><form:input path="gubre.gubreTipAdi"
							class="form-control input-sm" /></td> --%>
					</tr>
					<tr>
						<%-- <td>Gübrenin Tescil Numarası</td>
					<td><form:input path="gubre.gubreTescilNo"
							class="form-control input-sm" /></td>
					<td>Gübrenin Parti/Seri/Şarj/Lot Numarası</td>
					<td><form:input path="gubre.gubrePartiNo"
							class="form-control input-sm" /></td>
					<td>Gübrenin Ambalaj Büyüklüğü</td>
					<td><form:input path="gubre.gubreAmbalajBuyuklugu"
							class="form-control input-sm" /></td> --%>
						<td>Numune Alma Tarihi</td>
						<td><form:input path="numuneAlmaTarihi" id="numuneAlmaTarihi"
								type="date" class="form-control input-sm" /></td>
					</tr>
					<%-- <tr>
					<td>Gübrenin İçeriği</td>
					<td><form:input path="gubre.gubreIcerigi"
							class=" form-control input-sm" /></td>
					<td>Üretim Tarihi</td>
					<td><form:input path="gubre.gubreUretimTarihi"
							id="gubreUretimTarihi" class="form-control input-sm" /></td>
					<td>Son Kullanma Tarihi</td>
					<td><form:input path="gubre.gubreSonKullanmaTarihi"
							id="gubreSonKullanmaTarihi" class="form-control input-sm" /></td>
				</tr> --%>

					<tr>
						<c:if test="${tusYazisi!='Güncelle' }">
							<td colspan="7"></td>
						</c:if>

						<c:if test="${tusYazisi=='Güncelle' }">
							<td colspan="6"></td>
							<td><input type="button" value="Vazgeç"
								onclick="location.href='./numuneGuncelleVazgec'"
								class="form-control btn btn-danger"></td>
						</c:if>

						<td><input type="button" value="${tusYazisi}"
							onclick="formControl();" class="form-control btn btn-info"></td>
					</tr>
				</table>

			</fieldset>
		</div>
	</form:form>
	<br>
	<div class="table-responsive container">
		<table class="table  table-hover ">
			<caption>
				NUMUNE TUTANAK LİSTESİ
				<h6>
					Toplam <span style="color: red;">${numuneListesi.size()}</span>
					kayıt listeleniyor
				</h6>
			</caption>

			<tr class="active">
				<th>#</th>
				<th>Düzenle</th>
				<th>Denetim Şekli</th>
				<th>İl</th>
				<th>İlçe</th>
				<th>Numune Kodu</th>
				<th>Üretici Adı</th>
				<th>Üretici Lisans No</th>
				<th>Ticari Adı</th>
				<th>Tip İsmi</th>
				<th>Tescil Numarası</th>
				<th>Lot Numarası</th>
				<th>Ambalaj Büyüklüğü</th>
				<th>Numune Alma Tarihi</th>
				<th>İçeiği</th>
				<th>Üretim Tarihi</th>
				<th>Son Kullanma Tarihi</th>
				<th>Sil</th>

			</tr>
			<c:forEach items="${numuneListesi}" var="numune" varStatus="siraNo">
				<tr id="satirNo${numune.id }">
					<td>${siraNo.count }</td>
					<td><a href="./numuneGuncelle/${numune.id}"
						class="btn btn-primary btn-sm">Düzenle</a></td>
					<td>${numune.denetimSekli}</td>
					<td>${numune.il.isim}</td>
					<td>${numune.ilce.isim}</td>
					<c:if test="${numune.ilce.isim=='Yüreğir'}">
						<td>01.YÜR.0${numune.numuneKodu}</td>
					</c:if>
					<c:if test="${numune.ilce.isim=='Seyhan'}">
						<td>01.SEY.0${numune.numuneKodu}</td>
					</c:if>
					<c:if test="${numune.ilce.isim=='Çukurova'}">
						<td>01.ÇUK.0${numune.numuneKodu}</td>
					</c:if>
					<c:if test="${numune.ilce.isim=='Sarıçam'}">
						<td>01.SAR.0${numune.numuneKodu}</td>
					</c:if>
					<c:if test="${numune.ilce.isim=='Yumurtalık'}">
						<td>01.YUM.0${numune.numuneKodu}</td>
					</c:if>
					<td>${numune.gubreUretici.ureticiAdi}</td>
					<td>${numune.gubreUretici.lisansNo}</td>
					<td>${numune.gubre.gubreTicariAdi}</td>
					<td>${numune.gubre.gubreTipAdi}</td>
					<td>${numune.gubre.gubreTescilNo}</td>
					<td>${numune.gubre.gubrePartiNo}</td>
					<td>${numune.gubre.gubreAmbalajBuyuklugu}</td>
					<td><fmt:formatDate value="${numune.numuneAlmaTarihi}"
							pattern="dd.MM.yyyy" dateStyle="full" /></td>
					<td>${numune.gubre.gubreIcerigi}</td>
					<td>${numune.gubre.gubreUretimTarihi}</td>
					<td>${numune.gubre.gubreSonKullanmaTarihi}</td>
					<td><a href="./numuneSil/${numune.id}"
						class="btn btn-warning btn-sm">Sil</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>


</body>
</html>