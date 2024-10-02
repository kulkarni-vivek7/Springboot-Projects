package org.jsp.EventManagementSystem.controller;

import java.util.List;

import org.jsp.EventManagementSystem.entity.Events;
import org.jsp.EventManagementSystem.responcestructure.ResponceStructure;
import org.jsp.EventManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	
	@Autowired
	EventService service;
	
	@PostMapping("/events")
	public ResponceStructure<Events> addEvents(@RequestBody Events eve)
	{
		return service.addEvents(eve);
	}
	
	@GetMapping("/events")
	public ResponceStructure<List<Events>> findAllEvents()
	{
		return service.findAllEvents();
	}
	
	@GetMapping("/events/{id}")
	public ResponceStructure<Events> findEventsById(@PathVariable int id)
	{
		return service.findEventsById(id);
	}
	
	@DeleteMapping("/events")
	public ResponceStructure<String> deleteEventById(@RequestParam int id)
	{
		return service.deleteEventById(id);
	}
	
	@PutMapping("/events")
	public ResponceStructure<Events> updateEvent(@RequestBody Events eve)
	{
		return service.updateEvent(eve);
	}
	
	@GetMapping("/events/title/{title}")
	public ResponceStructure<Events> findByTitle(@PathVariable String title)
	{
		return service.findByTitle(title);
	}
	
	@GetMapping("/events/upcoming")
	public ResponceStructure<List<Events>> findByStatesUpcoming()
	{
		return service.findByStatesUpcoming();
	}
	
	@GetMapping("/events/ongoing")
	public ResponceStructure<List<Events>> findByStatesOngoing()
	{
		return service.findByStatesOngoing();
	}
	
	@GetMapping("/events/completed")
	public ResponceStructure<List<Events>> findByStatesCompleted()
	{
		return service.findByStatesCompleted();
	}
}
