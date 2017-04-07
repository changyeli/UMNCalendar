package umn.umncalendar;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
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

public class Calendar_tab extends Fragment implements AdapterView.OnItemSelectedListener{
    TextView test;
    TextView date;
    DatePickerDialog datePickerDialog;
    ImageButton datePicker;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currView = inflater.inflate(R.layout.fragment_calendar_tab, container, false);
        Spinner dropdown = (Spinner)(currView.findViewById(R.id.filters));
        dropdown.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(getContext(), R.array.filters_list,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        dropdown.setAdapter(adapter);

        date = (TextView) (currView.findViewById(R.id.date));
        datePicker = (ImageButton)(currView.findViewById(R.id.datePicker));
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
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });

        EventManager em = new EventManager();
        List<Event> recommendedList = em.getEventList();//((EventViewActivity)getActivity()).eventList;
        ListAdapter listAdapter = new RecommendedTabAdapter(this.getContext(), recommendedList);
        ListView listView = (ListView)currView.findViewById(R.id.eventList);
        listView.setAdapter(listAdapter);

        return currView;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        /*test = (TextView)(getView().findViewById(R.id.test));
        test.setText(parent.getItemAtPosition(pos).toString());*/
    }

    public void onNothingSelected(AdapterView<?> parent) {
        /*test = (TextView)(getView().findViewById(R.id.test));
        test.setText(parent.getItemAtPosition(0).toString());*/
    }
}