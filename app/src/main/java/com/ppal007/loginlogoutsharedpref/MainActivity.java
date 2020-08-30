package com.ppal007.loginlogoutsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name,password;
    private Button login;
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.etUserNameId);
        password=findViewById(R.id.etUserPassId);
        login=findViewById(R.id.buttonLoginId);

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLogin();
            }
        });

        if (sharedPreferenceConfig.read_login_status()){
            startActivity(new Intent(getApplicationContext(),DashBoardActivity.class));
            finish();
        }
    }

    private void initLogin() {
        String _name = name.getText().toString();
        String _pass = password.getText().toString();
        if (_name.equals(getResources().getString(R.string.username)) && _pass.equals(getResources().getString(R.string.password))){
            startActivity(new Intent(getApplicationContext(),DashBoardActivity.class));
            sharedPreferenceConfig.login_status(true);
            finish();
        }else {
            Toast.makeText(this, "user not valid", Toast.LENGTH_SHORT).show();
            name.setText("");
            password.setText("");
        }
        
    }
}