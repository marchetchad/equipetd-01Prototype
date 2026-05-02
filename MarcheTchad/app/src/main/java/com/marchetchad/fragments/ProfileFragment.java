package com.marchetchad.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.marchetchad.R;
import com.marchetchad.data.DataManager;

public class ProfileFragment extends Fragment {

    private TextView tvTransactions, tvScore;
    private MaterialButton btnApplyCredit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvTransactions = view.findViewById(R.id.tv_profile_transactions);
        tvScore = view.findViewById(R.id.tv_profile_score);
        btnApplyCredit = view.findViewById(R.id.btn_apply_credit);

        btnApplyCredit.setOnClickListener(v -> showCreditDialog());

        updateUI();

        return view;
    }

    private void showCreditDialog() {
        int score = DataManager.getInstance().getScore();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Analyse du Profil (Microfinance)");
        
        if (score >= 500) {
            builder.setMessage("Félicitations !\n\nVotre score de " + score + " basé sur votre historique Blockchain est excellent.\n\nStatut : ÉLIGIBLE\nMontant Max : 500,000 FCFA");
            builder.setIcon(android.R.drawable.ic_dialog_info);
            builder.setPositiveButton("Demander le déblocage", (dialog, which) -> {
                // Simulation d'envoi
            });
        } else {
            builder.setMessage("Score actuel : " + score + "\n\nVotre score est insuffisant pour un crédit immédiat. Continuez à enregistrer vos transactions pour renforcer votre crédibilité commerciale.");
            builder.setIcon(android.R.drawable.ic_dialog_alert);
        }
        
        builder.setNegativeButton("Fermer", null);
        builder.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        DataManager dm = DataManager.getInstance();
        if (tvTransactions != null) {
            tvTransactions.setText(String.valueOf(dm.getTransactions().size()));
        }
        if (tvScore != null) {
            tvScore.setText(String.valueOf(dm.getScore()));
        }
    }
}