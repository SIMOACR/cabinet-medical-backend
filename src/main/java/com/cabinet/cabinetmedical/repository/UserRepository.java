package com.cabinet.cabinetmedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cabinet.cabinetmedical.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	@Query(value = "SELECT * FROM User WHERE (status='patient') ", nativeQuery = true)
    List<User> findPatients();
	
	@Query(value = "SELECT "
			+ "* "
			+ "FROM `user` AS u JOIN `rdv` AS r "
			+ "on u.`id`=r.`idUser` where r.`id` = ?1", nativeQuery = true)
	    User findUserByRdvId( long idRdv);
}
