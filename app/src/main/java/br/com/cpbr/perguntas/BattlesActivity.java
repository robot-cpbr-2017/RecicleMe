package br.com.cpbr.perguntas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.cpbr.perguntas.adapter.BattleListAdapter;
import br.com.cpbr.perguntas.model.Battle;
import br.com.cpbr.perguntas.view.DividerItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BattlesActivity extends AppCompatActivity {

    @BindView(R.id.battles_recycler)
    RecyclerView battlesRecycler;

    BattleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battles);
        ButterKnife.bind(this);

        setUpAdapter();
    }

    private void setUpAdapter() {
        List<Battle> battles = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Battle battle = new Battle();
            battles.add(battle);
        }

        adapter = new BattleListAdapter(battles);

        battlesRecycler.setHasFixedSize(true);
        battlesRecycler.setLayoutManager(new LinearLayoutManager(this));
        battlesRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutCompat.VERTICAL));
        battlesRecycler.setAdapter(adapter);

    }
}