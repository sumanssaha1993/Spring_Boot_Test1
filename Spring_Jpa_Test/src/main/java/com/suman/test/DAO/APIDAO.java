package com.suman.test.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suman.test.DTO.UserDTO;

@Repository
public interface APIDAO extends JpaRepository<UserDTO, Long> {

	@Query("select u from UserDTO u where u.user_name=?1")
	UserDTO findUserData(String user_name);
}
