package com.cdac.restro.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_details_tab")
public class FeedbackDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackID;
	private String feedbackName;
	private String feedbackDesc;

	public FeedbackDetails() {
		super();
	}

	public Integer getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Integer feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getFeedbackName() {
		return feedbackName;
	}

	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}

	public String getFeedbackDesc() {
		return feedbackDesc;
	}

	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
	}

	@Override
	public String toString() {
		return "FeedbackDetails [feedbackID=" + feedbackID + ", feedbackName=" + feedbackName + ", feedbackDesc="
				+ feedbackDesc + "]";
	}




}
