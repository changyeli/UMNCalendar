package umn.umncalendar;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class NotificationList {
    static List<Event> notificationsList = initNotifications();
    static List<Event> nList = initNotifications();
//    static List<String> interests = getInterests();
    static List<Event> myevents = initNotifications();


    public static List<Event> initNotifications(){
        List<Event> res = new ArrayList<Event>();
        Calendar calStart = new GregorianCalendar(2017,3,31,8,0);
        Calendar calEnd = new GregorianCalendar(2017,3,31,10,0);
        Event one = new Event(1,1,"Spring Fest");
        one.setStartDate(calStart);
        one.setEndDate(calEnd);
        one.setStatus(Event.EventStatus.FUTURE);
        one.setCategory(Event.EventCategory.MUSIC);
        one.setAddress("Coffman Memorial Union");
        one.setStatus(Event.EventStatus.FUTURE);
        one.getKeywords().add("Music");
        one.setPoster(R.mipmap.logo_sping_fest_1);
        res.add(one);

        Event two = new Event(2,1,"Coffee Hour");
        two.setStartDate(calStart);
        two.setEndDate(calEnd);
        two.setStatus(Event.EventStatus.FUTURE);
        two.setCategory(Event.EventCategory.SOCIAL);
        two.setAddress("Coffman Memorial Union");
        two.setStatus(Event.EventStatus.FUTURE);
        two.getKeywords().add("Coffee");
        two.setPoster(R.mipmap.coffee_hour);
        two.setFood(Boolean.TRUE);
        res.add(two);
        return res;
    }

    public List<Event> getNotificationsList(){
        return notificationsList;
    }

    public List<Event> getEventsBasedOnCategories(List<Event.EventCategory> categories){
        List<Event> res = new ArrayList<>();

        for(Event e: notificationsList){
            for(Event.EventCategory ec : categories) {
                if (e.getCategory().equals(ec)){
                    res.add(e);
                }
            }
        }

        return res;
    }

    public List<Event> getEventsOnKeywords(List<String> keywords){
        List<Event> res = new ArrayList<>();

        for(Event e: notificationsList){
            for(String kw : keywords) {
                if (e.getKeywords().contains(kw)){
                    res.add(e);
                }
            }
        }

        return res;
    }

    public List<Event> getEventsBasedOnStatus(List<Event.EventStatus> statuses){
        List<Event> res = new ArrayList<>();

        for(Event e: notificationsList){
            for(Event.EventStatus es : statuses) {
                if (e.getStatus().equals(es)){
                    res.add(e);
                }
            }
        }

        return res;
    }

//    public List<Event> getRecommendedEvents(){
//        List<Event> res = new ArrayList<>();
//
//        for(Event e : getRecommendedList()){
//            if (e.getStatus().equals(Event.EventStatus.FUTURE)){
//                for(String i : interests){
//                    if(e.getKeywords().contains(i.toUpperCase()) || e.getCategory().name().equalsIgnoreCase(i)){
//                        res.add(e);
//                    }
//                }
//            }
//        }
//
//        return res;
//    }

    public static void setEventList(List<Event> eventList) {
        EventManager.eventList = eventList;
    }

//    public static List<Event> getRecommendedList() {
//        return recommendedList;
//    }

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
}
