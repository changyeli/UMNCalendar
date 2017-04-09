package umn.umncalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class NotificationsManager {
    static List<Event> notificationsList = initNotifications();
    static List<Event> nList = initNotifications();
    //    static List<String> interests = getInterests();
    static List<Event> mynotifications = initNotifications();


    public static List<Event>  initNotifications(){
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
        two.setAddress("AEURHHhNnG");
        two.setStatus(Event.EventStatus.FUTURE);
        two.getKeywords().add("Coffee");
        two.setPoster(R.mipmap.coffee_hour);
        two.setFood(Boolean.TRUE);
        res.add(two);


        Event three = new Event(2,1,"Exhibition | Body and Self");
        three.setStartDate(calStart);
        three.setEndDate(calEnd);
        three.setStatus(Event.EventStatus.FUTURE);
        three.setCategory(Event.EventCategory.SOCIAL);
        three.setAddress("CANCELLED");
        three.setStatus(Event.EventStatus.FUTURE);
        three.setPoster(R.mipmap.exhibit);
        three.setFood(Boolean.TRUE);
        res.add(three);



        return res;
    }

    public List<Event> getNotificationsList(){
        return notificationsList;
    }

    public static List<Event> getMyNotifications() {
        return mynotifications;
    }

//    public static void setMyevents(List<Event> myevents) {
//        EventManager.myevents = myevents;
//    }
}
