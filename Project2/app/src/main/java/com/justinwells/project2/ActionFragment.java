package com.justinwells.project2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.justinwells.project2.RecyclerView.MovieRecyclerViewAdapter;

import java.util.List;

/**
 * Created by justinwells on 11/7/16.
 */

public class ActionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_top_rated,container,false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.top_rated);


        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<Movie> actionMovies = MovieSQLiteOpenHelper.getInstance(rootView.getContext()).getAction();

        recyclerView.setAdapter(new MovieRecyclerViewAdapter(actionMovies));

        return rootView;    }
}
