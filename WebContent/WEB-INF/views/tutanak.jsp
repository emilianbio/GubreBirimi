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
<style type="text/css">
</style>


</head>
<body>
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
			</span> ile ilgili ${tutanakListesi.size()} adet kayıt bulundu...
			</label>
		</c:if>
	</fieldset>
	<form:form action="tutanakEkle" method="post" commandName="tutanak"
		class="form-horizontal">
		<form:hidden path="id" />
		<div class="container">
			<fieldset class="form-group row">
				<legend style="border-color: #e51d6a">GENEL BİLGİLERİ</legend>
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
						<td>İŞYERİ</td>
						<td><form:select path="isyeri.id"
								class="form-control input-sm " id="ilce">
								<form:option value="0" selected="true" disabled="true"
									label="--- Seçiniz ---" />
								<form:options items="${ilceler}" />
							</form:select></td>
					</tr>
					<tr>
						<td>İŞYERİ YETKİLİ AD-SOYAD</td>
						<td><form:select path="isyeri.id"
								class="form-control input-sm" id="ilce">
								<form:option value="0" selected="true" disabled="true"
									label="--- Seçiniz ---" />
								<form:options items="${ilceler}" />
							</form:select></td>
					</tr>
					<tr>
						<td>İŞYERİ SORUMLU AD-SOYAD</td>
						<td><form:select path="isyeri.id"
								class="form-control input-sm" id="ilce">
								<form:option value="0" selected="true" disabled="true"
									label="--- Seçiniz ---" />
								<form:options items="${ilceler}" />
							</form:select></td>
					</tr>
					<tr>
						<td>DENETİM TARİHİ</td>
						<td><form:input path="denetimTarihi" type="date"
								class="form-control input-sm" /></td>
					</tr>

					<tr>
						<td>DENETİM ŞEKLİ</td>
						<td><form:input path="denetimSekli"
								class="form-control input-sm" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="form-group row">
				<legend style="border-color: #e51d6a">LİSANS ve TESCİL NOSU</legend>
				<table>
					<tr>
						<td>LİSANS NO</td>
						<td><form:input path="lisansNo" class="form-control input-sm" /></td>
					</tr>
					<tr>
						<td>TESCİL NO</td>
						<td><form:input path="tescilNo" class="form-control input-sm" /></td>
					</tr>
					<tr>
						<td>GÜBRE TÜRÜ</td>
						<td><form:select path="gubreTuru"
								class="form-control input-sm" id="ilce">
								<form:option value="0" label="--- Seçiniz ---" disabled="true" />
								<form:option value="Kimyevi">Kimyevi</form:option>
								<form:option value="Organik">Organik</form:option>
							</form:select></td>
					</tr>
					<tr>
						<td>TİP ADI</td>
						<td><form:input path="tipAdi" class="form-control input-sm" /></td>
					</tr>

					<tr>
						<td>MENŞEİ</td>
						<td><form:select path="mensei" class="form-control input-sm"
								id="ilce">
								<form:option value="0" label="--- Seçiniz ---" />
								<form:option value="İthal">İthal</form:option>
								<form:option value="Türkiye">Türkiye</form:option>
							</form:select></td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="form-group row">
				<legend style="border-color: #e51d6a"></legend>
				<table>
					<tr>
						<td>NUMUNE</td>
						<td><form:input path="numune" class="form-control input-sm" /></td>
						<td>TESCİL ETİKET</td>
						<td><form:input path="tescilEtiket"
								class="form-control input-sm" /></td>
						<td>ANALİZ</td>
						<td><form:input path="analiz" class="form-control input-sm" /></td>

						<td>İŞYERİ ŞARTLARI</td>
						<td><form:input path="isyeriSartlari"
								class="form-control input-sm" /></td>
						<td>DİĞER</td>
						<td><form:input path="diger" class="form-control input-sm" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="form-group row">
				<table>
					<tr>
						<td>TESPİT EDİLEN EKSİKLİKLER</td>
						<td>:<form:input path="tespitEdilenEksiklikler"
								class="form-control input-sm" /></td>
					</tr>
					<tr>
						<td>AÇIKLAMA</td>
						<td>:<form:textarea path="aciklama" rows="4" cols="175"
								class="form-control input-sm" /></td>
					</tr>
				</table>
				<br> <input type="submit" value="KAYDET"
					class="form-control btn-danger">
			</fieldset>
		</div>
	</form:form>
</body>
</html>