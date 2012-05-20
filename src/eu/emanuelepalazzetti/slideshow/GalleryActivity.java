package eu.emanuelepalazzetti.slideshow;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;

public class GalleryActivity extends Activity {
	private Gallery imageGallery = null;
	private ImageView image = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imageGallery = (Gallery) findViewById(R.id.imageGallery);
		image = (ImageView) findViewById(R.id.image);

		// Set gallery adapter
		imageGallery.setAdapter(new ImageAdapter(this));
		imageGallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position,
					long id) {
				ImageAdapter adapter = (ImageAdapter) imageGallery.getAdapter();
				int idRes = adapter.getImage(position);
				image.setImageResource(idRes);
			}
		});
	}
}