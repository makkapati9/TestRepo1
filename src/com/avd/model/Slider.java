package com.avd.model;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_slide_show")
public class Slider implements Serializable {
	
	
	@Id
	@GenericGenerator(name = "mygen12", strategy = "increment")
 	@GeneratedValue(generator = "mygen12")
	@Column(name = "ID")
	public Integer id;
	
	@Column(name = "IMAGE")
	public Clob image;
	
	@Column(name = "IS_ACTIVE")
	public String isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clob getImage() {
		return image;
	}

	public void setImage(Clob image) {
		this.image = image;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}



}
