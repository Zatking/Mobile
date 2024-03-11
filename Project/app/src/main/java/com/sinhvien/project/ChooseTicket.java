package com.sinhvien.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sinhvien.project.Fragment.InputInforUserTicKet;
import com.sinhvien.project.Fragment.NomalTicket;
import com.sinhvien.project.Fragment.Pay_Fragment;

public class ChooseTicket extends AppCompatActivity {

    Fragment fragment;
    Button btnback,btnout;
    ImageView img1,img2,img3;

    String ngayDi,noiDi,noiDen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);


        Intent i = getIntent();
        Bundle b = i.getExtras();
        ngayDi = b.getString("NgayDi","");
        noiDi = b.getString("NoiDi","");
        noiDen = b.getString("NoiDen","");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fmticket1, NomalTicket.class,null);
        transaction.commit();
        btnback=findViewById(R.id.btnbackinticket);
        btnout=findViewById(R.id.btnout);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fmticket1);
                if (currentFragment instanceof NomalTicket) {
                    finish();
                }
                else if (currentFragment instanceof InputInforUserTicKet) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticket1, NomalTicket.class,null);
                    transaction.commit();
                    img1.setBackgroundResource(R.drawable.circle);
                    img2.setBackgroundResource(R.drawable.circle_gray);
                    img3.setBackgroundResource(R.drawable.circle_gray);
                }

                else if (currentFragment instanceof Pay_Fragment) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fmticket1, InputInforUserTicKet.class,null);
                    transaction.commit();
                    img1.setBackgroundResource(R.drawable.circle_gray);
                    img2.setBackgroundResource(R.drawable.circle);
                    img3.setBackgroundResource(R.drawable.circle_gray);
                }
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void ChangeColor(int color1,int color2, int color3){
        img1 =findViewById(R.id.img1ticket);
        img2 =findViewById(R.id.img2ticket);
        img3 =findViewById(R.id.img3ticket);
        img1.setBackgroundResource(color1);
        img2.setBackgroundResource(color2);
        img3.setBackgroundResource(color3);
    }

}