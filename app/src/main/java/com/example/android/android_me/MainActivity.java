package com.example.android.android_me;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements MasterListFragment.Listener {

    private ImageAssetsViewModel mImageAssetsViewModel;
    private boolean mIsTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIsTwoPane = findViewById(R.id.fragment_container) == null;
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (!mIsTwoPane) {
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
        if (mIsTwoPane) return;
        BodyPartFragment bodyPartFragment = new BodyPartFragment();
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, bodyPartFragment)
            .addToBackStack(null)
            .commit();
    }

    @Override
    public boolean isTwoPane() {
        return mIsTwoPane;
    }
}
