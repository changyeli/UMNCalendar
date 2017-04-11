package umn.umncalendar;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

/**
 * Created by AartiRajan on 4/9/2017.
 */

public class EventDetailsActivity extends AppCompatActivity {
    View currView;
    String eventNm;
    Button rsvp;
    Event event;
    LayoutInflater inflater;
    ViewGroup container;
    Bundle savedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_eventpage);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.eventpage_tolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        final String caller = bundle.getString("caller");
        EventManager em = new EventManager();
        Event e = null;
        if(caller.equals("Recommended")){
            e = em.getRecommendedEvents().get(position);
        }else if(caller.equals("Calendar")){
            e = em.getEventList().get(position);
        }else if(caller.equals("MyEvents")){
            e = em.getMyevents().get(position);
        }

        TextView eventName = (TextView)findViewById(R.id.eventName);
        eventName.setText(e.getEventName());

        ImageView poster = (ImageView)findViewById(R.id.poster);
        poster.setImageResource(e.getPoster());

        TextView category = (TextView)findViewById(R.id.category);
        category.setText(e.getCategory().name());

        TextView event_date = (TextView)findViewById(R.id.event_date);
        event_date.setText(e.getFormattedDate());

        TextView event_address = (TextView)findViewById(R.id.event_address);
        event_address.setText(e.getAddress());


        TextView desc = (TextView)findViewById(R.id.desc);
        desc.setText(e.getDesc());


        //ImageView foodIcon = (ImageView)findViewById(R.id.foodIcon);
        /*if(!e.isFood()){
            foodIcon.setVisibility(View.INVISIBLE);
        }*/

        ImageView map = (ImageView)findViewById(R.id.mymap);
        map.setImageResource(e.getMap());

        /*TextView foodDesc = (TextView)findViewById(R.id.foodDesc);
        foodDesc.setText(e.getFoodDesc());
*/
        /*TextView entryDesc = (TextView)findViewById(R.id.entryDesc);
        entryDesc.setText(e.getEntryDesc());*/

        myToolbar.setTitleTextColor(android.graphics.Color.WHITE);
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventDetailsActivity.super.onBackPressed();
            }
        });

        eventNm = ((TextView) findViewById(R.id.eventName)).getText().toString();
        rsvp=(Button) (findViewById(R.id.rsvpBtn));
        event=returnEventByName(eventNm);
        rsvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (rsvp.getText().equals("RSVP"))
                    addEvent();

                else
                    cancelEvent();
            }
        });
        addOrRemoveRSVP();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_eventpage, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }*/
    public Event returnEventByName(String eventName){
        EventManager em = new EventManager();
        List<Event> eventList= em.getEventList();
        Iterator<Event> iter = eventList.iterator();
        Event event = null;
        while (iter.hasNext()){
            Event e = iter.next();
            if (e.getEventName().equals(eventName)) {
                event = e;
                break;
            }
        }
        return event;
    }

    public boolean isEventInMyEvents(String eventName){
        EventManager em = new EventManager();
        return em.checkIfEventInMyEvents(event);
    }

    public void addOrRemoveRSVP(){
        ImageView rsvpIcon = (ImageView) (findViewById(R.id.RSVPIcon));
        ImageView rsvpCancelIcon = (ImageView) (findViewById(R.id.RSVPCancelIcon));
        if (isEventInMyEvents(eventNm)) {
            rsvp.setText("Cancel");
            rsvpIcon.setVisibility(View.INVISIBLE);
            rsvpCancelIcon.setVisibility(View.VISIBLE);

        }
        else {
            rsvp.setText("RSVP");
            rsvpIcon.setVisibility(View.VISIBLE);
            rsvpCancelIcon.setVisibility(View.INVISIBLE);
        }
    }
    public void addEvent(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Do you want to proceed adding this event?");
        builder.setMessage("This event will be added to your events, and you will receive updates for this event");
        builder.setPositiveButton("Add Event", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                EventManager em = new EventManager();
                Event eventToAdd = event;
                if (eventToAdd!=null){
                    em.addToMyevents(eventToAdd);
                }
                addOrRemoveRSVP();
                showSnackbarEventAdded();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
            }

        });

        AlertDialog alert = builder.create();
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                addOrRemoveRSVP();
            }
        });
        alert.show();

    }

    public void addEventWithoutPopup(){
        EventManager em = new EventManager();
        Event eventToAdd = event;
        if (eventToAdd!=null){
            em.addToMyevents(eventToAdd);
        }
        addOrRemoveRSVP();
        showSnackbarEventAdded();
    }

    public void cancelEvent(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Are you sure you want to cancel this RSVP?");
        builder.setMessage("This event will be removed from your events, and you will no longer receive updates for this event");
        builder.setPositiveButton("Cancel RSVP", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                EventManager em = new EventManager();
                em.removeFromMyevents(event);
                addOrRemoveRSVP();
                showSnackbarEventRemoved();

            }
        });

        builder.setNegativeButton("Keep RSVP", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                addOrRemoveRSVP();
            }

        });

        AlertDialog alert = builder.create();
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        alert.show();

    }

    public void cancelEventWithoutPopup(){
        EventManager em = new EventManager();
        em.removeFromMyevents(event);
        addOrRemoveRSVP();
        showSnackbarEventRemoved();
    }

    public void showSnackbarEventAdded(){
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.snackbarPosition);

        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Event is added to your events!", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cancelEventWithoutPopup();
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Event is removed from your events!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();

// Changing message text color
        snackbar.setActionTextColor(Color.RED);

// Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(16);
        textView.setGravity(Gravity.TOP);
        snackbar.show();
    }

    public void showSnackbarEventRemoved(){
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.snackbarPosition);

        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Event is removed from your events!", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addEventWithoutPopup();
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Event is added to your events!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();

// Changing message text color
        snackbar.setActionTextColor(Color.RED);

// Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(16);
        textView.setGravity(Gravity.TOP);
        snackbar.show();
    }
}
