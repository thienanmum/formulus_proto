package org.cas.formulus.entity;

public class Formulation {
	private String id;
	private String purpose;
	private String target;
	private String physicalForm;
	private String applicationTechnique;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	public void copy(Formulation other) {
		this.setApplicationTechnique(other.getApplicationTechnique());
		this.setPhysicalForm(other.getPhysicalForm());
		this.setTarget(other.getTarget());
		this.setPurpose(other.getPurpose());
	}
}
