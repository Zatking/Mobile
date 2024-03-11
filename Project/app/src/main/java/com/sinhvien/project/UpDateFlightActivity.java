package com.sinhvien.project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpDateFlightActivity extends AppCompatActivity {

    Integer price,ID=0;
    String code, departPlace, arrivalPlace, state,date,time,codePlane;
    EditText edtUpdateCode,edtUpdateDepartPlace,edtUpdateArrivalPlace,
            edtUpdateState,edtUpdatePrice,edtUpdateTime,edtUpdateDate,edtUpdateCodePlane;
    Button btnUpdate;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_updatedata);

        btnUpdate = findViewById(R.id.btn_update);
    }
}
