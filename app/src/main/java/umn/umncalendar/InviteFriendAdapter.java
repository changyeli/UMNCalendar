package umn.umncalendar;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class InviteFriendAdapter extends ArrayAdapter<User> {
    // List<Event> eventList;
    public InviteFriendAdapter(@NonNull Context context, List<User> events) {
        super(context, R.layout.custom_row_invite_friend, events);
        //eventList = events;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row_invite_friend, parent, false);

        User user = getItem(position);
        TextView name = (TextView) customView.findViewById(R.id.friend_name);
        ImageView pic = (ImageView) customView.findViewById(R.id.friend_pic);

        name.setText(user.getUser_name());
        pic.setImageResource(user.getUser_pic());
        setAddFriendListener(customView,user);
        return customView;
    }

    public void setAddFriendListener(View customView, final User friend) {
        final Button addThisFriend = (Button) customView.findViewById(R.id.invite_friend);
        // cancelRsvp.setText("Add");
        addThisFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setMessage("Are you sure you want to invite " + friend.getUser_name() + " to this event?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // How to remove the selected item?
                        Toast.makeText(getContext(), "Invitation sent", Toast.LENGTH_LONG).show();
                        addThisFriend.setText("Invited");
                        addThisFriend.setEnabled(false);
                        addThisFriend.setTextColor(Color.WHITE);
                    }

                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                    }

                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}