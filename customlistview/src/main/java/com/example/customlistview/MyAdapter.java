package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.PriorityQueue;

public class MyAdapter extends BaseAdapter {
    private Context context; // 현재 메인액티비티에서 어댑터를 붙이는 역할
    private List<ItemData> itemDataListe;//아이템 리스트에 들어갈 변수
    private LayoutInflater mInflater;




    public MyAdapter(Context context, List<ItemData> itemDataList) {
        this.context=context;
        this.itemDataListe=itemDataList;
        this.mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemDataListe.size();//렝스가아니고 사이즈
    }

    @Override
    public Object getItem(int position) {
        return itemDataListe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null) {
            itemView=mInflater.inflate(R.layout.item_listview,null);
        }
        ImageView ivPoster=(ImageView)itemView.findViewById(R.id.ivPoster);
        TextView tvTitle=(TextView)itemView.findViewById(R.id.tvTitle);
        TextView tvContent=(TextView)itemView.findViewById(R.id.tvContent);
        ItemData itemData=itemDataListe.get(position);
        ivPoster.setImageResource(itemData.getImgID());
        tvTitle.setText(itemData.getTitle());
        tvContent.setText(itemData.getContent());

        return itemView;
    }
}
