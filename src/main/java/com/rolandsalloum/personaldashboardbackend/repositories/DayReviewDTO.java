package com.rolandsalloum.personaldashboardbackend.repositories;

import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DayReviewDTO extends JpaRepository<DayReview, String> {
}
