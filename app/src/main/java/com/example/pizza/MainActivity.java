package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pizza.View.Fragment_cart;
import com.example.pizza.View.Fragment_heart;
import com.example.pizza.View.Fragment_home;
import com.example.pizza.View.Fragment_notification;
import com.example.pizza.View.Fragment_personal;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment_home()).commit();
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selcetfrag = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        selcetfrag = new Fragment_home();
                        break;
                    case R.id.heart:
                        selcetfrag = new Fragment_heart();
                        break;
                    case R.id.cartmenu:
                        selcetfrag = new Fragment_cart();
                        break;
                    case R.id.notification:
                        selcetfrag = new Fragment_notification();
                        break;
                    case R.id.personal:
                        selcetfrag = new Fragment_personal();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selcetfrag).commit();
                return true;
            }
        });
    }
    void initview(){
        menu = findViewById(R.id.menubar);
    }
}