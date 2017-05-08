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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import models.NumuneAlmaTutanagi;
import service.GubreService;
import service.GubreUreticiService;
import service.IlService;
import service.IlceService;
import service.NumuneService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class NumuneController {
	@Autowired
	private NumuneService numuneService;
	@Autowired
	private GubreUreticiService gubreUreticiService;
	@Autowired
	private GubreService gubreService;
	@Autowired
	private IlceService ilceService;
	@Autowired
	private IlService ilService;

	private NumuneAlmaTutanagi numune;
	public List<NumuneAlmaTutanagi> numuneListesi;
	public String tusYazisi = "Kaydet";

	@RequestMapping(value = "/NumuneAlmaTutanagi")
	public String numune(ModelMap model) {
		if (numune == null) {

			numune = new NumuneAlmaTutanagi();
		}
		model.put("numune", numune);
		model.put("ureticiListesi", gubreUreticiService.gubreUreticiList());
		model.put("gubreListesi", gubreService.gubreListesi());
		model.put("ilListesi", ilService.ilListesi());
		model.put("ilceListesi", ilceService.ilceListesi());
		if (numune.getId() == 0) {

			model.put("sonNumuneKodu", numuneService.sonNumuneKoduGetir());
		} else {
			model.put("sonNumuneKodu", numune.getNumuneKodu());
		}

		model.put("tusYazisi", tusYazisi);

		if (numuneListesi != null) {
			model.put("numuneListesi", numuneListesi);

		} else {
			model.put("numuneListesi", numuneService.numuneList());
		}
		model.put("title", "Numune Tutanağı");
		numuneListesi = null;

		tusYazisi = "Kaydet";
		return "numunetutanagi";
	}

	@RequestMapping(value = "/numuneEkle", method = RequestMethod.POST)
	public String numuneEkle(ModelMap model, @ModelAttribute(value = "numuneBulma") NumuneAlmaTutanagi numune1,
			@ModelAttribute(value = "numune") NumuneAlmaTutanagi numune2) {
		System.out.println("Numune EKle id : " + numune2.getId());
		try {
			numune2.setEklemezamani(new Date());
			numuneService.numuneEkle(numune2);
		} catch (Exception e) {
			System.out.println(e);
		}
		numune = null;
		return "redirect:/NumuneAlmaTutanagi";
	}

	@RequestMapping(value = "/numuneBul", method = RequestMethod.GET)
	public String numuneBul(@RequestParam(value = "searchString") String searchString, ModelMap model,
			@ModelAttribute(value = "numuneBulma") NumuneAlmaTutanagi numune1) {
		if (numune == null) {

			numune = new NumuneAlmaTutanagi();
		}
		model.put("numune", numune);
		model.put("arananKelime", searchString);
		model.put("ureticiListesi", gubreUreticiService.gubreUreticiList());
		model.put("gubreListesi", gubreService.gubreListesi());
		model.put("ilListesi", ilService.ilListesi());
		model.put("ilceListesi", ilceService.ilceListesi());
		model.put("tusYazisi", tusYazisi);
		model.put("sonNumuneKodu", numuneService.sonNumuneKoduGetir());
		numuneListesi = numuneService.numuneList(searchString);

		if (numuneListesi != null) {
			model.put("numuneListesi", numuneListesi);

		} else {
			model.put("numuneListesi", numuneService.numuneList());
		}
		model.put("title", "Numune Arama");
		numuneListesi = null;
		return "numunetutanagi";
	}

	@RequestMapping(value = "/numuneGuncelle/{id}")
	public String numuneGuncelle(@PathVariable("id") long id) {

		numune = numuneService.numuneGetir(id);
		tusYazisi = "Güncelle";
		return "redirect:/NumuneAlmaTutanagi";
	}

	@RequestMapping(value = "/numuneGuncelleVazgec")
	public String numuneGuncelleVazgec() {

		tusYazisi = "Kaydet";
		numune = null;
		return "redirect:/NumuneAlmaTutanagi";
	}

	@RequestMapping(value = "/numuneSil/{id}")
	public String numuneSil(@PathVariable("id") long id) {
		numuneService.numuneSil(id);

		return "redirect:/NumuneAlmaTutanagi";
	}

}
