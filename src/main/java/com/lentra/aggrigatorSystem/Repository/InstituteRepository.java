package com.lentra.aggrigatorSystem.Repository;

import com.lentra.aggrigatorSystem.Model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute,Integer> {
    Institute findByInstituteName(String instituteName);
}
