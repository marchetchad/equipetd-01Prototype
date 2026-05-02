package com.marchetchad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MaterialButton btnSignup = findViewById(R.id.btn_signup);
        TextView tvLoginLink = findViewById(R.id.tv_login_link);

        btnSignup.setOnClickListener(v -> {
            // Simulation de création de compte réussie
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            startActivity(intent);
            finishAffinity(); // Ferme toutes les activités précédentes
        });

        tvLoginLink.setOnClickListener(v -> {
            finish(); // Retourne à l'écran de connexion
        });

        findViewById(R.id.iv_back).setOnClickListener(v -> finish());
    }
}