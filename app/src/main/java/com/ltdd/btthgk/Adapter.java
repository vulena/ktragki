package com.ltdd.btthgk;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private java.util.List<Items> items;

    public Adapter(Activity activity, List<Items> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.layout_item, null);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvMota = (TextView) view.findViewById(R.id.tv_mota);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_img);
        tvName.setText(items.get(i).getTen());
        tvMota.setText(items.get(i).getGia());
        imageView.setImageResource(items.get(i).getAnh());
        return view;
    }
}
