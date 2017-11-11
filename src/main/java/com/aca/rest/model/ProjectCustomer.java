package com.aca.rest.model;


public class ProjectCustomer {
	
	

	private String customerId;
		
	private String firstName;
		
	private String lastName;
	
	private String phone;
		
	private String street;
			
	private String city;
	
	private String state;
	
	private String zip;
	
	private String email;
	
	private String services;
	
	private boolean monday;
	
	private boolean tuesday;
	
	private boolean wednesday;
	
	private boolean thursday;
	
	private boolean friday;
	
	private boolean saturday;
	
	private boolean sunday;
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setServices(String services) {
		this.services = services;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getEmail() {
		return email;
	}
	
	public String getServices() {
		return services;
	}

	public Boolean getMonday() {
		return monday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public Boolean getFriday() {
		return friday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public Boolean getSunday() {
		return sunday;
	}
	
	public String toString(){
		StringBuffer value = new StringBuffer();
		value.append("customer id: ");
		value.append(customerId);
		value.append("\n");
		value.append("first name: ");
		value.append(firstName);
		value.append("\n");
		value.append("last name: ");
		value.append(lastName);
		value.append("\n");
		value.append("phone: ");
		value.append(phone);
		value.append("\n");
		value.append("street: ");
		value.append(street);		
		value.append("\n");
		value.append("city: ");
		value.append(city);
		value.append("\n");
		value.append("state: ");
		value.append(state);
		value.append("\n");
		value.append("zip: ");
		value.append(zip);
		value.append("\n");
		value.append("email: ");
		value.append(email);
		value.append("\n");
		value.append("services: ");
		value.append(services);
		value.append("\n");
		value.append("monday: ");
		value.append(monday);
		value.append("\n");
		value.append("tuesday: ");
		value.append(tuesday);
		value.append("\n");
		value.append("wednesday: ");
		value.append(wednesday);
		value.append("\n");
		value.append("thursday: ");
		value.append(thursday);
		value.append("\n");
		value.append("friday: ");
		value.append(friday);
		value.append("\n");
		value.append("saturday: ");
		value.append(saturday);
		value.append("\n");
		value.append("sunday: ");
		value.append(sunday);
		value.append("\n");
		return value.toString();
	
	}


}
