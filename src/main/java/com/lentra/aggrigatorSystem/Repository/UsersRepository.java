package com.lentra.aggrigatorSystem.Repository;

import com.lentra.aggrigatorSystem.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findByUserId(String userId);

}
