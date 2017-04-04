package com.bookhi;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bookhi.fragment.HomePageFragment;
import com.bookhi.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HomePageFragment homePageFragment = new HomePageFragment();
        transaction.replace(R.id.layout_root,homePageFragment);
        homePageFragment.setRegisterButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack(null);
//                transaction.attach(new RegisterFragment());
                transaction.replace(R.id.layout_root,new RegisterFragment());
                transaction.commit();
            }
        });
        homePageFragment.setLoginButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        transaction.commit();
    }



}
