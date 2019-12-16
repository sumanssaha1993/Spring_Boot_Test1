package com.suman.test.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suman.test.DTO.UserDTO;

@Repository
public interface APIDAO extends JpaRepository<UserDTO, Long> {

}
