package umn.umncalendar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notifications extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.fragment_notifications, container, false);
        NotificationsManager nm = new NotificationsManager();
        List<Event> notificationsList = nm.getMyNotifications();

        ImageView im=(ImageView) customView.findViewById(R.id.noNotifications);
        if (notificationsList.size()==0){
            im.setVisibility(View.VISIBLE);
        }
        else {
            ListView listView = (ListView)customView.findViewById(R.id.nList);
            ListAdapter listAdapter = new NotificationTabAdapter(this.getContext(), notificationsList);
            listView.setAdapter(listAdapter);
            im.setVisibility(View.INVISIBLE);
        }


        return customView;
    }


}