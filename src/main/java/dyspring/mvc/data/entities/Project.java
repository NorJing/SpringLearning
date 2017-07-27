package dyspring.mvc.data.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@XmlRootElement(name="project")
public class Project {
	private Long projectId;
	
	private String name;
	
	@NotBlank(message="You must provide a description!")
	private String description;
	
	private Sponsor sponsor;
	
	private BigDecimal authorizedHours;
	
	private BigDecimal authorizedFunds;
	
	private String year;
	
	private boolean special;
	
	private String type;
	
	private List<String> pointsOfContact;
	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the sponsor
	 */
	public Sponsor getSponsor() {
		return sponsor;
	}
	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	/**
	 * @return the authorizedHours
	 */
	public BigDecimal getAuthorizedHours() {
		return authorizedHours;
	}
	/**
	 * @param authorizedHours the authorizedHours to set
	 */
	public void setAuthorizedHours(BigDecimal authorizedHours) {
		this.authorizedHours = authorizedHours;
	}
	/**
	 * @return the authorizedFunds
	 */
	public BigDecimal getAuthorizedFunds() {
		return authorizedFunds;
	}
	/**
	 * @param authorizedFunds the authorizedFunds to set
	 */
	public void setAuthorizedFunds(BigDecimal authorizedFunds) {
		this.authorizedFunds = authorizedFunds;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the special
	 */
	public boolean isSpecial() {
		return special;
	}
	/**
	 * @param special the special to set
	 */
	public void setSpecial(boolean special) {
		this.special = special;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the pointsOfContact
	 */
	public List<String> getPointsOfContact() {
		return pointsOfContact;
	}
	/**
	 * @param pointsOfContact the pointsOfContact to set
	 */
	public void setPointsOfContact(List<String> pointsOfContact) {
		this.pointsOfContact = pointsOfContact;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", description=" + description + ", sponsor="
				+ sponsor + ", authorizedHours=" + authorizedHours + ", authorizedFunds=" + authorizedFunds + ", year="
				+ year + ", special=" + special + ", type=" + type + ", pointsOfContact=" + pointsOfContact + "]";
	}
	
	
}
