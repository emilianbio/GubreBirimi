/**
 * 
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Emrah Denizer
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/giris")
	public String home(ModelMap map) {

		map.put("title", "Gübre Birimi");

		return "giris";
	}

	@RequestMapping(value = "/bootstrapAnaliz")
	public String bootstrapAnaliz(ModelMap map) {

		map.put("title", "Bootstrap");

		return "BootstrapTemplates/bootstrapAnaliz";
	}

	@RequestMapping(value = "/bootstrapSosyalMedya")
	public String bootstrapSosyalMedya(ModelMap map) {

		map.put("title", "Bootstrap");

		return "BootstrapTemplates/bootstrapSosyalMedya";
	}

	@RequestMapping(value = "/bootstrapPlain")
	public String bootstrapPlain(ModelMap map) {

		map.put("title", "Bootstrap");

		return "BootstrapTemplates/bootstrapPlain";
	}

	@RequestMapping(value = "/server")
	public String zimmetListesi4(ModelMap map) {

		map.put("title", "Bootstrap");

		return "zimmetlistesi4";
	}

}
