package com.example.myapplication.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.viewpager.widget.PagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 2016/12/19.
 */
public class ExpressionGridAdapter extends PagerAdapter {

    private List<GridView> grideViews;

    public ExpressionGridAdapter() {
      grideViews=new ArrayList<>();
    }
   public void add(List<GridView> datas) {
        if (grideViews.size() > 0) {
            grideViews.clear();
        }
        grideViews.addAll(datas);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return grideViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(grideViews.get(position));
        return grideViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(grideViews.get(position));
    }
}
