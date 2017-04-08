package umn.umncalendar;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by AartiRajan on 4/6/2017.
 */

public class RsvpCancelDialog extends DialogFragment implements View.OnClickListener{
    LayoutInflater inflater;
    View view;
    Button yes, no;
    Event event;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cancel_rsvp_dialog, null);
        yes = (Button)view.findViewById(R.id.btn_yes);
        no =  (Button)view.findViewById(R.id.btn_no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_yes){
            Fragment f = getParentFragment();
            System.out.println(f.getId());
        }
        if(v.getId()==R.id.btn_no){
            dismiss();
        }
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
