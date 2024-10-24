package com.shrey.calculatorgdsc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.MyViewHolder> {

    //Adapter class is responsible for connecting data sources and UI/FrontEnd
    Context context;
    ArrayList<HistoryItemModel> historyItemModels;

    public recyclerViewAdapter(Context context, ArrayList<HistoryItemModel> historyItemModels) {
        this.context = context;
        this.historyItemModels = historyItemModels;

    }

    @NonNull
    @Override
    //This is where we inflate the layout(Giving a look to our rows)
    public recyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.reyclerview_row, parent, false);
        return new recyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    //Assigning data to the views created in recyclerview_row file based on the position of recycler view
    public void onBindViewHolder(@NonNull recyclerViewAdapter.MyViewHolder holder, int position) {
        holder.historyItem.setText(historyItemModels.get(position).getHistoryText());
    }

    @Override
    //For the recycler view to know the number of items you want displayed
    public int getItemCount() {
        return historyItemModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //Grabbing views from recyclerView_rows layout file like in OnCreate method

        TextView historyItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            historyItem = itemView.findViewById(R.id.historyItem);

        }
    }

}
