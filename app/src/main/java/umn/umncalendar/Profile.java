package umn.umncalendar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Profile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        InterestHelper ih = new InterestHelper();
        ArrayList<String> interestList = ih.getInterests("gilm7783@umn.edu");


        String[] interestArray = {"Sports", "Culture", "Movies"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, interestArray);

        ListView listView = (ListView)v.findViewById(R.id.interests_container);
        listView.setAdapter(arrayAdapter);


        return v;
    }
}

