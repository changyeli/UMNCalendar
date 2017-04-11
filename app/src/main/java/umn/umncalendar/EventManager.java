package umn.umncalendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import umn.umncalendar.Event.EventCategory;
import umn.umncalendar.Event.EventStatus;
/**
 * Created by AartiRajan on 4/3/2017.
 */

public class EventManager {
    static List<Event> eventList = initEvents();
    static List<Event> recommendedList = initEvents();
    static List<String> interests = getInterests();
    static List<Event> myevents = initMyEvents();

    /**
     * Temp method, move to user manager later
     * */
    public static List<String> getInterests(){
        List<String> res = new ArrayList<>();
        res.add("Sports");
        res.add("Music");
        res.add("Art");
        res.add("Social");
        return res;
    }

    public static List<Event> initEvents(){
        List<Event> res = new ArrayList<Event>();
        Calendar calStart = new GregorianCalendar(2017,3,13,8,0);
        Calendar calEnd = new GregorianCalendar(2017,3,13,11,0);
        Event one = new Event(1,1,"Spring Fest");
        one.setStartDate(calStart);
        one.setEndDate(calEnd);
        one.setAddress("The Rail Apartments");
        one.setStatus(EventStatus.FUTURE);
        one.setCategory(EventCategory.Music);
        one.getKeywords().add("Music");
        one.setPoster(R.mipmap.logo_sping_fest_1);
        one.setFood(false);
        one.setOnCampus(false);
        one.setfreeEntry(true);
        one.setMap(R.mipmap.map_rail_apts);
        one.setDesc("Springfest is an annual music festival put on by Program Board. The event is complete with a Beer Garden, food trucks, and activities supplied by Macalester student organizations");
        res.add(one);

        Event two = new Event(2,1,"Coffee Hour");
        calStart = new GregorianCalendar(2017,3,15,10,0);
        calEnd = new GregorianCalendar(2017,3,1,11,0);
        two.setStartDate(calStart);
        two.setEndDate(calEnd);
        two.setCategory(EventCategory.Social);
        two.setAddress("Akerman Hall");
        two.setStatus(EventStatus.FUTURE);
        two.getKeywords().add("Coffee");
        two.setPoster(R.mipmap.coffee_hour);
        two.setFood(Boolean.TRUE);
        two.setOnCampus(true);
        two.setfreeEntry(false);
        two.setMap(R.mipmap.map_akerman);
        two.setDesc("Coffee Hour! A whole hour of Coffee! (or tea, or maybe even hot cocoa!) Come on down to coffee hour and have a bagel or donut to go with a favorite warm beverage. Talk with fellow grad students about life and/or school and/or whatever!");
        res.add(two);

        Event three = new Event(3,1,"Movie Night");
        calStart = new GregorianCalendar(2017,4,1,9,0);
        calEnd = new GregorianCalendar(2017,4,1,12,0);
        three.setStartDate(calStart);
        three.setEndDate(calEnd);
        three.setStatus(EventStatus.FUTURE);
        three.setCategory(EventCategory.Movie);
        three.setAddress("Coffman Memorial Union");
        three.getKeywords().add("Movie");
        three.setPoster(R.mipmap.movie_night);
        three.setFood(Boolean.TRUE);
        three.setOnCampus(true);
        three.setfreeEntry(true);
        three.setMap(R.mipmap.map_coffman);
        three.setDesc("Join us to watch a movie under the stars, sponsored and organized by the PTA. Bring warm clothes, a blanket and low chairs to sit on during the film.");
        res.add(three);

        return res;
    }

    public static List<Event> initMyEvents(){
        List<Event> myEventList= new ArrayList<Event>();
        return myEventList;
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

    public List<Event> getRecommendedEvents(){
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

    public List<Event> getFilteredEvents(String date, String category, boolean food, boolean entry, boolean onCampus){
        List<Event> res = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


        for(Event e : eventList){
            String eventDate=((int)(e.getStartDate().get(Calendar.MONTH))+1)+"/"+(int)(e.getStartDate().get(Calendar.DATE))+"/"+(int)(e.getStartDate().get(Calendar.YEAR));
            if ((date.equals("Select date") || eventDate.equals(date)) && (food==false || e.isFood()==food) && (entry==false || e.isfreeEntry()==entry) && (onCampus == false || e.isOnCampus()==onCampus)){
                if (category.equals("Select Category") || e.getCategory().name().equals(category))
                   res.add(e);
            }
        }
        return res;
    }

    public List<Event> getFilteredMyEvents(String date){
        List<Event> res = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


        for(Event e : myevents){
            String eventDate=((int)(e.getStartDate().get(Calendar.MONTH))+1)+"/"+(int)(e.getStartDate().get(Calendar.DATE))+"/"+(int)(e.getStartDate().get(Calendar.YEAR));
            if ((date.equals("Select date") || eventDate.equals(date))){
                    res.add(e);
            }
        }
        return res;
    }

    public static void setEventList(List<Event> eventList) {
        EventManager.eventList = eventList;
    }

    public static List<Event> getRecommendedList() {
        return recommendedList;
    }

    public static void setRecommendedList(List<Event> recommendedList) {
        EventManager.recommendedList = recommendedList;
    }

    public static void setInterests(List<String> interests) {
        EventManager.interests = interests;
    }

    public static List<Event> getMyevents() {
        return myevents;
    }

    public static void setMyevents(List<Event> myevents) {
        EventManager.myevents = myevents;
    }

    public static void addToMyevents(Event event) {
        if (!myevents.contains(event))
        myevents.add(event);
    }

    public static void removeFromMyevents(Event event) {
        myevents.remove(event);
    }

    public static boolean checkIfEventInMyEvents(Event event) {
        return myevents.contains(event);
    }

}
