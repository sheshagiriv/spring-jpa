package com.pluralsight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

@Repository("goalRepository")
public interface GoalRepository extends JpaRepository<Goal, Long>{

// Projection Query - Should be extended in the interface for joins & extended queries which are not supported by Spring Data JPA 
	@Query(Goal.NAMED_QUERY) // should be a valid query
	List<GoalReport> findAllGoalReports();
}
