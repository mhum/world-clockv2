package com.humiston.worldclock.backing;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.humiston.worldclock.dto.OfficeDto;
import com.humiston.worldclock.manager.OfficeList;
 
@Named("office")
@ConversationScoped
public class Office implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private OfficeList officeList;
    @Inject
    private Conversation conversation;
	private OfficeDto selectedOffice;
	private String officeName;
	private String timeZone;


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
		conversation.begin();
		officeList.getOffices().add(new OfficeDto(officeName, timeZone));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Added",  officeName+" has been added."));
		officeName = null;
		timeZone = null;
		conversation.end();
    }
	
	public void setSelectedOffice(OfficeDto office) {
		conversation.begin();
		this.selectedOffice = office;
		this.officeName = office.getOfficeName();
		this.timeZone = office.getTimeZone();
	}
	
	public void editOffice(){
		int index = officeList.getOffices().indexOf(selectedOffice);
		OfficeDto office = officeList.getOffices().get(index);
		office.setOfficeName(officeName);
		office.setTimeZone(timeZone);
		officeList.getOffices().set(index, office);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Updated",  officeName+" has been updated."));
		officeName = null;
		timeZone = null;
		conversation.end();
	}
}
