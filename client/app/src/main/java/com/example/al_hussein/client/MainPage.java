package com.example.al_hussein.client;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;



public class MainPage extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagemain);

        /// my project
        fragmentMyProject myProject = new fragmentMyProject();


        List<CommonProject> commonProjects = new ArrayList<>();
        CommonProject x = new CommonProject();
        x.Author = "Mohammad";
        x.Name = "Java";

        CommonProject y = new CommonProject();
        y.Author = "Ahmad";
        y.Name = "C++";
        commonProjects.add(x);
        commonProjects.add(y);
        myProject.setMyProjectlist(commonProjects);

        /// Notifications
        fragmentNotifications notifications = new fragmentNotifications();
        List<Event> event_classes = new ArrayList<>();

        Event ev1 = new Event();
        ev1.type = "Add";
        ev1.owner = "Mohammad";

        Event ev2 = new Event();
        ev2.type = "Delete";
        ev2.owner = "Ahmad";

        event_classes.add(ev1);
        event_classes.add(ev2);


        notifications.setNotifications(event_classes);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(notifications, "Notifications");
        adapter.AddFragment(myProject, "My Project");
        adapter.AddFragment(new fragmentFav(), "All Project");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}


