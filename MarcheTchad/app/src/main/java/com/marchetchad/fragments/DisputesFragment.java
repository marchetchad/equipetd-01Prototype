package com.marchetchad.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.marchetchad.R;
import com.marchetchad.ReportDisputeActivity;
import com.marchetchad.data.DataManager;
import com.marchetchad.data.Dispute;
import java.util.List;

public class DisputesFragment extends Fragment {

    private TextView tvActiveCount, tvResolvedCount, tvNoDisputes;
    private LinearLayout llDisputesList;
    private MaterialButton btnReportDispute;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disputes, container, false);

        tvActiveCount = view.findViewById(R.id.tv_active_count);
        tvResolvedCount = view.findViewById(R.id.tv_resolved_count);
        tvNoDisputes = view.findViewById(R.id.tv_no_disputes);
        llDisputesList = view.findViewById(R.id.ll_disputes_list);
        btnReportDispute = view.findViewById(R.id.btn_report_dispute);

        btnReportDispute.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ReportDisputeActivity.class);
            startActivity(intent);
        });

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        List<Dispute> disputes = DataManager.getInstance().getDisputes();
        if (tvActiveCount != null) {
            tvActiveCount.setText(String.valueOf(disputes.size()));
        }
        
        if (disputes.isEmpty()) {
            tvNoDisputes.setVisibility(View.VISIBLE);
        } else {
            tvNoDisputes.setVisibility(View.GONE);
            llDisputesList.removeAllViews();
            for (Dispute d : disputes) {
                View item = getLayoutInflater().inflate(R.layout.item_dispute, llDisputesList, false);
                ((TextView)item.findViewById(R.id.tv_dispute_id)).setText(d.getId());
                ((TextView)item.findViewById(R.id.tv_dispute_title)).setText(d.getTitle());
                ((TextView)item.findViewById(R.id.tv_dispute_desc)).setText(d.getDescription());
                ((TextView)item.findViewById(R.id.tv_dispute_amount)).setText(d.getAmount());
                llDisputesList.addView(item, 0);
            }
        }
    }
}