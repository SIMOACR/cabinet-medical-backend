package com.cabinet.cabinetmedical.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.cabinetmedical.entity.Consultation;
import com.cabinet.cabinetmedical.repository.ConsultationRepository;

@Service
public class ConsultationService {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	public void addConsultation(Consultation consultation) {
		consultationRepository.save(consultation);
	}
	
	public List<Consultation> getConsultations (Long idrdv){
		return consultationRepository.findAllRdvByRdvID(idrdv);
	}
	
	public List<Consultation> getAllConsultations(){
		List<Consultation> consultations = new ArrayList<>();
		consultationRepository.findAll().forEach(consultations::add);
        return consultations;
	}

}
