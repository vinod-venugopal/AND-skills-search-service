package com.anddigital.bootcamp.searchskill.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anddigital.bootcamp.searchskill.clientengagement.ClientEngagement;
import com.anddigital.bootcamp.searchskill.clientengagement.SearchResultsNotFoundException;
import com.anddigital.bootcamp.searchskill.repository.SearchRepository;

@RestController
public class SearchController {

	@Autowired
	private SearchRepository searchRepository;

	@GetMapping(path="/search")
	public List<ClientEngagement> searchAllEngagements(){
		return searchRepository.findAll(new Sort("clientName"));
	}

	@GetMapping(path="/search/{searchText}")
	public List<ClientEngagement> searchBySearchText(@PathVariable String searchText){
		String likeCapability = "%" + searchText + "%";
		List<ClientEngagement> searchResults = searchRepository.searchBySearchText(new Sort("clientName"),likeCapability,searchText);
		if(searchResults.isEmpty()) {
			throw new SearchResultsNotFoundException("Sorry,We Couldn't find any results matching or like < " + searchText + " >");
		}
		return searchResults;
	}
	

	
}
