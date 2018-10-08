package com.thirudetails.alphabet;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/*
 * Created by welcome on 2/2/2018.
 */

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MyViewHolder> {

    private Context context;
    private String[] alphabet;
    int [] songs = {R.raw.pack1s1, R.raw.pack1s2, R.raw.pack1s3, R.raw.pack1s4, R.raw.pack1s5,
            R.raw.pack1s6, R.raw.pack1s7, R.raw.pack1s8, R.raw.pack1s9, R.raw.pack1s10,
            R.raw.pack1s11, R.raw.pack1s12, R.raw.pack1s13, R.raw.pack1s14, R.raw.pack1s15,
            R.raw.pack1s16, R.raw.pack1s17, R.raw.pack1s18, R.raw.pack1s19, R.raw.pack1s20,
            R.raw.pack1s21, R.raw.pack1s22, R.raw.pack1s23, R.raw.pack1s24, R.raw.pack1s25,R.raw.pack1s26};
    public MediaAdapter(Context context, String[] alphabet) {

        this.alphabet = alphabet;
        this.context = context;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        Button letter;

        public MyViewHolder(View itemView) {
            super(itemView);
            letter = itemView.findViewById(R.id.letter);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alphabet_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.letter.setText(alphabet[position]);
        holder.letter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(context, AlphabetActivity.class);
                sendIntent.putExtra(Constants.KEY_ARRAY_IMAGE, String.valueOf(position));
                Constants.setPrefernc(context, Constants.POSITION, String.valueOf(position));
                MediaPlayer mediaPlayer= MediaPlayer.create(context,songs[position]);

                mediaPlayer.start();
                context.startActivity(sendIntent);
                }

        });

    }

//   apply(new RequestOptions().override(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)).transition(DrawableTransitionOptions.withCrossFade(300))




    @Override
    public int getItemCount() {
        return alphabet.length;
    }

}
