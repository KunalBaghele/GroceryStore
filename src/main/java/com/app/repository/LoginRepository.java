package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.models.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query("SELECT l FROM Login l WHERE l.email = :email")
	Optional<Login> findByEmail(String email);

}
