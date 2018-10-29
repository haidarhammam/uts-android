package com.example.haidarhammam.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haidarhammam.uts.model.SessionManagement;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnLogin;
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManagement(getApplicationContext());
        txtUsername = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.password);
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0 ){
                    session.createLoginSession(txtUsername.getText().toString(), txtPassword.getText().toString());
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    alert.showAlertDialog(MainActivity.this, "Login failed..", "Masukkan Username dan Password anda!", false);
                }

            }
        });
    }
}