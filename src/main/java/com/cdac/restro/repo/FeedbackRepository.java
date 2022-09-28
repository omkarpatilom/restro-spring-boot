package com.cdac.restro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.restro.beans.FeedbackDetails;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackDetails, Integer> {
// custom methods

//	findByAge()
}
