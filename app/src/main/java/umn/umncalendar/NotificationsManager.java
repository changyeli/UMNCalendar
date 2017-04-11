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

        Event one = new Event(1,1,"Movie Night - Location Change");
        one.setPoster(R.mipmap.movie_night);
        one.setDesc("Location has been changed to 'Coffman Memorial Union'");
        res.add(one);

        Event two = new Event(2,1,"Coffee Hour - Friend Invitation");
        two.setDesc("James Smith has invited you for the event 'Coffee Hour'");
        two.setPoster(R.mipmap.coffee_hour);
        res.add(two);

        Event three = new Event(1,1,"Spring Fest - Day Change");
        three.setDesc("Event has been reschedued for 13th April");
        three.setPoster(R.mipmap.logo_sping_fest_1);
        res.add(three);

        return res;
    }

    public List<Event> getNotificationsList(){
        return notificationsList;
    }

    public static List<Event> getMyNotifications() {
        return mynotifications;
    }

    public static List<Event> removeEventFromMyNotifications(Event e) {
        mynotifications.remove(e);
        return mynotifications;
    }

}