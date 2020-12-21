package com.example.kontrol_relay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button onLampu = (Button) findViewById(R.id.onLampu);
        final Button offLampu = (Button) findViewById(R.id.offLampu);

        final Button onAc = (Button) findViewById(R.id.onAc);
        final Button offAc = (Button) findViewById(R.id.offAc);

        final Button onDesktop = (Button) findViewById(R.id.onDesktop);
        final Button offDesktop = (Button) findViewById(R.id.offDesktop);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refLampu = database.getReference("STATUS_LAMPU");
        DatabaseReference refAc = database.getReference("STATUS_AC");
        DatabaseReference refDesktop = database.getReference("STATUS_DESKTOP");

        refLampu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);
                    if(message==0){
                        offLampu.setVisibility(View.GONE);
                        onLampu.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        onLampu.setVisibility(View.GONE);
                        offLampu.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refAc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);
                    if(message==0){
                        offAc.setVisibility(View.GONE);
                        onAc.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        onAc.setVisibility(View.GONE);
                        offAc.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refDesktop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);
                    if(message==0){
                        offDesktop.setVisibility(View.GONE);
                        onDesktop.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        onDesktop.setVisibility(View.GONE);
                        offDesktop.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        onLampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU");

                myref.setValue(1);
            }
        });

        offLampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU");

                myref.setValue(0);
            }
        });

        onAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_AC");

                myref.setValue(1);
            }
        });

        offAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_AC");

                myref.setValue(0);
            }
        });

        onDesktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DESKTOP");

                myref.setValue(1);
            }
        });

        offDesktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DESKTOP");

                myref.setValue(0);
            }
        });
    }
}