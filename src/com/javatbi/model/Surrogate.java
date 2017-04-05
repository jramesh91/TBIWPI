package com.javatbi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SURROGATE_TABLE", uniqueConstraints = { @UniqueConstraint(columnNames = "SURR_ID") })
public class Surrogate implements Serializable {
	private static final long serialVersionUID = -1798070786993154676L;
	@Id
	@GeneratedValue
	@Column(name = "SURR_ID", unique = true, nullable = false)
	private Long surr_id;
	@Column(name = "SURR_EMAIL")
	private String surr_email;

	public Surrogate() {
		super();
	}

	public Surrogate( String surr_email) {
		super();	
		this.surr_email = surr_email;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SURR_ID")
	private Set<Application> application;

	public Long getSurr_id() {
		return surr_id;
	}

	public void setSurr_id(Long surr_id) {
		this.surr_id = surr_id;
	}

	public String getSurr_email() {
		return surr_email;
	}

	public void setSurr_email(String surr_email) {
		this.surr_email = surr_email;
	}

	public Set<Application> getApplication() {
		return application;
	}

	public void setApplication(Set<Application> application) {
		this.application = application;
	}
}
