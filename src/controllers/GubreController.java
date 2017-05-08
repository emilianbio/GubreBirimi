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

import models.Gubre;
import service.GubreService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class GubreController {
	@Autowired
	private GubreService gubreService;
	public Gubre gubre;
	public String tusYazisi = "Kaydet";

	@RequestMapping(value = "/gubreTanimlama")
	public String gubreTanımlama(ModelMap model) {

		if (gubre == null) {

			gubre = new Gubre();
		}
		model.put("gubre", gubre);
		model.put("title", "Gubre Tanımlama");
		model.put("gubreListesi", gubreService.gubreListesi());
		model.put("tusYazisi", tusYazisi);
		gubre = null;

		return "gubretanimlama";
	}

	@RequestMapping(value = "/gubreEkle")
	public String gubreEkle(@ModelAttribute(value = "gubre") Gubre gubre1) {

		gubre1.setEklemezamani(new Date());
		gubreService.gubreEkle(gubre1);

		return "redirect:/gubreTanimlama";
	}

	@RequestMapping(value = "/gubreDuzenle/{id}")
	public String gubreGuncelle(@PathVariable("id") long id) {

		gubre = gubreService.gubreGetir(id);
		tusYazisi = "Güncelle";
		return "redirect:/gubreTanimlama";
	}

	@RequestMapping(value = "/gubreDuzenleVazgec")
	public String gubreDuzenleVazgec() {

		gubre = null;
		tusYazisi = "Kaydet";
		return "redirect:/gubreTanimlama";
	}

	@RequestMapping(value = "/gubreSil/{id}")
	public String gubreSil(@PathVariable("id") long id) {

		gubreService.gubreSil(id);
		gubre = null;
		tusYazisi = "Kaydet";
		return "redirect:/gubreTanimlama";
	}
}
