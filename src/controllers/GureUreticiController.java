/**
 * 
 */
package controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.GubreUreticisi;
import service.GubreUreticiService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class GureUreticiController {
	@Autowired
	GubreUreticiService gubreUreticiService;

	public GubreUreticisi gubreUreticisi;
	public List<GubreUreticisi> ureticiList;
	public String tusYazisi = "Kaydet";

	@RequestMapping(value = "/gubreUreticiTanimlama")
	public String gubreUreticiTanımlama(ModelMap model) {
		if (gubreUreticisi == null) {

			gubreUreticisi = new GubreUreticisi();
		}
		model.put("gubreUreticisi", gubreUreticisi);
		model.put("ureticiListesi", gubreUreticiService.gubreUreticiList());
		model.put("title", "Gübre Üretici Tanımlama");
		model.put("tusYazisi", tusYazisi);
		gubreUreticisi = null;
		tusYazisi = "Kaydet";
		return "gubreureticitanimlama";
	}

	@RequestMapping(value = "/gubreUreticiEkle")
	public String gubreUreticiEkle(@ModelAttribute(value = "gubreUreticisi") GubreUreticisi gubreUreticisi) {

		gubreUreticisi.setEklemezamani(new Date());
		gubreUreticiService.gubreUreticiEkle(gubreUreticisi);

		return "redirect:/gubreUreticiTanimlama";
	}

	@RequestMapping(value = "/ureticiDuzenle/{id}")
	public String ureticiDuzenle(@PathVariable("id") long id) {

		gubreUreticisi = gubreUreticiService.ureticiGetir(id);

		tusYazisi = "Güncelle";
		return "redirect:/gubreUreticiTanimlama";
	}

	@RequestMapping(value = "/ureticiDuzenleVazgec")
	public String ureticiDuzenleVazgec() {

		gubreUreticisi = null;
		tusYazisi = "Kaydet";
		return "redirect:/gubreUreticiTanimlama";
	}

	@RequestMapping(value = "/ureticiBul")
	public String ureticiBulma(@RequestParam("searchString") String searchString,
			@ModelAttribute("ureticiBulma") GubreUreticisi uretici, ModelMap model) {
		if (gubreUreticisi == null) {

			gubreUreticisi = new GubreUreticisi();
		}
		model.put("gubreUreticisi", gubreUreticisi);
		model.put("title", "Gübre Üretici Arama");
		model.put("arananKelime", searchString);
		model.put("tusYazisi", tusYazisi);
		ureticiList = gubreUreticiService.ureticiList(searchString);

		if (ureticiList != null) {
			model.put("ureticiListesi", ureticiList);
		} else {
			model.put("ureticiListesi", gubreUreticiService.gubreUreticiList());
		}

		return "gubreureticitanimlama";
	}
}
