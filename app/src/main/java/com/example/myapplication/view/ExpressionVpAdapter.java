package com.example.myapplication.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

/**
 * Created by Denis on 2016/12/19.
 */
public class ExpressionVpAdapter extends PagerAdapter {

    private List<ViewPager> grideViews;

    public ExpressionVpAdapter(List<ViewPager> grideViews) {
        this.grideViews = grideViews;
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
