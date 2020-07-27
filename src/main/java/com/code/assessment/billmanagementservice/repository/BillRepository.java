package com.code.assessment.billmanagementservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.code.assessment.billmanagementservice.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	  @Query("select distinct b from Bill b join b.friends f where f.firstName=:firstName and f.lastName=:lastName")
	  public Collection<Bill> findByFriend(@Param("firstName") String firstName, @Param("lastName") String lastName);
  
//	  @Query("delete from Bill b where b.description=:description and b.amount=:amount")
//	  public void deleteBill(@Param("description") String description, @Param("amount") float amount);
}