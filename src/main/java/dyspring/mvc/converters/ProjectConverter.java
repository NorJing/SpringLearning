package dyspring.mvc.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import dyspring.mvc.data.entities.Project;
import dyspring.mvc.data.services.ProjectService;

public class ProjectConverter implements Converter<String, Project> {

	@Autowired
	private ProjectService projectservice;
	
	public ProjectConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Project convert(String projectId) {
		System.out.println("Converting string projectId to object Project.");
		return this.projectservice.find(new Long(projectId));
	}

}
