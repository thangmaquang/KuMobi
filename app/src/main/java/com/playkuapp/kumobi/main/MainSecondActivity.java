package com.playkuapp.kumobi.main;


import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.playkuapp.kumobi.R;
import com.playkuapp.kumobi.base.BaseActivity;
import com.playkuapp.kumobi.webview.WebViewActivity;

public class MainSecondActivity extends BaseActivity {
    int type = 0;
    boolean isOnline;
    ImageView imgLogo;
//    ImageView imgSupport;
    Animation.AnimationListener listener;
    Button btnLogin, btnSignIn;
//    RippleBackground rippleBackground, rippleBackground1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        setupWindowAnimations();
        btnLogin = findViewById(R.id.btnLogin);
        btnSignIn = findViewById(R.id.btnSignIn);
//        imgSupport = findViewById(R.id.imgSupport);
        imgLogo = findViewById(R.id.imgLogo);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline){
                    Intent intent = new Intent(MainSecondActivity.this, WebViewActivity.class);
                    intent.putExtra("home", "https://kumobi.app/dang-ky");
                    transitionTo(intent);
                }else {
                    openDialog(MainSecondActivity.this);
                }
            }
        });
//        imgSupport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isOnline){
//                    Intent intent = new Intent(MainSecondActivity.this, WebViewActivity.class);
//                    intent.putExtra("home", "https://kumobi.app/");
//                    transitionTo(intent);
//                }else {
//                    openDialog(MainSecondActivity.this);
//                }
//            }
//        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline){
                    Intent intent = new Intent(MainSecondActivity.this, WebViewActivity.class);
                    intent.putExtra("home", "https://ff3185.ku11.net");
                    transitionTo(intent);
                }else {
                    openDialog(MainSecondActivity.this);
                }
            }
        });
//        rippleBackground = findViewById(R.id.content);
//        rippleBackground.startRippleAnimation();
//        rippleBackground1 = findViewById(R.id.content1);
//        rippleBackground1.startRippleAnimation();

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadAnimations();
    }


    @Override
    protected void haveConnect() {
        isOnline = true;
    }

    @Override
    protected void dontHaveConnect() {
        isOnline = false;
    }

    private void setupWindowAnimations() {
        Transition transition;

        if (type == TYPE_PROGRAMMATICALLY) {
            transition = buildEnterTransition();
        } else {
            transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_bottom);
        }
        getWindow().setEnterTransition(transition);
    }

    void loadAnimations() {
        new AnimationUtils();
        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);
        rotation.setAnimationListener(listener);
        imgLogo.startAnimation(rotation);
    }

    private Visibility buildEnterTransition() {
        Slide enterTransition = new Slide();
        enterTransition.setDuration(500);
        enterTransition.setSlideEdge(Gravity.RIGHT);
        return enterTransition;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
