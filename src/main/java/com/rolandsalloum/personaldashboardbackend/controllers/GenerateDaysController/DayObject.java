package com.rolandsalloum.personaldashboardbackend.controllers.GenerateDaysController;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DayObject {
    private String date;
}
