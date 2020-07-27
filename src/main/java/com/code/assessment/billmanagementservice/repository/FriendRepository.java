package com.code.assessment.billmanagementservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.code.assessment.billmanagementservice.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

	@Query("select distinct f from Friend f join f.bills b where b.description=:description and b.amount=:amount")
	  public Collection<Friend> findByBill(@Param("description") String description, @Param("amount") float amount);
}