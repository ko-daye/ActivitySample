package com.example.activitysample;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button but = (Button) findViewById(R.id.button1);
		but.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SubActivity.class));
			}
		});
		setImage();
	}

	int[] images = new int[] { R.drawable.ic_launcher, R.drawable.droid_1,
			R.drawable.droid2 };
	int imageResource = -1;
	ImageView mImageView = null;

	private void setImage() {

		mImageView = (ImageView) findViewById(R.id.imageView1);
		Button mbutton = (Button) findViewById(R.id.button2);
		mbutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Random rand = new Random();
				imageResource = images[Math.abs(rand.nextInt()) % images.length];
				mImageView.setImageResource(imageResource);
			}
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
//		if (imageResource != -1) {
//			outState.putInt("imageResource", imageResource);
//		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

//		if (savedInstanceState != null) {
//			imageResource = savedInstanceState.getInt("imageResource");
//			mImageView.setImageResource(imageResource);
//		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
