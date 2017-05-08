/**
 * 
 */
package controllers;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import models.Isyeri;
import service.IlceService;
import service.IsyeriService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class IsyeriController {
	@Autowired
	private IsyeriService isyeriService;
	@Autowired
	private IlceService ilceService;

	private Isyeri isyeri;
	public String tusYazisi = "Kaydet";

	public List<Isyeri> isyeriList;

	@RequestMapping(value = "/isyeri")
	public String isyeri(ModelMap model, @ModelAttribute("isyeri") Isyeri isyeri1) {
		if (isyeri == null) {

			isyeri = new Isyeri();
		}
		model.put("isyeri", isyeri);
		model.put("ilceListesi", ilceService.ilceListesi());
		model.put("title", "İşyeri Tanımlama");
		model.put("tusYazisi", tusYazisi);

		if (isyeriList != null) {
			model.put("isyeriListesi", isyeriList);
		} else {

			model.put("isyeriListesi", isyeriService.isyeriListesi());
		}

		isyeri = null;
		tusYazisi = "Kaydet";
		return "isyeri";
	}

	@RequestMapping(value = "/isyeriEkle")
	public String isyeriEkle(@ModelAttribute("isyeri") Isyeri isyeri2,
			@RequestParam(value = "vergiNo", required = false) long TcKimlikNo) {

		isyeri2.setEklemezamani(new Date());
		isyeriService.isyeriEkle(isyeri2);

		return "redirect:/isyeri";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/isYeriGetir")
	public @ResponseBody String isYeriGetir(@RequestParam(value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws UnsupportedEncodingException {

		// response.setCharacterEncoding("utf-8");
		// request.setCharacterEncoding("utf-8");
		JSONObject jsonObject = new JSONObject();
		try {

			Isyeri isyeri = isyeriService.isyeriGetir(id);

			jsonObject.put("ilKodu", isyeri.getIlce().getIl().getIlKodu());
			jsonObject.put("ilceKodu", isyeri.getIlce().getIlceKodu());
			jsonObject.put("adiSoyadi", isyeri.getIsyeriAdi());
			jsonObject.put("isyeriYetkilisi", isyeri.getYetkiliAdiSoyadi());
			jsonObject.put("TCNo", isyeri.getVergiNo());
			jsonObject.put("mersisNo", isyeri.getMersisNo());
			jsonObject.put("isyeriAdresi", isyeri.getIsyeriAdresi());
			jsonObject.put("depoAdresi", isyeri.getDepoAdresi());

			System.out.println(jsonObject);
			return jsonObject.toString();
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("redirect/DagiticiBelgesiError");
			araclar.Genel.hata = e;
			mv.addObject(araclar.Genel.hata);
			return mv.toString();
		}

	}

	@RequestMapping(value = "/isyeriGetir/{id}")
	public String isYeriDuzenle(@PathVariable(value = "id") Long id) {
		isyeri = isyeriService.isyeriGetir(id);
		tusYazisi = "Güncelle";
		return "redirect:/isyeri";
	}

	@RequestMapping(value = "/isyeriDuzenleVazgec")
	public String isyeriDuzenleVazgec() {
		isyeri = null;
		tusYazisi = "Kaydet";
		return "redirect:/isyeri";
	}

	@RequestMapping(value = "/isyeriSil/{id}")
	public String isyeriSil(@PathVariable("id") Long id) {
		isyeriService.isyeriSil(id);
		return "redirect:/isyeri";
	}

	@RequestMapping(value = " /isyeriBul", method = RequestMethod.GET)
	public String numuneBul(@RequestParam(value = "searchString") String searchString, ModelMap model,
			@ModelAttribute(value = "isyeriBulma") Isyeri isyeri2) {
		if (isyeri == null) {

			isyeri = new Isyeri();
		}
		model.put("isyeri", isyeri);
		model.put("ilceListesi", ilceService.ilceListesi());
		model.put("title", "İşyeri Tanımlama");
		model.put("tusYazisi", tusYazisi);
		model.put("arananKelime", searchString);
		isyeriList = isyeriService.isyeriListesi(searchString);
		if (isyeriList != null) {
			model.put("isyeriListesi", isyeriList);
		} else {

			model.put("isyeriListesi", isyeriService.isyeriListesi());
		}

		isyeri = null;
		tusYazisi = "Kaydet";
		model.put("title", "İşyeri Arama");
		isyeriList = null;
		return "isyeri";
	}

}
