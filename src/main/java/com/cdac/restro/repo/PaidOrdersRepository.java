package com.cdac.restro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.restro.beans.PaidOrderDetails;

@Repository
public interface PaidOrdersRepository extends JpaRepository<PaidOrderDetails, Integer> {
// custom methods

//	findByAge()
}
