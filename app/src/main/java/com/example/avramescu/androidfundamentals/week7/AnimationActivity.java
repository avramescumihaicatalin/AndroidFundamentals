package com.example.avramescu.androidfundamentals.week7;

import android.graphics.drawable.AnimationDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.avramescu.androidfundamentals.R;

public class AnimationActivity extends AppCompatActivity {

    LinearLayout mLiearLayoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();
        setAnimation();
    }

    private void setAnimation() {
        AnimationDrawable animationDrawable = (AnimationDrawable) mLiearLayoutAnimation.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
    }

    private void initView() {
        mLiearLayoutAnimation = findViewById(R.id.linear_layout_animation);
    }
}
