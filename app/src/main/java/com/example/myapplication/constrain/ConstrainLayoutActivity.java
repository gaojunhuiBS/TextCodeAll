package com.example.myapplication.constrain;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.view.ExpressionVpAdapter;
import com.example.myapplication.view.ExpressionsBean;
import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ConstrainLayoutActivity extends Activity {
    private ViewPager viewPager;
    private List<ExpressionsBean> list = new ArrayList<>();
    private List<ExpressionsBean> listData = new ArrayList<>();
    private int grid_item_num = 8;
    private ExpressionVpAdapter vpAdapter;
    private List<ViewPager> viewPagers = new ArrayList<>();
    private List<GridView> gridViews = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView closeTv;
    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetBehavior bottomSheetBehavior;
    private Button openBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        viewPager = findViewById(R.id.vp);
        openBt = findViewById(R.id.openTv);
        openBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialog();
                bottomSheetDialog.show();
            }
        });
        for (int i = 0; i < 600; i++) {
            list.add(new ExpressionsBean());
        }

    }

    private void initDialog() {
        if (bottomSheetDialog == null) {
            bottomSheetDialog = new BottomSheetDialog(this);
            View view = View.inflate(this, R.layout.dialog_bottomsheet, null);
            recyclerView = view.findViewById(R.id.rv);
            closeTv = view.findViewById(R.id.closeTv);
            closeTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialog.dismiss();
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new BaseAdapter(this, list));
            bottomSheetDialog.setContentView(view);
            bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
            bottomSheetBehavior.setPeekHeight(getPeekHeight());
        }
    }

    /**
     * 弹窗高度，默认为屏幕高度的四分之三
     * 子类可重写该方法返回peekHeight
     *
     * @return height
     */
    protected int getPeekHeight() {
        int peekHeight = getResources().getDisplayMetrics().heightPixels;
        //设置弹窗高度为屏幕高度的3/4
        return peekHeight - peekHeight / 3;
    }

    private class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.VH> {
        private Context context;
        private List<ExpressionsBean> list = new ArrayList<>();

        public BaseAdapter(Context context, List<ExpressionsBean> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_tv, null);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, final int position) {
            holder.textView.setText(String.valueOf(Math.random() * 100));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "pos:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class VH extends RecyclerView.ViewHolder {
            private TextView textView;

            public VH(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv);
            }
        }
    }
}
