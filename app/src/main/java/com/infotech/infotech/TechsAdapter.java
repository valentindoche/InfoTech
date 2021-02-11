package com.infotech.infotech;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

import java.util.List;

public class TechsAdapter extends RecyclerView.Adapter<TechsAdapter.ViewHolder> {

    final List<String> techValueName;
    final List<String> techValueType;
    final List<String> techValueDescription;
    final List<String> techValueImg;
    final List<String> techValueJobs;
    final Context context;

    public TechsAdapter(Context ct, List<String> name,  List<String> type,  List<String> description,  List<String> img, List<String> jobs){
        context = ct;
        techValueName = name;
        techValueType = type;
        techValueDescription = description;
        techValueImg = img;
        techValueJobs = jobs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.tech_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.techName.setText(techValueName.get(position));
        holder.techDescription.setText(techValueDescription.get(position));
        holder.techJobs.setText(techValueJobs.get(position));

        holder.techCard.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", techValueName.get(position));
            intent.putExtra("description", techValueDescription.get(position));
            intent.putExtra("image", R.drawable.java);
            intent.putExtra("jobsCount", techValueJobs.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return techValueName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView techName;
        final TextView techDescription;
        final Chip techJobs;
        final LinearLayout techItemLayout;
        final MaterialCardView techCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            techName = itemView.findViewById(R.id.tech_name);
            techDescription = itemView.findViewById(R.id.tech_description);
            techJobs = itemView.findViewById(R.id.tech_offers);
            techItemLayout = itemView.findViewById(R.id.tech_item_layout);
            techCard = itemView.findViewById(R.id.tech_card);

        }
    }
}
