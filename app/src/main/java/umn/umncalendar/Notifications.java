package umn.umncalendar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notifications extends Fragment {


//    public Notifications() {
//
//    }




//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_notifications, container, false);
//    }
//
//



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_notifications, container, false);
        NotificationsManager nm = new NotificationsManager();
        List<Event> notificationsList = nm.getNotificationsList();

        ListAdapter listAdapter = new RecommendedTabAdapter(this.getContext(), notificationsList);

        ListView listView = (ListView)customView.findViewById(R.id.nList);
        listView.setAdapter(listAdapter);


        return customView;
    }


}
