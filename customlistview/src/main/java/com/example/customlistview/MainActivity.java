package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    MyAdapter adapter;
    Integer posterID[]={R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};
    String title[]= {"써니","완득이","괴물","라디오스타","비열한거리","왕의남자",
                      "아일랜드","웰컴투동막골","헬보이","빽투더퓨처"};
    String content[]={"7 공주 프로젝트","내 인생이 꼬이기 시작했따.","가족의 사투가 시작되엇다.","언제나 나를 최고라고",
                       "지금 여기 그 남자의...","질투와 열망이 부른","이제 거대한 미래가 창조","1950년 지금은 전쟁중...",
                        "잘 생긴 얼굴만 세상을 구하는 것 아니지","과거로 여행을"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView)findViewById(R.id.listView1);
        List<ItemData> data = new ArrayList<>();
        for (int i = 0 ; i<posterID.length; i++){
            data.add(new ItemData(posterID[i],title[i],content[i]));
        }
        adapter=new MyAdapter(this,data);
        listView1.setAdapter(adapter);
    }
}
