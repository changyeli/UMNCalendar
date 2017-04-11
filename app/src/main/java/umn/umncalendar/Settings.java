package umn.umncalendar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static umn.umncalendar.R.layout.fragment_settings;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {


    Switch notificationsSwitch, friendSwitch, weatherSwitch, privacySwitch;
    String statusMessage, switchName;


    public Settings() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(fragment_settings, container, false);


        notificationsSwitch = (Switch) v.findViewById(R.id.event_updates);
        friendSwitch = (Switch) v.findViewById(R.id.friend_updates);
        weatherSwitch = (Switch) v.findViewById(R.id.weather_updates);
        privacySwitch = (Switch) v.findViewById(R.id.privacy_toggle);


        notificationsSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statusSwitch1, statusSwitch2;
                if (notificationsSwitch.isChecked()) {
                    statusMessage = "ON";
                    switchName = "Event updates are now ";
                }
                else {
                    statusMessage = "OFF";
                    switchName = "Event updates are now ";
                }



                Toast.makeText(getContext(), switchName + statusMessage, Toast.LENGTH_SHORT).show(); // display the current state for switch's

            }
        });



        friendSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statusSwitch1, statusSwitch2;
                if (friendSwitch.isChecked()) {
                    statusMessage = "ON";
                    switchName = "Friend updates are now  ";
                }
                else {
                    statusMessage = "OFF";
                    switchName = "Friend updates are now ";
                }

                Toast.makeText(getContext(), switchName + statusMessage, Toast.LENGTH_SHORT).show(); // display the current state for switch's

            }
        });



        weatherSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statusSwitch1, statusSwitch2;
                if (weatherSwitch.isChecked()) {
                    statusMessage = "ON";
                    switchName = "Weather alerts are now  ";
                }
                else {
                    statusMessage = "OFF";
                    switchName = "Weather alerts are now ";
                }

                Toast.makeText(getContext(), switchName + statusMessage, Toast.LENGTH_SHORT).show(); // display the current state for switch's

            }
        });



        privacySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statusSwitch1, statusSwitch2;
                if (privacySwitch.isChecked()) {
                    statusMessage = "PUBLIC";
                    switchName = "Profile is now ";
                }
                else {
                    statusMessage = "PRIVATE";
                    switchName = "Profile is now ";
                }

                Toast.makeText(getContext(), switchName + statusMessage, Toast.LENGTH_SHORT).show(); // display the current state for switch's

            }
        });



//        Toast.makeText(this.getContext(), statusMessage, Toast.LENGTH_LONG).show(); // display the current state for switch's

        return v;

    }



    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // do something when check is selected

            statusMessage = "ON!!";


        } else {
            //do something when unchecked

            statusMessage = "OFF";
        }
    }


}