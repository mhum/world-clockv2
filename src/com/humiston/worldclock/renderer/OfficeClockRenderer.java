package com.humiston.worldclock.renderer;

import java.io.IOException;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.render.FacesRenderer;

import org.primefaces.component.clock.Clock;
import org.primefaces.component.clock.ClockRenderer;
import org.primefaces.util.WidgetBuilder;

import com.humiston.worldclock.component.OfficeClock;

@FacesRenderer(
	    componentFamily=OfficeClock.COMPONENT_FAMILY,
	    rendererType=OfficeClockRenderer.RENDERER_TYPE
	)
public class OfficeClockRenderer extends ClockRenderer{
	
	public static final String RENDERER_TYPE = "com.humiston.worldclock.renderer.OfficeClockRenderer";
	
	@Override
	protected void encodeScript(FacesContext context, Clock clock) throws IOException {
		String clientId = clock.getClientId(context);
		String mode = clock.getMode();
		WidgetBuilder wb = getWidgetBuilder(context);
		
		wb.init("Clock", clock.resolveWidgetVar(), clientId);
		wb.attr("mode", mode)
		.attr("pattern", clock.getPattern(), null)
		.attr("locale", context.getViewRoot().getLocale().toString());

		if(mode.equals("server")) {
			TimeZone remoteTimeZone = TimeZone.getTimeZone((String) clock.getAttributes().get("timeZone")); 
			TimeZone localTimeZone = TimeZone.getDefault();
			long utcTime = System.currentTimeMillis(); 
			long remoteOffset = remoteTimeZone.getOffset(utcTime); 
			long localOffset = localTimeZone.getOffset(utcTime); 
			long t = utcTime + remoteOffset-localOffset;

			wb.attr("value", t);

			if(clock.isAutoSync()) {
				wb.attr("autoSync", true).attr("syncInterval", clock.getSyncInterval());
			}
		}

		wb.finish();
	}

}
