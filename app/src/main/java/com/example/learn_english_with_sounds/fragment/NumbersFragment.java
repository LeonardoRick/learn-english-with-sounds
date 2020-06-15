package com.example.learn_english_with_sounds.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.learn_english_with_sounds.R;



public class NumbersFragment extends Fragment implements View.OnClickListener {

    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6;
    MediaPlayer mediaPlayer;
    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_numbers, container, false);

        imageButton1 = view.findViewById(R.id.imageButton1);
        imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton4 = view.findViewById(R.id.imageButton4);
        imageButton5 = view.findViewById(R.id.imageButton5);
        imageButton6 = view.findViewById(R.id.imageButton6);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);

        return view;
    }

    // Method useful to control mutiple clicks on different views
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton1:
                playSound(R.raw.one);
                break;
            case R.id.imageButton2:
                playSound(R.raw.two);
                break;
            case R.id.imageButton3:
                playSound(R.raw.three);
                break;
            case R.id.imageButton4:
                playSound(R.raw.four);
                break;
            case R.id.imageButton5:
                playSound(R.raw.five);
                break;
            case R.id.imageButton6:
                playSound(R.raw.six);
                break;
        }
    }

    public void playSound(Integer song) {
        Log.i("teste", song.toString());
        mediaPlayer = MediaPlayer.create(getActivity(), song);
        if(mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }
}