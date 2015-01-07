package com.meganet.mypetandroid;

import java.io.IOException;
import java.io.InputStream;

import android.support.v7.app.ActionBarActivity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

	//Constants
	String eggImg = "egg.png";
	String loveButtonImg = "heart_red.png";
	
	ImageView petImageView, loveButtonImageView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup()
    {
    	petImageView = (ImageView) findViewById(R.id.petImageViewId);
    	petImageView.setImageBitmap(getBitmapFromAsset(eggImg));
    	
    	loveButtonImageView = (ImageView) findViewById(R.id.loveButtonImageViewId);
    	loveButtonImageView.setImageBitmap(getBitmapFromAsset(loveButtonImg));
    }
    // Helper
    private Bitmap getBitmapFromAsset(String fileName)
    {
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
    
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
