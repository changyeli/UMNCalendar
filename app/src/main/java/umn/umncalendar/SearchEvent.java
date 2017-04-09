package umn.umncalendar;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
        ListView lv = (ListView) findViewById(R.id.listActivity);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchEvent.this, EmptyEvent.class);
                startActivity(intent);
            }
        });


        ArrayList<String> arrayActivity = new ArrayList<>();
        arrayActivity.addAll(Arrays.asList(getResources().getStringArray(R.array.array_activity)));

        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<>(
                SearchEvent.this,
                android.R.layout.simple_list_item_1,
                arrayActivity);

        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_event_view, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//
//                return false;
//            }
//        });
//
        return super.onCreateOptionsMenu(menu);
    }
}
