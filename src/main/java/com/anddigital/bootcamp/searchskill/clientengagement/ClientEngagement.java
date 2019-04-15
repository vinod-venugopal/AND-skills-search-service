package com.anddigital.bootcamp.searchskill.clientengagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClientEngagement {

	
	@Id
	@GeneratedValue
	private Integer clientEngagementId;
	
	private String clientName;

	private String serviceOwner;
	
	private String pdl;
	
	private String projectName;
	
	private String engagementType;
	
	private String industry;
	
	private String capability;
	
	private String caseStudy;

	public ClientEngagement() {
		super();
	}

	public ClientEngagement(Integer clientEngagementId, String clientName, String serviceOwner, String pdl,
			String projectName, String engagementType, String industry, String capability, String caseStudy) {
		super();
		this.clientEngagementId = clientEngagementId;
		this.clientName = clientName;
		this.serviceOwner = serviceOwner;
		this.pdl = pdl;
		this.projectName = projectName;
		this.engagementType = engagementType;
		this.industry = industry;
		this.capability = capability;
		this.caseStudy = caseStudy;
	}

	public Integer getClientEngagementId() {
		return clientEngagementId;
	}

	public void setClientEngagementId(Integer clientEngagementId) {
		this.clientEngagementId = clientEngagementId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getServiceOwner() {
		return serviceOwner;
	}

	public void setServiceOwner(String serviceOwner) {
		this.serviceOwner = serviceOwner;
	}

	public String getPdl() {
		return pdl;
	}

	public void setPdl(String pdl) {
		this.pdl = pdl;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEngagementType() {
		return engagementType;
	}

	public void setEngagementType(String engagementType) {
		this.engagementType = engagementType;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}


	public String getCaseStudy() {
		return caseStudy;
	}

	public void setCaseStudy(String caseStudy) {
		this.caseStudy = caseStudy;
	}

	@Override
	public String toString() {
		return "ClientEngagement [clientEngagementId=" + clientEngagementId + ", clientName=" + clientName
				+ ", serviceOwner=" + serviceOwner + ", pdl=" + pdl + ", projectName=" + projectName
				+ ", engagementType=" + engagementType + ", industry=" + industry + ", capability=" + capability
				+ ", case_study=" + caseStudy + "]";
	}
	
	
	
	

}
