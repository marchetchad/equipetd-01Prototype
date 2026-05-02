package com.marchetchad;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.marchetchad.R;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        findViewById(R.id.iv_back).setOnClickListener(v -> finish());

        findViewById(R.id.btn_save).setOnClickListener(v -> {
            Toast.makeText(this, "Profil mis à jour sur la Blockchain", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}