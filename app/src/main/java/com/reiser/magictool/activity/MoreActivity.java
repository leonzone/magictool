package com.reiser.magictool.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.reiser.magictool.R;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class MoreActivity extends AppCompatActivity {

    private List<String> datas;
//    private RecyclerView mRecyclerView;
//    private RecyclerViewAdapter mAdapter;


    MyListAdapter myListAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initDatas();
        myListAdapter = new MyListAdapter(this, datas);
        mListView = (ListView) findViewById(R.id.lv_more);
        mListView.setAdapter(myListAdapter);
//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_more);
//
//
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mAdapter = new RecyclerViewAdapter(datas);
//        mRecyclerView.setAdapter(mAdapter);
//        //0则不执行拖动或者滑动
//        ItemTouchHelper.Callback mCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT) {
//            /**
//             * @param recyclerView
//             * @param viewHolder 拖动的ViewHolder
//             * @param target 目标位置的ViewHolder
//             * @return
//             */
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//                int fromPosition = viewHolder.getAdapterPosition();//得到拖动ViewHolder的position
//                int toPosition = target.getAdapterPosition();//得到目标ViewHolder的position
//                if (fromPosition < toPosition) {
//                    //分别把中间所有的item的位置重新交换
//                    for (int i = fromPosition; i < toPosition; i++) {
//                        Collections.swap(datas, i, i + 1);
//                    }
//                } else {
//                    for (int i = fromPosition; i > toPosition; i--) {
//                        Collections.swap(datas, i, i - 1);
//                    }
//                }
//                mAdapter.notifyItemMoved(fromPosition, toPosition);
//                //返回true表示执行拖动
//                return true;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                int position = viewHolder.getAdapterPosition();
//                datas.remove(position);
//                mAdapter.notifyItemRemoved(position);
//            }
//
//            @Override
//            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//                    //左右滑动时改变Item的透明度
//                    final float alpha = 1 - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
//                    viewHolder.itemView.setAlpha(alpha);
//                    viewHolder.itemView.setTranslationX(dX);
//                }
//            }
//
//            @Override
//            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
//                super.onSelectedChanged(viewHolder, actionState);
//                //当选中Item时候会调用该方法，重写此方法可以实现选中时候的一些动画逻辑
//                Log.v("zxy", "onSelectedChanged");
//            }
//
//            @Override
//            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//                super.clearView(recyclerView, viewHolder);
//                //当动画已经结束的时候调用该方法，重写此方法可以实现恢复Item的初始状态
//                Log.v("zxy", "clearView");
//            }
//        };
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
//        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

    private void initDatas() {
        datas = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            datas.add("Number:" + i);
        }
    }

    class MyListAdapter extends ArrayAdapter<String> {
        public MyListAdapter(Context context, List<String> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder viewHolder;
            if (convertView == null) {
                view = View.inflate(getContext(), R.layout.list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.tv_content);
                view.setTag(viewHolder);
            } else {
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.textView.setText(getItem(position));
            return view;
        }

        class ViewHolder {
            TextView textView;
        }
    }


}
