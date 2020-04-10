package com.example.android.android_me;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MasterListAdapter extends BaseAdapter {

  private final Context mContext;

  MasterListAdapter(Context context) {
    mContext = context;
  }

  @Override
  public int getCount() {
    return ImageAssetsViewModel.getTotalImageNumber();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ImageView imageView = (ImageView) convertView;
    if (imageView == null) {
      imageView = new ImageView(mContext);
      imageView.setAdjustViewBounds(true);
      imageView.setScaleType(ScaleType.CENTER_CROP);
      imageView.setPadding(8, 8, 8, 8);
    }
    imageView.setImageResource(ImageAssetsViewModel.getImageResource(position));
    return imageView;
  }
}
