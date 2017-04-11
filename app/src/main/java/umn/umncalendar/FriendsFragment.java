package umn.umncalendar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.*;

public class FriendsFragment extends Fragment {//implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    //TextView a;
    //EditText b;
    //EditText c;
    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private ExpandableListView myList;
    //private ArrayList<ParentRow> parentList = new ArrayList<ParentRow>();
    //private ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    private MenuItem searchItem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.friend_list, container, false);
        EventManager em = new EventManager();
        List<User> friendList = User.getFriends();//((EventViewActivity)getActivity()).eventList;
        ListAdapter listAdapter = new FriendListAdapter(this.getContext(), friendList);
        ListView listView = (ListView)customView.findViewById(R.id.friend_list);
        listView.setAdapter(listAdapter);

        FloatingActionButton fab = (FloatingActionButton) customView.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), AddFriendActivity.class);
                startActivity(intent);
            }
        });


        return customView;

       /* super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_friends);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        getActivity().setSupportActionBar(toolbar);
        searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        parentList = new ArrayList<ParentRow>();
        showTheseParentList = new ArrayList<ParentRow>();
        displayList();
        expandAll();
        return super.onCreateView(inflater, container, savedInstanceState);
       */
    }

   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        Toolbar toolbar = (Toolbar) findViewById(R.id.friends_toolbar);
        setSupportActionBar(toolbar);
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        parentList = new ArrayList<ParentRow>();
        showTheseParentList = new ArrayList<ParentRow>();
        displayList();
        expandAll();
        *//*
        a = (TextView) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.a);
        c = (EditText) findViewById(R.id.a);
        Button searchBtn = (Button) findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User[] friends = new User[];
            }
        }); *//*
    }*/


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_friends, menu);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

/*    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }
    }
    private void displayList() {
        loadData();
        myList = (ExpandableListView) findViewById(R.id.expandableListView_search);
        listAdapter = new MyExpandableListAdapter(FriendsActivity.this, parentList);
        myList.setAdapter(listAdapter);
    }
    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;
        childRows.add(new ChildRow(R.mipmap.seth, "seth"));
        childRows.add(new ChildRow(R.mipmap.james, "james"));
        parentRow = new ParentRow("First Group", childRows);
        parentList.add(parentRow);
        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.seth, "seth"));
        childRows.add(new ChildRow(R.mipmap.james, "james"));
        parentRow = new ParentRow("Second Group", childRows);
        parentList.add(parentRow);
    }
    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }*/
}