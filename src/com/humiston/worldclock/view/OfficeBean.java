package com.humiston.worldclock.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import com.humiston.worldclock.dto.OfficeDto;
 
@ManagedBean
@RequestScoped
public class OfficeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{clockBean}")
	private ClockBean clockBean;
	private String officeName;
	private String timeZone;
	
	public void setClockBean(ClockBean clockBean) {
		this.clockBean = clockBean;
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
    
    public void addOffice(){
    	clockBean.getOffices().add(new OfficeDto(officeName, timeZone));
    	officeName="";
    	timeZone="";
    }
}
