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
import org.springframework.web.bind.annotation.ResponseBody;

import models.Dagitici;
import service.DagiticiService;
import service.IlceService;
import service.IsyeriService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class DagiticiController {
	@Autowired
	private IsyeriService isyeriService;
	@Autowired
	private DagiticiService dagiticiService;
	@Autowired
	private IlceService ilceService;
	public Dagitici dagitici;
	public String tusYazisi = "Kaydet";

	public List<Dagitici> dagiticiList;

	@RequestMapping(value = "/dagiticiBelgesi")
	public String dagiticiBelgesi(ModelMap model) {
		if (dagitici == null) {

			dagitici = new Dagitici();
		}
		model.put("dagiticiBulma", dagitici);
		model.put("dagitici", dagitici);
		model.put("title", "Dağıtıclık Belgesi");
		if (dagiticiList == null || dagiticiList.size() == 0) {
			model.put("dagiticiListesi", dagiticiService.dagiticiListesi());
		} else {

			model.put("dagiticiListesi", dagiticiList);

		}
		model.put("ilceListesi", ilceService.ilceListesi());
		model.put("isyeriListesi", isyeriService.isyeriListesi());
		model.put("sonDagiticiBelgeNo", dagiticiService.sonDagiticiBelgeNo());
		model.put("tusYazisi", tusYazisi);
		dagitici = null;
		dagiticiList = null;
		tusYazisi = "Kaydet";
		return "dagiticibelgesi";
	}

	@RequestMapping(value = "/DagiticiBelgesiError")
	public String dagiticiBelgesiError(ModelMap model) {
		if (araclar.Genel.hata != null) {
			model.put("error", araclar.Genel.hata);
			model.put("title", "Hata Sayfası");
			return "Exceptions/Dagitici/dagiticiException";
		}
		araclar.Genel.hata = null;

		return "redirect:/dagiticiBelgesi";
	}

	@RequestMapping(value = "/dagiticiBelgesiEkle")
	public String dagiticiEkle(@ModelAttribute(value = "dagitici") Dagitici dagitici1) {
		try {
			dagitici1.setEklemeZamani(new Date());
			dagiticiService.dagiticiEkle(dagitici1);
			return "redirect:/dagiticiBelgesi";
		} catch (Exception e) {
			araclar.Genel.hata = e;
			return "redirect:/DagiticiBelgesiError";
			// TODO: handle exception
		}

	}

	@RequestMapping(value = "/dagiticiGetir/{id}")
	public String dagiticiGetir(@PathVariable("id") Long id) {

		dagitici = dagiticiService.dagiticiGetir(id);
		tusYazisi = "Güncelle";
		return "redirect:/dagiticiBelgesi";
	}

	@RequestMapping(value = "/sonDagiticiBelgeNo", method = RequestMethod.GET)
	public @ResponseBody int sonDagiticiBelgeNo() {
		System.out.println("id çalıştı");

		return (int) dagiticiService.sonDagiticiBelgeNo() + 1;
	}

	@RequestMapping(value = "/dagiticiSil/{id}")
	public String dagiticiSil(@PathVariable("id") Long id) {

		// dagiticiService.dagiticiSil(id);
		dagitici = dagiticiService.dagiticiGetir(id);
		dagitici.setDurum(false);

		dagiticiService.dagiticiEkle(dagitici);
		tusYazisi = "Kaydet";
		return "redirect:/dagiticiBelgesi";
	}

	@RequestMapping(value = "/dagiticiBelgesiYazdirmaSayfasi")
	public String dagiticiBelgesiYazdirmaSayfasi(ModelMap model) {

		model.put("dagitici", dagitici);
		return "dagiticibelgesiyazdir";
	}

	@RequestMapping(value = "/dagiticiBelgesiYazdir")
	public String dagiticiBelgesiYazdir(@RequestParam("id") Long id, ModelMap model) {

		dagitici = dagiticiService.dagiticiGetir(id);

		System.out.println("belge no " + dagitici.getBelgeNo());
		return "redirect:/dagiticiBelgesiYazdirmaSayfasi";
	}

	@RequestMapping(value = "/dagiticiDuzenleVazgec")
	public String dagiticiDuzenleVazgec() {
		dagitici = null;
		tusYazisi = "Kaydet";
		return "redirect:/dagiticiBelgesi";
	}

	@RequestMapping(value = " /dagiticiBul", method = RequestMethod.GET)
	public String numuneBul(@RequestParam(value = "searchString") String searchString, ModelMap model,
			@ModelAttribute(value = "dagiticiBulma") Dagitici dagitici2) {
		if (dagitici == null) {

			dagitici = new Dagitici();
		}
		model.put("dagiticiBulma", dagitici);
		model.put("dagitici", dagitici);
		model.put("title", "Dağıtıclık Belgesi");
		model.put("ilceListesi", ilceService.ilceListesi());
		model.put("isyeriListesi", isyeriService.isyeriListesi());
		model.put("sonDagiticiBelgeNo", dagiticiService.sonDagiticiBelgeNo());
		model.put("tusYazisi", tusYazisi);
		model.put("arananKelime", searchString);
		dagiticiList = dagiticiService.dagiticiBul(searchString);
		if (dagiticiList != null) {
			model.put("dagiticiListesi", dagiticiList);
		} else {

			model.put("dagiticiListesi", dagiticiService.dagiticiListesi());
		}

		dagitici = null;
		tusYazisi = "Kaydet";
		model.put("title", "Dağıtıcı Arama");
		dagiticiList = null;
		return "dagiticibelgesi";
	}

	@RequestMapping(value = "/ilceyeGoreDagiticiGetir")
	public String ilceyeGoreDagiticiGetir(@RequestParam("isyeri.ilce.id") Long id, ModelMap model) {

		dagiticiList = dagiticiService.ilceyeGoreDagiticiListesi(id);

		// System.out.println("belge no " + dagitici.getBelgeNo());
		return "redirect:/dagiticiBelgesi";
	}
}