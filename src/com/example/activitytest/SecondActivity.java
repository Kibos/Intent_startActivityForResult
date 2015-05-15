package com.example.activitytest;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	TextView textView1, textView2, textView4;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);

		Button button1 = (Button) findViewById(R.id.button1);
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView4 = (TextView) findViewById(R.id.textView4);

		Intent intent = getIntent();
		final String data1 = intent.getStringExtra("data1");
		final String data2 = intent.getStringExtra("data2");

		textView1.setText(data1);
		textView2.setText(data2);
		button1.setOnClickListener(new OnClickListener() {
			String dataString = String.valueOf(Integer.parseInt(data1)
					+ Integer.parseInt(data2));

			@Override
			public void onClick(View arg0) {
				textView4.setText(dataString);

				// Intent intent1 = new Intent(SecondActivity.this,
				// FirstActivity.class);
				// intent1.putExtra("dataString", dataString);
				// startActivity(intent1);
				
				  TimerTask task = new TimerTask(){  
					      public void run(){  
					    		Uri uri = Uri.parse(dataString);
								Intent intent1 = new Intent(null, uri);
								setResult(RESULT_OK, intent1);
								    

								finish(); 
					        }  
					   };  
					Timer timer = new Timer();
					      timer.schedule(task, 3000);
			

			}

		});

	}

	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", textView4.getText().toString());

		setResult(2, intent);
		// startActivityForResult(intent,RESULT_OK);
		Log.v("RESULT_OK textView4", textView4.getText().toString());
		finish();
	}
}
