package com.techsisters.gatherly.controller;

import com.techsisters.gatherly.dto.EventDTO;
import com.techsisters.gatherly.dto.ResponseDTO;
import com.techsisters.gatherly.entity.Event;
import com.techsisters.gatherly.request.EventRequest;
import com.techsisters.gatherly.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("events")
public class EventController {
    private final EventService eventService;
    @PostMapping("/create-new")
    public ResponseDTO createEvent(@RequestBody EventRequest eventRequest) {
        Event event = eventService.createEvent(eventRequest);
        ResponseDTO response = new ResponseDTO();
        if(event != null){
            response.setSuccess(true);
            response.setMessage("Event created successfully.");
        }else{
            response.setSuccess(false);
            response.setMessage("Event creation failed");
        }
        return response;

    }
}
