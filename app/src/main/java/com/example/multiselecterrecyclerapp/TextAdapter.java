package com.example.multiselecterrecyclerapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TextAdapter  extends RecyclerView.Adapter<TextAdapter.TextHolder> {

    public  static  final Integer ACTIVE=0;
    public  static  final Integer INACTVE=1;
    private Context mContext;
    ArrayList<SingleItem> mItems;

    public TextAdapter(ArrayList<SingleItem> pItems) {
        mItems = pItems;
    }

    @Override
    public int getItemViewType(int position) {
        boolean type=mItems.get(position).isActive();
        return type?ACTIVE:INACTVE;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup pViewGroup, int pI) {
        mContext=pViewGroup.getContext();
        final int vLayout=pI==INACTVE?R.layout.inactive_item_layout:R.layout.active_item_layout;
        View v= LayoutInflater.from(mContext).inflate(vLayout,pViewGroup,false);
        return new TextHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TextHolder pTextHolder, int pI) {
        pTextHolder.title.setText(mItems.get(pI).getTitle());
        pTextHolder.desc.setText(mItems.get(pI).getDescription()+" ,"+(mItems.get(pI).isActive()?"ACTIVE":"INActive") );
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class TextHolder extends RecyclerView.ViewHolder{

        TextView title,desc;
        TextHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.description);
        }
    }

}
