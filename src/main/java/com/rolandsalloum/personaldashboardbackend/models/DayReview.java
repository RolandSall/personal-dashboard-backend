package com.rolandsalloum.personaldashboardbackend.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class DayReview {

    @Id
    private String date;
    private String note;
    private boolean WakeUpEarly;
    private boolean training;
    private boolean morningHabit;
    private boolean reading;
    private boolean defaultSetting;


}
