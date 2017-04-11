package umn.umncalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by cfan9 on 4/10/2017.
 */

public class AddFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.add_friend_toolbar);

        //add toolbar func
        List<User> userList = User.getAllUsers();
        ListView listView = (ListView)findViewById(R.id.user_list);
        ListAdapter listAdapter = new AddFriendAdapter(this, userList);
        //ListView listView = (ListView)customView.findViewById(R.id.friend_list);
        listView.setAdapter(listAdapter);
    }
}