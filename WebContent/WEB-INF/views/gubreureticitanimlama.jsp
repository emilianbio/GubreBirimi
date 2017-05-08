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
		jq(document).ready(function() {
			var x = jq("#vergiNo").val();
			console.log(jq("#ilce").val());

			//jq("#ureticiLisansNo").val("");
			jq("#gubreSonKullanmaTarihi").mask("99/9999", {
				placeholder : "aa/yyyy"
			});
			jq("#vergiNo").val("");
			jq("#gubreUretimTarihi").mask("99/9999", {
				placeholder : "aa/yyyy"
			});
		});

		function numunekodu(ilce) {

			//alert(ilce);
			if (ilce == "0") {
				console.log(ilce);
				jq("#numuneKodu").val("");
			} else if (ilce == "Seyhan") {
				console.log(ilce);
				jq("#numuneKodu").val("01.SEY.0" + 001);
			} else if (ilce == "Sarıçam") {
				console.log(ilce);
				jq("#numuneKodu").val("01.SAR.0" + 001);
			} else if (ilce == "Çukurova") {
				console.log(ilce);
				jq("#numuneKodu").val("01.ÇUK.0" + 001);

			} else if (ilce == "Yüreğir") {
				console.log(ilce);
				jq('#numuneKodu').val('01.YÜR.0' + 001);
			}

		}

		function formControl() {
			if (jq("#denetimSekli").val() == "0") {

				return jq.alertable.alert('Denetim Şekli Seçmelisiniz..!');
				;
			} else if (jq("#ilce").val() == "0") {
				return jq.alertable.alert("İlçe Seçmelisiniz!!");
			} else if (jq("#ureticiLisansNo").val() == "") {

				//jq.alertable.alert("Üretici Lisans No Girmelisiniz!!");

				return jq.alertable.prompt('Üretici Lisans No Giriniz').then(
						function(data) {
							jq("#ureticiLisansNo").mask(
									"9999999999999999999999");
							jq("#ureticiLisansNo").val(data.value);
							console.log(jq("#ureticiLisansNo").val());
							//numune.submit();
						}, function() {
							console.log('Prompt canceled');
						});

			}

			else if (jq("#numuneAlmaTarihi").val() == "") {

				//jq.alertable.alert("Tarih Seçmelisiniz!!");

				return jq.alertable.prompt('tarih1 giriniz').then(

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
				gubreUreticisi.submit();
			}
		}
	</script>
	<fieldset>
		<legend>Arama Sekmesi</legend>
		<form:form action="ureticiBul" method="get" commandName="ureticiBulma"
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
			</span> ile ilgili ${ureticiListesi.size()} adet kayıt bulundu...
			</label>
		</c:if>
	</fieldset>


	<form:form action="gubreUreticiEkle" method="post"
		commandName="gubreUreticisi" autocomplete="off"
		class="form-horizontal">
		<form:hidden path="id" />
		<div class="container">
			<fieldset>
				<legend>Üretici Bilgileri</legend>
				<table>
					<tr>
						<td>ÜRETİCİ ADI</td>
						<td><form:input path="ureticiAdi"
								class="form-control input-sm" /></td>

						<td>ÜRETİCİ LİSANS NO</td>
						<td><form:input path="lisansNo" id="ureticiLisansNo"
								class="form-control input-sm" /></td>
						<c:if test="${tusYazisi=='Güncelle'}">
							<td><input type="button" value="Vazgeç"
								onclick="location.href='./ureticiDuzenleVazgec'"
								class="form-control btn btn-danger btn-sm "></td>

						</c:if>

						<td><input type="button" value="${tusYazisi}"
							onclick="formControl();" class="form-control btn btn-info btn-sm"></td>
				</table>
			</fieldset>

		</div>
	</form:form>
	<br>
	<div class="container">
		<table class=" table table-sm  table-hover">
			<caption>
				ÜRETİCİ LİSTESİ
				<h6>
					Toplam <span style="color: red;">${ureticiListesi.size()}</span>
					kayıt listeleniyor
				</h6>
			</caption>

			<tr class="active">
				<th>#</th>
				<th>Düzenle</th>
				<th>Üretici Adı</th>
				<th>Üretici Lisans No</th>
			</tr>
			<c:forEach items="${ureticiListesi}" var="uretici" varStatus="siraNo">
				<tr id="satirNo${numune.id }">
					<td>${siraNo.count }</td>
					<td><a href="./ureticiDuzenle/${uretici.id}"
						class="btn btn-primary btn-sm"> Düzenle</a></td>
					<td>${uretici.ureticiAdi}</td>
					<td>${uretici.lisansNo}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>