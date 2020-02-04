package com.example.gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    GridView gridView1;
    String moveName[]={"써니","완득이","괴물","라디오스타","비열한거리","써니","완득이","괴물","라디오스타","비열한거리",
            "써니","완득이","괴물","라디오스타","비열한거리","써니","완득이","괴물","라디오스타","비열한거리",
            "써니","완득이","괴물","라디오스타","비열한거리","써니","완득이","괴물","라디오스타","비열한거리"
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView1=(GridView)findViewById(R.id.gridView1);
        MygridAdapter adapter = new MygridAdapter(this);//현재 액티비티를 어댑터를 생성
        gridView1.setAdapter(adapter);
    }
    public class MygridAdapter extends BaseAdapter {
        Context context;
        Integer posterID[] = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
                              R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
                R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,
                R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20,
                R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,R.drawable.mov24,R.drawable.mov25,
                R.drawable.mov26,R.drawable.mov27,R.drawable.mov28,R.drawable.mov29,R.drawable.mov30,
               };
        public MygridAdapter(Context c) {
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
            Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
            int x = display.getWidth()/3;
            int y= (int)(x*1.5);
            final ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(x,y));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);//그림여백을 늘려서꽉채움
            imageview.setPadding(5,5,5,5);//안쪽 여백을 줌

            imageview.setImageResource(posterID[position]);

            imageview.setOnClickListener(new View.OnClickListener() {
                final int pos= position;
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog,null);//메인액티비티에 인플레이트시킨다
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);//메인액티비티에 대화상자를 만든다
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);//이미지뷰 캐스팅
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(moveName[pos]);
                    dlg.setView(dialogView);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });
            return imageview;

        }

    }
}
