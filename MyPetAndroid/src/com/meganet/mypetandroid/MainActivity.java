package com.meganet.mypetandroid;

import java.io.IOException;
import java.io.InputStream;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private int count = 0;
	private long startMillis = 0;

	String eggImg = "egg.png";
	ImageView petImageView;

	private SensorManager mSensorManager;
	private ShakeEventListener mSensorListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setup();

		AnimatorSet eggSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,
				R.animator.egg_spin);
		eggSet.setTarget(petImageView);
		eggSet.start();

		petImageView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int eventaction = event.getAction();
				if (eventaction == MotionEvent.ACTION_UP) {
					long time = System.currentTimeMillis();
					if (startMillis == 0 || (time - startMillis > 3000)) {
						startMillis = time;
						count = 1;
					}
					else {
						count++;
					}
					if (count == 5) {
						Toast.makeText(v.getContext(),
								"You touch me so fast laaa", Toast.LENGTH_LONG)
								.show();
					}
				}

				/* Swipe effect */
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
//					Toast.makeText(v.getContext(),
//							"Action down,..." + event.getX(), Toast.LENGTH_LONG)
//							.show();
					break;
				case MotionEvent.ACTION_MOVE:

					break;
				case MotionEvent.ACTION_UP:
					v.performClick();
//					Toast.makeText(v.getContext(),
//							"Action up,..." + event.getY(), Toast.LENGTH_LONG)
//							.show();
					break;
				default:
					return false;
				}
				v.invalidate();
				/* End swipe effect */
				return true;
			}
		});

		/* Shake event */
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensorListener = new ShakeEventListener();

		mSensorListener
				.setOnShakeListener(new ShakeEventListener.OnShakeListener() {

					public void onShake() {
						Toast.makeText(MainActivity.this, "Shake!",
								Toast.LENGTH_SHORT).show();
					}
				});

	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(mSensorListener,
				mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		mSensorManager.unregisterListener(mSensorListener);
		super.onPause();
	}

	private void setup() {
		petImageView = (ImageView) findViewById(R.id.petImageViewId);
		petImageView.setImageBitmap(getBitmapFromAsset(eggImg));
	}

	// Helper
	private Bitmap getBitmapFromAsset(String fileName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;
		try {
			istr = assetManager.open(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}

	public void poopButtonClick(View v) {
		Toast.makeText(v.getContext(), "Poop -1", Toast.LENGTH_LONG).show();
	}

	public void loveButtonClick(View v) {
		Toast.makeText(v.getContext(), "Heart +1", Toast.LENGTH_LONG).show();
	}

	public void eatButtonClick(View v) {
		Toast.makeText(v.getContext(), "Eat +1", Toast.LENGTH_LONG).show();
	}

	public void skillButtonClick(View v) {
		Toast.makeText(v.getContext(), "Skill +1", Toast.LENGTH_LONG).show();
	}

	public void healButtonClick(View v) {
		Toast.makeText(v.getContext(), "Heal +1 - Earning by getting enough sleep (6 to 7 hours/night)", Toast.LENGTH_LONG).show();
	}

	public void sleepButtonClick(View v) {
		Toast.makeText(v.getContext(), "Turn off - Are you sure? You can't turn it on by the next 6/7 hours", Toast.LENGTH_LONG).show();
	}

}
