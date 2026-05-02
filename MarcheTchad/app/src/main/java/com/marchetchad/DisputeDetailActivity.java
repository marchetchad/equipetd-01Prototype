package com.marchetchad;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.marchetchad.data.DataManager;
import com.marchetchad.data.Dispute;

public class DisputeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispute_detail);

        findViewById(R.id.iv_back).setOnClickListener(v -> finish());

        // For demo, we might pass an ID, but here we just show the first one or a default
        if (!DataManager.getInstance().getDisputes().isEmpty()) {
            Dispute d = DataManager.getInstance().getDisputes().get(0);
            ((TextView)findViewById(R.id.tv_detail_id)).setText(d.getId());
            ((TextView)findViewById(R.id.tv_detail_title)).setText(d.getTitle());
            ((TextView)findViewById(R.id.tv_detail_desc)).setText(d.getDescription());
            ((TextView)findViewById(R.id.tv_detail_hash)).setText("Hash: " + d.getBlockchainHash());
        }
    }
}