/**
 * 
 */
package controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import models.Ilce;
import service.IlService;
import service.IlceService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class IlceController {
	@Autowired
	private IlService ilService;
	@Autowired
	private IlceService ilceService;
	public Ilce ilce;
	public String legend = "İlce Bilgileri";
	public String tusYazisi = "Kaydet";

	@RequestMapping(value = "/ilce")
	public String illce(ModelMap model) {

		if (ilce == null) {

			ilce = new Ilce();
		}

		model.put("ilce", ilce);
		model.put("ilListesi", ilService.ilListesi());
		model.put("ilceListesi", ilceService.ilceListesi());
		model.put("title", "İlce Ekle");
		model.put("legend", legend);
		model.put("tusYazisi", tusYazisi);
		ilce = null;
		legend = "İlce Bilgileri";
		tusYazisi = "Kaydet";
		return "ilcesayfasi";
	}

	@RequestMapping(value = "/ilceEkle")
	public String ilceEkle(@ModelAttribute(value = "ilce") Ilce ilce) {
		ilce.setEklemeZamani(new Date());
		ilceService.ilceEkle(ilce);

		return "redirect:/ilce";
	}

	@RequestMapping(value = "/ilceDuzenle/{id}")
	public String ilceDuzenle(@PathVariable("id") Long id) {

		ilce = ilceService.ilceGetir(id);
		tusYazisi = "Güncelle";
		legend = "İlce Bilgileri Düzenle";
		return "redirect:/ilce";
	}

	@RequestMapping(value = "/ilceVazgec}")
	public String vazgec() {
		ilce = null;
		legend = "İlce Bilgileri";
		tusYazisi = "Kaydet";

		return "redirect:/ilce";
	}

}
