package com.cabinet.cabinetmedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cabinet.cabinetmedical.entity.Consultation;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
	@Query(value = "SELECT * FROM consultation WHERE (idrdv = ?1) ", nativeQuery = true)
    List<Consultation> findAllRdvByRdvID(Long id);
}

