package com.example.davidbezalellaoli.lastmobilemikroskil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.davidbezalellaoli.lastmobilemikroskil.models.User;
import com.example.davidbezalellaoli.lastmobilemikroskil.modules.auth.activities.AuthParent;
import com.example.davidbezalellaoli.lastmobilemikroskil.modules.home.activities.Home;
import com.example.davidbezalellaoli.lastmobilemikroskil.utils.Session;

import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {


    public static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        users = new ArrayList<>();
        try {
            users.add(new User("151110001", "Andy", "password"));
            users.add(new User("151110002", "Bobby", "password"));
            users.add(new User("151110003", "Cindy", "password"));
            users.add(new User("151110004", "Dessy", "password"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                    if (Session.getInstance(getApplicationContext()).isUserLoggedIn()) {
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), AuthParent.class);
                        startActivity(intent);
                    }
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
}
