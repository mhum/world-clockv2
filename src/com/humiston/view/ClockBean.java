package com.humiston.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.humiston.dto.OfficeDto;
 
@ManagedBean
@ViewScoped
public class ClockBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter fmt = DateTimeFormat.forPattern("h:mm:ss a");
	private List<OfficeDto> offices = new ArrayList<>();
	
	public ClockBean(){
    	DateTime dt = new DateTime();
		OfficeDto office = new OfficeDto();
    	office.setTime(fmt.print(dt));
    	offices.add(office);

    	office = new OfficeDto();
    	office.setTime(fmt.print(dt));
    	offices.add(office);
	}
 
    public List<OfficeDto> getOffices() {
        return offices;
    }
 
    public void setOffices(List<OfficeDto> offices) {
        this.offices = offices;
    }
    
    public void update(){
    	DateTime dt = new DateTime();
    	for (int x=0;x<offices.size();x++){
    		OfficeDto office = offices.get(x);
    		office.setTime(fmt.print(dt));
    	}
    }
}
