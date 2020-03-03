package com.cabinet.cabinetmedical.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

//Table - User
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="status" )
	private String status;

	@Column(name ="fname" )
	private String first_name;

	@Column(name ="lname" )
	private String last_name;

	@Column(name ="age" )
	private int age;

	@Column(name ="job" )
	private String job;

	@Column(name ="mail" )
	private String mail;
	
	@Column(name ="password" )
	private String password;

	@Column(name ="phonenumber" )
	private int phone_number;

	@Column(name ="address" )
	private String address;

	@Column(name ="imagepath" )
	private String image_path;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Rdv> rdv;

	protected User() {

	}
	
	

	public User(String status, String first_name, String last_name, int age, String job, String mail, String password,
			int phone_number, String address, String image_path, List<Rdv> rdv) {
		super();
		this.status = status;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.job = job;
		this.mail = mail;
		this.password = password;
		this.phone_number = phone_number;
		this.address = address;
		this.image_path = image_path;
		this.rdv = rdv;
	}

	public long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public int getAge() {
		return age;
	}

	public String getJob() {
		return job;
	}

	public String getMail() {
		return mail;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public String getAddress() {
		return address;
	}

	public String getImage_path() {
		return image_path;
	}

	public List<Rdv> getRdv() {
		return rdv;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", status=" + status + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", age=" + age + ", job=" + job + ", mail=" + mail + ", password=" + password + ", phone_number="
				+ phone_number + ", address=" + address + ", image_path=" + image_path + ", rdv=" + rdv + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

}

