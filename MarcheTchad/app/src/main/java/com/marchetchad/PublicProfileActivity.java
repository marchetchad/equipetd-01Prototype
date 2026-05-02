package com.marchetchad;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.marchetchad.data.DataManager;

public class PublicProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile);

        TextView tvName = findViewById(R.id.tv_public_name);
        TextView tvScore = findViewById(R.id.tv_public_score);
        ProgressBar pbScore = findViewById(R.id.pb_public_score);

        DataManager dm = DataManager.getInstance();
        tvScore.setText(dm.getScore() + " / 1000");
        pbScore.setProgress(dm.getScore());

        findViewById(R.id.iv_back).setOnClickListener(v -> finish());
    }
}