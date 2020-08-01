package com.example.scorer;

import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
       private DrawerLayout drawer;
       private String url="http://cricapi.com/api/matches?apikey=CYPsCHFFcoM34hqpUjx8rz7HZYD3";
       FragmentTransaction fragmentTransaction;
      ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer=findViewById(R.id.drawer_layout);


        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,new Cricket());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("welcome");



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

          switch (item.getItemId()) {
              case R.id.nav_cricket:
                  fragmentTransaction=getSupportFragmentManager().beginTransaction();
                  fragmentTransaction.replace(R.id.fragment_container,new Cricket());
                  fragmentTransaction.commit();
                  getSupportActionBar().setTitle("home Cricket");
                  item.setChecked(true);
                  drawer.closeDrawers();



                  break;

              case R.id.nav_football:
                  fragmentTransaction=getSupportFragmentManager().beginTransaction();
                  fragmentTransaction.replace(R.id.fragment_container,new Football());
                  fragmentTransaction.commit();
                  getSupportActionBar().setTitle("home Football");
                  item.setChecked(true);
                    drawer.closeDrawers();
              break;

          }
          return false;
    }
}
