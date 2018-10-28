package com.blog.ehcache.ehcacheboot.service;

import com.blog.ehcache.ehcacheboot.dto.EventDTO;

public interface EventService {

    public EventDTO retrieveEvent(long eventId);

    public void saveEvent(EventDTO eventDto);
}