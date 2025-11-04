package com.techsisters.gatherly.mapper;

import com.techsisters.gatherly.dto.EventDTO;
import com.techsisters.gatherly.entity.Event;
import com.techsisters.gatherly.request.EventRequest;
import com.techsisters.gatherly.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Component
public class EventMapper {
    public Event convertToEntity(EventRequest request) {
        Event event = new Event();
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        // parse ISO datetime string
        OffsetDateTime eventDateTime = OffsetDateTime.parse(request.getEventDateTime());
        event.setEventDateTime(eventDateTime);
        event.setTags(request.getTags());
        event.setCreatedDate(LocalDateTime.now());
        event.setTimezone(request.getTimezone());
        event.setUserEmail(request.getUserEmail());
        return event;
    }
}
