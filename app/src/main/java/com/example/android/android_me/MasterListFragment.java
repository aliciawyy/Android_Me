package com.example.android.android_me;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {
  interface Listener {
    void onImageSelected(int position);
    void onButtonNextClicked();
    boolean isTwoPane();
  }

  private Listener mListener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mListener = (Listener) context;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_master_list, container, false);
    GridView masterListGridView = view.findViewById(R.id.master_list_grid_view);
    MasterListAdapter adapter = new MasterListAdapter(getContext());
    masterListGridView.setAdapter(adapter);
    masterListGridView.setOnItemClickListener(
        (parent, view1, position, id) -> mListener.onImageSelected(position));

    Button buttonNext = view.findViewById(R.id.button_next);
    if (mListener.isTwoPane()) {
      buttonNext.setVisibility(View.GONE);
    } else {
      buttonNext.setOnClickListener(v -> mListener.onButtonNextClicked());
    }
    return view;
  }
}