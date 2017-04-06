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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
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
        TextView name = (TextView)customView.findViewById(R.id.name);
        ImageView poster = (ImageView)customView.findViewById(R.id.poster);
        TextView category = (TextView)customView.findViewById(R.id.category);
        TextView date = (TextView)customView.findViewById(R.id.date);
        TextView time = (TextView)customView.findViewById(R.id.time);
        TextView location = (TextView)customView.findViewById(R.id.location);
        LinearLayout freeFood = (LinearLayout) customView.findViewById(R.id.free_food_indicator);
        name.setText(singleEvent.getEventName());
        poster.setImageResource(singleEvent.getPoster());
        category.setText(singleEvent.getCategory().name());
        date.setText(singleEvent.getFormattedDate());
        location.setText(singleEvent.getAddress());

        if(!singleEvent.isFood()){
            freeFood.setVisibility(View.GONE);
        }
        return  customView;
    }
}


