package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by zien on 4/8/17.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private DatabaseHelper dbHelper = new DatabaseHelper();
    private InterestHelper itHelper = new InterestHelper();

    /**
     *  The array adapter for saving searched results
     */
    private ArrayAdapter<String> adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_event_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuSearch) {
            Intent i = new Intent(this,SearchEvent.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get user info and interest list
        String user_email = getIntent().getStringExtra("email");
        String user_name = dbHelper.getFullName(user_email);
        ArrayList<String> user_interest = itHelper.getInterests(user_email);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

        NavigationView navigationViewTop = (NavigationView) findViewById(R.id.nav_view_top);
        NavigationView navigationViewBottom = (NavigationView) findViewById(R.id.nav_view_bottom);
        navigationViewTop.setNavigationItemSelectedListener(this);
        navigationViewBottom.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.event_view) {
            Log.d("CLICKED: ", "TABS");
            FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
            xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

        } else if (id == R.id.profile) {
            Log.d("CLICKED: ", "THIRD FRAGMENT");
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new Profile()).commit();
        }
        else if (id == R.id.notifications){
            Log.d("CLICKED: ", "THIRD FRAGMENT");
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new Notifications()).commit();
        }

        else  if (id == R.id.friends){
            Log.d("CLICKED: ", "THIRD FRAGMENT");
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new FriendsFragment()).commit();


        }

        else  if (id == R.id.settings){
            Log.d("CLICKED: ", "THIRD FRAGMENT");
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new Settings()).commit();

        }

        else  if (id == R.id.logout){
            Log.d("CLICKED: ", "THIRD FRAGMENT");
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new Logout()).commit();

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
