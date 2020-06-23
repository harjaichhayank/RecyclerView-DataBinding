package com.example.recyclerViewDataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.example.recyclerViewDataBinding.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.RecyclerViewId.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.RecyclerViewId.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(this,prepareMovie());
        mainBinding.RecyclerViewId.setAdapter(adapter);
    }

    private List<Movie> prepareMovie(){
        String[] names = getResources().getStringArray(R.array.Top_10_movies);
        List<String> ratings = Arrays.asList(getResources().getStringArray(R.array.Movie_ratings));

        int[] imageId = {R.drawable.movie_1,R.drawable.movie_2,R.drawable.movie_3,R.drawable.movie_4,R.drawable.movie_5,
                        R.drawable.movie_6,R.drawable.movie_7,R.drawable.movie_8, R.drawable.movie_9,R.drawable.movie_10,
                        R.drawable.movie_11,R.drawable.movie_12,R.drawable.movie_13,R.drawable.movie_14,R.drawable.movie_15,
                        R.drawable.movie_16,R.drawable.movie_17,R.drawable.movie_18,R.drawable.movie_19,R.drawable.movie_20,
                        R.drawable.movie_21};

        List<Movie> Names = new ArrayList<>();
        int count = 0;

        for(String name: names){
            Names.add(new Movie(name,ratings.get(count),imageId[count]));
            count++;
        }
        return Names;
    }
}
