package com.jordan.daniel.pizzapalace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    DealFragment.OnFragmentInteractionListener,
                    MainFragment.OnFragmentInteractionListener,
                    ContactFragment.OnFragmentInteractionListener,
                    OrderFragment.OnFragmentInteractionListener,
                    TipFragment.OnFragmentInteractionListener,
                    PizzaListFragment.OnFragmentInteractionListener {


    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();
        if(savedInstanceState == null){
            FragmentTransaction trans = fm.beginTransaction();
            trans.replace(R.id.content, new MainFragment());
            trans.commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.GONE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction trans = fm.beginTransaction();

        if (id == R.id.nav_home){
            trans.replace(R.id.content, new MainFragment());
            trans.addToBackStack(null);
            trans.commit();
        } else if (id == R.id.nav_sale) {
            trans.replace(R.id.content, new PizzaListFragment());
            trans.addToBackStack(null);
            trans.commit();
        } else if (id == R.id.nav_order) {
            trans.replace(R.id.content, new OrderFragment());
            trans.addToBackStack(null);
            trans.commit();
        } else if (id == R.id.nav_contact) {
            trans.replace(R.id.content, new ContactFragment());
            trans.addToBackStack(null);
            trans.commit();
        } else if (id == R.id.nav_tips) {
            trans.replace(R.id.content, new TipFragment());
            trans.addToBackStack(null);
            trans.commit();
        } else if (id == R.id.nav_timer) {
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Delivery Timer")
                    .putExtra(AlarmClock.EXTRA_LENGTH, 1800);
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        } else if (id == R.id.nav_location) {
            Uri location = Uri.parse("geo:0,0?q=42.2463450,-83.0191849(Pizza Palace)");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(location);
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
