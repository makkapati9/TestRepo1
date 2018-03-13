package com.avd.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_product_sequence database table.
 * 
 */
@Entity
@Table(name="tbl_product_sequence")
public class TblProductSequence implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;

	public TblProductSequence() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}