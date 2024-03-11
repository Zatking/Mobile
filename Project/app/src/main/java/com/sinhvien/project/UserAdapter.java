package com.sinhvien.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public UserAdapter(ArrayList<User> arr_User) {
        this.arr_User = arr_User;
    }

    ArrayList <User> arr_User;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewUser = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        ViewHolder viewHolderUser = new ViewHolder(viewUser);
        return viewHolderUser;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    User user = arr_User.get(position);

    holder.txtUserName.setText(user.getUserName());
    holder.txtBirthDay.setText(user.getBirthDay().toString());
    holder.txtSex.setText(user.getSex());
    holder.txtPhoneNumber.setText(user.getPhoneNumber());
    holder.txtAddress.setText(user.getAddress());
    holder.txtEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return arr_User.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView txtUserName,txtAddress,txtPhoneNumber,txtSex,txtBirthDay,txtEmail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtUserName=itemView.findViewById(R.id.UserName);
            txtAddress=itemView.findViewById(R.id.Address);
            txtEmail=itemView.findViewById(R.id.Email);
            txtSex=itemView.findViewById(R.id.Sex);
            txtPhoneNumber=itemView.findViewById(R.id.UserPhone);
            txtBirthDay=itemView.findViewById(R.id.Birthday);
        }
    }
}
