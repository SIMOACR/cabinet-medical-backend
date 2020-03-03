package com.cabinet.cabinetmedical.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Table - Rdv
@Entity
@Table(name = "rdv")
public class Rdv implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "isavailable")
	private String available;
	
	@Column(name = "startinghour")
	private int starting_hour;

	@Column(name = "finishinghour")
	private int finishing_hour;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user;
	
	protected Rdv() {
		
	}

	public Rdv(Date date, String available, int starting_hour, int finishing_hour, User user) {
		super();
		this.date = date;
		this.available = available;
		this.starting_hour = starting_hour;
		this.finishing_hour = finishing_hour;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public String getAvailable() {
		return available;
	}

	public int getStarting_hour() {
		return starting_hour;
	}

	public int getFinishing_hour() {
		return finishing_hour;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Rdv [id=" + id + ", date=" + date + ", available=" + available + ", starting_hour=" + starting_hour
				+ ", finishing_hour=" + finishing_hour + ", user=" + user + "]";
	}

}
