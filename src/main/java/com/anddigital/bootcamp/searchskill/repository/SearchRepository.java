package com.anddigital.bootcamp.searchskill.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anddigital.bootcamp.searchskill.clientengagement.ClientEngagement;

@Repository
public interface SearchRepository extends JpaRepository<ClientEngagement, Integer> {

	/* SELECT * FROM CLIENT_ENGAGEMENT where capability like 'Scrum' or client_name = 'Allen and Overy' or industry = 'Law'; */
	@Query("Select r from ClientEngagement r where capability like :likeCapability or clientName = :searchText or industry = :searchText or projectName = :searchText")
	List<ClientEngagement> searchBySearchText(Sort sort,@Param("likeCapability") String likeCapability,@Param("searchText") String searchText);
	
	
	@Query(value="Select r.capability from client_engagement r where capability like :likeCapability union "
			+ "Select r.client_name from client_engagement r where client_name = :searchText union "
			+ "Select r.industry from client_engagement r where industry = :searchText union "
			+ "Select r.project_name from client_engagement r where project_name = :searchText",nativeQuery = true)
	List<String> searchByPrediction(@Param("likeCapability") String likeCapability,@Param("searchText") String searchText);
	

}
