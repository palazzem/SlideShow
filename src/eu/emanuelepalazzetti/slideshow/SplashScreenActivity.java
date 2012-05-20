package eu.emanuelepalazzetti.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class SplashScreenActivity extends Activity {
	private int timeout = 5000;
	private boolean enabled = true;
	private Thread splashThread = null;
	private String TAG = "Gallery";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);

		// Wait until timeout or touch event is fired
		splashThread = new Thread() {
			@Override
			public void run() {
				try {
					int now = 0;
					while (enabled && now < timeout) {
						sleep(100);
						now += 100;
					}
				} catch (InterruptedException e) {
					Log.d(TAG, "Error on sleep");
				} finally {
					// Close this activity
					finish();
					
					// Start gallery activity
					Intent intent = new Intent(SplashScreenActivity.this, GalleryActivity.class);
					startActivity(intent);
				}
			}
		};

		splashThread.start();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			enabled = false;
		}
		return true;
	}
}
