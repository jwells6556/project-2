package com.justinwells.project2;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.justinwells.project2.RecyclerView.MovieRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchableActivity extends AppCompatActivity {
    private RecyclerView searchResults;
    private MovieRecyclerViewAdapter adapter;
    List<Movie>results;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        searchResults = (RecyclerView) findViewById(R.id.search_results);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        adapter = new MovieRecyclerViewAdapter(new ArrayList<Movie>());

        searchResults.setLayoutManager(layoutManager);
        searchResults.setAdapter(adapter);

        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.back);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        handleIntent(getIntent());
    }



    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent (Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            getResults(query);

            if (results != null) {
                adapter.replaceData(results);
            }

        }
    }

    public void getResults(String query) {
        AsyncTask <String, Void, List<Movie>> task = new AsyncTask<String, Void, List<Movie>>() {
            @Override
            protected List<Movie> doInBackground(String... strings) {
                return MovieSQLiteOpenHelper.getInstance(context).searchMovies(strings[0]);
            }

            @Override
            protected void onPostExecute(List<Movie> movies) {
                results = movies;
            }
        };

        task.execute(query);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        ComponentName componentName = new ComponentName(this,SearchableActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));


        return true;
    }
}
