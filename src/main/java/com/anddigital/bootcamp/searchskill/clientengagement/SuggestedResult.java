package com.anddigital.bootcamp.searchskill.clientengagement;

public class SuggestedResult {

	private String suggestedText;
	
	public String getSuggestedText() {
		return suggestedText;
	}

	public void setSuggestedText(String suggestedText) {
		this.suggestedText = suggestedText;
	}
	
	

	@Override
	public String toString() {
		return "SuggestedResult [suggestedText=" + suggestedText + "]";
	}

	public SuggestedResult() {
	}

}
