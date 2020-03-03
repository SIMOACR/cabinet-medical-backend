package com.cabinet.cabinetmedical.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.cabinetmedical.entity.Rdv;
import com.cabinet.cabinetmedical.repository.RdvRepository;

@Service
public class RdvService {

	@Autowired
	private RdvRepository rdvRepository;
	
	public void addRdv(Rdv rdv) {
		rdvRepository.save(rdv);
	}
	
	public void updateRdv(Rdv rdv) {
		rdvRepository.save(rdv);
	}
	
	public void deleteRdv(long id) {
		rdvRepository.deleteById(id);
	}

	public boolean userExists(Long id){
		return rdvRepository.existsById(id);
	}
	
	public List<Rdv> getRdvByUser(Long iduser){
		return rdvRepository.findAllRdvByUserID(iduser);
	}
	
	public List<Rdv> getRdvByUserAndDate(Long iduser, String date){
		return rdvRepository.findAllRdvByUserIDAndDate(iduser, date);
	}
	
	public List<Rdv> getRdvHistory(Long iduser, String date){
		return rdvRepository.findAllRdvHistory(iduser, date);
	}
	
	public List<Rdv> getAllRdvs(){
		List<Rdv> rdvs = new ArrayList<>();
		rdvRepository.findAll().forEach(rdvs::add);
        return rdvs;
	}
	
	public Rdv getRdv(Long id) {
		return rdvRepository.findById(id).get();
	}
	
	public List<Rdv> getRdvsByDate( String date ) {
		return rdvRepository.findRdvsByDate(date);
	}
	
	public long userId(long idRdv) {
		return rdvRepository.findUserIdByRdvId(idRdv);
	}
	
	public void addRdv2(Rdv rdv, long idUser) {
		rdvRepository.addrdv(rdv.getDate().toString(), rdv.getStarting_hour(), rdv.getFinishing_hour(), idUser);
	}
}
