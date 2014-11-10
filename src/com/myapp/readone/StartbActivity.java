package com.myapp.readone;

import java.util.Calendar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class StartbActivity extends Activity {
	ActionBar actionBar;
	EditText startdate;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startb);
		actionBar = getActionBar();
		actionBar.show();
		actionBar.setDisplayHomeAsUpEnabled(true);
		// actionBar.setDisplayShowHomeEnabled(true);
		// actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		// actionBar.setCustomView(R.layout.actionbar);
		startdate = (EditText) findViewById(R.id.startdate);
		startdate.setInputType(InputType.TYPE_NULL);
		Button b = (Button) findViewById(R.id.startconfirmbutton);

		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText bookname = (EditText) findViewById(R.id.start_bname);
				//EditText author = (EditText) findViewById(R.id.start_bauthor);
				//EditText startdate = (EditText) findViewById(R.id.startdate);
				if (bookname.getText().toString().length() > 0) {
					Intent intent = new Intent(StartbActivity.this,
							MainActivity.class);
					startActivity(intent);
				}
				Toast.makeText(getApplicationContext(), bookname.getText().toString()+"is reading",
						Toast.LENGTH_LONG).show();
			}
		});

		startdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (hasFocus) {
					Calendar c = Calendar.getInstance();
					new DatePickerDialog(StartbActivity.this,
							new DatePickerDialog.OnDateSetListener() {

								@Override
								public void onDateSet(DatePicker view,
										int year, int monthOfYear,
										int dayOfMonth) {
									// TODO Auto-generated method stub
									startdate.setText(year + "/"
											+ (monthOfYear + 1) + "/"
											+ dayOfMonth);
								}
							}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
									.get(Calendar.DAY_OF_MONTH)).show();

				}
			}
		});
		startdate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();
				new DatePickerDialog(StartbActivity.this,
						new DatePickerDialog.OnDateSetListener() {

							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								// TODO Auto-generated method stub
								startdate.setText(year + "/"
										+ (monthOfYear + 1) + "/" + dayOfMonth);
							}
						}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
								.get(Calendar.DAY_OF_MONTH)).show();

			}
		});
	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
		default:
			return super.onOptionsItemSelected(item);
		}

	}

}
