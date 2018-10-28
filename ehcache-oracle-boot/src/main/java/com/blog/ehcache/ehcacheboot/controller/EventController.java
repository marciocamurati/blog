package com.blog.ehcache.ehcacheboot.controller;

import com.blog.ehcache.ehcacheboot.dto.EventDTO;
import com.blog.ehcache.ehcacheboot.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<String> processEvent(@RequestBody EventDTO eventDto){
        eventService.saveEvent(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public ResponseEntity<EventDTO> fetchEvent(@RequestParam long eventId) {
        return ResponseEntity.ok(eventService.retrieveEvent(eventId));
    }
}