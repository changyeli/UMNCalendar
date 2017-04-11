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
 * Created by COMP1 on 10-04-2017.
 */

public class NotificationTabAdapter extends ArrayAdapter<Event> {
    public NotificationTabAdapter(@NonNull Context context, List<Event> events) {
        super(context, R.layout.custom_row, events);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row_notifications, parent, false);

        Event singleEvent =  getItem(position);
        TextView name = (TextView)customView.findViewById(R.id.eventname);
        ImageView poster = (ImageView)customView.findViewById(R.id.eventposter);
        TextView category = (TextView)customView.findViewById(R.id.eventcategory);

        name.setText(singleEvent.getEventName());
        poster.setImageResource(singleEvent.getPoster());
        category.setText(singleEvent.getDesc());

        setDismissListener(customView, singleEvent,parent);


        return  customView;
    }

    public void setDismissListener(final View customView, final Event event, final ViewGroup parent){
        Button dismiss = (Button)customView.findViewById(R.id.dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                NotificationsManager nm = new NotificationsManager();
                nm.removeEventFromMyNotifications(event);
                notifyDataSetChanged();
            }
        });
    }

}
