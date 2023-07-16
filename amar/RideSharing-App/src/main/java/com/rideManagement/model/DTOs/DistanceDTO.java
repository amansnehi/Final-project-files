package com.rideManagement.model.DTOs;

public class DistanceDTO {
	private int id;
	private String from;
	private String to;
	private int distanceInKMS;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getDistanceInKMS() {
		return distanceInKMS;
	}
	public void setDistanceInKMS(int distanceInKMS) {
		this.distanceInKMS = distanceInKMS;
	}
	
}