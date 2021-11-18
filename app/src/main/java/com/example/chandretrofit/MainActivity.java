package com.example.chandretrofit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ListView superListView;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superListView = findViewById(R.id.superListView);

        getSuperHeroes();
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void getSuperHeroes() {
        retrofit2.Call<List<Result>> call = Retrofitclient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Result>> call, Response<List<Result>> response) {
                List<Result> myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getName();
                }

                superListView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));

            }

            @Override
            public void onFailure(retrofit2.Call<List<Result>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();

            }

        });
    }
}