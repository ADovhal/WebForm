package com.dovhal.serverapplication.repos;

import com.dovhal.serverapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Integer> {

}
