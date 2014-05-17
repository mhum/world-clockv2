package com.humiston.worldclock.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean
@RequestScoped
public class OfficeBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String officeName;
 
    public String getOfficeName() {
        return officeName;
    }
 
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
    
    public void addOffice(){
    	System.out.println("Here! "+officeName);
    }
}
