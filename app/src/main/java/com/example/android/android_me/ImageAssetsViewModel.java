package com.example.android.android_me;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ImageAssetsViewModel extends ViewModel {
    private final MutableLiveData<Integer> headIndex = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> bodyIndex = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> legsIndex = new MutableLiveData<>(0);

    static int[] sHeadResources = {
        R.drawable.head1,
        R.drawable.head2,
        R.drawable.head3,
        R.drawable.head4,
        R.drawable.head5,
        R.drawable.head6,
        R.drawable.head7,
        R.drawable.head8,
        R.drawable.head9,
        R.drawable.head10,
        R.drawable.head11,
        R.drawable.head12,
    };

    static int[] sBodyResources = {
        R.drawable.body1,
        R.drawable.body2,
        R.drawable.body3,
        R.drawable.body4,
        R.drawable.body5,
        R.drawable.body6,
        R.drawable.body7,
        R.drawable.body8,
        R.drawable.body9,
        R.drawable.body10,
        R.drawable.body11,
        R.drawable.body12,
    };

    static int[] sLegsResources = {
        R.drawable.legs1,
        R.drawable.legs2,
        R.drawable.legs3,
        R.drawable.legs4,
        R.drawable.legs5,
        R.drawable.legs6,
        R.drawable.legs7,
        R.drawable.legs8,
        R.drawable.legs9,
        R.drawable.legs10,
        R.drawable.legs11,
        R.drawable.legs12,
    };

    void incrementHeadIndex() {
        Integer value = headIndex.getValue();
        ++value;
        if (value == sHeadResources.length) value = 0;
        headIndex.setValue(value);
    }

    void incrementBodyIndex() {
        Integer value = bodyIndex.getValue();
        ++value;
        if (value == sBodyResources.length) value = 0;
        bodyIndex.setValue(value);
    }

    void incrementLegsIndex() {
        Integer value = legsIndex.getValue();
        ++value;
        if (value == sLegsResources.length) value = 0;
        legsIndex.setValue(value);
    }

    LiveData<Integer> getHeadIndex() {
        return headIndex;
    }

    LiveData<Integer> getBodyIndex() {
        return bodyIndex;
    }

    LiveData<Integer> getLegsIndex() {
        return legsIndex;
    }
}
