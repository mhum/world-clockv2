package com.humiston.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
 
@ManagedBean
@ViewScoped
public class ClockBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter fmt = DateTimeFormat.forPattern("h:mm:ss a");
	private String date;
	
	public ClockBean(){
    	DateTime dt = new DateTime();   	
    	date = fmt.print(dt);
	}
 
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
    
    public void update(){
    	DateTime dt = new DateTime();
    	date = fmt.print(dt);
    }
}
