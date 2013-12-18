
package com.aug.swip;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends Activity {
    Context mContext;

    SwipeListView mListView;

    @SuppressWarnings("unused")
    private SwipAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        initView();
    }

    private void initView() {
        mListView = (SwipeListView)findViewById(R.id.listview);
        SwipeAdapter adapter = new SwipeAdapter(mContext, mListView.getRightViewWidth(),
                new SwipeAdapter.IOnItemRightClickListener() {
                    @Override
                    public void onRightClick(View v, int position) {
                        // TODO Auto-generated method stub
                        Toast.makeText(mContext, "right onclick " + position, Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "item onclick " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
