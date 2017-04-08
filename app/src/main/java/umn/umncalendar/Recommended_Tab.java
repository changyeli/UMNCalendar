package umn.umncalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class Recommended_Tab extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_recommended, container, false);
        EventManager em = new EventManager();
        List<Event> recommendedList = em.getRecommendedEvents();//((EventViewActivity)getActivity()).eventList;
        ListAdapter listAdapter = new RecommendedTabAdapter(this.getContext(), recommendedList);
        ListView listView = (ListView)customView.findViewById(R.id.eventList);
        listView.setAdapter(listAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            // setting onItemLongClickListener and passing the position to the function
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {
                inflater.inflate(R.layout.fragment_eventpage,container,false);
                return true;
            }
        });
        return customView;
    }
}