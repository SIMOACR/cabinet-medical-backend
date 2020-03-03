package com.cabinet.cabinetmedical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.cabinetmedical.entity.Consultation;
import com.cabinet.cabinetmedical.entity.Rdv;
import com.cabinet.cabinetmedical.repository.RdvRepository;
import com.cabinet.cabinetmedical.service.ConsultationService;

@RestController
public class ConsultationController {
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private RdvRepository rdvRepository;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value="/addconsultation/{idrdv}")
	public void addConsultation( @RequestBody Consultation consultation, @PathVariable Long idrdv) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		Rdv rdv = rdvRepository.findById(idrdv).get();
		consultation.setRdv(rdv);
		consultationService.addConsultation(consultation);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/consultations/{idrdv}")
	public List<Consultation> getConsultationByRdvId( @PathVariable Long idrdv) {
		return consultationService.getConsultations(idrdv);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/allconsultations")
	public List<Consultation> getAllConsultation( ) {
		return consultationService.getAllConsultations();
	}
}
