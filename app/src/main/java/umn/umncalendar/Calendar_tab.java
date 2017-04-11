package umn.umncalendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class Calendar_tab extends Fragment implements AdapterView.OnItemSelectedListener{
    View currView;
    TextView test;
    TextView date;
    DatePickerDialog datePickerDialog;
    ImageButton datePicker;
    Spinner dropdown;
    CheckBox freeFoodchk;
    CheckBox freeEntryChk;
    CheckBox onCampusChk;
    Button applyFilter;
    Button reset;
    String selectedDate;
    String selectedCategory;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currView = inflater.inflate(R.layout.fragment_calendar_tab, container, false);
        date = (TextView) (currView.findViewById(R.id.date));
        datePicker = (ImageButton)(currView.findViewById(R.id.datePicker));
        dropdown = (Spinner)(currView.findViewById(R.id.filters));
        freeFoodchk=(CheckBox)(currView.findViewById(R.id.free_food_chk));
        freeEntryChk=(CheckBox)(currView.findViewById(R.id.free_entry_chk));
        onCampusChk=(CheckBox)(currView.findViewById(R.id.on_campus_chk));
        applyFilter=(Button) (currView.findViewById(R.id.apply_filters_btn));
        reset=(Button) (currView.findViewById(R.id.reset_filters_btn));

        dropdown.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(getContext(), R.array.filters_list,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        dropdown.setAdapter(adapter);

        //setTodayDate();
        datePicker.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v){
                                        DialogFragment newFragment = new DatePickerFragment();
                                        newFragment.show(getFragmentManager(), "datePicker");
                                        date = (TextView) (currView.findViewById(R.id.date));
                                    }
                                });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
                date = (TextView) (currView.findViewById(R.id.date));
            }
        });

        applyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                applyFilters();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resetFilters();
            }
        });

        EventManager em = new EventManager();
        List<Event> eventList = em.getEventList();
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        ImageView noEventsView = (ImageView)currView.findViewById(R.id.noEvents);
        if (eventList.size()==0){
            listView.setVisibility(View.INVISIBLE);
            noEventsView.setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            noEventsView.setVisibility(View.INVISIBLE);
            ListAdapter listAdapter = new RecommendedTabAdapter(this.getContext(), eventList);
            listView.setAdapter(listAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent newIntent = new Intent(getActivity(),EventDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    bundle.putString("caller","Calendar");
                    newIntent.putExtras(bundle);
                    startActivity(newIntent);
                }
            });
        }

        return currView;
    }

    public void setOnEventClickListener(View customView, final Event event){
        Button cancelRsvp = (Button)customView.findViewById(R.id.cancelRsvp);
        cancelRsvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        /*test = (TextView)(getView().findViewById(R.id.test));
        test.setText(parent.getItemAtPosition(pos).toString());*/
    }

    public void onNothingSelected(AdapterView<?> parent) {
        /*test = (TextView)(getView().findViewById(R.id.test));
        test.setText(parent.getItemAtPosition(0).toString());*/
    }

    public void setTodayDate(){
        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        date.setText(mDay + "/"
                + (mMonth + 1) + "/" + mYear);
    }

    public void resetFilters(){
        date.setText("Select date");
        dropdown.setSelection(0);
        freeFoodchk.setChecked(false);
        freeEntryChk.setChecked(false);
        onCampusChk.setChecked(false);

        EventManager em = new EventManager();
        List<Event> filteredEvents = em.getEventList();
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        ImageView noEventsView = (ImageView)currView.findViewById(R.id.noEvents);
        if (filteredEvents.size()==0){
            listView.setVisibility(View.INVISIBLE);
            noEventsView.setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            noEventsView.setVisibility(View.INVISIBLE);
            ListAdapter listAdapter = new RecommendedTabAdapter(this.getContext(), filteredEvents);
            listView.setAdapter(listAdapter);
        }
    }

    public void applyFilters(){
        selectedDate = date.getText().toString();
        selectedCategory = dropdown.getSelectedItem().toString();
        boolean freeFoodOption=freeFoodchk.isChecked();
        boolean freeEntryOption=freeEntryChk.isChecked();
        boolean onCampusOption=onCampusChk.isChecked();

        EventManager em = new EventManager();
        List<Event> filteredEvents = em.getFilteredEvents(selectedDate, selectedCategory, freeFoodOption, freeEntryOption, onCampusOption);
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        ImageView noEventsView = (ImageView)currView.findViewById(R.id.noEvents);
        if (filteredEvents.size()==0){
            listView.setVisibility(View.INVISIBLE);
            noEventsView.setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            noEventsView.setVisibility(View.INVISIBLE);
            ListAdapter listAdapter = new RecommendedTabAdapter(this.getContext(), filteredEvents);
            listView.setAdapter(listAdapter);
        }
    }


}