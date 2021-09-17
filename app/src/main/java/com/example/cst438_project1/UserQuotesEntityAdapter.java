package com.example.cst438_project1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cst438_project1.database.UserQuotesEntity;

import java.util.ArrayList;
import java.util.List;

public class UserQuotesEntityAdapter extends RecyclerView.Adapter<UserQuotesEntityAdapter.UserQuotesEntityHolder> {
    List<UserQuotesEntity> userFavoriteQuotes = new ArrayList<>();

    @NonNull
    @Override
    public UserQuotesEntityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.item_no_button, parent, false);

        return new UserQuotesEntityAdapter.UserQuotesEntityHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserQuotesEntityHolder holder, int position) {
        UserQuotesEntity currentEntity = userFavoriteQuotes.get(position);

        holder.textViewAnime.setText(currentEntity.getTitle());
        holder.textViewCharacter.setText(currentEntity.getCharName());
        holder.textViewQuote.setText(currentEntity.getQuote());
    }

    @Override
    public int getItemCount() {
        return userFavoriteQuotes.size();
    }

    public void setQuotes(List<UserQuotesEntity> quotes) {
        this.userFavoriteQuotes = quotes;

        notifyDataSetChanged();
    }


    class UserQuotesEntityHolder extends RecyclerView.ViewHolder{
        private TextView textViewAnime;
        private TextView textViewCharacter;
        private TextView textViewQuote;

        public UserQuotesEntityHolder(@NonNull View itemView) {
            super(itemView);

            textViewAnime = itemView.findViewById(R.id.itemNoButton_anime);
            textViewCharacter = itemView.findViewById(R.id.itemNoButton_character);
            textViewQuote = itemView.findViewById(R.id.itemNoButton_quote);
        }
    }
}
