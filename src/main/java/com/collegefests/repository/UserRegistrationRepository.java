package com.collegefests.repository;

import com.collegefests.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Integer> {
}
