package com.techsisters.gatherly.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRequest {

    @NotBlank(message = "Title is required")
    @JsonProperty
    private String title;

    @NotBlank(message = "Event description is required")
    @JsonProperty
    private String description;

    @NotBlank(message = "User email is required")
    @JsonProperty("user_email")
    private String userEmail;

    @NotBlank(message = "Event datetime is required")
    @JsonProperty("event_datetime")
    private String eventDateTime;

    @NotBlank(message = "Timezone is required")
    @JsonProperty
    private String timezone;

    @JsonProperty
    private String tags;
}

