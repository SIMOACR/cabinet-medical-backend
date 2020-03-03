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

import com.cabinet.cabinetmedical.entity.Rdv;
import com.cabinet.cabinetmedical.entity.User;
import com.cabinet.cabinetmedical.repository.UserRepository;
import com.cabinet.cabinetmedical.service.RdvService;

@RestController
public class RdvController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RdvService rdvService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getallrdvs")
	public List<Rdv> getAllRdvs() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return rdvService.getAllRdvs();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/rdv/{id}")
	public Rdv getRdvById(@PathVariable Long id) {
		return rdvService.getRdv(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/rdvsofday/{date}")
	public List<Rdv> getRdvsByDate(@PathVariable String date ) {
		return rdvService.getRdvsByDate(date);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/rdvs/{iduser}")
	public List<Rdv> getRdvs(@PathVariable Long iduser ) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return rdvService.getRdvByUser(iduser);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/myrdvs/{iduser}/{date}")
	public List<Rdv> getMyRdvs(@PathVariable Long iduser, @PathVariable String date) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return rdvService.getRdvByUserAndDate(iduser, date);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/myrdvshistory/{iduser}/{date}")
	public List<Rdv> getMyRdvsHistory(@PathVariable Long iduser, @PathVariable String date) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return rdvService.getRdvHistory(iduser, date);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/cancelrdv/{idrdv}")
	public void cancelRdv(@PathVariable Long idrdv) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		rdvService.deleteRdv(idrdv);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/userid/{idrdv}")
	public long userId(@PathVariable Long idrdv) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return rdvService.userId(idrdv);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value="/addrdv")
	public Rdv addRdv(@RequestBody Rdv rdv) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		rdvService.addRdv(rdv);
		return rdv;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value="/addrdv/{iduser}")
	public Rdv addRdvToUser(@RequestBody Rdv rdv, @PathVariable Long iduser ) {
		User user = userRepository.findById(iduser).get();
		rdv.setUser(user);
		rdvService.addRdv(rdv);
		return rdv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/updaterdv")
	public Rdv updateRdv(@RequestBody Rdv rdv) {
		rdvService.updateRdv(rdv);
		return rdv;
	}
	
}
