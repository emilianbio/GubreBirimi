/**
 * 
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Personel;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class PersonelController {
	private Personel personel;

	@RequestMapping(value = "/personel")
	public String personel(ModelMap model) {
		if (personel == null) {
			personel = new Personel();
		}
		model.put("personel", personel);
		model.put("title", "Personel Tanımlama");

		return "personel";
	}

	@RequestMapping(value = "/personelEkle", method = RequestMethod.POST)
	public String personelEkle(ModelMap model) {

		return "redirect:/personel";
	}
}
