package com.javatbi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "APPLICATION", uniqueConstraints = { @UniqueConstraint(columnNames = "APP_ID"), })
public class Application implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "APP_ID", unique = true, nullable = false)
	private Long app_id;
	@ManyToOne
	private Surrogate surr;

	public Application(Long app_id) {
		super();
		this.app_id = app_id;
	}

	public Application() {
		super();
	}

	public Long getApp_id() {
		return app_id;
	}

	public void setApp_id(Long app_id) {
		this.app_id = app_id;
	}

	public Surrogate getSurr() {
		return surr;
	}

	public void setSurr(Surrogate surr) {
		this.surr = surr;
	}
}
