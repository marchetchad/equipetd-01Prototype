package com.marchetchad;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.marchetchad.data.DataManager;
import com.marchetchad.data.Dispute;

public class ReportDisputeActivity extends AppCompatActivity {

    private Spinner spinnerType;
    private EditText etDesc, etAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_dispute);

        spinnerType = findViewById(R.id.spinner_dispute_type);
        etDesc = findViewById(R.id.et_dispute_desc);
        etAmount = findViewById(R.id.et_dispute_amount);

        findViewById(R.id.iv_back).setOnClickListener(v -> finish());

        findViewById(R.id.btn_submit_dispute).setOnClickListener(v -> {
            String type = spinnerType.getSelectedItem().toString();
            String desc = etDesc.getText().toString();
            String amount = etAmount.getText().toString();

            if (desc.isEmpty() || amount.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            Dispute newDispute = new Dispute(
                    "LIT-" + (System.currentTimeMillis() % 1000000),
                    type,
                    desc,
                    amount + " FCFA",
                    "En cours"
            );

            DataManager.getInstance().addDispute(newDispute);
            Toast.makeText(this, "Litige ancré sur la Blockchain avec succès !", Toast.LENGTH_LONG).show();
            finish();
        });
    }
}