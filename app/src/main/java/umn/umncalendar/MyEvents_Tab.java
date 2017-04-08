package umn.umncalendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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
import java.util.zip.Inflater;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class MyEvents_Tab extends Fragment {
    TextView date;
    DatePickerDialog datePickerDialog;
    ImageButton datePicker;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currView = inflater.inflate(R.layout.fragment_myevents, container, false);
        date = (TextView) (currView.findViewById(R.id.date_myevents));
        datePicker = (ImageButton)(currView.findViewById(R.id.datePicker_myevents));
        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        date.setText(mDay + "/"
                + (mMonth + 1) + "/" + mYear);
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

        EventManager em = new EventManager();
        List<Event> myeventList = em.getMyevents();
        final ArrayAdapter listAdapter = new MyEventTabAdapter(this.getContext(), myeventList);
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
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
        return currView;
    }


}