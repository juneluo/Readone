package com.myapp.readone;

import java.util.Calendar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FinishbActivity extends Activity {
	ActionBar actionBar;
	TextView finishbname;
	EditText finishdate;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finishb);
		actionBar = getActionBar();
		actionBar.show();
		actionBar.setDisplayHomeAsUpEnabled(true);
		// actionBar.setDisplayShowHomeEnabled(true);
		Button b = (Button) findViewById(R.id.finishconfirmbutton);
		final Spinner spinner = (Spinner) findViewById(R.id.finish_bname_spinner);
		finishdate = (EditText) findViewById(R.id.finishdate);
		finishdate.setInputType(InputType.TYPE_NULL);

		// PROBLEM
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int pos, long id) {
				String result = parent.getItemAtPosition(pos).toString();
				Log.i("选择结果是：", result);
				// finishbname.setText(result);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// String bname=finishbname.getText().toString();
				//EditText feeling = (EditText) findViewById(R.id.finish_feeling);
				//EditText finishdate = (EditText) findViewById(R.id.finishdate);
				// if (finishbname.getText().toString().length() > 0) {
				Intent intent = new Intent(FinishbActivity.this,
						MainActivity.class);
				startActivity(intent);
				// }
				 Toast.makeText(getApplicationContext(),
				  "Finish ONE Book",
				 Toast.LENGTH_LONG).show();
			}
		});

		finishdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (hasFocus) {
					Calendar c = Calendar.getInstance();
					new DatePickerDialog(FinishbActivity.this,
							new DatePickerDialog.OnDateSetListener() {

								@Override
								public void onDateSet(DatePicker view,
										int year, int monthOfYear,
										int dayOfMonth) {
									// TODO Auto-generated method stub
									finishdate.setText(year + "/"
											+ (monthOfYear + 1) + "/"
											+ dayOfMonth);
								}
							}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
									.get(Calendar.DAY_OF_MONTH)).show();

				}
			}
		});
		finishdate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();
				new DatePickerDialog(FinishbActivity.this,
						new DatePickerDialog.OnDateSetListener() {

							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								// TODO Auto-generated method stub
								finishdate.setText(year + "/"
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
