package umn.umncalendar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class MyEventTabAdapter extends ArrayAdapter<Event> {
   // List<Event> eventList;
    public MyEventTabAdapter(@NonNull Context context, List<Event> events) {
        super(context, R.layout.custom_row_myevent, events);
        //eventList = events;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row_myevent, parent, false);

        Event singleEvent =  getItem(position);
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

        Button cancelRsvp = (Button)customView.findViewById(R.id.cancelRsvp);
        cancelRsvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FragmentActivity activity = (FragmentActivity)getContext();
                FragmentManager fm = activity.getSupportFragmentManager();
                RsvpCancelDialog alertDialog = new RsvpCancelDialog();
                alertDialog.show(fm, "fragment_alert");
            }
        });
        return  customView;
    }

    /*private void showDialog(){
        final Dialog confirmDialog =  new Dialog(getContext());
        confirmDialog.setTitle("Cancel RSVP");
        confirmDialog.setContentView(R.layout.cancel_rsvp_dialog);
        //confirmDialog.setCancelable(Boolean.TRUE);
        //Button btnNo = (Button)confirmDialog.findViewById(R.id.btn_no);
        //btnNo.setOnClickListener(confirmDialog.);
    }*/

}


