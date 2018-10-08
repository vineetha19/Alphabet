package com.thirudetails.alphabet;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/*
 * Created by welcome on 12/18/2017.
 */

public class ImageOpenAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    ArrayList<String> imagePaths = new ArrayList<>();
//    private AdView mAdView;

    Integer[] imageAlphabet = {R.drawable.pack1d1, R.drawable.pack1d2, R.drawable.pack1d3, R.drawable.pack1d4, R.drawable.pack1d5,
            R.drawable.pack1d6, R.drawable.pack1d7, R.drawable.pack1d8, R.drawable.pack1d9, R.drawable.pack1d10,
            R.drawable.pack1d11, R.drawable.pack1d12, R.drawable.pack1d13, R.drawable.pack1d14, R.drawable.pack1d15,
            R.drawable.pack1d16, R.drawable.pack1d17, R.drawable.pack1d18, R.drawable.pack1d19, R.drawable.pack1d20,
            R.drawable.pack1d21, R.drawable.pack1d22, R.drawable.pack1d23, R.drawable.pack1d24, R.drawable.pack1d25,R.drawable.pack1d26};
    public ImageOpenAdapter(AlphabetActivity imageOpeningActivity, ArrayList<String> imagePaths) {
        context = imageOpeningActivity;
        this.imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return imageAlphabet.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.image_open_item, null);
        ImageView imageView =  view.findViewById(R.id.imageView);
        imageView.setImageResource(imageAlphabet[position]);



        ViewPager vp = (ViewPager) container;

        vp.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
