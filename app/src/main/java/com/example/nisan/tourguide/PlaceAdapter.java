package com.example.nisan.tourguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private ArrayList<Place> mDataList;
    private LayoutInflater inflater;
    private Context context;

    public PlaceAdapter(ArrayList<Place> mDataList, Context context) {
        this.mDataList = mDataList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Place currentPlace = mDataList.get(position);

        holder.mName.setText(currentPlace.getName());
        holder.mAddress.setText(currentPlace.getAddress());
        holder.mImage.setImageResource(currentPlace.getImageResourceId());

        String placeName = mDataList.get(position).getName();
        String placeAddress = mDataList.get(position).getAddress();
        String placeDescription = mDataList.get(position).getDescription();
        int placeImageId = mDataList.get(position).getImageResourceId();

        final Intent detailsIntent = new Intent(context, DetailsActivity.class);

        Bundle bun = new Bundle();

        bun.putString("name", placeName);
        bun.putString("address",placeAddress);
        bun.putString("description",placeDescription);
        bun.putInt("image",placeImageId);

        detailsIntent.putExtras(bun);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(detailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mAddress;
        private ImageView mImage;
        private CardView cardView;

        private ViewHolder(View view) {
            super(view);
            context = view.getContext();
            mName = view.findViewById(R.id.placeName_text_view);
            mAddress = view.findViewById(R.id.address_text_view);
            mImage = view.findViewById(R.id.place_image);
            cardView = itemView.findViewById(R.id.rootCardView);
        }
    }
}