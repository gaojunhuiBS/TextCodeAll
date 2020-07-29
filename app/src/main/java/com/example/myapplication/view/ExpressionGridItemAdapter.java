package com.example.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ExpressionGridItemAdapter extends BaseAdapter {
    private List<ExpressionsBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private int page;

    public ExpressionGridItemAdapter(Context context, List<ExpressionsBean> list, int page, int item_num) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.page = page;
        this.list.clear();
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = page * item_num;
        int end = start + item_num;
        while ((start < list.size()) && (start < end)) {
            this.list.add(list.get(start));
            start++;
        }

    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public ExpressionsBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.expression_item, null);
            viewHolder.iv = convertView.findViewById(R.id.iv);
            viewHolder.tv = convertView.findViewById(R.id.tv);
            viewHolder.relativeLayout = convertView.findViewById(R.id.parentRlay);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv.setImageResource(R.drawable.ic_launcher_background);
//        viewHolder.tv.setOnClickListener(v -> {
//            if (mOnSelectorListener != null && !CheckUtil.isEmpty(list)) {
//                mOnSelectorListener.setSelector(list.get(position));
//            }
//        });
        return convertView;
    }

    protected class ViewHolder {
        private ImageView iv;
        private TextView tv;
        private RelativeLayout relativeLayout;
    }

    public OnSelectorListener mOnSelectorListener;

    public void setOnSelectorListener(OnSelectorListener onSelectorListener) {
        mOnSelectorListener = onSelectorListener;
    }

    public interface OnSelectorListener {
        void setSelector(ExpressionsBean expressionsBean);
    }
}
