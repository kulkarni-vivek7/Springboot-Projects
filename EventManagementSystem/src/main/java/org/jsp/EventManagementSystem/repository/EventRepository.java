package org.jsp.EventManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.EventManagementSystem.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Events, Integer> {

	Optional<Events> findByTitle(String title);

	@Query("select e from Events e where e.states = 'upcoming'")
	List<Events> findByStatesUpcoming();

	@Query("select e from Events e where e.states = 'ongoing'")
	List<Events> findByStatesOngoing();

	@Query("select e from Events e where e.states = 'completed'")
	List<Events> findByStatesCompleted();

}
