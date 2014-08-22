package com.humiston.worldclock.view;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.humiston.worldclock.dto.OfficeDto;
import com.humiston.worldclock.model.AutocompletionResponse;
import com.humiston.worldclock.model.Prediction;
 
@Named("officeBean")
@ViewScoped
public class OfficeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClockBean clockBean;
	private OfficeDto selectedOffice;
	private String officeName;
	private String timeZone;
	private Prediction city;
	
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
    
    public Prediction getCity() {
		return city;
	}

	public void setCity(Prediction city) {
		this.city = city;
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
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Added",  officeName+" has been added."));
    	officeName="";
    	timeZone="";
    }
	
	public void editOffice(){
		int index = clockBean.getOffices().indexOf(selectedOffice);
		OfficeDto office = clockBean.getOffices().get(index);
		office.setOfficeName(officeName);
		office.setTimeZone(timeZone);
		clockBean.getOffices().set(index, office);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Updated",  officeName+" has been updated."));
    	officeName="";
    	timeZone="";
	}
	
    public List<Prediction> getCity(String query) throws JAXBException {       
        JAXBContext jc = JAXBContext.newInstance(AutocompletionResponse.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("C:\\Users\\Brianna\\git\\world-clockv2\\src/firstSearch.xml");
        AutocompletionResponse search = (AutocompletionResponse) unmarshaller.unmarshal(xml);
        
        return search.getPrediction();
    }
}
