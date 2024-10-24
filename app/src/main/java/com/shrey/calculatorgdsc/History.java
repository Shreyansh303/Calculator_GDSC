package com.shrey.calculatorgdsc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    private Button backButton;
    private RecyclerView recyclerView;

    private Bundle bundle;
    private List<String> historyList;
    private ArrayList<HistoryItemModel> historyItemModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        backButton = findViewById(R.id.backButton);
        recyclerView = findViewById(R.id.recyclerView);

        bundle = getIntent().getExtras();
        assert bundle != null;
        historyList = bundle.getStringArrayList("History");

        setUpHistoryItemModels();

        recyclerViewAdapter adapter = new recyclerViewAdapter(this, historyItemModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(History.this, MainActivity.class);
            startActivity(intent);
        });

    }

    private void setUpHistoryItemModels() {
        for (int index = 0; index < historyList.size() ; index++) {
            historyItemModels.add(new HistoryItemModel(historyList.get(index)));
        }
    }

}