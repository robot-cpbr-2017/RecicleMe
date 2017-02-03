package br.com.cpbr.perguntas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.cpbr.perguntas.R;
import br.com.cpbr.perguntas.model.Battle;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class BattleListAdapter extends RecyclerView.Adapter<BattleListAdapter.ViewHolder> {

    private List<Battle> battles;

    public BattleListAdapter(List<Battle> battles) {
        this.battles = battles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_battle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load("http://saranossaterra.com.br/content/uploads/2015/04/Chuck-Norris-CelebHealthy_com.jpg").into(holder.userImage);
        Glide.with(holder.itemView.getContext()).load("http://www.osul.com.br/wp-content/uploads/2016/10/donald.jpg").into(holder.enemyImage);
    }

    @Override
    public int getItemCount() {
        return battles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.result)
        TextView result;

        @BindView(R.id.user_image)
        CircleImageView userImage;

        @BindView(R.id.enemy_image)
        CircleImageView enemyImage;

        @BindView(R.id.user_name)
        TextView userName;

        @BindView(R.id.enemy_name)
        TextView enemyName;

        @BindView(R.id.user_wins)
        TextView userWins;

        @BindView(R.id.user_loss)
        TextView userLoss;

        @BindView(R.id.enemy_wins)
        TextView enemyWins;

        @BindView(R.id.enemy_loss)
        TextView enemyLoss;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
