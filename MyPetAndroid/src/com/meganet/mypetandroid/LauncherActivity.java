package com.meganet.mypetandroid;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class LauncherActivity extends Activity {
	
	Intent myIntent;
	ImageView staffImageView, starImageView, star2ImageView, starHalfImageView, starEmptyImageView, shieldImageView;
	DisplayMetrics metrics;
	int width;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay()
                .getMetrics(metrics);
        width = metrics.widthPixels;
		
		staffImageView = (ImageView) findViewById(R.id.staffImageViewId);
		starImageView = (ImageView) findViewById(R.id.starImageViewId);
		starHalfImageView = (ImageView) findViewById(R.id.starHalfImageViewId);
		starEmptyImageView = (ImageView) findViewById(R.id.starEmptyImageViewId);
		star2ImageView = (ImageView) findViewById(R.id.star2ImageViewId);
		shieldImageView = (ImageView) findViewById(R.id.shieldImageViewId);
		
		AnimatorSet staffSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,
				R.animator.staff_spin);
		
		staffSet.setTarget(staffImageView);
		staffSet.start();
		
		
		AnimatorSet shieldSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,
				R.animator.shield_spin);
		
		shieldSet.setTarget(shieldImageView);
		shieldSet.start();
		
		TranslateAnimation animationStar = new TranslateAnimation(50.0f, width - 250.0f,
	            80.0f, 120.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
		animationStar.setDuration(4000);  // animation duration 
		animationStar.setRepeatCount(TranslateAnimation.INFINITE);  
		animationStar.setRepeatMode(1);
	    starImageView.startAnimation(animationStar);  // start animation 

	    
		TranslateAnimation animationStar2 = new TranslateAnimation(50.0f, width - 250.0f,
	            50.0f, 90.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
		animationStar2.setDuration(3500);  // animation duration 
		animationStar2.setRepeatCount(TranslateAnimation.INFINITE);  
		animationStar2.setRepeatMode(1);
	    star2ImageView.startAnimation(animationStar2);  // start animation 
	    
		TranslateAnimation animationHalfStar = new TranslateAnimation(50.0f, width - 250.0f,
	            40.0f, 80.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
		animationHalfStar.setDuration(3000);  // animation duration 
		animationHalfStar.setRepeatCount(TranslateAnimation.INFINITE);  
		animationHalfStar.setRepeatMode(1);
	    starHalfImageView.startAnimation(animationHalfStar);  // start animation 
	    
	    
		TranslateAnimation animationEmptyStar = new TranslateAnimation(50.0f, width - 250.0f,
	            50.0f, 9.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
		animationEmptyStar.setDuration(2480);  // animation duration 
		animationEmptyStar.setRepeatCount(TranslateAnimation.INFINITE);  
		animationEmptyStar.setRepeatMode(1);
	    starEmptyImageView.startAnimation(animationEmptyStar);  // start animation 
		
		myIntent = new Intent(this, MainActivity.class);
		
	}
	public void nextButtonClick(View v) {
		this.startActivity(myIntent);
		finish();
	}
}
