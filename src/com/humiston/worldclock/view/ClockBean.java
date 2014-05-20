package com.humiston.worldclock.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.humiston.worldclock.dto.OfficeDto;
 
@ManagedBean
@ViewScoped
public class ClockBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<OfficeDto> offices = new ArrayList<>();
	
	public ClockBean(){
    	offices.add(new OfficeDto("Local", "America/New_York"));
    	offices.add(new OfficeDto("Sydney", "Australia/Sydney"));
	}
 
    public List<OfficeDto> getOffices() {
        return offices;
    }
 
    public void setOffices(List<OfficeDto> offices) {
        this.offices = offices;
    }
	
	public void removeOffice(OfficeDto office){
		offices.remove(office);
	}
}
