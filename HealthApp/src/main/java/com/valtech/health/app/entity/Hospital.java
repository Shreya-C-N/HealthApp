package com.valtech.health.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String hospitalname;
	private String location;
	private String contactnumber;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int id, String hospitalname, String location, String contactnumber) {
		super();
		this.id = id;
		this.hospitalname = hospitalname;
		this.location = location;
		this.contactnumber = contactnumber;
	}

	public Hospital(String hospitalname, String location, String contactnumber) {
		super();
		this.hospitalname = hospitalname;
		this.location = location;
		this.contactnumber = contactnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalname=" + hospitalname + ", location=" + location + ", contactnumber="
				+ contactnumber + "]";
	}

}
