package com.humiston.worldclock.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AutocompletionResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class AutocompletionResponse {
	private String status;
	
	@XmlElement(name="prediction")
	private List<Prediction> prediction;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Prediction> getPrediction() {
		return prediction;
	}
	public void setPrediction(List<Prediction> prediction) {
		this.prediction = prediction;
	}
}
