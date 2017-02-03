package br.com.cpbr.perguntas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.cpbr.perguntas.adapter.TopPlayersListAdapter;
import br.com.cpbr.perguntas.model.Player;
import br.com.cpbr.perguntas.util.PlayerUtil;
import br.com.cpbr.perguntas.view.DividerItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsActivity extends AppCompatActivity {

    @BindView(R.id.friends_recycler)
    RecyclerView friendsRecycler;

    private TopPlayersListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        ButterKnife.bind(this);

        setupAdapter();
    }

    private void setupAdapter() {
        adapter = new TopPlayersListAdapter(getPlayers());

        friendsRecycler.setHasFixedSize(true);
        friendsRecycler.setLayoutManager(new LinearLayoutManager(this));
        friendsRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutCompat.VERTICAL));
        friendsRecycler.setAdapter(adapter);
    }

    private List<Player> getPlayers() {
        List<Player> players = PlayerUtil.getPlayers();

        players.remove(0);
        players.remove(1);
        players.remove(1);
        players.remove(2);
        players.remove(2);
        players.remove(3);
        players.remove(3);
        return players;
    }
}
