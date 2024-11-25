package com.lentra.aggrigatorSystem.Repository;

import com.lentra.aggrigatorSystem.Entity.ConsentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsentDetailsRepository extends JpaRepository<ConsentDetails,Integer> {


    @Query("SELECT c FROM ConsentDetails c WHERE c.consentInstitute.id = :instituteId")
    List<ConsentDetails> findAllByInstituteId(int instituteId);




}
