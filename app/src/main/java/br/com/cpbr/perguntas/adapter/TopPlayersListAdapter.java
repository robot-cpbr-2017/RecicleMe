package br.com.cpbr.perguntas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.cpbr.perguntas.R;
import br.com.cpbr.perguntas.model.Player;
import br.com.cpbr.perguntas.util.StringUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class TopPlayersListAdapter extends RecyclerView.Adapter<TopPlayersListAdapter.ViewHolder> {

    private List<Player> players;

    public TopPlayersListAdapter(List<Player> players) {
        this.players = players;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_players, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Player player = players.get(position);

        Glide.with(holder.itemView.getContext()).load(player.getImage()).into(holder.playerImage);
        holder.playerName.setText(player.getName());
        holder.pointsAmount.setText(StringUtil.userPointsToString(holder.itemView.getContext(), player.getPointsAmount()));
        holder.productsAcquired.setText(StringUtil.userProductsAcquiredToString(holder.itemView.getContext(), player.getProductsAcquired()));
        holder.playerRank.setText(String.valueOf(player.getRank()));
    }

    @Override
    public int getItemCount() {
        return players == null ? 0 : players.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_image)
        CircleImageView playerImage;

        @BindView(R.id.user_name)
        TextView playerName;

        @BindView(R.id.points_amount)
        TextView pointsAmount;

        @BindView(R.id.products_acquired)
        TextView productsAcquired;

        @BindView(R.id.user_rank)
        TextView playerRank;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}