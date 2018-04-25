package org.cas.formulus.entity;

public class Formulation {
	private int Id;
	private String purpose;
	private String target;
	private String physicalForm;
	private String applicationTechnique;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getPhysicalForm() {
		return physicalForm;
	}
	public void setPhysicalForm(String physicalForm) {
		this.physicalForm = physicalForm;
	}
	public String getApplicationTechnique() {
		return applicationTechnique;
	}
	public void setApplicationTechnique(String applicationTechnique) {
		this.applicationTechnique = applicationTechnique;
	}	
}
