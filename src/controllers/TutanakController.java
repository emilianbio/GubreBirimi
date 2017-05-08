/**
 * 
 */
package controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Tutanak;
import service.TutanakService;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class TutanakController {
	@Autowired
	private TutanakService tutanakService;
	public Tutanak tutanak;

	@RequestMapping(value = "/tutanak")
	public String tutanak(ModelMap model, @ModelAttribute("tutanak") Tutanak tutanak1) {

		if (tutanak == null) {

			tutanak = new Tutanak();
		}
		model.put("tutanak", tutanak);
		model.put("title", "Tutanak Tanımlama");

		return "tutanak";
	}

	@RequestMapping(value = "/tutanakEkle", method = RequestMethod.POST)
	public String tutanakEkle(ModelMap model, @ModelAttribute("tutanak") Tutanak tutanak1) {
		if (tutanak1 == null) {

			return "redirect:/tutanak";
		}

		tutanak1.setEklemezamani(new Date());

		tutanakService.tutanakEkle(tutanak1);

		return "redirect:/tutanak";
	}

}
