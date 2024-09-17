package com.example.layout_constraint2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText mail;
    private Button btn_dangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Find views by their IDs
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mail = findViewById(R.id.mail);
        btn_dangky = findViewById(R.id.btn_dangky);

        // Find the TextView by its ID in the layout
        TextView btn = findViewById(R.id.textViewDaCo);

        // Set an OnClickListener to the TextView
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the RegisterActivity
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        // Set OnClickListener for the Login button
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from username and password EditText
                String ten = username.getText().toString();
                String pass = password.getText().toString();
                String gmail = mail.getText().toString();


                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle("Thông tin đăng ký")
                        .setMessage("Username: " + ten + "\nPassword: " + pass + "\nMail: " + gmail)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            };
    });
    }}