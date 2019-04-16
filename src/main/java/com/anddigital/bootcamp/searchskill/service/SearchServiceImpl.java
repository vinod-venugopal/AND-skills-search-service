package com.anddigital.bootcamp.searchskill.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anddigital.bootcamp.searchskill.clientengagement.ClientEngagement;
import com.anddigital.bootcamp.searchskill.clientengagement.SearchResultsNotFoundException;
import com.anddigital.bootcamp.searchskill.repository.SearchRepository;

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
		String likeCapability = "%" + searchText + "%";
		List<ClientEngagement> searchResults = searchRepository.searchBySearchText(new Sort("clientName"),likeCapability,searchText);
		if(searchResults.isEmpty()) {
			throw new SearchResultsNotFoundException("Sorry,We Couldn't find any results matching or like < " + searchText + " >");
		}
		return searchResults;
	}

	@Override
	public List<String> searchByPrediction(String searchText) {
		String likeSearchText = "%" + searchText + "%";
		List<String> searchResults = searchRepository.searchByPrediction(likeSearchText);
		Collections.sort(searchResults);
		return searchResults;
	}

}
