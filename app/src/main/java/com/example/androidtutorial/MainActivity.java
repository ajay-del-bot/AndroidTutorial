package com.example.androidtutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TextView textView;
    private Button button;
    private Fragment fragment;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.setNavigationItemSelectedListener(MainActivity.this);

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new BlankFragment()).commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) textView.getBackground();
                    int colorCode = cd.getColor();
                }
                textView.setText("Black Munde");
                textView.setBackgroundColor(getResources().getColor(R.color.black));
                Intent intent = new Intent(new Intent(MainActivity.this, SecondActivity.class));

                String string = textView.getText().toString();
                intent.putExtra("string", string);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Color Changed", Toast.LENGTH_SHORT).show();
            }
        }
        );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.home: getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                            break;
            case R.id.profile: break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}