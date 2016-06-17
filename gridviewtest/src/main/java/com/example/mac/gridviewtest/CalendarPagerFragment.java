package com.example.mac.gridviewtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

public class CalendarPagerFragment extends Fragment {

    public static final String MONTH_INDEX = "month_index";

    private int monthIndex;

    public static CalendarPagerFragment create(int monthIndex) {
        CalendarPagerFragment fragment = new CalendarPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MONTH_INDEX, monthIndex);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        monthIndex = getArguments().getInt(MONTH_INDEX);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.view_calendar, null);
//		CalendarView calendarView = new CalendarView(getActivity(), monthIndex);
//		calendarView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
//		view.addView(calendarView);

        MonthDateView monthDateView = new MonthDateView(getActivity(), monthIndex);
        monthDateView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        view.addView(monthDateView);
        return view;
    }
}
