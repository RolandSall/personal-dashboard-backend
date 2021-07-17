package com.rolandsalloum.personaldashboardbackend.controllers.GenerateDaysController;

import com.rolandsalloum.personaldashboardbackend.services.GenerateDaysService.GenerateDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateDaysController {


    private GenerateDaysService generateDaysService;

    @Autowired
    public GenerateDaysController(GenerateDaysService generateDaysService) {
        this.generateDaysService = generateDaysService;
    }

    @PostMapping("/generate-week")
    public ResponseEntity<?> getDayReviewById(@RequestBody DayObject date) {
        try {
            generateDaysService.generateWeek(date);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



}
