var jq = jQuery.noConflict();

jq(document).ready(function() {
	//jq("#belgeNo").val("");
});

function isyeriGetir(isyeriID) {

	var x = parseInt('${sonDagiticiBelgeNo}');
	jq.ajax({
		type : "GET",
		dataType : 'json',
		url : './isYeriGetir',
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		data : {
			id : isyeriID
		},
		success : function(data) {
			console.log(data.depoAdresi);
			jq("#lblBelgeNo").text(data.ilKodu + "." + data.ilceKodu + "")

		},
		complete : function(data) {

			jq.ajax({
				type : 'get',
				dataType : 'html',
				url : './sonDagiticiBelgeNo',
				success : function(belgeNo) {
					// alert(belgeNo);
					jq("#belgeNo").val(belgeNo);
				}
			})
		},

		error : function(xhr, textStatus, errorThrown) {
			alert(textStatus, xhr, errorThrown);
		}

	})
};

function isyeriFormControl() {

	if (jq("#vergiNo").val() == "") {

		return jq.alertable.alert('TC No yada Vergi No Girmelisiniz..!');

	} else if (jq("#isyeriAdi").val() == "") {

		return jq.alertable.alert("İş Yeri Adı Girmelisiniz..!!");

	} else if (jq("#ilce").val() == null) {

		return jq.alertable.alert("İlçe Seçiniz...");

	} else if (jq("#yetkiliAdiSoyadi").val() == "") {

		return jq.alertable.alert("Yetkili İsmi Giriniz...!");
	} else if (jq("#sorumluAdiSoyadi").val() == "") {

		// jq.alertable.alert("Tarih Seçmelisiniz!!");

		return jq.alertable.alert('Sorumlu İsmi Giriniz...!');

	} else if (jq("#eMail").val() == "") {
		return jq.alertable.alert('Geçerli Bir e-Mail Giriniz...!');

	} else if (jq("#isyeriAdresi").val() == "") {

		return jq.alertable.alert('İşyeri Adresi Giriniz...!');

	} else if (jq("#depoAdresi").val() == "") {

		return jq.alertable.alert('Depo Adresi Giriniz...!');

	} else {
		isyeri.submit();
	}

}

function dagiticiFormControl() {

	if (jq("#isyeriAdi").val() == 0 || jq("#isyeriAdi").val() == null
			|| jq("#isyeriAdi").val() == "" || jq("#isyeriAdi").val() == "0") {

		return jq.alertable.alert("İş Yeri Adı Girmelisiniz..!!");

	} else if (jq("#duzeltmeTarihi").val() == "") {

		return jq.alertable.alert("Tarih Giriniz...");

	}

	else {
		dagitici.submit();
	}

}
