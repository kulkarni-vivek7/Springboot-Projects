package org.jsp.EventManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.EventManagementSystem.entity.Events;
import org.jsp.EventManagementSystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDao {
	
	@Autowired
	EventRepository e_repo;

	public Events addEvents(Events eve) {
		// TODO Auto-generated method stub
		return e_repo.save(eve);
	}

	public List<Events> findAllEvents() {
		// TODO Auto-generated method stub
		return e_repo.findAll();
	}

	public Optional<Events> findEventsById(int id) {
		// TODO Auto-generated method stub
		return e_repo.findById(id);
	}

	public void deleteEventById(int id) {
		// TODO Auto-generated method stub
		e_repo.deleteById(id);
	}

	public Events updateEvent(Events eve) {
		// TODO Auto-generated method stub
		return e_repo.save(eve);
	}

	public Optional<Events> findByTitle(String title) {
		// TODO Auto-generated method stub
		return e_repo.findByTitle(title);
	}

	public List<Events> findByStatesUpcoming() {
		// TODO Auto-generated method stub
		return e_repo.findByStatesUpcoming();
	}

	public List<Events> findByStatesOngoing() {
		// TODO Auto-generated method stub
		return e_repo.findByStatesOngoing();
	}

	public List<Events> findByStatesCompleted() {
		// TODO Auto-generated method stub
		return e_repo.findByStatesCompleted();
	}

}
