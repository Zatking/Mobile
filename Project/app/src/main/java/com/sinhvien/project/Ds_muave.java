package com.sinhvien.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Ds_muave extends AppCompatActivity {

    private ChuyenBayAdapter mCBAdapter;

    private List<ChuyenBay> mListCB;

    String ngayDi,noiDi,noiDen;

    //code tu gen tu findviewbychuyenbay 20
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_mua_ve);





        RecyclerView rcv_cb = (RecyclerView) findViewById(R.id.LvDsV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_cb.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_cb.addItemDecoration(dividerItemDecoration);

        mListCB = new ArrayList<>();
        mCBAdapter = new ChuyenBayAdapter(mListCB);

        rcv_cb.setAdapter(mCBAdapter);

        FilterDB(ngayDi,noiDi,noiDen);
    }

    private void getListCBRD() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbr = database.getReference("list_Flight");

        dbr.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ChuyenBay cb = dataSnapshot.getValue(ChuyenBay.class);
                    mListCB.add(cb);
                }
                mCBAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Ds_muave.this,"leu leu",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void FilterDB(String ngayDi,String noiDi,String noiDen){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbr = database.getReference("list_Flight");

        dbr.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ChuyenBay cb = snapshot.getValue(ChuyenBay.class);
                if(cb != null){
                    if(cb.getDateDepart().contains(ngayDi) && cb.getDateDepart().contains(noiDi) && cb.getArrivalPlace().contains(noiDen)){
                        mListCB.add(cb);
                    }
                    mCBAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}