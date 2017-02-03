package br.com.cpbr.perguntas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.cpbr.perguntas.R;
import br.com.cpbr.perguntas.adapter.TopPlayersListAdapter;
import br.com.cpbr.perguntas.model.Player;
import br.com.cpbr.perguntas.util.PlayerUtil;
import br.com.cpbr.perguntas.view.DividerItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TopPlayersFragment extends Fragment {

    @BindView(R.id.players_recycler)
    RecyclerView playersRecycler;

    private TopPlayersListAdapter adapter;

    public TopPlayersFragment() {
    }

    public static TopPlayersFragment newInstance() {
        return new TopPlayersFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new TopPlayersListAdapter(PlayerUtil.getPlayers());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_players, container, false);
        ButterKnife.bind(this, view);
        setupAdapter();
        return view;
    }

    private void setupAdapter() {
        playersRecycler.setHasFixedSize(true);
        playersRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        playersRecycler.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutCompat.VERTICAL));
        playersRecycler.setAdapter(adapter);
    }
}