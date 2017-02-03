package br.com.cpbr.perguntas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.cpbr.perguntas.adapter.MainFragmentPagerAdapter;
import br.com.cpbr.perguntas.fragment.ChallengesFragment;
import br.com.cpbr.perguntas.fragment.TopPlayersFragment;
import br.com.cpbr.perguntas.fragment.TopProductsFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.main_viewpager)
    ViewPager mainViewPager;

    @BindView(R.id.main_tabs)
    TabLayout mainTabs;

    @BindView(R.id.challenge_fab)
    FloatingActionButton challengeFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mainTabs.addOnTabSelectedListener(this);
        setupViewPager();
    }

    private void setupViewPager() {
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTabs));

        String[] mainTabsArray = getResources().getStringArray(R.array.main_tabs);
        List<String> mainTabList = Arrays.asList(mainTabsArray);

        adapter.addFragment(ChallengesFragment.newInstance(), mainTabList.get(0));
        adapter.addFragment(TopPlayersFragment.newInstance(), mainTabList.get(1));
        adapter.addFragment(TopProductsFragment.newInstance(), mainTabList.get(2));

        mainViewPager.setAdapter(adapter);
        mainTabs.setupWithViewPager(mainViewPager);
    }

    @OnClick(R.id.challenge_fab)
    void onChallengeClicked(FloatingActionButton fab) {
        Toast.makeText(this, "Implementar desafios", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_friends) {
            startActivity(new Intent(this, FriendsActivity.class));
        } else if (id == R.id.nav_battles) {
            startActivity(new Intent(this, BattlesActivity.class));
        } else if (id == R.id.nav_products) {
            startActivity(new Intent(this, ProductsActivity.class));
        } else if (id == R.id.nav_share) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Eu te desafio a me vencer o Recicle me eai ta afim?");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_logout) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mainViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
}