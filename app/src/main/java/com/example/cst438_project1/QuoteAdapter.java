package com.example.cst438_project1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteHolder> {
    private List<Quote> quotes = new ArrayList<>();

    @NonNull
    @Override
    public QuoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class QuoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewAuthor;
        private TextView textViewQuote;

        public QuoteHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.item_anime);
            textViewAuthor = itemView.findViewById(R.id.item_character);
            textViewQuote = itemView.findViewById(R.id.item_quote);
        }
    }
}
