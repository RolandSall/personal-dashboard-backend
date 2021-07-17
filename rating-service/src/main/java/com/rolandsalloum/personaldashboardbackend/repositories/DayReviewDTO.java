package com.rolandsalloum.personaldashboardbackend.repositories;

import com.rolandsalloum.personaldashboardbackend.models.DayReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface DayReviewDTO extends JpaRepository<DayReview, Date> {

    @Query(value ="select * from day_review where date between :start AND :end "
            , nativeQuery = true)
     List<DayReview> getDayReviewInRange(@Param("start") Date start, @Param("end") Date end);

}
