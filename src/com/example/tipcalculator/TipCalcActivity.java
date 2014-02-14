package com.example.tipcalculator;

import java.math.BigDecimal;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class TipCalcActivity extends Activity {

	private EditText et;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);
        et = (EditText) findViewById(R.id.tipinput);
        
    }

    
    public void clearTip(View v) {
    	EditText calc = (EditText)findViewById(R.id.tipcalc);
    	calc.setText("");
    	calc.setBackgroundColor(Color.WHITE);
    }
    
    public void calcTip(View v) {
    	try {
	    if (et.getText().toString().equals("")) {
	    	   return;
	    }
    	EditText et_calc = (EditText) findViewById(R.id.tipcalc);
    	BigDecimal amt = new BigDecimal(et.getText().toString());
    	
    	BigDecimal  s = new BigDecimal((String)v.getTag());
    	BigDecimal tip = (s.divide(new BigDecimal(100))).multiply(amt);
    	
    	et_calc.setText(tip.toString());
    	et_calc.setBackgroundColor(Color.GREEN);
    	et.setText("");
    	} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calc, menu);
        return true;
    }
    
}
