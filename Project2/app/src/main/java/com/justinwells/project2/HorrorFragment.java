package com.justinwells.project2;

import android.content.Context;
import android.os.AsyncTask;
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

public class HorrorFragment extends Fragment {
    Context context;
    MovieRecyclerViewAdapter adapter;
    List<Movie>scaryMovies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_top_rated,container,false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.top_rated);

        context = rootView.getContext();

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        fillHorrorList();

        adapter = new MovieRecyclerViewAdapter(scaryMovies);

        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void fillHorrorList(){
        AsyncTask<Void,Void,List<Movie>> task = new AsyncTask<Void, Void, List<Movie>>() {
            @Override
            protected List<Movie> doInBackground(Void... voids) {
                return MovieSQLiteOpenHelper.getInstance(context).getHorror();
            }

            @Override
            protected void onPostExecute(List<Movie> movies) {
                super.onPostExecute(movies);
                scaryMovies = movies;
            }
        };

        task.execute();


    }


    @Override
    public void onResume() {
        fillHorrorList();
        adapter.replaceData(scaryMovies);
        super.onResume();
    }
}

