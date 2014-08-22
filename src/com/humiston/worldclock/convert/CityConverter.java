package com.humiston.worldclock.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.humiston.worldclock.model.Prediction;

@FacesConverter("cityConverter")
public class CityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("Get as object"+value);
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object != null) {
            return String.valueOf(((Prediction) object).getReference());
        }
        else {
            return null;
        }
    }   

}
