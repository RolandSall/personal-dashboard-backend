package com.rolandsalloum.personaldashboardbackend.repositories;

import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DayReviewDTO extends JpaRepository<DayReview, String> {
}
