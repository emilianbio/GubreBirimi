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

			jq("#ureticiLisansNo").val("");
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
				gubre.submit();
			}
		}
	</script>
	<fieldset>
		<legend>Arama Sekmesi</legend>
		<form:form action="gubreBul" method="get" commandName="gubreBulma"
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
	<div class="container-fluid">
		<form:form action="gubreEkle" method="post" commandName="gubre"
			autocomplete="off" class="form-horizontal">
			<form:hidden path="id" />
			<div class="col-md-15 container">
				<fieldset>
					<legend>Gübre Bilgileri</legend>
					<table>
						<tr>
							<td>Gübrenin Ticari Adı</td>
							<td><form:input path="gubreTicariAdi"
									class="form-control input-sm" /></td>
							<td>Gübrenin Tip İsmi</td>
							<td><form:input path="gubreTipAdi"
									class="form-control input-sm" /></td>



							<td>Gübrenin Tescil İsmi</td>
							<td><form:input path="gubreTescilAdi"
									class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>Gübrenin Tescil Numarası</td>
							<td><form:input path="gubreTescilNo"
									class="form-control input-sm" /></td>
							<td>Gübrenin Parti/Seri/Şarj/Lot Numarası</td>
							<td><form:input path="gubrePartiNo"
									class="form-control input-sm" /></td>
							<td>Gübrenin Ambalaj Büyüklüğü</td>
							<td><form:input path="gubreAmbalajBuyuklugu"
									class="form-control input-sm" /></td>
						</tr>
						<tr>
							<td>Gübrenin İçeriği</td>
							<td><form:input path="gubreIcerigi"
									class=" form-control input-sm" /></td>
							<td>Üretim Tarihi</td>
							<td><form:input path="gubreUretimTarihi"
									id="gubreUretimTarihi" class="form-control input-sm" /></td>
							<td>Son Kullanma Tarihi</td>
							<td><form:input path="gubreSonKullanmaTarihi"
									id="gubreSonKullanmaTarihi" class="form-control input-sm" /></td>
						</tr>
						<tr>

							<c:if test="${tusYazisi !='Güncelle'}">
								<td colspan="5"></td>
							</c:if>

							<c:if test="${tusYazisi =='Güncelle'}">
								<td colspan="4"></td>
								<td><input type="button" value="Vazgeç"
									class="form-control btn-danger btn-sm"
									onclick="javascript:location.href='./gubreDuzenleVazgec'"></td>
							</c:if>
							<td><input type="button" value="${tusYazisi}"
								onclick="formControl();"
								class="form-control btn btn-info btn-sm "></td>
						</tr>
					</table>
				</fieldset>

			</div>
		</form:form>
		<br>
		<div class="table-responsive container">
			<c:if test="${!empty gubreListesi}">



				<table class="table  table-hover table-condensed ">
					<caption>
						GÜBRE LİSTESİ
						<h6>
							Toplam <span style="color: red;">${gubreListesi.size()}</span>
							kayıt listeleniyor
						</h6>



					</caption>
					<tr class="active">
						<th>#</th>
						<th>Düzenle</th>
						<th>Gübrenin Ticari Adı</th>
						<th>Gübrenin Tip İsmi</th>
						<th>Gübrenin Tescil Numarası</th>
						<th>Gübrenin Lot Numarası</th>
						<th>Ambalaj Büyüklüğü</th>
						<th>Gübrenin İçeiği</th>
						<th>Gübrenin Üretim Tarihi</th>
						<th>Gübrenin Son Kullanma Tarihi</th>
						<th>Sil</th>
					</tr>
					<c:forEach items="${gubreListesi}" var="gubre" varStatus="siraNo">
						<tr id="satirNo${numune.id }">
							<td>${siraNo.count }</td>
							<td><a href="./gubreDuzenle/${gubre.id}"
								class="btn btn-primary btn-sm"> Düzenle</a></td>
							<td>${gubre.gubreTicariAdi}</td>
							<td>${gubre.gubreTipAdi}</td>
							<td>${gubre.gubreTescilNo}</td>
							<td>${gubre.gubrePartiNo}</td>
							<td>${gubre.gubreAmbalajBuyuklugu}</td>
							<td>${gubre.gubreIcerigi}</td>
							<td>${gubre.gubreSonKullanmaTarihi}</td>
							<td>${gubre.gubreUretimTarihi}</td>
							<td><a href="./gubreSil/${gubre.id}"
								class="btn btn-warning btn-dm">Sil</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>

</body>
</html>