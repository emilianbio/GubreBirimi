<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="<c:url value="/assets/gthbLogo.png"/>" />
<title>${title}&nbsp;|&nbsp;GübreBirimi</title>
<link href="<c:url value="/assets/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/assets/jquery-3.1.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/assets/bootstrap.min.js" />"
	type="text/javascript"></script>
	
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
<script type="text/javascript">
	var jq = jQuery.noConflict();

	function numuneSayfasi() {
		jq.ajax({
			type : "GET",
			url : '${pageContext.request.contextPath}/NumuneAlmaTutanagi',
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(data) {
				window.location.href = "./NumuneAlmaTutanagi";
			},
			error : function(xhr, textStatus, errorThrown) {
				alert(textStatus + " " + xhr + " " + " " + errorThrown);
			}

		})
	}

	function isyeriSayfasi() {
		jq.ajax({
			type : "GET",
			url : '${pageContext.request.contextPath}/NumuneAlmaTutanagi',
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(data) {
				window.location.href = "./isyeri";
			},
			error : function(xhr, textStatus, errorThrown) {
				alert(textStatus + " " + xhr + " " + " " + errorThrown);
			}

		})
	}

	function personelSayfasi() {
		jq.ajax({
			type : "GET",
			url : '${pageContext.request.contextPath}/NumuneAlmaTutanagi',
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(data) {
				window.location.href = "./personel";
			},
			error : function(xhr, textStatus, errorThrown) {
				alert(textStatus + " " + xhr + " " + " " + errorThrown);
			}

		})
	}

	function tutanakSayfasi() {
		jq.ajax({
			type : "GET",
			url : '${pageContext.request.contextPath}/NumuneAlmaTutanagi',
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(data) {
				window.location.href = "./tutanak";
			},
			error : function(xhr, textStatus, errorThrown) {
				alert(textStatus + " " + xhr + " " + " " + errorThrown);
			}

		})
	}

	function gubreSayfasi() {
		jq.ajax({
			type : "GET",
			url : '${pageContext.request.contextPath}/NumuneAlmaTutanagi',
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(data) {
				window.location.href = "./gubreTanimlama";
			},
			error : function(xhr, textStatus, errorThrown) {
				alert(textStatus + " " + xhr + " " + " " + errorThrown);
			}

		})
	}

	function gubreUreticiSayfasi() {
		jq.ajax({
			type : "GET",
			url : '${pageContext.request.contextPath}/NumuneAlmaTutanagi',
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(data) {
				window.location.href = "./gubreUreticiTanimlama";
			},
			error : function(xhr, textStatus, errorThrown) {
				alert(textStatus + " " + xhr + " " + " " + errorThrown);
			}

		})
	}

	function dagiticiSayfasi() {
		jq
				.ajax({
					type : "GET",
					url : '${pageContext.request.contextPath}/NumuneAlmaTutanagi',
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					success : function(data) {
						window.location.href = "./dagiticiBelgesi";
					},
					error : function(xhr, textStatus, errorThrown) {

						console.log(xhr);
						alert("Sayfaya ulaşılamıyor, lütfen sistem yöneticinizle görüşün..!"
								+ textStatus + " /" + xhr + " \\" + errorThrown);
					}

				})
	}
</script>

</head>
<body>
	<nav class="navbar navbar-default navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul
				class="nav navbar-nav ${fn:contains(pageContext.request.requestURI,'/gubreTanimlama') ? 'in' : ''}">
				<li><a href="./">Anasayfa</a></li>
				<li><a href="#" onclick="isyeriSayfasi()">İşyeri Tanımlama</a></li>
				<li><a href="#" onclick="dagiticiSayfasi()">Dağıtıcı
						Belgesi</a></li>
				<li><a href="#" onclick="gubreUreticiSayfasi()">Üretici
						Tanımlama</a></li>
				<li><a href="#" onclick="gubreSayfasi()">Gübre Tanımlama</a></li>
				<li><a href="#" onclick="tutanakSayfasi()">Denetim Tutanağı</a></li>
				<li><a href="#" onclick="numuneSayfasi()">Numune Tutanağı</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span></span> Login</a></li>
			</ul>
		</div>
	</div>
	</nav>




</body>
</html>