package com.humiston.worldclock.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.humiston.worldclock.dto.OfficeDto;
 
@ManagedBean
@ViewScoped
public class OfficeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{clockBean}")
	private ClockBean clockBean;
	private OfficeDto selectedOffice;
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
    
    public OfficeDto getSelectedOffice() {
		return selectedOffice;
	}

	public void setSelectedOffice(OfficeDto selectedOffice) {
		this.selectedOffice = selectedOffice;
		officeName = selectedOffice.getOfficeName();
		timeZone = selectedOffice.getTimeZone();
	}

	public void addOffice(){
    	clockBean.getOffices().add(new OfficeDto(officeName, timeZone));
    	officeName="";
    	timeZone="";
    }
	
	public void editOffice(){
		int index = clockBean.getOffices().indexOf(selectedOffice);
		OfficeDto office = clockBean.getOffices().get(index);
		office.setOfficeName(officeName);
		office.setTimeZone(timeZone);
		clockBean.getOffices().set(index, office);
    	officeName="";
    	timeZone="";
	}
}
