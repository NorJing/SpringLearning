package dyspring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dyspring.mvc.data.entities.Project;
import dyspring.mvc.data.entities.Sponsor;
import dyspring.mvc.data.services.ProjectService;

@Controller
public class HomeController {

//	@Autowired
//	private ProjectService projectservice;
	
	@RequestMapping(value="/")
	public String goHomeAgain(Model model, @ModelAttribute("project") Project project) {
		model.addAttribute("currentProject", project);
		return "home";
	}
	
//	@RequestMapping(value="/")
//	public String goHome(Model model) {
////		Project project = new Project();
////		project.setName("First project");
////		project.setSponsor(new Sponsor("NASA", "555-555-5555", "nasa@nasa.com"));
////		project.setDescription("This is a simple project sponsored by NASA");
////		model.addAttribute("currentProject", project);
//		return "home";
//	}
	
	@RequestMapping(value="/welcome")
	public String welcome() {
		return "welcome";
	}
}
