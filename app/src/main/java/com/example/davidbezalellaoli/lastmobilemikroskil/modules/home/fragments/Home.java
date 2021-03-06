package com.example.davidbezalellaoli.lastmobilemikroskil.modules.home.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.davidbezalellaoli.lastmobilemikroskil.R;
import com.example.davidbezalellaoli.lastmobilemikroskil.SplashScreen;
import com.example.davidbezalellaoli.lastmobilemikroskil.modules.auth.activities.AuthParent;
import com.example.davidbezalellaoli.lastmobilemikroskil.modules.home.adapters.User_RV_Adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    private View view;
    private RecyclerView rv;
    private User_RV_Adapter userRvAdapter;

    public Home() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initView();
        initObject();

        return view;
    }

    private void initView() {
        rv = (RecyclerView) view.findViewById(R.id.home_rv);

        /*LayoutManager: linear*/
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        /*LayoutManager: Grid*/
//        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rv.setHasFixedSize(true);
    }

    private void initObject() {
        userRvAdapter = new User_RV_Adapter();

        /*setting user rv adapter: inject data to adapter*/
        userRvAdapter.setUsers(SplashScreen.users);

        rv.setAdapter(userRvAdapter);
    }

}
