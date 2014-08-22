package com.humiston.worldclock.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PlaceDetailsResponse")
public class PlaceDetailsResponse {
	private String status;
	
	@XmlElement(name="result")
	private List<Result> result;
}
