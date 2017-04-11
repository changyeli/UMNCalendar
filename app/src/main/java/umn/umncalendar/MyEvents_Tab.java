package umn.umncalendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        ImageView noEventsView = (ImageView)currView.findViewById(R.id.noEvents_myevents);
        ImageView noEventsView1 = (ImageView)currView.findViewById(R.id.noEvents1_myevents);
        if (myeventList.size()==0){
            listView.setVisibility(View.INVISIBLE);
            noEventsView.setVisibility(View.VISIBLE);
            noEventsView1.setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            noEventsView.setVisibility(View.INVISIBLE);
            noEventsView1.setVisibility(View.INVISIBLE);
            ListAdapter listAdapter = new MyEventTabAdapter(this.getContext(), myeventList);
            listView.setAdapter(listAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent newIntent = new Intent(getActivity(),EventDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    bundle.putString("caller","MyEvents");
                    newIntent.putExtras(bundle);
                    startActivity(newIntent);
                }
            });
        }
        return currView;
    }

    public void applyFilters(){
        selectedDate = date.getText().toString();

        EventManager em = new EventManager();
        List<Event> filteredEvents = em.getFilteredMyEvents(selectedDate);
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        ImageView noEventsView = (ImageView)currView.findViewById(R.id.noEvents_myevents);
        ImageView noEventsView1 = (ImageView)currView.findViewById(R.id.noEvents1_myevents);
        if (filteredEvents.size()==0){
            listView.setVisibility(View.INVISIBLE);
            noEventsView.setVisibility(View.VISIBLE);
            noEventsView1.setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            noEventsView.setVisibility(View.INVISIBLE);
            noEventsView1.setVisibility(View.INVISIBLE);
            ListAdapter listAdapter = new MyEventTabAdapter(this.getContext(), filteredEvents);
            listView.setAdapter(listAdapter);
        }
    }

    public void resetFilters(){
        date.setText("Select date");

        EventManager em = new EventManager();
        List<Event> filteredEvents = em.getMyevents();
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        ImageView noEventsView = (ImageView)currView.findViewById(R.id.noEvents_myevents);
        ImageView noEventsView1 = (ImageView)currView.findViewById(R.id.noEvents1_myevents);
        if (filteredEvents.size()==0){
            listView.setVisibility(View.INVISIBLE);
            noEventsView.setVisibility(View.VISIBLE);
            noEventsView1.setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            noEventsView.setVisibility(View.INVISIBLE);
            noEventsView1.setVisibility(View.INVISIBLE);
            ListAdapter listAdapter = new MyEventTabAdapter(this.getContext(), filteredEvents);
            listView.setAdapter(listAdapter);
        }
    }

}