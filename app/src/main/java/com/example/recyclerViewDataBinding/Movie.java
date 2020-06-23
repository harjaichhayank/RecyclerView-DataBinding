package com.example.recyclerViewDataBinding;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class Movie {
    private String Title,Rating;
    private int ImageId;

    public Movie(String title, String rating, int imageId) {
        setTitle(title);
        setRating(rating);
        setImageId(imageId);
    }

    public String getTitle() { return Title; }
    public int getImageId() { return ImageId; }
    public String getRating() { return Rating; }

    private void setTitle(String title) { Title = title; }
    private void setRating(String rating) { Rating = rating; }
    private void setImageId(int imageId) { ImageId = imageId; }

    @BindingAdapter("android:image")
    public static void loadImage(View view,int imageId){
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(),imageId));
    }
}
