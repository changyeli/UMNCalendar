package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class Recommended_Tab extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_recommended, container, false);
        EventManager em = new EventManager();
        List<Event> recommendedList = em.getRecommendedEvents();//((EventViewActivity)getActivity()).eventList;
        ListView listView = (ListView)customView.findViewById(R.id.rec_eventList);
        ImageView noEventsView = (ImageView)customView.findViewById(R.id.noEvents_rec);
        if (recommendedList.size()==0){
            listView.setVisibility(View.INVISIBLE);
            noEventsView.setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            noEventsView.setVisibility(View.INVISIBLE);
            ListAdapter listAdapter = new RecommendedTabAdapter(this.getContext(), recommendedList);
            listView.setAdapter(listAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent newIntent = new Intent(getActivity(),EventDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    bundle.putString("caller","Recommended");
                    newIntent.putExtras(bundle);
                    startActivity(newIntent);
                }
            });
        }
        return customView;
    }
}