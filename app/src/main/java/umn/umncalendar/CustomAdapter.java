package umn.umncalendar;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class CustomAdapter extends ArrayAdapter<Event> {
   // List<Event> eventList;
    public CustomAdapter(@NonNull Context context, List<Event> events) {
        super(context, R.layout.custom_row, events);
        //eventList = events;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row, parent, false);

        Event singleEvent =  getItem(position);
        TextView eventName = (TextView)customView.findViewById(R.id.eventName);
        ImageView eventPoster = (ImageView)customView.findViewById(R.id.eventPoster);

        eventName.setText(singleEvent.getEventName());
        eventPoster.setImageResource(singleEvent.getPoster());
        return  customView;
    }
}


