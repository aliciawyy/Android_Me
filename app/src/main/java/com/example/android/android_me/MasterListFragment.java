package com.example.android.android_me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_master_list, container, false);
    GridView masterListGridView = view.findViewById(R.id.master_list_grid_view);
    MasterListAdapter adapter = new MasterListAdapter(getContext());
    masterListGridView.setAdapter(adapter);
    return view;
  }
}