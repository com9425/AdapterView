package com.example.galleryex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Gallery gallery1;
    ImageView ivPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery1=(Gallery)findViewById(R.id.gallery1);
        ivPoster=(ImageView)findViewById(R.id.ivPoster);
        //어댑터 준비
        MyAdapter adapter=new MyAdapter(this);
        gallery1.setAdapter(adapter);
    }
    public class MyAdapter extends BaseAdapter {
        Context context;
        Integer posterID[]={R.drawable.mov01, R.drawable.mov02,R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};
        public MyAdapter(Context c) {
            context=c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ImageView imageView=new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ivPoster.setImageResource(posterID[position]);
                    return false;
                }
            });
            return imageView;
        }
    }
}
