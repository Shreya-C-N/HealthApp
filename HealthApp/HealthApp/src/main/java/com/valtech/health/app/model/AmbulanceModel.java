package com.valtech.health.app.model;

public class AmbulanceModel {

	private int id;
	private String hospitalAvailability;
	private String hospitalName;
	private String location;
	private String doctorsAvailability;
	private String bedAvailability;

	public AmbulanceModel() {

	}

	public AmbulanceModel(int id, String hospitalAvailability, String hospitalName,String location, String doctorsAvailability,
			String bedAvailability) {
		super();
		this.id = id;
		this.hospitalAvailability = hospitalAvailability;
		this.hospitalName = hospitalName;
		this.location=location;
		this.doctorsAvailability = doctorsAvailability;
		this.bedAvailability = bedAvailability;
	}

	public AmbulanceModel(String hospitalAvailability, String hospitalName,String location, String doctorsAvailability,
			String bedAvailability) {
		super();

		this.hospitalAvailability = hospitalAvailability;
		this.hospitalName = hospitalName;
		this.location=location;
		this.doctorsAvailability = doctorsAvailability;
		this.bedAvailability = bedAvailability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalAvailability() {
		return hospitalAvailability;
	}

	public void setHospitalAvailability(String hospitalAvailability) {
		this.hospitalAvailability = hospitalAvailability;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDoctorsAvailability() {
		return doctorsAvailability;
	}

	public void setDoctorsAvailability(String doctorsAvailability) {
		this.doctorsAvailability = doctorsAvailability;
	}

	public String getBedAvailability() {
		return bedAvailability;
	}

	public void setBedAvailability(String bedAvailability) {
		this.bedAvailability = bedAvailability;
	}

	@Override
	public String toString() {
		return "AmbulanceModel [id=" + id + ", hospitalAvailability=" + hospitalAvailability + ", hospitalName="
				+ hospitalName + ", location=" + location + ", doctorsAvailability=" + doctorsAvailability
				+ ", bedAvailability=" + bedAvailability + "]";
	}

	
}
