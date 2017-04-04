package umn.umncalendar;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import umn.umncalendar.Event.EventCategory;

/**
 * Created by AartiRajan on 4/3/2017.
 */

public class DataInitializer {
    List<Event> eventList;
    //List<Host> hostList;
    public DataInitializer(){
        eventList = new ArrayList<>();
    }

    public static List<Event> initEvents(){
        List<Event> res = new ArrayList<>();
        Date d = Date.valueOf("2017-01-01 03:00:00");
        Event one = new Event(1,1,"Spring Fest");
        one.setDate(d);
        one.setStatus(Event.EventStatus.FUTURE);
        one.setCategory(Event.EventCategory.MUSIC);
        one.setAddress("Coffman Memorial Union");
        res.add(one);
        return res;
    }

    public List<Event> getEventsBasedOnCategories(List<EventCategory> categories){
        List<Event> res = new ArrayList<>();

        for(Event e: eventList){
            for(EventCategory ec : categories) {
                if (e.getCategory().equals(ec)){
                    res.add(e);
                }
            }
        }

        return res;
    }

    public List<Event> getEventsOnKeywords(List<String> keywords){
        List<Event> res = new ArrayList<>();

        for(Event e: eventList){
            for(String kw : keywords) {
                if (e.getKeywords().contains(kw)){
                    res.add(e);
                }
            }
        }

        return res;
    }
}
