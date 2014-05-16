package com.humiston.dto;

import java.io.Serializable;

public class OfficeDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String officeName;
	private String time;
 
    public String getOfficeName() {
        return officeName;
    }
 
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
