package com.zt.apple.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by apple on 2017/2/20.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mListFruit;
    public FruitAdapter(List<Fruit> mListFruit){
        this.mListFruit=mListFruit;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        private View fruitView;
        ImageView imageView;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            fruitView=itemView;
            imageView= (ImageView) itemView.findViewById(R.id.img);
            title= (TextView) itemView.findViewById(R.id.title);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);

            final ViewHolder holder=new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mListFruit.get(position);
                Toast.makeText(view.getContext(), "you clicked view"+fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positon=holder.getAdapterPosition();
                Fruit fruit=mListFruit.get(positon);
                Toast.makeText(view.getContext(), "you clicked view"+fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit=mListFruit.get(position);
        holder.imageView.setImageResource(fruit.getImageId());
        holder.title.setText(fruit.getName());
    }



    @Override
    public int getItemCount() {
        return mListFruit.size();
    }
}
