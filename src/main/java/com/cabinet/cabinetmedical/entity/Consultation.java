package com.cabinet.cabinetmedical.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Table - Consultation
@Entity
@Table(name = "consultation")
public class Consultation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "filepath")
	private String file_path;
	
	@OneToOne
	@JoinColumn(name = "idrdv")
	private Rdv rdv;
	
	protected Consultation() {
		
	}

	public Consultation(String description, String file_path, Rdv rdv) {
		super();
		this.description = description;
		this.file_path = file_path;
		this.rdv = rdv;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getFile_path() {
		return file_path;
	}

	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	@Override
	public String toString() {
		return "Consultation [id=" + id + ", description=" + description + ", file_path=" + file_path + ", rdv=" + rdv
				+ "]";
	}
	
	
	
}
