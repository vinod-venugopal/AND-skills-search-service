package com.anddigital.bootcamp.searchskill.service;

import java.util.List;
import com.anddigital.bootcamp.searchskill.clientengagement.ClientEngagement;
import com.anddigital.bootcamp.searchskill.exception.SearchResultsNotFoundException;

public interface SearchService {

	 List<ClientEngagement> searchAllEngagements();
	
	 List<ClientEngagement> searchBySearchText(String searchText);
	 
	 List<String> searchByPrediction (String searchText);
	
}
