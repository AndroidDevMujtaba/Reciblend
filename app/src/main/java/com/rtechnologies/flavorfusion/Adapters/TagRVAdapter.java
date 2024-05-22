package com.rtechnologies.flavorfusion.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rtechnologies.flavorfusion.R;

import java.util.List;

public class TagRVAdapter extends RecyclerView.Adapter<TagRVAdapter.TagViewHolder> {

    private List<String> tagList;

    public TagRVAdapter(List<String> tagList) {
        this.tagList = tagList;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.generate_recyclerview_design, parent, false);
        return new TagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
        String tag = tagList.get(position);
        holder.tagText.setText(tag);
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public class TagViewHolder extends RecyclerView.ViewHolder {
        public TextView tagText;
        public ImageView removeButton;

        public TagViewHolder(View itemView) {
            super(itemView);

            tagText = itemView.findViewById(R.id.tagText);
            removeButton = itemView.findViewById(R.id.removeButton);

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        tagList.remove(position);
                        notifyItemRemoved(position);
                    }
                }
            });
        }
    }
    public void addTag(String tag) {
        tagList.add(tag);
        notifyItemInserted(tagList.size() - 1);
    }
}






