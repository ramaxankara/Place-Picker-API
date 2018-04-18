package com.example.ramazankara.placepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class PlacePickerActivity extends AppCompatActivity {

    int PLACE_PİCKER_REQUEST =1;

     TextView tvPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_picker);

        tvPlace=findViewById(R.id.tvPlace);



    }

    public void  goPlacePicker(View view){


        //This is the place to call the place picker function

        PlacePicker.IntentBuilder builder =new PlacePicker.IntentBuilder();



        try {

            startActivityForResult(builder.build(PlacePickerActivity.this),PLACE_PİCKER_REQUEST);

        }catch (GooglePlayServicesRepairableException e){
            e.printStackTrace();
        }catch (GooglePlayServicesNotAvailableException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){


        if(requestCode ==PLACE_PİCKER_REQUEST){
            if(resultCode == RESULT_OK){

              Place place =PlacePicker.getPlace(PlacePickerActivity.this,data);

             tvPlace.setText(place.getAddress());

            }
        }






    }



}
