package dyspring.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dyspring.mvc.data.entities.Project;
import dyspring.mvc.data.invalidators.ProjectValidator;
import dyspring.mvc.data.services.ProjectService;

@Controller
@RequestMapping("/project")
@SessionAttributes("project")
public class ProjectController {

	@Autowired
	private ProjectService projectservice;
	
	@ModelAttribute("types")
	public List<String> getTypes(){
		System.out.println("invoking getTypes");
		return new ArrayList<String>(){
			{
				add("");
				add("Single Year");
				add("Multi Year");
			}};
	}
	
	@ModelAttribute("project")
	public Project getProject() {
		System.out.println("invoking getProject");
		return new Project();
	}
	
	@RequestMapping(value="/find")
	public String findAllProjects(Model model) {
		model.addAttribute("projects", this.projectservice.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/{projectId}")
	public String findByProjectId(Model model, @PathVariable("projectId") Long projectId) {
		model.addAttribute("project", this.projectservice.find(projectId));
		return "project";
	}
	
	@RequestMapping(value="/find/{projectId}")
	@ResponseBody
	public Project findByProjectIdDifferentFormat(@PathVariable("projectId") Long projectId) {
		return this.projectservice.find(projectId);
	}
	
	@RequestMapping(value="/request")
	@ResponseBody
	public String sendRequest(@ModelAttribute Project project) {
		System.out.println("invoking sendRequest");
		System.out.println(project);
		return "The request has been sent to approval";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showProject() {
		System.out.println("invoking showProject");
		return "project";
	}
	
	@RequestMapping(value="/review")
	public String reviewProject(@ModelAttribute Project project) {
		System.out.println("invoking reviewProject");
		return "review_project";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addProject(Model model, SessionStatus status) {
		System.out.println("invoking addProject");
//		if(1==1) {
//			throw new RuntimeException("This is from RuntimeException!");
//		}
		status.setComplete();
		return "add_project";
	}
	
	@RequestMapping(value="/add")
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors, RedirectAttributes attribute) {
		System.out.println("invoking saveProject");
		if(!errors.hasErrors()) {
			System.out.println("The project name is validated.");
		}else {
			System.out.println("The project name did not validate!");
			return "add_project";
		}
		project.setProjectId(55L);
		System.out.println(project);
		this.projectservice.save(project);
		attribute.addFlashAttribute("project", project);
		return "redirect:/";
	}
	
//	@RequestMapping(value="/save")
//	public String saveProject2(@Valid @ModelAttribute Project project, SessionStatus status, Errors errors) {
//		System.out.println("invoking saveProject");
//		if(!errors.hasErrors()) {
//			System.out.println("The project name is validated.");
//		}else {
//			System.out.println("The project name did not validate!");
//			return "add_project";
//		}
//		System.out.println(project);
//		status.setComplete();
//		return "redirect:/project/add";
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request) {
		return "controller_error";
	}
}
