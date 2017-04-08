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

public class RecommendedTabAdapter extends ArrayAdapter<Event> {
    public RecommendedTabAdapter(@NonNull Context context, List<Event> events) {
        super(context, R.layout.custom_row, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row, parent, false);

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
        return  customView;
    }
}