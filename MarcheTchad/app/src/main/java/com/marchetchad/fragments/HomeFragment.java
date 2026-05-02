package com.marchetchad.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.marchetchad.R;
import com.marchetchad.data.DataManager;
import com.marchetchad.data.Transaction;
import java.util.List;

public class HomeFragment extends Fragment {

    private TextView tvScoreValue, tvSalesToday, tvOrdersCount;
    private ProgressBar progressScore;
    private LinearLayout llActivities;
    private TextView tvNoActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvScoreValue = view.findViewById(R.id.tv_score_value);
        tvSalesToday = view.findViewById(R.id.tv_sales_today);
        tvOrdersCount = view.findViewById(R.id.tv_orders_count);
        progressScore = view.findViewById(R.id.progress_score);
        llActivities = view.findViewById(R.id.ll_activities);
        tvNoActivity = view.findViewById(R.id.tv_no_activity);

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        DataManager dm = DataManager.getInstance();
        
        if (tvScoreValue != null) {
            tvScoreValue.setText(dm.getScore() + "\n/ 1000");
            progressScore.setProgress(dm.getScore());
        }
        
        if (tvSalesToday != null) {
            tvSalesToday.setText(String.format("%,.0f", dm.getTotalSalesToday()));
        }
        
        if (tvOrdersCount != null) {
            tvOrdersCount.setText(String.valueOf(dm.getTransactions().size()));
        }

        updateActivityList();
    }

    private void updateActivityList() {
        List<Transaction> transactions = DataManager.getInstance().getTransactions();
        if (transactions.isEmpty()) {
            tvNoActivity.setVisibility(View.VISIBLE);
        } else {
            tvNoActivity.setVisibility(View.GONE);
            // Clear existing except tvNoActivity if needed, but for demo we just show them
            // In a real app we'd use a RecyclerView
            llActivities.removeAllViews();
            for (Transaction t : transactions) {
                View item = getLayoutInflater().inflate(R.layout.item_activity, llActivities, false);
                TextView title = item.findViewById(R.id.tv_item_title);
                TextView amount = item.findViewById(R.id.tv_item_amount);
                title.setText("Vente : " + t.getBuyerName());
                amount.setText(String.format("+%,.0f F", t.getAmount()));
                llActivities.addView(item, 0); // Add at top
            }
        }
    }
}