package com.example.cst438_project1;

import android.view.LayoutInflater;
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
        View itemView = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.item, parent, false);

        return new QuoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteHolder holder, int position) {
        Quote currentQuote = quotes.get(position);

        holder.textViewAnime.setText(currentQuote.getAnime());
        holder.textViewCharacter.setText(currentQuote.getCharacter());
        holder.textViewQuote.setText(currentQuote.getQuote());
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;

        notifyDataSetChanged();
    }

    class QuoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewAnime;
        private TextView textViewCharacter;
        private TextView textViewQuote;

        public QuoteHolder(@NonNull View itemView) {
            super(itemView);

            textViewAnime = itemView.findViewById(R.id.item_anime);
            textViewCharacter = itemView.findViewById(R.id.item_character);
            textViewQuote = itemView.findViewById(R.id.item_quote);
        }
    }
}
