package com.anddigital.bootcamp.searchskill.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anddigital.bootcamp.searchskill.clientengagement.ClientEngagement;
import com.anddigital.bootcamp.searchskill.clientengagement.SuggestedResult;
import com.anddigital.bootcamp.searchskill.exception.SearchResultsNotFoundException;
import com.anddigital.bootcamp.searchskill.repository.SearchRepository;
import com.fasterxml.jackson.core.JsonGenerationException;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchRepository searchRepository;

	public SearchServiceImpl() {
	}

	@Override
	public List<ClientEngagement> searchAllEngagements() {
		return searchRepository.findAll(new Sort("clientName"));
	}

	@Override
	public List<ClientEngagement> searchBySearchText(String searchText){
		String lowerCaseText="";
		if(!searchText.isEmpty()) {
			lowerCaseText = searchText.toLowerCase();
		}
		String likeCapability = "%" + lowerCaseText + "%";
		List<ClientEngagement> searchResults = searchRepository.searchBySearchText(new Sort("clientName"),likeCapability,lowerCaseText);
		if(searchResults.isEmpty()) {
			throw new SearchResultsNotFoundException("Sorry, we couldn't find any results matching or like < " + searchText + " >");
		}
		return searchResults;
	}

	@Override
	public List<SuggestedResult> searchByPrediction(String searchText) {
		String likeSearchText = "%" + searchText + "%";
		List<String> searchResults = searchRepository.searchByPrediction(likeSearchText.toLowerCase());	
		Collections.sort(searchResults);
		List<SuggestedResult> suggestedResults = new ArrayList<SuggestedResult>();
		for(String result: searchResults) {
			SuggestedResult sr = new SuggestedResult();
			sr.setSuggestedText(result);
			suggestedResults.add(sr);
		}
		return suggestedResults;
	}

}
