package com.software.tempe.gitsocial;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.software.tempe.gitsocial.adapter.UserAdapter;
import com.software.tempe.gitsocial.common.Common;
import com.software.tempe.gitsocial.model.User;
import com.software.tempe.gitsocial.model.UserList;
import com.software.tempe.gitsocial.service.UserAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager layoutManager;

    private Toolbar toolbar;

    private RecyclerView recycler_main;
    private UserAdapter adapter;

    private UserAPI userAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recycler_main = findViewById(R.id.recycler_main);
        recycler_main.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_main.setLayoutManager(layoutManager);

        userAPI = Common.getUserAll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search_action).getActionView();
        MenuItem searchMenu = menu.findItem(R.id.search_action);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search Github User");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.length() > 2) {
                    loadUser(s);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        searchMenu.getIcon().setVisible(false, false);

        return true;
    }

    private void loadUser(String s) {
        userAPI.getUser(Common.getUser(s))
                .enqueue(new Callback<UserList>() {
                    @Override
                    public void onResponse(Call<UserList> call, Response<UserList> response) {
                        List<User> users = response.body().getItems();

                        adapter = new UserAdapter(getBaseContext(), users);
                        adapter.notifyDataSetChanged();
                        recycler_main.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<UserList> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Request limit!" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
