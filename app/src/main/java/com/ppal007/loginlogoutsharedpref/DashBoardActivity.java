package com.ppal007.loginlogoutsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoardActivity extends AppCompatActivity {

    private Button logout;
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        logout=findViewById(R.id.buttonLogoutId);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLogout();
            }
        });
    }

    private void initLogout() {
        sharedPreferenceConfig.login_status(false);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();

    }
}