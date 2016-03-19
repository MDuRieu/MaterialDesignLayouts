package com.example.thecrab.materialdesignlayouts;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NavDrawerActivity extends AppCompatActivity {

    //A string array to put some labels in the drawer
    private String[] hydrocarbons;
    //The DrawerLayout itself (root layout of this activity)
    private DrawerLayout drawerLayout;
    //The listview to go in the sliding drawer part of the layout
    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        //Just junk to put in the drawer
        hydrocarbons = new String[]{"Methane", "Ethane", "Propane", "Butane"};

        //Link the drawer and list to their xml declarations in the layout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);


        //Set adapter for the listview
        drawerList.setAdapter(new ArrayAdapter<>(this, R.layout.nav_drawer_item, hydrocarbons));

        //Set a click listener for the items in the list (DrawerItemClickListener is a custom class)
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    //Perform the action desired for clicking list elements
    //Could change fragments in the main frame layout etc, but for simplicity here,
    //Just change the text in the main window
    private void selectItem(int position){

        //Declare the textview and change its text to the index in the string array
        //Which is specified by the click position
        TextView mainTextView = (TextView) findViewById(R.id.main_text_view);
        mainTextView.setText(hydrocarbons[position]);

        //Highlight the selected item in the list
        //Note, it looks like setItemChecked is buggy and the workarounds are complicated
        //For the sake of keeping this example minimalistic, I'll leave it non functioning
        drawerList.setItemChecked(position, true);
        drawerLayout.closeDrawer(drawerList);

    }


}

