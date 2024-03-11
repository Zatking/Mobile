package com.sinhvien.project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageFlight extends AppCompatActivity {

    Integer price,ID=0;
    String code, departPlace, arrivalPlace, state,date,time,codePlane;
    EditText edtCode,edtDepartPlace,edtArrivalPlace,edtState,edtPrice,edtTime,edtDate,edtCodePlane;
    RecyclerView rv_flight;

    Button btnadd, btndelete, btnsearch;
    ArrayList<Flight> arrFlight;

    FlightAdapter flightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_flight);
        btnadd = findViewById(R.id.btn_add);
        btndelete=findViewById(R.id.btn_delete);
        btnsearch=findViewById(R.id.btn_search);
        edtCode=findViewById(R.id.edtCode);
        edtDepartPlace=findViewById(R.id.edtDepartPlace);
        edtArrivalPlace=findViewById(R.id.edtArrivalPlace);
        edtState=findViewById(R.id.edtState);
        edtPrice=findViewById(R.id.edtPrice);
        edtDate=findViewById(R.id.edt_date);
        edtTime=findViewById(R.id.edt_Time);
        edtCodePlane=findViewById(R.id.edtCodePlane);
        rv_flight =findViewById(R.id.rv_filght);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_flight.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rv_flight.addItemDecoration(dividerItemDecoration);
        arrFlight = new ArrayList<>();
        flightAdapter = new FlightAdapter(arrFlight);
        rv_flight.setAdapter(flightAdapter);
        onClickGetListFlightData();




        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date=String.valueOf(edtDate.getText());
                time=String.valueOf(edtTime.getText());
                code= String.valueOf(edtCode.getText());
                departPlace=String.valueOf(edtDepartPlace.getText());
                arrivalPlace=String.valueOf(edtArrivalPlace.getText());
                state=String.valueOf(edtState.getText());
                price=Integer.parseInt(edtPrice.getText().toString().trim());
                codePlane=String.valueOf(edtCodePlane.getText());
                Flight flight = new Flight(code,arrivalPlace,departPlace,state,date,price,time,codePlane);
                onClickAddFlight(flight);


            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });







        }
    private void onClickAddFlight(Flight flight) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("list_Flight");
        ID++;
        String pathObject = String.valueOf(ID);
        reference.child(pathObject).setValue(flight, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(ManageFlight.this,"Add Flight Success",Toast.LENGTH_SHORT).show();
            }
        });
        onClickUpdateData();

    }
    public void onClickGetListFlightData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("list_Flight");

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot dataSnapshot1: datasnapshot.getChildren()){
                    Flight flight = dataSnapshot1.getValue(Flight.class);

                    arrFlight.add(flight);
                    Toast.makeText(ManageFlight.this, "Get data success", Toast.LENGTH_SHORT).show();
                    /*flightAdapter*/
                }
                flightAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(ManageFlight.this,"Get list users failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onClickUpdateData(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("Flight");

        /*   myref.child(String.valueOf())*/
        /*Flight flight = new Flight(code, departPlace, arrivalPlace, date, state);*/

    }






}
