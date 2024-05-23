package org.matsim.analysis;

import org.matsim.core.events.EventsUtils;

public class SimpleAnalysis {
    public static void main(String[] args){

        var handler = new LinkEventHandler2();
        var histohandler = new HistrogramHandler();
        var manager = EventsUtils.createEventsManager();
        manager.addHandler(handler);
        manager.addHandler(histohandler);

        EventsUtils.readEvents(manager,"C:\\Users\\arsal\\Documents\\IntelliJProject\\matsim-serengeti-park-hodenhagen\\scenarios\\serengeti-park-v1.0\\output\\output-serengeti-park-v1.0-run1\\serengeti-park-v1.0-run1.output_events.xml.gz");

        for (var stringIntegerEntry : histohandler.histogram.entrySet()){
            System.out.println(stringIntegerEntry.getKey()+ ":" + stringIntegerEntry.getValue());

        }
    }
}
