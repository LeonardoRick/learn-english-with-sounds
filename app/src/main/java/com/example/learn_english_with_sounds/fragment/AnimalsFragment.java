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

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class AnimalsFragment extends Fragment implements View.OnClickListener {


    private ImageButton imageButtonDog, imageButtonCat, imageButtonMonkey,
                            imageButtonLion, imageButtonCow, imageButtonSheep;

    private MediaPlayer mediaPlayer = new MediaPlayer();
    public AnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);


        imageButtonDog = view.findViewById(R.id.imageButtonDog);
        imageButtonCat = view.findViewById(R.id.imageButtonCat);
        imageButtonMonkey = view.findViewById(R.id.imageButtonMonkey);
        imageButtonLion = view.findViewById(R.id.imageButtonLion);
        imageButtonCow = view.findViewById(R.id.imageButtonCow);
        imageButtonSheep = view.findViewById(R.id.imageButtonSheep);


        imageButtonDog.setOnClickListener(this);
        imageButtonCat.setOnClickListener(this);
        imageButtonMonkey.setOnClickListener(this);
        imageButtonLion.setOnClickListener(this);
        imageButtonCow.setOnClickListener(this);
        imageButtonSheep.setOnClickListener(this);

        return view;
    }

    // Method useful to control mutiple clicks on different views
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButtonDog:
                playSound(R.raw.dog);
                break;
            case R.id.imageButtonCat:
                playSound(R.raw.cat);
                break;
            case R.id.imageButtonMonkey:
                playSound(R.raw.monkey);
                break;
            case R.id.imageButtonLion:
                playSound(R.raw.lion);
                break;
            case R.id.imageButtonCow:
                playSound(R.raw.cow);
                break;
            case R.id.imageButtonSheep:
                playSound(R.raw.sheep);
                break;
        }
    }

    public void playSound(Integer song) {
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