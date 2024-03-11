package com.sinhvien.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightViewHolder> {

    public interface IClickListener{
        void onClickUpdateItem(Flight flight);
    }

  private  IClickListener mClickListener;

    ArrayList<Flight> arr_Flight;


    public FlightAdapter( ArrayList<Flight> arr_Flight) {

        this.arr_Flight = arr_Flight;
    }

    public FlightAdapter( ArrayList<Flight> arr_Flight,IClickListener mClickListener) {

        this.arr_Flight = arr_Flight;
        this.mClickListener= mClickListener;
    }




    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewFlight = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight,parent,false);
        return new FlightViewHolder(viewFlight);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, int position) {
        Flight flight = arr_Flight.get(position);
        if(arr_Flight == null) {
        return;
        }
        holder.txtCode.setText(flight.getCode());
        holder.txtDepartPlace.setText(flight.getDepartPlace());
        holder.txtArrivalPlace.setText(flight.getArrivalPlace());
        holder.txtDay.setText(flight.getDateDepart());
        holder.txtState.setText(flight.getState());
        holder.txtPrice.setText(String.valueOf(flight.getPrice()));
        holder.txtNamePlane.setText(flight.getNamePlane());
        holder.txtTime.setText(flight.getTime());

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onClickUpdateItem(flight);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (arr_Flight != null) {
            return arr_Flight.size();
        }
        return 0;
    }

    public class FlightViewHolder extends RecyclerView.ViewHolder {
        TextView txtCode,txtDepartPlace,txtArrivalPlace,txtDay,txtState,txtPrice,txtTime,txtNamePlane;
        Button btnUpdate;
        public FlightViewHolder(@NonNull View itemFlight) {
            super(itemFlight);
            txtCode=itemFlight.findViewById(R.id.tvcodeFlight);
            txtDepartPlace=itemFlight.findViewById(R.id.tv_DepartPlace);
            txtState=itemFlight.findViewById(R.id.tvState);
            txtArrivalPlace=itemFlight  .findViewById(R.id.tv_ArrivalPlace);
            txtDay=itemFlight.findViewById(R.id.tvDepartDay);
            txtPrice=itemFlight.findViewById(R.id.tv_Price);
            txtNamePlane=itemFlight.findViewById(R.id.tvNamePlane);
            txtTime=itemFlight.findViewById(R.id.tvTime);
            btnUpdate=itemFlight.findViewById(R.id.btnupdate);
        }
    }
}
