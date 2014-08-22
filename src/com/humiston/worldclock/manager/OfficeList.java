package com.humiston.worldclock.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.humiston.worldclock.dto.OfficeDto;

@Named("officeList")
@SessionScoped
public class OfficeList implements Serializable{
	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger(OfficeList.class.getName());
	
	private List<OfficeDto> offices = new ArrayList<>();
	
	public OfficeList(){
	}
 
    public List<OfficeDto> getOffices() {
        return offices;
    }
 
    public void setOffices(List<OfficeDto> offices) {
        this.offices = offices;
    }
    
	public void removeOffice(OfficeDto office){
		offices.remove(office);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Removed",  office.getOfficeName()+" has been removed."));
	}
    
    @PostConstruct
    private void populate() {
    	offices.add(new OfficeDto("1", "Local", "America/New_York"));
    	offices.add(new OfficeDto("2", "Sydney", "Australia/Sydney"));
    }

}
