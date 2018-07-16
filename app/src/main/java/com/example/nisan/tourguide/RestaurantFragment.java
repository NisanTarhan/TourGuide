package com.example.nisan.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        String nameList[] = getResources().getStringArray(R.array.restaurantsNameList);
        String addressList[] = getResources().getStringArray(R.array.restaurantsAddressList);
        String descriptionList[] = getResources().getStringArray(R.array.restaurantsDescriptionList);
        int[] imageList = {
                R.drawable.lebiderya,
                R.drawable.mikla,
                R.drawable.istanbul360,
                R.drawable.poseidon,
                R.drawable.tapasuma,
                R.drawable.ulus29,
                R.drawable.vogue_restaurant,
                R.drawable.lokma
        };



        final ArrayList<Place> places = new ArrayList<>();

        for (int i = 0; i < nameList.length; i++) {
            places.add(new Place(nameList[i], addressList[i], descriptionList[i], imageList[i]));
        }

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());

        PlaceAdapter placeAdapter = new PlaceAdapter(places, rootView.getContext());

        recyclerView.setAdapter(placeAdapter);
        recyclerView.setLayoutManager(layoutManager);

        placeAdapter.notifyDataSetChanged();

        return rootView;
    }

}
