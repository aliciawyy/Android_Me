package com.example.android.android_me;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, bodyPartFragment).commit();
        }
    }
}
