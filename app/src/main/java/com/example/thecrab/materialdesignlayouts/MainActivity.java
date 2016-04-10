package com.example.thecrab.materialdesignlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thecrab.materialdesignlayouts.Transition.TransitionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LaunchNavDrawer(View view){
        Intent intent = new Intent(this, NavDrawerActivity.class);
        startActivity(intent);
    }

    public void LaunchTransitions(View view){
        Intent intent = new Intent(this, TransitionActivity.class);
        startActivity(intent);
    }

}
