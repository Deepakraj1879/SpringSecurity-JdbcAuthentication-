package com.deepak.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.model.UserDetail;

@Repository
public interface User_repository extends JpaRepository<UserDetail, Integer>{

	Optional<UserDetail>findByName(String name);

}
