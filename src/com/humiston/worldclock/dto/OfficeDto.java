package com.humiston.worldclock.dto;

import java.io.Serializable;

public class OfficeDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String officeName;
	private String timeZone;
	
	public OfficeDto(){
		
	}
	
	public OfficeDto(String officeName, String timeZone){
		this.officeName = officeName;
		this.timeZone = timeZone;
	}
	
	public OfficeDto(String id, String officeName, String timeZone){
		this.id = id;
		this.officeName = officeName;
		this.timeZone = timeZone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOfficeName() {
        return officeName;
    }
 
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}
