package umn.umncalendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class MyEvents_Tab extends Fragment {
    View currView;
    TextView date;
    DatePickerDialog datePickerDialog;
    ImageButton datePicker;
    String selectedDate;
    Button searchBtn;
    Button resetBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currView = inflater.inflate(R.layout.fragment_myevents, container, false);
        date = (TextView) (currView.findViewById(R.id.date_myevents));
        datePicker = (ImageButton)(currView.findViewById(R.id.datePicker_myevents));
        searchBtn=(Button) (currView.findViewById(R.id.search_btn));
        resetBtn=(Button) (currView.findViewById(R.id.reset_btn));

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker_myevents");
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker_myevents");
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                applyFilters();
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resetFilters();
            }
        });

        EventManager em = new EventManager();
        List<Event> myeventList = em.getMyevents();
        ListAdapter listAdapter = new MyEventTabAdapter(this.getContext(), myeventList);
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        listView.setAdapter(listAdapter);
        return currView;
    }

    public void applyFilters(){
        selectedDate = date.getText().toString();

        EventManager em = new EventManager();
        List<Event> filteredEvents = em.getFilteredMyEvents(selectedDate);
        ListAdapter listAdapter = new MyEventTabAdapter(this.getContext(), filteredEvents);
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        listView.setAdapter(listAdapter);
    }

    public void resetFilters(){
        date.setText("Select date");

        EventManager em = new EventManager();
        List<Event> filteredEvents = em.getMyevents();
        ListAdapter listAdapter = new MyEventTabAdapter(this.getContext(), filteredEvents);
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        listView.setAdapter(listAdapter);
    }

}