package com.example.android.android_me;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.example.android.android_me.MasterListFragment.OnImageClickListener;

public class MainActivity extends AppCompatActivity implements OnImageClickListener {

    ImageAssetsViewModel mImageAssetsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager supportFragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {
            if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
                MasterListFragment masterListFragment = new MasterListFragment();
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, masterListFragment).commit();
            }
        }
        mImageAssetsViewModel = new ViewModelProvider(this).get(ImageAssetsViewModel.class);
    }

    @Override
    public void onImageSelected(int position) {
        mImageAssetsViewModel.setImageIndex(position);
    }

    @Override
    public void onButtonNextClicked() {
        BodyPartFragment bodyPartFragment = new BodyPartFragment();
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, bodyPartFragment)
            .addToBackStack(null)
            .commit();
    }
}
