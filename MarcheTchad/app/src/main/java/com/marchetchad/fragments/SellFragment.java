package com.marchetchad.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.marchetchad.R;
import com.marchetchad.data.DataManager;
import com.marchetchad.data.Transaction;

public class SellFragment extends Fragment {

    private TextInputEditText etBuyerName, etDescription, etAmount, etDate;
    private MaterialButton btnSaveSale;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sell, container, false);

        etBuyerName = view.findViewById(R.id.et_buyer_name);
        etDescription = view.findViewById(R.id.et_description);
        etAmount = view.findViewById(R.id.et_amount);
        etDate = view.findViewById(R.id.et_date);
        btnSaveSale = view.findViewById(R.id.btn_save_sale);

        btnSaveSale.setOnClickListener(v -> saveTransaction());

        return view;
    }

    private void saveTransaction() {
        String name = etBuyerName.getText().toString();
        String desc = etDescription.getText().toString();
        String amountStr = etAmount.getText().toString();
        String date = etDate.getText().toString();

        if (name.isEmpty() || amountStr.isEmpty()) {
            Toast.makeText(getContext(), "Veuillez remplir au moins le nom et le montant", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);
        Transaction transaction = new Transaction(name, desc, amount, date);
        
        DataManager.getInstance().addTransaction(transaction);

        Toast.makeText(getContext(), "Vente enregistrée sur la Blockchain !", Toast.LENGTH_LONG).show();
        
        // Reset fields
        etBuyerName.setText("");
        etDescription.setText("");
        etAmount.setText("");
        etDate.setText("");
    }
}