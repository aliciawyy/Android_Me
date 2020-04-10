package com.example.android.android_me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartFragment extends Fragment {
  private ImageView mHeadView;
  private ImageView mBodyView;
  private ImageView mLegsView;

  private ImageAssetsViewModel mImageAssetsViewModel;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_body_part, container, false);
    mImageAssetsViewModel = new ViewModelProvider(requireActivity())
        .get(ImageAssetsViewModel.class);
    mHeadView = view.findViewById(R.id.body_head);
    mHeadView.setImageResource(ImageAssetsViewModel.sHeadResources[mImageAssetsViewModel.getHeadIndex().getValue()]);

    mBodyView = view.findViewById(R.id.body_body);
    mBodyView.setImageResource(ImageAssetsViewModel.sBodyResources[mImageAssetsViewModel.getBodyIndex().getValue()]);

    mLegsView = view.findViewById(R.id.body_legs);
    mLegsView.setImageResource(ImageAssetsViewModel.sLegsResources[mImageAssetsViewModel.getLegsIndex().getValue()]);

    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mHeadView.setOnClickListener(v -> mImageAssetsViewModel.incrementHeadIndex());
    mImageAssetsViewModel.getHeadIndex().observe(getViewLifecycleOwner(),
        index -> mHeadView.setImageResource(ImageAssetsViewModel.sHeadResources[index]));

    mBodyView.setOnClickListener(v -> mImageAssetsViewModel.incrementBodyIndex());
    mImageAssetsViewModel.getBodyIndex().observe(getViewLifecycleOwner(),
        index -> mBodyView.setImageResource(ImageAssetsViewModel.sBodyResources[index]));

    mLegsView.setOnClickListener(v -> mImageAssetsViewModel.incrementLegsIndex());
    mImageAssetsViewModel.getLegsIndex().observe(getViewLifecycleOwner(),
        index -> mLegsView.setImageResource(ImageAssetsViewModel.sLegsResources[index]));
  }
}