package umn.umncalendar;

import android.icu.util.ULocale;
import android.media.Image;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by AartiRajan on 4/3/2017.
 */

public class Event {
    public enum EventStatus {
        DRAFT(1), CANCELLED(2), PAST(3), FUTURE(4);
        private int value;

        EventStatus(int value) {
            this.value=value;
        }
    }

    public enum EventCategory {
        SPORTS(1), MUSIC(2), DANCE(3), ACADEMIC(4), SOCIAL(5);
        private int value;

        EventCategory(int value) {
            this.value=value;
        }
    }

    int eventId;
    int hostId;
    String eventName;
    int poster;
    Calendar date;
    String desc;
    EventStatus status;
    EventCategory category;
    List<String> keywords;
    String address;
    boolean food;
    boolean RSVP;
    String imageName;
    int imagePoster;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Event(int eventId, int hostId, String eventName, int poster, Calendar date, String desc, EventStatus status, int category, List<String> keywords, String address, boolean food, boolean RSVP) {
        this.eventId = eventId;
        this.hostId = hostId;
        this.eventName = eventName;
        this.poster = poster;
        this.date = date;
        this.desc = desc;
        this.status = status;
        this.category = EventCategory.values()[category];
        this.keywords = keywords;
        this.address = address;
        this.food = food;
        this.RSVP = RSVP;
    }

    public Event(int eventId, int hostId, String eventName) {
        this.eventId = eventId;
        this.hostId = hostId;
        this.eventName = eventName;
        keywords = new ArrayList<>();
    }

    public void addKeyword(String keyword){
        this.keywords.add(keyword);
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getFormattedDate() {
        String pattern = "EEE MMM dd HH:mm aa";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String evDate = sdf.format(date.getTime());
        return evDate;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isRSVP() {
        return RSVP;
    }

    public void setRSVP(boolean RSVP) {
        this.RSVP = RSVP;
    }
}