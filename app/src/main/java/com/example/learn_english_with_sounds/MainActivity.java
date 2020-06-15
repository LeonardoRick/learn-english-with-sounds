package com.example.learn_english_with_sounds;

import android.os.Bundle;

import com.example.learn_english_with_sounds.fragment.AnimalsFragment;
import com.example.learn_english_with_sounds.fragment.NumbersFragment;
import com.example.learn_english_with_sounds.fragment.VowelsFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide divider line between action bar and tabs
        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter adapter = setAdapter();
        SmartTabLayout viewPagerTab = findViewById(R.id.viewPagerTab);
        ViewPager viewPager = findViewById(R.id.viewPager);

        // Conecting components
        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);
    }

    /**
    * Create Tab structure
    */
    public FragmentPagerItemAdapter setAdapter() {
        return new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Animais", AnimalsFragment.class)
                        .add("Números", NumbersFragment.class)
                        .add("Vogais", VowelsFragment.class)
                .create()
        );
    }
}