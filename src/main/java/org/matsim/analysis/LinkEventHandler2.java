package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.network.Link;
import org.matsim.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class LinkEventHandler2 implements LinkLeaveEventHandler {

    private Id<Link> linkId = Id.createLinkId("7232382780000f");
    private int currentCount = 0;
    Map<Integer,Integer> hourlyRate = new HashMap();
    @Override
    public void handleEvent(LinkLeaveEvent linkLeaveEvent) {

        var activeLinkId = linkLeaveEvent.getLinkId();
        if (linkId==activeLinkId){
            currentCount = currentCount+1;
            int time = (int) (linkLeaveEvent.getTime()/3600);
            hourlyRate.put(time,currentCount);

        }
        System.out.println(hourlyRate);

    }


}