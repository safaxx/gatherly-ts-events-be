package com.techsisters.gatherly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private OffsetDateTime eventDateTime;   // ✅ unified date-time field

    private LocalDateTime createdDate = LocalDateTime.now(); // auto set

    private String timezone;   // optional, if you still want to store creator’s TZ

    private String userEmail;

    private String tags;
}
