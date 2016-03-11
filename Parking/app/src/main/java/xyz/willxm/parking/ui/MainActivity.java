package xyz.willxm.parking.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.baidu.mapapi.SDKInitializer;

import xyz.willxm.parking.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SDKInitializer.initialize(getApplicationContext());


        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentMap fragmentMap = new FragmentMap();
        getFragmentManager().beginTransaction().replace(R.id.content_main_layout,fragmentMap).commit();



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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (id == R.id.message) {
            // Handle the camera action
            FragmentNews fragmentNews = new FragmentNews();
            getFragmentManager().beginTransaction().replace(R.id.content_main_layout,fragmentNews).commit();
            toolbar.setTitle(R.string.news);

        } else if (id == R.id.parking) {

            FragmentPark fragmentPark = new FragmentPark();
            getFragmentManager().beginTransaction().replace(R.id.content_main_layout,fragmentPark).commit();
            toolbar.setTitle(R.string.park);

        } else if (id == R.id.business) {

            FragmentBusiness fragmentBusiness = new FragmentBusiness();
            getFragmentManager().beginTransaction().replace(R.id.content_main_layout,fragmentBusiness).commit();
            toolbar.setTitle(R.string.business);

        } else if (id == R.id.user) {

            FragmentMe fragmentMe = new FragmentMe();
            getFragmentManager().beginTransaction().replace(R.id.content_main_layout,fragmentMe).commit();
            toolbar.setTitle(R.string.me);

        } else if (id == R.id.map) {

            FragmentMap fragmentMap = new FragmentMap();
            getFragmentManager().beginTransaction().replace(R.id.content_main_layout,fragmentMap).commit();
            toolbar.setTitle(R.string.map);

        } else if (id == R.id.setting) {

        } else if (id == R.id.about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
