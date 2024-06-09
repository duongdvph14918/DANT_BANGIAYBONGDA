package com.men.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
public class Style implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int styleId;
	@Column(columnDefinition = "NVARCHAR(255)  NULL")
	String name;
	private boolean status;
	
	
	public int getStyleId() {
		return styleId;
	}
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public Style(int styleId, String name, boolean status) {
		super();
		this.styleId = styleId;
		this.name = name;
		this.status = status;
	}
	public Style() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
