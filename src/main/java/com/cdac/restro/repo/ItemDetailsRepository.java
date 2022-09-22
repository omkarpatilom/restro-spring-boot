package com.cdac.restro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.restro.beans.ItemDetails;

@Repository
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer> {

}
