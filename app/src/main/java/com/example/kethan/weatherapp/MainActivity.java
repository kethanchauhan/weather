package com.example.kethan.weatherapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import custom.RobotoTextView;
import fragments.FiveDays;
import fragments.Home;
import fragments.PickLocation;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RobotoTextView title;
    Drawer result;

    public static final int HOME=1;
    public static final int FIVE_DAY_FORECAST=2;
    public static final int PICK_LOCATION=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar("Weather app");
        makeDrawer();
        selectItem(PICK_LOCATION,new Bundle());
    }


    private void makeDrawer() {

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("5 Day Forecast");
                //.withIcon(getResources().getDrawable(R.drawable.propsreqsassign));
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Pick Location");
               // .withIcon(getResources().getDrawable(R.drawable.propsreqsassign));

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.weather)
                .build();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//create the drawer and remember the `Drawer` result object
        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        item3

                )

                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        selectItem(position,new Bundle());
                        // do something with the clicked item :
                        return true;
                    }
                })
                .build();
    }



    public void setupToolbar(String text) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = (RobotoTextView) toolbar.findViewById(R.id.title);
        title.setText(text);
        setTitle("");
    }

    public void selectItem(int id,Bundle bundle){
        Fragment fragment = new Fragment();

        String tag = "";
        if(result !=null)
            result.closeDrawer();
        //showBackButton();

        if (id == HOME) {
            //getSupportActionBar().setTitle("Dashboard");
            fragment = new Home();
            tag = "home";
            //hideBackButton();
            //title.setText("home");
        }else if (id == FIVE_DAY_FORECAST){
            //getSupportActionBar().setTitle("Properties Assigned");
            fragment = new FiveDays();
            tag = "five_days";
            title.setText("5 Day Forecast");
        }else if (id == PICK_LOCATION){
            //getSupportActionBar().setTitle("Properties Assigned");

            fragment = new PickLocation();
            tag = "pick_location";
            title.setText("Pick Location");
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment tempFragment = fragmentManager.findFragmentByTag(tag);
        if(tempFragment == null) {
            fragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .replace(R.id.frame, fragment, tag)
                    .addToBackStack(null)
                    .commit();

        }else {

            if(tempFragment.getArguments()==null) {

                tempFragment.setArguments(bundle);

            } else{

                tempFragment.getArguments().putAll(bundle);

            }
            fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frame, tempFragment).commit();

        }

    }

}
