package umn.umncalendar;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by AartiRajan on 4/4/2017.
 */

public class FriendListAdapter extends ArrayAdapter<User> {
    // List<Event> eventList;
    public FriendListAdapter(@NonNull Context context, List<User> events) {
        super(context, R.layout.custom_row_friends, events);
        //eventList = events;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row_friends, parent, false);

        User user = getItem(position);
        TextView name = (TextView) customView.findViewById(R.id.friend_name);
        ImageView pic = (ImageView) customView.findViewById(R.id.friend_pic);

        name.setText(user.getUser_name());
        pic.setImageResource(user.getUser_pic());
        setRemoveFriendListener(customView,user);
        return customView;
    }

    public void setRemoveFriendListener(View customView, final User friend) {
        Button cancelRsvp = (Button) customView.findViewById(R.id.unfriend);
        cancelRsvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                //builder.setTitle("Are you sure you remove this person?");
                builder.setMessage("Are you sure you want to remove " + friend.getUser_name() + " from your friend list?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // How to remove the selected item?
                        User.getFriends().remove(friend);
                        notifyDataSetChanged();
                        Toast.makeText(getContext(), friend.getUser_name() + " has been successfully removed from your friend list!", Toast.LENGTH_SHORT).show();
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