package com.example.nisan.tourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView addressTextView;
    TextView descriptionTextView;
    ImageView detailsImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameTextView = findViewById(R.id.title_textView);
        addressTextView = findViewById(R.id.address_textView);
        descriptionTextView = findViewById(R.id.description_textView);
        detailsImageView = findViewById(R.id.details_imageView );

        Bundle extras = getIntent().getExtras();

        String mDetailsName = extras.getString("name");
        String mDetailsAddress = extras.getString("address");
        String mDetailsDescription = extras.getString("description");
        int mDetailsImageId = extras.getInt("image");

        nameTextView.setText(mDetailsName);
        addressTextView.setText(mDetailsAddress);
        descriptionTextView.setText(mDetailsDescription);
        detailsImageView.setImageResource(mDetailsImageId);

    }
}
