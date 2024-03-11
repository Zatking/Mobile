package com.sinhvien.project;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserManagermentActivity extends AppCompatActivity {
RecyclerView recyclerViewUser;

UserAdapter userAdapter;

ArrayList <User> arrUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_managerment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            addControls();
            loadData();
            return insets;

        });
    }

    private void loadData  (){
    arrUser.add(new User("Diệp  Thành","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
            "Nam","2004-01-01"));
        arrUser.add(new User("Diệp Văn Thành","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
                "Nam","2004-01-01"));
        arrUser.add(new User("HoàiThanh","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
                "Nam","2004-01-01"));
        arrUser.add(new User("Diệp Thanh Tâm","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
                "Nam","2004-01-01"));
        arrUser.add(new User("Ngô Văn Thành","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
                "Nam","2004-01-01"));
        arrUser.add(new User("Nguyễn Văn Tâm","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
                "Nam","2004-01-01"));
        arrUser.add(new User("Tâm Thanh Nguyễn","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
                "Nam","2004-01-01"));
        arrUser.add(new User("Diệp Văn Tâm","DVT41557@gmail.com","0937624923","347/47 Lê Văn Thọ Phường 9 Quận Gò Vấp Tp Hồ Chí Minh",
                "Nam","2004-01-01"));

    }
    private void addControls(){
        recyclerViewUser=findViewById(R.id.rv_user);
        arrUser= new ArrayList<>();
        userAdapter = new UserAdapter(arrUser);
        recyclerViewUser.setAdapter(userAdapter);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

    }
}