package com.github.posko.pos.ui.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PoweredAdapter <Model, ViewHolder extends PoweredAdapter.BaseViewHolder> extends RecyclerView.Adapter<ViewHolder> {

    @NonNull
    private Context context;
    private List<Model> items = new ArrayList<>();
    private OnItemClickLIstener onItemClickLIstener;

    public PoweredAdapter(Context context, List<Model> items) {
        this.context = context;
        this.items = items;
    }

    public void setOnItemClickLIstener(OnItemClickLIstener onItemClickLIstener) {
        this.onItemClickLIstener = onItemClickLIstener;
    }

    public OnItemClickLIstener getOnItemClickLIstener() {
        return onItemClickLIstener;
    }

    public Context getContext() {
        return context;
    }

    public List<Model> getItems() {
        return items;
    }

    public void setItems(List<Model> items) {
        this.items = items;
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private View itemView;
        private OnItemClickLIstener onItemClickLIstener;

        public BaseViewHolder(@NonNull View itemView, OnItemClickLIstener onItemClickLIstener) {
            super(itemView);
            this.itemView = itemView;
            this.itemView.setOnClickListener(this);
            this.itemView.setOnLongClickListener(this);
            this.onItemClickLIstener = onItemClickLIstener;
        }

        @Override
        public void onClick(View view) {
            if(onItemClickLIstener != null) onItemClickLIstener.onitemClicked(view, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            if(onItemClickLIstener != null) onItemClickLIstener.onItemLongClicked(view, getAdapterPosition());
            return true;
        }
    }
}
