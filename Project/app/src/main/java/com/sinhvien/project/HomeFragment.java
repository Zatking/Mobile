package com.sinhvien.project;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textView = view.findViewById(R.id.textView);
        String text = "Trở thành hội viên của chúng tôi, Đăng ký hoặc Đăng nhập";

        SpannableString spannableString = new SpannableString(text);

        ClickableSpan registerClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện khi nhấp vào "Đăng ký"
                // Ví dụ: Chuyển sang trang đăng ký
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        };

        ClickableSpan loginClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện khi nhấp vào "Đăng nhập"
                // Ví dụ: Chuyển sang trang đăng nhập
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        };

        spannableString.setSpan(registerClickableSpan, text.indexOf("Đăng ký"), text.indexOf("Đăng ký") + "Đăng ký".length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(loginClickableSpan, text.indexOf("Đăng nhập"), text.indexOf("Đăng nhập") + "Đăng nhập".length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan registerColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.purple));
        ForegroundColorSpan loginColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.purple));

        spannableString.setSpan(registerColorSpan, text.indexOf("Đăng ký"), text.indexOf("Đăng ký") + "Đăng ký".length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(loginColorSpan, text.indexOf("Đăng nhập"), text.indexOf("Đăng nhập") + "Đăng nhập".length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}