package com.demo.task.dto;

import java.util.List;

import com.demo.task.entity.Address;
import com.demo.task.entity.ArrivalTime;
import com.demo.task.entity.Contacts;

public class HotelDTO {
	private String name;
	private String description;
	private String brand;
	private Address address;
	private Contacts contacts;
	private ArrivalTime arrivalTime;
	private List<String> amenities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public ArrivalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(ArrivalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
}