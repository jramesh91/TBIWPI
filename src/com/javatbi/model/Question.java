package com.javatbi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Indicates the {@link Question} entity that stores information related to each
 * questions provided by the surgeon.
 * 
 * @author Kevin
 */
@Entity
@Table(name = "QUESTION", uniqueConstraints = { @UniqueConstraint(columnNames = "Q_ID") })
public class Question implements Serializable {
	/**
	 * Indicates the generated serial ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Uniquely identifies the entity.
	 */
	@Id
	@GeneratedValue
	@Column(name = "Q_ID", unique = true, nullable = false)
	private Long q_id;
	/**
	 * Indicates the text associated with the question.
	 */
	@Column(name = "Q_text")
	private String q_text;
	/**
	 * Indicates if the question is to be included in the decision aid or not.
	 */
	@Column(name = "IS_LIVE")
	private boolean is_live;
	/**
	 * Indicates which section/tab does the question belong to.
	 */
	@Column(name = "Q_SECTION")
	private int Integer;
	/**
	 * Indicates the creation date of the entity.
	 */
	@Column(name = "CREATION_DATE")
	private Date creation_date;

	/**
	 * @return the q_id
	 */
	public Long getQ_id() {
		return q_id;
	}

	/**
	 * @param q_id
	 *            the q_id to set
	 */
	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}

	/**
	 * @return the q_text
	 */
	public String getQ_text() {
		return q_text;
	}

	/**
	 * @param q_text
	 *            the q_text to set
	 */
	public void setQ_text(String q_text) {
		this.q_text = q_text;
	}

	/**
	 * @return the is_live
	 */
	public boolean isIs_live() {
		return is_live;
	}

	/**
	 * @param is_live
	 *            the is_live to set
	 */
	public void setIs_live(boolean is_live) {
		this.is_live = is_live;
	}

	/**
	 * @return the integer
	 */
	public int getInteger() {
		return Integer;
	}

	/**
	 * @param integer
	 *            the integer to set
	 */
	public void setInteger(int integer) {
		Integer = integer;
	}

	/**
	 * @return the creation_date
	 */
	public Date getCreation_date() {
		return creation_date;
	}

	/**
	 * @param creation_date
	 *            the creation_date to set
	 */
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
}
