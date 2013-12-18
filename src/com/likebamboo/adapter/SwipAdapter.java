
package com.likebamboo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class SwipAdapter extends BaseAdapter {

    /**
     * 上下文对象
     */
    private Context mContext = null;

    /**
     * 
     */
    private int mRightWidth = 0;

    /**
     * 单击事件监听器
     */
    private IOnItemClickListener mListener = null;

    /**
     * @param mainActivity
     */
    public SwipAdapter(Context ctx, int rightWidth, IOnItemClickListener l) {
        mContext = ctx;
        mRightWidth = rightWidth;
        mListener = l;
    }

    public interface IOnItemClickListener {
        void onLeftClick(View v, int position);

        void onRightClick(View v, int position);
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = new LinearLayout(mContext);
        convertView = layout;

        layout.addView(generateLeftView(position));
        layout.addView(generateRightView(position));
        return convertView;
    }

    private View generateLeftView(final int position) {
        TextView view = new TextView(mContext);
        LinearLayout.LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        // lp.setMargins(0, 0, 100, 0);
        view.setLayoutParams(lp);
        view.setText("item " + position);
        view.setPadding(10, 30, 10, 30);
        // view.setBackgroundColor(Color.parseColor("#f2c2c2"));
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    // Toast.makeText(mContext, "left " + position,
                    // Toast.LENGTH_SHORT).show();
                    mListener.onLeftClick(v, position);
                }
            }
        });
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        return view;
    }

    private View generateRightView(final int position) {
        TextView view = new TextView(mContext);
        LinearLayout.LayoutParams lp = new LayoutParams(mRightWidth, LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);
        view.setText("delete " + position);
        view.setGravity(Gravity.CENTER);
        view.setBackgroundColor(Color.parseColor("#12c2c2"));
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    // Toast.makeText(mContext, "del " + position,
                    // Toast.LENGTH_SHORT).show();
                    mListener.onRightClick(v, position);
                }
            }
        });
        view.setFocusable(false);
        return view;
    }
}
