package com.example.dakaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dakaapp.R;
import com.example.dakaapp.entity.DakaInfo;
import com.example.dakaapp.R;
import com.example.dakaapp.entity.DakaInfo;

import java.util.List;

public class DakaBaseAdapter extends BaseAdapter {

    private Context mContext;
    private List<DakaInfo> mDakaInfo;

    public DakaBaseAdapter(Context mContext, List<DakaInfo> mDakaInfo) {
        this.mContext = mContext;
        this.mDakaInfo = mDakaInfo;
    }

    // 获取列表项的个数
    @Override
    public int getCount() {
        return mDakaInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return mDakaInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            // 根据布局文件item_list.xml生成转换视图对象
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_daka, null);
            holder = new ViewHolder();
            holder.tv_time11 = convertView.findViewById(R.id.tv_time11);
            holder.tv_key111 = convertView.findViewById(R.id.tv_key111);
            holder.tv_con1111 = convertView.findViewById(R.id.tv_con1111);
            // 将视图持有者保存到转换视图当中
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        // 给控制设置好数据
        DakaInfo dakaInfo = mDakaInfo.get(position);
        holder.tv_time11.setText("3." + dakaInfo.shijian);
        holder.tv_key111.setText(dakaInfo.keyword);
        holder.tv_con1111.setText(dakaInfo.content);

        return convertView;


    }

    public final class ViewHolder {
        public TextView tv_time11;
        public TextView tv_key111;
        public TextView tv_con1111;
    }
}
