package com.sinhvien.project;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChuyenBayAdapter extends RecyclerView.Adapter<ChuyenBayAdapter.ChuyenBayViewHolder>{

    private List<ChuyenBay> mlistcb;

    public ChuyenBayAdapter(List<ChuyenBay> mlistcb) {
        this.mlistcb = mlistcb;
    }

    @NonNull
    @Override
    public ChuyenBayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_airline,parent,false);
        return new ChuyenBayViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuyenBayViewHolder holder, int position) {
        ChuyenBay chuyenBay = mlistcb.get(position);
        if(chuyenBay == null){
            return;
        }
        holder.tvnoiden.setText(chuyenBay.getArrivalPlace());
        holder.tvmachuyenbay.setText(chuyenBay.getCode());
        holder.tvngaydi.setText(chuyenBay.getDateDepart());
        holder.tvnoidi.setText(chuyenBay.getDepartPlace());
        holder.tvNamePlane.setText(chuyenBay.getNamePlane());
        holder.tvgiave.setText(String.valueOf(chuyenBay.getPrice()));
        holder.tvState.setText(chuyenBay.getState());
        holder.tvgiobay.setText(chuyenBay.getTime());
    }

    @Override
    public int getItemCount() {
        if(mlistcb != null){
            return mlistcb.size();
        }
        return 0;
    }

    public class ChuyenBayViewHolder extends RecyclerView.ViewHolder {

        private TextView tvngaydi;
        private TextView tvNamePlane;
        private TextView tvnoidi;
        private TextView tvnoiden;
        private TextView tvgiobay;
        private TextView tvState;
        private TextView tvgiave;
        private TextView tvmachuyenbay;
        public ChuyenBayViewHolder(@NonNull View itemView) {
            super(itemView);

            tvngaydi = itemView.findViewById(R.id.textNgayDi);
            tvNamePlane = itemView.findViewById(R.id.textNP);
            tvnoidi = itemView.findViewById(R.id.textNoiDi);
            tvnoiden = itemView.findViewById(R.id.textNoiDen);
            tvgiobay = itemView.findViewById(R.id.textGioBay);
            tvState = itemView.findViewById(R.id.textState);
            tvgiave = itemView.findViewById(R.id.textGiaVe);
            tvmachuyenbay = itemView.findViewById(R.id.textMCB);

        }
    }
}
