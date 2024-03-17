package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;


public class SimplePersonEventHandler2 implements PersonDepartureEventHandler, PersonArrivalEventHandler {
    private double arrivalTime;
    private double departureTime;

    private Id<Person> personID;

    //Map<Id<Person>, Double> personToDepartureTime = new HashMap<Id<Person>, Double>();
    @Override
    public void handleEvent(PersonArrivalEvent personArrivalEvent) {
        this.arrivalTime = personArrivalEvent.getTime();
        //System.out.println("Arrival Time: "+arrivalTime);
        var time = arrivalTime - departureTime;
       // personToDepartureTime.put(personArrivalEvent.getPersonId(),time);
        //System.out.println("Person : "+personArrivalEvent.getPersonId()+ " : "+time);
        this.personID = personArrivalEvent.getPersonId();
        System.out.println("Person Id: "+personID+ " Time: "+time);

    }

    @Override
    public void handleEvent(PersonDepartureEvent personDepartureEvent) {
        this.departureTime= personDepartureEvent.getTime();
       // System.out.println("Departure Time: "+departureTime);
       // personToDepartureTime.put(personDepartureEvent.getPersonId(),personDepartureEvent.getTime());
       // System.out.println(personToDepartureTime);


    }
}
