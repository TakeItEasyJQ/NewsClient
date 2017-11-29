package com.example.newsclient;

import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.newsclient.Adapter.DrawerLayoutAdapter;
import com.example.newsclient.Adapter.NewsType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    private ListView listView;
    public static List<NewsType> newsTypeList=new ArrayList<>();
    private DrawerLayoutAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                DrawerFragment fragment=(DrawerFragment)getSupportFragmentManager().findFragmentById(R.id.drawablelayout_fragment);
                FrameLayout frameLayout=(FrameLayout)findViewById(R.id.main_framelayout);
                float scrollwidth=slideOffset*fragment.getView().getWidth();
                frameLayout.setScrollX((int)(-1*scrollwidth));
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        listView=(ListView)findViewById(R.id.drawer_listview);
        adapter=new DrawerLayoutAdapter(this,R.layout.drawer_layout_item,newsTypeList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                drawerLayout.openDrawer(GravityCompat.START);
                return  true;
            default:
                break;
        }
        return false;
    }
}
