package com.humiston.worldclock.component;

import java.util.Calendar;

import javax.faces.component.FacesComponent;

import org.primefaces.component.clock.Clock;

import com.humiston.worldclock.renderer.OfficeClockRenderer;

@FacesComponent(OfficeClock.COMPONENT_TYPE)
public class OfficeClock extends Clock{
	
    public static final String COMPONENT_FAMILY = "com.humiston.worldclock.component";
    public static final String COMPONENT_TYPE = "com.humiston.worldclock.component.OfficeClock";
    
    private enum PropertyKeys {
        timezone
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return OfficeClockRenderer.RENDERER_TYPE;
    }
    
    public String getTimeZone() {
    	String tz = Calendar.getInstance().getTimeZone().getID();
        return (String) getStateHelper().eval(PropertyKeys.timezone, tz);
    }

    public void setTimeZone(String timeZone) {
        getStateHelper().put(PropertyKeys.timezone, timeZone);
    }

}
