package com.example.someshwara_assignment;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LocationVIewModel extends ViewModel {
    public Context context;
    private  LocationModel locationModel;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public LocationVIewModel(Context context) {
        this.context = context;
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Location");
    }
    public void setLocation(LocationModel locationModel){
        this.locationModel=locationModel;
        addDatatoFirebase();
    }

    private void addDatatoFirebase() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(locationModel);
                Toast.makeText(context, "Location data saved success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(context, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
