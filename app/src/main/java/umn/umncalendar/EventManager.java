package umn.umncalendar;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import umn.umncalendar.Event.EventCategory;
import umn.umncalendar.Event.EventStatus;
/**
 * Created by AartiRajan on 4/3/2017.
 */

public class EventManager {
    static List<Event> eventList = initEvents();
    //List<Host> hostList;

    /**
     * Temp method, move to user manager later
     * */
    public List<String> getInterests(){
        List<String> res = new ArrayList<>();
        res.add("Sports");
        res.add("Music");
        res.add("Art");
        res.add("Social");
        return res;
    }

    public static List<Event> initEvents(){
        List<Event> res = new ArrayList<Event>();
        Calendar calendar = new GregorianCalendar(2017,3,31,8,0,0);
        Event one = new Event(1,1,"Spring Fest");
        one.setDate(calendar);
        one.setStatus(EventStatus.FUTURE);
        one.setCategory(EventCategory.MUSIC);
        one.setAddress("Coffman Memorial Union");
        one.setStatus(EventStatus.FUTURE);
        one.getKeywords().add("Music");
        one.setPoster(R.mipmap.logo_sping_fest_1);
        res.add(one);

        Event two = new Event(2,1,"Coffee Hour");
        two.setDate(calendar);
        two.setStatus(EventStatus.FUTURE);
        two.setCategory(EventCategory.SOCIAL);
        two.setAddress("Coffman Memorial Union");
        two.setStatus(EventStatus.FUTURE);
        two.getKeywords().add("Coffee");
        two.setPoster(R.mipmap.coffee_hour);
        res.add(two);
        return res;
    }

    public List<Event> getEventList(){
        return eventList;
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

    public List<Event> getEventsBasedOnStatus(List<EventStatus> statuses){
        List<Event> res = new ArrayList<>();

        for(Event e: eventList){
            for(EventStatus es : statuses) {
                if (e.getStatus().equals(es)){
                    res.add(e);
                }
            }
        }

        return res;
    }

    public List<Event> getRecommendedEvents(List<String> interests){
        List<Event> res = new ArrayList<>();

        for(Event e : eventList){
            if (e.getStatus().equals(EventStatus.FUTURE)){
                for(String i : interests){
                    if(e.getKeywords().contains(i.toUpperCase()) || e.getCategory().name().equalsIgnoreCase(i)){
                        res.add(e);
                    }
                }
            }
        }

        return res;
    }
}
