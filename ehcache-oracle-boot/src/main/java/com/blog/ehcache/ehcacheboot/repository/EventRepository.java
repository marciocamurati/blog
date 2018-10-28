package com.blog.ehcache.ehcacheboot.repository;

import com.blog.ehcache.ehcacheboot.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.id=:eventId")
    Event findEvent(long eventId);
}