package com.example.activitytest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends Activity {

	EditText editText1, editText2;
	TextView textView3 ,textView7,textView6;
	String data1, data2;
	static final int sun1 = 1;
	static final int sun2 = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);

		Button button1 = (Button) findViewById(R.id.button1);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		textView3 = (TextView) findViewById(R.id.textView3);

		textView6= (TextView) findViewById(R.id.textView6);
		textView7= (TextView) findViewById(R.id.textView7);
		
		if (savedInstanceState != null) {
			data1 = savedInstanceState.getString("data1");
			data2 = savedInstanceState.getString("data2");
			editText1.setText(data1);
			editText1.setText(data2);
		}

		// Intent intent = getIntent();
		// final String dataString = intent.getStringExtra("data_return");
		// if (dataString.equals("")||dataString=="") {
		//
		// } else {
		// //textView3.setVisibility(View.VISIBLE);
		// textView3.setText(dataString);
		//
		//
		// }
		//

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")){
					AlertDialog.Builder builder = new Builder(FirstActivity.this); 
					builder.setTitle("警告"); 
					builder.setPositiveButton("确定",null); 
//					builder.setIcon(R.drawable.ic_dialog_info); 
					builder.setIcon(android.R.drawable.ic_dialog_alert);
					builder.setMessage("请填写完整"); 
					builder.show(); 
				}
				else {
				
						
						 Pattern p = Pattern.compile("[0-9]*"); 
					     Matcher m1 = p.matcher(editText1.getText().toString()); 
					     Matcher m2 = p.matcher(editText2.getText().toString()); 
					     if(m1.matches()&&m2.matches()){
					     
					    		Intent intent = new Intent(FirstActivity.this,
										SecondActivity.class);
								data1 = editText1.getText().toString();
								data2 = editText2.getText().toString();
								intent.putExtra("data1", editText1.getText().toString());
								intent.putExtra("data2", editText2.getText().toString());
								// startActivity(intent);

								startActivityForResult(intent, sun1);
					     
					     } else {

								AlertDialog.Builder builder = new Builder(FirstActivity.this); 
								builder.setTitle("警告"); 
								builder.setPositiveButton("确定",null); 
//								builder.setIcon(R.drawable.ic_dialog_info); 
								builder.setIcon(android.R.drawable.ic_dialog_alert);
								builder.setMessage("只能是数字"); 
								builder.show(); 
							
							
						}
						
				}
					
			
				}
			

		});

		Button button2 = (Button) findViewById(R.id.button2);

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")){
					AlertDialog.Builder builder = new Builder(FirstActivity.this); 
					builder.setTitle("警告"); 
					builder.setPositiveButton("确定",null); 
//					builder.setIcon(R.drawable.ic_dialog_info); 
					builder.setIcon(android.R.drawable.ic_dialog_alert);
					builder.setMessage("请填写完整"); 
					builder.show(); 
				}
				else {

					
					
					 Pattern p = Pattern.compile("[0-9]*"); 
				     Matcher m1 = p.matcher(editText1.getText().toString()); 
				     Matcher m2 = p.matcher(editText2.getText().toString()); 
				     if(m1.matches()&&m2.matches()){
				     

							Intent intent1 = new Intent(FirstActivity.this, ThridA.class);
							data1 = editText1.getText().toString();
							data2 = editText2.getText().toString();
							intent1.putExtra("data1", editText1.getText().toString());
							intent1.putExtra("data2", editText2.getText().toString());
							// startActivity(intent);
							startActivityForResult(intent1, sun2);
							Log.v(" sun 2", " ff1:"+editText1.getText()+" data1"+data1);
				     
				     } else {

							AlertDialog.Builder builder = new Builder(FirstActivity.this); 
							builder.setTitle("警告"); 
							builder.setPositiveButton("确定",null); 
//							builder.setIcon(R.drawable.ic_dialog_info); 
							builder.setIcon(android.R.drawable.ic_dialog_alert);
							builder.setMessage("只能是数字"); 
							builder.show(); 
						
						
					}
					
			
				
		
			
					
					
					
					
				
				

			}

		

		Log.d("data", R.string.app_name + " Clock execute");
	}
		});}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "you clicked add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
					.show();
			break;

		case R.id.exit_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
					.show();
			finish();
			break;

		default:
			Toast.makeText(this, "def", Toast.LENGTH_SHORT).show();
		}
		return true;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d("onActivityResult", "onActivityResult");
		// TODO Auto-generated method stub

		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				Uri uri = data.getData();
				textView6.setText(uri.toString());
			} else {
				textView6.setText("无返回值");
			}
			break;
		case 2:
			if (resultCode == RESULT_OK) {
				Uri uri = data.getData();
				textView7.setText(uri.toString());
			} else {
				textView7.setText("无返回值");
			}
			break;
		default:
			break;
		}

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save away the original text, so we still have it if the activity
		// needs to be killed while paused.
		savedInstanceState.putString("number1", editText1.getText().toString());
		savedInstanceState.putString("number2", editText2.getText().toString());
		super.onSaveInstanceState(savedInstanceState);
		Log.e("first", "onSaveInstanceState");
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		data1 = savedInstanceState.getString("number1");
		data2 = savedInstanceState.getString("number2");

		Log.e("first data", "onRestoreInstanceState+IntTest=" + data1
				+ "+StrTest=" + data2);
	}
}
