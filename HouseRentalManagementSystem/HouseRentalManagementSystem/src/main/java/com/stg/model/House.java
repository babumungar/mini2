package com.stg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "house")
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private int houseId;
	private String houseName;
	private String houseAddress;

	// one admin many houses

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId", nullable = false, referencedColumnName = "adminId")
	@JsonBackReference(value = "house")
	private Admin adminRef;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",nullable = false, referencedColumnName = "userId")
	@JsonBackReference(value = "userPojo")
	 private User userRef;
	 

	public House() {
		super();

	}

	public House(int houseId, String houseName, String houseAddress) {
		super();
		this.houseId = houseId;
		this.houseName = houseName;
		this.houseAddress = houseAddress;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

}
