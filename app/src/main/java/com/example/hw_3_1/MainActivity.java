package com.example.hw_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etTheme;
    private EditText etMessage;
    private Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.et_gmail);
        etTheme = findViewById(R.id.et_theme);
        etMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_SEND);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, theme, message;
                email = etEmail.getText().toString();
                theme = etTheme.getText().toString();
                message = etMessage.getText().toString();
                if (email.equals("") && theme.equals("") && message.equals("")) {
                    Toast.makeText(MainActivity.this, "Вы не заполнили поля", Toast.LENGTH_SHORT).show();
                }else {
                    sendEmail(email,theme,message);
                }

            }
        });
    }

    private void sendEmail(String email,String theme, String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT,theme);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"email"));
    }
}