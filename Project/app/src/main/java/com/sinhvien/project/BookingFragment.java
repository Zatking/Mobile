package com.sinhvien.project;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingFragment extends Fragment {
    EditText etngaydi,etngayve,etNoiden,etNoidi;
    Button btnmc,btnTimVe;
    TextView codeFlight,diemden,diemdi,ngaydi,ngayden,gia,status;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BookingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        etngaydi = view.findViewById(R.id.et_Ngaydi);
        etNoidi = view.findViewById(R.id.etNoidi);
        etNoiden = view.findViewById(R.id.etNoiden);
        etngaydi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgayDi();
            }
        });

        btnTimVe = view.findViewById(R.id.TimVe);
        btnTimVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChooseTicket.class);
                Bundle b = new Bundle();
                b.putString("NgayDi",etngaydi.getText().toString());
                b.putString("NoiDi",etNoidi.getText().toString());
                b.putString("NoiDen",etNoidi.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        return view;
    }
    private void ChonNgayDi(){
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                etngaydi.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,date);
        datePickerDialog.show();
    }

    private void ChonNgayVe() {
        Calendar calendar = Calendar.getInstance();
        int dateVe = calendar.get(Calendar.DATE);
        int monthVe = calendar.get(Calendar.MONTH);
        int yearVe = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                if (selectedDate.before(calendar)) {
                    // The return date is before the departure date
                    // You can show an error message or handle it as per your requirement
                    Toast.makeText(getActivity(), "Ngày về phải lớn hơn ngày đi", Toast.LENGTH_SHORT).show();
                } else {
                    calendar.set(year, month, dayOfMonth);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    etngayve.setText(simpleDateFormat.format(calendar.getTime()));
                }
            }
        }, yearVe, monthVe, dateVe);
        datePickerDialog.show();
    }
}