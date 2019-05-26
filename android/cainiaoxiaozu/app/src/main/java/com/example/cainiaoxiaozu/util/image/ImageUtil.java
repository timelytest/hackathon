package com.example.cainiaoxiaozu.util.image;

import android.widget.ImageView;

import com.example.cainiaoxiaozu.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

public class ImageUtil {

    private static Picasso picasso = Picasso.get();

    public static void loadImage(String imageUrl, ImageView imageView) {
        picasso.load(imageUrl).placeholder(R.drawable.ic_broken_image_white_48dp).fit().centerCrop().into(imageView);
    }

    public static void transform(String imageUrl, List<Transformation> tf, ImageView imageView){
        picasso.load(imageUrl).transform(tf).into(imageView);
    }
}
