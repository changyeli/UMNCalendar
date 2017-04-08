package umn.umncalendar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class MyEventTabAdapter extends ArrayAdapter<Event> {
   // List<Event> eventList;
    Event currEvent;
    public MyEventTabAdapter(@NonNull Context context, List<Event> events) {
        super(context, R.layout.custom_row_myevent, events);
        //eventList = events;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row_myevent, parent, false);
        final Event singleEvent =  getItem(position);
        TextView name = (TextView)customView.findViewById(R.id.eventname);
        ImageView poster = (ImageView)customView.findViewById(R.id.eventposter);
        TextView category = (TextView)customView.findViewById(R.id.eventcategory);
        TextView date = (TextView)customView.findViewById(R.id.eventdate);
        TextView location = (TextView)customView.findViewById(R.id.eventlocation);
        LinearLayout freeFood = (LinearLayout) customView.findViewById(R.id.free_food_indicator);
        name.setText(singleEvent.getEventName());
        poster.setImageResource(singleEvent.getPoster());
        category.setText(singleEvent.getCategory().name());
        date.setText(singleEvent.getFormattedDate());
        location.setText(singleEvent.getAddress());

        if(!singleEvent.isFood()){
            freeFood.setVisibility(View.GONE);
        }
       setCancelRsvpListener(customView, singleEvent);

        return  customView;
    }


    public void setCancelRsvpListener(View customView, final Event event){
        Button cancelRsvp = (Button)customView.findViewById(R.id.cancelRsvp);
        cancelRsvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Are you sure you want to cancel this RSVP?");
                builder.setMessage("This event will be removed from your events, and you will no longer receive updates for this event");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // How to remove the selected item?
                        EventManager em = new EventManager();
                       em.myevents.remove(event);
                        notifyDataSetChanged();
                    }

                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                    }

                });

                AlertDialog alert = builder.create();
                alert.show();

                /*FragmentActivity activity = (FragmentActivity)getContext();
                FragmentManager fm = activity.getSupportFragmentManager();
                RsvpCancelDialog alertDialog = new RsvpCancelDialog();
                alertDialog.setEvent(singleEvent);
                alertDialog.show(fm, "fragment_alert");*/


            }
        });
    }

}


