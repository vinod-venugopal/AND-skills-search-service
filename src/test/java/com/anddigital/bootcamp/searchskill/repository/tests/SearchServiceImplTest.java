package com.anddigital.bootcamp.searchskill.repository.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.anddigital.bootcamp.searchskill.clientengagement.ClientEngagement;
import com.anddigital.bootcamp.searchskill.exception.SearchResultsNotFoundException;
import com.anddigital.bootcamp.searchskill.repository.SearchRepository;
import com.anddigital.bootcamp.searchskill.service.SearchService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SearchServiceImplTest {

	@MockBean
	private SearchService searchService;
	
	List<ClientEngagement> clientEngagements;


	@Before
	public void setUp() {
		ClientEngagement clientEngagement = new ClientEngagement(1001,"Allen and Overy","Phil","Sunil","Anti-Origami","Discovery (Specific idea)","Law","Scrum","Y","");
		clientEngagements = new ArrayList<ClientEngagement>();
		clientEngagements.add(clientEngagement);
	}

	@Test
	public void whenValidClientName_thenClientEngagementShouldBeFound() {
		String clientName = "Allen and Overy";
		Mockito.when(searchService.searchBySearchText(clientName))
		.thenReturn(clientEngagements);
		List<ClientEngagement> results = searchService.searchBySearchText(clientName);
		assertNotNull(results);
		assertTrue(clientName.equals(results.get(0).getClientName()));

	}

	@Test
	public void whenValidIndustry_thenClientEngagementShouldBeFound() {
		String industry = "Law";
		Mockito.when(searchService.searchBySearchText(industry))
		.thenReturn(clientEngagements);
		List<ClientEngagement> results = searchService.searchBySearchText(industry);
		assertNotNull(results);
		assertTrue(industry.equals(results.get(0).getIndustry()));

	}

	@Test
	public void whenValidProjectName_thenClientEngagementShouldBeFound() {
		String projectName = "Anti-Origami";
		Mockito.when(searchService.searchBySearchText(projectName))
		.thenReturn(clientEngagements);
		List<ClientEngagement> results = searchService.searchBySearchText(projectName);
		assertNotNull(results);
		assertTrue(projectName.equals(results.get(0).getProjectName()));

	}

	@Test
	public void whenValidCapability_thenClientEngagementShouldBeFound() {
		String capability = "Scrum";
		Mockito.when(searchService.searchBySearchText(capability))
		.thenReturn(clientEngagements);
		List<ClientEngagement> results = searchService.searchBySearchText(capability);
		assertNotNull(results);
		assertTrue(capability.equals(results.get(0).getCapability()));

	}

	@Test
	public void whenNoResultsFound_thenThrowsException() {
		String errorMessage = null;
		try {
			String capability = "Tosca";
			errorMessage = "Sorry,We Couldn't find any results matching or like < " + capability + " >";
			searchService.searchBySearchText(capability);
		}
		catch(SearchResultsNotFoundException se) {
			assertEquals(se.getMessage(),errorMessage);
		}
	}
	
	@Test
	public void whenSearchByPrediction_thenReturnStringList() {
		String predictiveStr = "S";
		List<String> predictiveResults = searchService.searchByPrediction(predictiveStr);
		assertNotNull(predictiveResults);
		assertTrue(predictiveResults.isEmpty());
	}

}
