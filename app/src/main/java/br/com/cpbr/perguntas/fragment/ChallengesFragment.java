package br.com.cpbr.perguntas.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.cpbr.perguntas.R;

public class ChallengesFragment extends Fragment {

    public ChallengesFragment() {
    }

    public static ChallengesFragment newInstance() {
        return new ChallengesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_challenges, container, false);
    }
}