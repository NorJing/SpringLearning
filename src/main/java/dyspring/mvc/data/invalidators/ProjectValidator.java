package dyspring.mvc.data.invalidators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import dyspring.mvc.data.entities.Project;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		// It has to be the Project class
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Project project = (Project) target;
		
		if(project.getName().length() < 5) {
			System.out.println("The project name length is less than 5 letters!");
			errors.rejectValue("name", "prject.name", "The project name is less than 5 letters");
		}
	}

}
