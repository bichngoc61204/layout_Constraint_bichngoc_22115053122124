package com.example.layout_constraint2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find views by their IDs
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        TextView btnDangKy = findViewById(R.id.textViewDangKy);

        // Set OnClickListener to the "Đăng ký" TextView
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the RegisterActivity
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        // Set OnClickListener for the Login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from username and password EditText
                String ten = username.getText().toString();
                String pass = password.getText().toString();


                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Thông tin đăng nhập")
                            .setMessage("Username: " + ten + "\nPassword: " + pass)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

        });
    }
}