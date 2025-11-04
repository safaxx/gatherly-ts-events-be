package com.techsisters.gatherly.service;

import com.techsisters.gatherly.entity.Event;
import com.techsisters.gatherly.mapper.EventMapper;
import com.techsisters.gatherly.repository.EventRepository;
import com.techsisters.gatherly.request.EventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

    public Event createEvent(EventRequest eventRequest) {
        Event event = eventMapper.convertToEntity(eventRequest);
        return eventRepository.save(event);
    }
}
