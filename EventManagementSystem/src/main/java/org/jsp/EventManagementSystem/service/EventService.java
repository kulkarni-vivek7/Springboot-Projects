package org.jsp.EventManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.jsp.EventManagementSystem.dao.EventDao;
import org.jsp.EventManagementSystem.entity.Events;
import org.jsp.EventManagementSystem.responcestructure.ResponceStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventService {
	
	@Autowired
	EventDao e_dao;

	public ResponceStructure<Events> addEvents(Events eve) {
		// TODO Auto-generated method stub
		Events ev = e_dao.addEvents(eve);
		
		ResponceStructure<Events> res = new ResponceStructure<>();
		
		res.setStatus(201);
		res.setMessage("Event Added Successfully...");
		res.setBody(ev);
		
		return res;
	}

	public ResponceStructure<List<Events>> findAllEvents() {
		// TODO Auto-generated method stub
		List<Events> evs = e_dao.findAllEvents();
		
		ResponceStructure<List<Events>> res = new ResponceStructure<>();
		
		if(evs.isEmpty())
		{
			res.setStatus(404);
			res.setMessage("No Events Are Scheduled At The Moment...");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(200);
		res.setMessage("All Events Found Successfully...");
		res.setBody(evs);
		
		return res;
	}

	public ResponceStructure<Events> findEventsById(int id) {
		// TODO Auto-generated method stub
		Optional<Events> ev = e_dao.findEventsById(id);
		
		ResponceStructure<Events> res = new ResponceStructure<>();
		
		if(ev.isEmpty())
		{
			res.setStatus(404);
			res.setMessage("No Event Found For The Given Id");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(200);
		res.setMessage("Event Found Successfully For The Given ID");
		res.setBody(ev.get());
		
		return res;
	}

	public ResponceStructure<String> deleteEventById(int id) {
		// TODO Auto-generated method stub
		Optional<Events> ev = e_dao.findEventsById(id);
		
		ResponceStructure<String> res = new ResponceStructure<>();
		
		if(ev.isEmpty())
		{
			res.setStatus(400);
			res.setMessage("Bad Request - Invalid Event Id");
			res.setBody("Unable To Delete Event");
			
			return res;
		}
		
		e_dao.deleteEventById(id);
		
		res.setStatus(200);
		res.setMessage("Event Deleted Successfully");
		res.setBody("Event Deleted");
		
		return res;
	}

	public ResponceStructure<Events> updateEvent(Events eve) {
		// TODO Auto-generated method stub
		Events ev = e_dao.updateEvent(eve);
		
		ResponceStructure<Events> res = new ResponceStructure<>();
		
		res.setStatus(200);
		res.setMessage("Event Updated Successfully");
		res.setBody(ev);
		
		return res;
	}

	public ResponceStructure<Events> findByTitle(String title) {
		// TODO Auto-generated method stub
		Optional<Events> ev = e_dao.findByTitle(title);
		
		ResponceStructure<Events> res = new ResponceStructure<>();
		
		if(ev.isEmpty())
		{
			res.setStatus(404);
			res.setMessage("There Is No Event By The Given Name");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(200);
		res.setMessage("Event Found Successfully For The Given Name");
		res.setBody(ev.get());
		
		return res;
	}

	public ResponceStructure<List<Events>> findByStatesUpcoming() {
		// TODO Auto-generated method stub
		List<Events> evs = e_dao.findByStatesUpcoming();
		
		ResponceStructure<List<Events>> res = new ResponceStructure<>();
		
		if(evs.isEmpty())
		{
			res.setStatus(404);
			res.setMessage("There Are No Upcoming Events");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(200);
		res.setMessage("All The Upcoming Events Found Successfully");
		res.setBody(evs);
		
		return res;
	}

	public ResponceStructure<List<Events>> findByStatesOngoing() {
		// TODO Auto-generated method stub
		List<Events> evs = e_dao.findByStatesOngoing();
		
		ResponceStructure<List<Events>> res = new ResponceStructure<>();
		
		if(evs.isEmpty())
		{
			res.setStatus(404);
			res.setMessage("There Are No Ongoing Events");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(200);
		res.setMessage("All The Ongoing Events Found Successfully");
		res.setBody(evs);
		
		return res;
	}

	public ResponceStructure<List<Events>> findByStatesCompleted() {
		// TODO Auto-generated method stub
		List<Events> evs = e_dao.findByStatesCompleted();
		
		ResponceStructure<List<Events>> res = new ResponceStructure<>();
		
		if(evs.isEmpty())
		{
			res.setStatus(404);
			res.setMessage("There Are No Completed Events");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(200);
		res.setMessage("All The Completed Events Found Successfully");
		res.setBody(evs);
		
		return res;
	}

}
