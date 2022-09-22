package com.cdac.restro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.restro.beans.CustomerDetails;
import com.cdac.restro.beans.ItemDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer> {
// custom methods

//	findByAge()
}
