package com.zt.apple.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fruit> mFruitList=new ArrayList<Fruit>();
    RecyclerView recycler_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruitList();
        recycler_view= (RecyclerView) findViewById(R.id.recycler_view);
        FruitAdapter adpter=new FruitAdapter(mFruitList);
        StaggeredGridLayoutManager linerlayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(linerlayoutManager);
        recycler_view.setAdapter(adpter);
    }

    private void initFruitList() {
        for(int i=0;i<15;i++){
            Fruit apple=new Fruit("apple",R.drawable.apple);
            mFruitList.add(apple);
            Fruit banana=new Fruit("banana",R.drawable.banana);
            mFruitList.add(banana);
            Fruit orenge=new Fruit("orenge",R.drawable.orenge);
            mFruitList.add(orenge);
            Fruit pipe=new Fruit("pipe",R.drawable.pipe);
            mFruitList.add(pipe);
        }

    }
}
