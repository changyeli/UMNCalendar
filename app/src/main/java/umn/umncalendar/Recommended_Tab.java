package umn.umncalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.sql.Date;
import java.util.ArrayList;
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
        List<String> interests = em.getInterests();
        List<Event> recommendedList = em.getRecommendedEvents(interests);//((EventViewActivity)getActivity()).eventList;
        List<String> evntArr = new ArrayList<>();
        ListAdapter listAdapter = new CustomAdapter(this.getContext(), recommendedList);
        ListView listView = (ListView)customView.findViewById(R.id.eventList);
        listView.setAdapter(listAdapter);
        return customView;
    }
}