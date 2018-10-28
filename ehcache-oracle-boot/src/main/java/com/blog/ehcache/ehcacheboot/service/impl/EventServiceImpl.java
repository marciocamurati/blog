package com.blog.ehcache.ehcacheboot.service.impl;

import com.blog.ehcache.ehcacheboot.dto.EventDTO;
import com.blog.ehcache.ehcacheboot.entity.Event;
import com.blog.ehcache.ehcacheboot.repository.EventRepository;
import com.blog.ehcache.ehcacheboot.service.EventService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="EventConfig")
public class EventServiceImpl implements EventService {

    private static final Logger log = LogManager.getLogger(EventServiceImpl.class);

    @Autowired
    EventRepository eventRepository;

    @CacheEvict(allEntries = true)
    public void clearCache(){}

    @Override
    @Cacheable(key="#eventId")
    public EventDTO retrieveEvent(long eventId) {
        log.info("Calling Repository method to retrieve event");
        Event event = eventRepository.findEvent(eventId);
        EventDTO eventDto = mapEventToDto(event);
        return eventDto;
    }

    private EventDTO mapEventToDto(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        return dto;
    }

    @Override
    public void saveEvent(EventDTO eventDto) {
        Event event = mapDtoToEvent(eventDto);
        eventRepository.save(event);
	}

    private Event mapDtoToEvent(EventDTO eventDto) {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());
        return event;
    }

}