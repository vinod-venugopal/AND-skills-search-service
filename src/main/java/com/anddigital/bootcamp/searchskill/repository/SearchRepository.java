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


	@Query("Select r from ClientEngagement r where capability like :likeCapability or clientName = :searchText or industry = :searchText or projectName = :searchText")
	List<ClientEngagement> searchBySearchText(Sort sort,@Param("likeCapability") String likeCapability,@Param("searchText") String searchText);
	
	
	@Query(value="Select r.client_name from client_engagement r where client_name like :likeSearchText union "
			+ "Select r.industry from client_engagement r where industry like :likeSearchText union "
			+ "Select r.project_name from client_engagement r where project_name like :likeSearchText",nativeQuery = true)
	List<String> searchByPrediction(@Param("likeSearchText") String likeSearchText);
	

}
