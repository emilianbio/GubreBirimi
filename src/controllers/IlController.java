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

import models.Il;
import service.IlService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class IlController {
	@Autowired
	IlService ilService;
	public Il il;

	@RequestMapping("/il")
	public String il(ModelMap model) {

		if (il == null) {

			il = new Il();
		}
		model.put("il", il);
		model.put("title", "İl Ekleme");
		il = null;
		return "ilsayfasi";
	}

	@RequestMapping(value = "/ilEkle")
	public String ilEkleme(@ModelAttribute(value = "il") Il il) {

		il.setEklemeZamani(new Date());
		ilService.isyeriEkle(il);

		return "redirect:/il";
	}

	@RequestMapping(value = "/ilDuzenle/{id}")
	public String ilceDuzenle(@PathVariable("id") Long id) {

		il = ilService.ilGetir(id);

		return "redirect:/il";
	}
}
