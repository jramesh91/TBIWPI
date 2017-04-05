
package com.javatbi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWER_TABLE")
public class Answer implements Serializable {
    
    @Id @GeneratedValue
    private Long ans_id;
    @Column(name = "ANS_TEXT")
    private String ans_text;
    @Column(name = "CREATION_DATE")
    private Date creation_date;
    
    public Answer() {
    }

    
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Q_ID")
	private Set<Question> questions;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "APP_ID")
	private Set<Application> applicaton_id;
	


	public Answer(Long ans_id, Long app_id, String ans_text,
			Date creation_date) {
		super();
		this.ans_id = ans_id;
		//this.app_id = app_id;
		this.ans_text = ans_text;
		this.creation_date = creation_date;
	}

	public Long getAns_id() {
		return ans_id;
	}

	public void setAns_id(Long ans_id) {
		this.ans_id = ans_id;
	}

	/*public Long getApp_id() {
		return app_id;
	}

	public void setApp_id(Long app_id) {
		this.app_id = app_id;
	}*/

	public String getAns_text() {
		return ans_text;
	}

	public void setAns_text(String ans_text) {
		this.ans_text = ans_text;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
    
	
	
	
	
    
   
}
