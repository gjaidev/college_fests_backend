package com.collegefests.service;


import com.collegefests.model.Event;
import com.collegefests.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public Event saveEvent(Event event){
        return repository.save(event);
    }

    public List<Event> saveEvents(List<Event> events){
        return repository.saveAll(events);
    }

    public List<Event> getEvents(){
        return repository.findAll();
    }

    public Event getEventById(int event_id){
        return repository.findById(event_id).orElse(null);
    }

    public String deleteEvent(int event_id){
        repository.deleteById(event_id);
        return "Event deleted";
    }

    public Event updateEvent(Event event){
        Event existingEvent= repository.findById(event.getEventId()).orElse(null);
        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventDescription(event.getEventDescription());
        existingEvent.setEventOrganiser(event.getEventOrganiser());
        existingEvent.setDate(event.getDate());
        existingEvent.setFees(event.getFees());
        existingEvent.setPhone(event.getPhone());
        existingEvent.setTime(event.getTime());
        existingEvent.setEventLocation(event.getEventLocation());
        return repository.save(existingEvent);
    }
}
