package com.anddigital.bootcamp.searchskill.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anddigital.bootcamp.searchskill.clientengagement.ClientEngagement;
import com.anddigital.bootcamp.searchskill.clientengagement.SuggestedResult;
import com.anddigital.bootcamp.searchskill.service.SearchService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SearchController {


	@Autowired
	private SearchService searchService;

	/**
	 * Search all the engagements handled by the club
	 * @return list of client engagements
	 */
	@GetMapping(path="/search")
	public List<ClientEngagement> searchAllEngagements(){
		return searchService.searchAllEngagements();
	}

	/**
	 * Search by industry, capability, client or project name
	 * @param searchText
	 * @return list of client engagements
	 */
	@GetMapping(path="/search/{searchText}")
	public List<ClientEngagement> searchBySearchText(@PathVariable String searchText){
		return searchService.searchBySearchText(searchText);
	}
	
	/**
	 * Search by 
	 * @param searchText
	 * @return list of client engagements
	 */
	@GetMapping(path="/searchByPrediction/{searchText}")
	public List<SuggestedResult> searchByPrediction(@PathVariable String searchText){
		return searchService.searchByPrediction(searchText);
	}
	
}
