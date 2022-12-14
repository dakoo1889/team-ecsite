package jp.co.internous.sunflower.model.domain;

import java.sql.Timestamp;

public class MstDestination {
	private long id;
	
	private long userId;
	
	private String familyName;
	
	private String firstName;
	
	private String telNumber;
	
	private String address;
	
	private int status;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	public long getId() {
		return id;
	}
		public void setId(long id) {
		this.id = id;
	}
		
	public long getUserId() {
		return userId;
	}
		
	public void setUserId(long userId) {
			this.userId = userId;
	}
	
	public String getFamilyName() {
		return familyName;
	}
		
	public void setFamilyName(String familyName) {
			this.familyName = familyName;
	}
	
	public String getFirstName() {
		return firstName;
	}
		
	public void setFirstName(String firstName) {
			this.firstName = firstName;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
		
	public void setTelNumber(String telNumber) {
			this.telNumber = telNumber;
	}
	
	public String getAddress() {
		return address;
	}
		
	public void setAddress(String address) {
			this.address = address;
	}
	
	public int getStatus() {
		return status;
	}
		
	public void setStatus(int status) {
			this.status = status;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
		
	public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
		
	public void setUpdatedAt(Timestamp updatedAt) {
			this.updatedAt = updatedAt;
	}
	
}
