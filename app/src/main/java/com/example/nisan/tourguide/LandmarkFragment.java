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
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandmarkFragment extends Fragment {

    public LandmarkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        String nameList[] = getResources().getStringArray(R.array.landmarksNameList);
        String addressList[] = getResources().getStringArray(R.array.landmarksAddressList);
        String descriptionList[] = getResources().getStringArray(R.array.landmarksDescriptionList);
        int[] imageList = {
                R.drawable.topkapi_palace,
                R.drawable.galata_tower,
                R.drawable.dolmabahce,
                R.drawable.ayasofya,
                R.drawable.sultanahmet,
                R.drawable.rumeli_fortress,
                R.drawable.maiden_tower,
                R.drawable.basilica_cistern
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
