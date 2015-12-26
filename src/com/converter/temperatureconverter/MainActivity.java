package com.converter.temperatureconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText editValue;
	Button buttonConvert;
	RadioGroup radioGroup;
	RadioButton radioButton;
	TextView textResult;
	TextView textCurrent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonConvert = (Button) findViewById(R.id.buttonConvert);
		editValue = (EditText) findViewById(R.id.editValue);
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		textResult = (TextView) findViewById(R.id.textResult);
		textCurrent = (TextView) findViewById(R.id.textCurrent);
		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch(checkedId) {
				case R.id.radioC:
					textCurrent.setText("degreen Fahrenheit");
					break;
					
				case R.id.radioF:
					textCurrent.setText("degree Celsius");
					break;
				}

			}
		});
		
		buttonConvert.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int selectedId = radioGroup.getCheckedRadioButtonId();
				if(editValue.getText().toString().equals("")) {
					Toast toastMessage = Toast.makeText(MainActivity.this, "Please Enter Input", Toast.LENGTH_LONG);
					toastMessage.show();
					return;
				}
				float oper1 = Float.parseFloat(editValue.getText().toString());
				double result=0;
				String format="";
				try {
					switch(selectedId) {
					case R.id.radioC:
						result = (oper1-32)*(5.0/9.0);
						format = " degree Celsius";
						break;
						
					case R.id.radioF:
						result = oper1*(9.0/5.0) + 32;
						format = " degree Fahrenheit";
						break;
					}
					textResult.setText(Double.toString(result)+format);
				} catch(NumberFormatException e) {
					e.printStackTrace();
					return;
				}
				

			}
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		if (id == R.id.action_about) {
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			return true;
		}
		
		if (id == R.id.action_formula) {
			Intent intent = new Intent(this, FormulaActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
