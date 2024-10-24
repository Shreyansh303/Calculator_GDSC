package com.shrey.calculatorgdsc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.synerset.unitility.unitsystem.common.Distance;
import com.synerset.unitility.unitsystem.common.Mass;
import com.synerset.unitility.unitsystem.thermodynamic.Temperature;

import java.text.DecimalFormat;
import java.util.Objects;

public class Conversion extends AppCompatActivity {

    private Button backButton;
    private Button inputUnit1Button;
    private Button inputUnit2Button;
    private Button inputUnit3Button;
    private Button outputUnit1Button;
    private Button outputUnit2Button;
    private Button outputUnit3Button;
    private TextView convertToText;
    private TextView resultText;
    private EditText valueEdit;
    private String inputUnit;
    private String outputUnit;
    private AutoCompleteTextView autoCompleteText;

    public String[] conversions = {"Length","Mass","Temperature"};
    public String conversion;
    private Double value;
    private Temperature temperature;
    private Mass mass;
    private Distance distance;
    private Double result;

    private String meter;
    private String miles;
    private String feet;
    private String kilogram;
    private String ounce;
    private String pound;
    private String kelvin;
    private String celsius;
    private String fahrenheit;

    private DecimalFormat decimalFormat = new DecimalFormat("#.########");

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        meter = getResources().getString(R.string.meter);
        miles = getResources().getString(R.string.mile);
        feet = getResources().getString(R.string.feet);
        kilogram = getResources().getString(R.string.kilogram);
        ounce = getResources().getString(R.string.ounce);
        pound = getResources().getString(R.string.pound);
        kelvin = getResources().getString(R.string.kelvin);
        celsius = getResources().getString(R.string.celsius);
        fahrenheit = getResources().getString(R.string.fahrenheit);

        backButton = findViewById(R.id.backButton);
        inputUnit1Button = findViewById(R.id.inputUnit1);
        inputUnit2Button = findViewById(R.id.inputUnit2);
        inputUnit3Button = findViewById(R.id.inputUnit3);
        outputUnit1Button = findViewById(R.id.outputUnit1);
        outputUnit2Button = findViewById(R.id.outputUnit2);
        outputUnit3Button = findViewById(R.id.outputUnit3);
        convertToText = findViewById(R.id.convert_to);
        resultText = findViewById(R.id.result);
        valueEdit = findViewById(R.id.valueEdit);

        autoCompleteText = findViewById(R.id.auto_complete_text);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,conversions);

        autoCompleteText.setAdapter(adapterItems);

        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                conversion = adapterView.getItemAtPosition(i).toString();
                valueEdit.setText(null);
                inputUnit = null;
                outputUnit = null;
                temperature = null;
                mass = null;
                distance = null;
                inputUnit1Button.setText(null);
                inputUnit2Button.setText(null);
                inputUnit3Button.setText(null);
                outputUnit1Button.setText(null);
                outputUnit2Button.setText(null);
                outputUnit3Button.setText(null);
                resultText.setText(null);
                valueEdit.setVisibility(View.VISIBLE);

                if (Objects.equals(conversion,"Length")) {
                    allButtonsVisible();
                    inputUnit1Button.setText(R.string.meter);
                    inputUnit2Button.setText(R.string.mile);
                    inputUnit3Button.setText(R.string.feet);
                    outputUnit1Button.setText(R.string.meter);
                    outputUnit2Button.setText(R.string.mile);
                    outputUnit3Button.setText(R.string.feet);
                } else if (Objects.equals(conversion,"Mass")) {
                    allButtonsVisible();
                    inputUnit1Button.setText(R.string.kilogram);
                    inputUnit2Button.setText(R.string.ounce);
                    inputUnit3Button.setText(R.string.pound);
                    outputUnit1Button.setText(R.string.kilogram);
                    outputUnit2Button.setText(R.string.ounce);
                    outputUnit3Button.setText(R.string.pound);
                } else if (Objects.equals(conversion,"Temperature")) {
                    allButtonsVisible();
                    inputUnit1Button.setText(R.string.kelvin);
                    inputUnit2Button.setText(R.string.celsius);
                    inputUnit3Button.setText(R.string.fahrenheit);
                    outputUnit1Button.setText(R.string.kelvin);
                    outputUnit2Button.setText(R.string.celsius);
                    outputUnit3Button.setText(R.string.fahrenheit);
                }
            }
        });

        backButton.setOnClickListener(view -> {
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
        });

        inputUnit1Button.setOnClickListener(view -> {
            System.out.println((valueEdit.getText()).getClass().getName());
            if (Objects.equals(String.valueOf(inputUnit1Button.getText()),meter)) {
                inputUnit = meter;
            } else if (Objects.equals(String.valueOf(inputUnit1Button.getText()),kilogram)) {
                inputUnit = kilogram;
            } else if (Objects.equals(String.valueOf(inputUnit1Button.getText()),kelvin)) {
                inputUnit = kelvin;
            }
        });

        inputUnit2Button.setOnClickListener(view -> {
            if (Objects.equals(String.valueOf(inputUnit2Button.getText()),miles)) {
                inputUnit = miles;
            } else if (Objects.equals(String.valueOf(inputUnit2Button.getText()),ounce)) {
                inputUnit = ounce;
            } else if (Objects.equals(String.valueOf(inputUnit2Button.getText()),celsius)) {
                inputUnit = celsius;
            }
        });

        inputUnit3Button.setOnClickListener(view -> {
            if (Objects.equals(String.valueOf(inputUnit3Button.getText()),feet)) {
                inputUnit = feet;
            } else if (Objects.equals(String.valueOf(inputUnit3Button.getText()),pound)) {
                inputUnit = pound;
            } else if (Objects.equals(String.valueOf(inputUnit3Button.getText()),fahrenheit)) {
                inputUnit = fahrenheit;
            }
        });

        outputUnit1Button.setOnClickListener(view -> {
            if (Objects.equals(String.valueOf(outputUnit1Button.getText()),meter)) {
                outputUnit = meter;
            } else if (Objects.equals(String.valueOf(outputUnit1Button.getText()),kilogram)) {
                outputUnit = kilogram;
            } else if (Objects.equals(String.valueOf(outputUnit1Button.getText()),kelvin)) {
                outputUnit = kelvin;
            }
            conversion(inputUnit,outputUnit);
        });

        outputUnit2Button.setOnClickListener(view -> {
            if (Objects.equals(String.valueOf(outputUnit2Button.getText()),miles)) {
                outputUnit = miles;
            } else if (Objects.equals(String.valueOf(outputUnit2Button.getText()),ounce)) {
                outputUnit = ounce;
            } else if (Objects.equals(String.valueOf(outputUnit2Button.getText()),celsius)) {
                outputUnit = celsius;
            }
            conversion(inputUnit,outputUnit);
        });

        outputUnit3Button.setOnClickListener(view -> {
            if (Objects.equals(String.valueOf(outputUnit3Button.getText()),feet)) {
                outputUnit = feet;
            } else if (Objects.equals(String.valueOf(outputUnit3Button.getText()),pound)) {
                outputUnit = pound;
            } else if (Objects.equals(String.valueOf(outputUnit3Button.getText()),fahrenheit)) {
                outputUnit = fahrenheit;
            }
            conversion(inputUnit,outputUnit);
        });



    }

    public void Test(View view) {
        Toast.makeText(this, conversion, Toast.LENGTH_SHORT).show();
    }

    public void allButtonsVisible() {
        inputUnit1Button.setVisibility(View.VISIBLE);
        inputUnit2Button.setVisibility(View.VISIBLE);
        inputUnit3Button.setVisibility(View.VISIBLE);
        outputUnit1Button.setVisibility(View.VISIBLE);
        outputUnit2Button.setVisibility(View.VISIBLE);
        outputUnit3Button.setVisibility(View.VISIBLE);
        convertToText.setVisibility(View.VISIBLE);
    }

    public void conversion(String input, String output) {
        try {
            value = Double.parseDouble(String.valueOf(valueEdit.getText()));
            if (Objects.equals(input,meter)){
                distance = Distance.ofMeters(value);
            } else if (Objects.equals(input,miles)){
                distance = Distance.ofMiles(value);
            } else if (Objects.equals(input,feet)) {
                distance = Distance.ofFeet(value);
            } else if (Objects.equals(input,kilogram)) {
                mass = Mass.ofKilograms(value);
            } else if (Objects.equals(input,ounce)) {
                mass = Mass.ofOunces(value);
            } else if (Objects.equals(input,pound)) {
                mass = Mass.ofPounds(value);
            } else if (Objects.equals(input,kelvin)) {
                temperature = Temperature.ofKelvins(value);
            } else if (Objects.equals(input,celsius)) {
                temperature = Temperature.ofCelsius(value);
            } else if (Objects.equals(input,fahrenheit)) {
                temperature = Temperature.ofFahrenheit(value);
            }

            if (Objects.equals(output,meter)){
                result = distance.getInMeters();
            } else if (Objects.equals(output,miles)){
                result = distance.getInMiles();
            } else if (Objects.equals(output,feet)) {
                result = distance.getInFeet();
            } else if (Objects.equals(output,kilogram)) {
                result = mass.getInKilograms();
            } else if (Objects.equals(output,ounce)) {
                result = mass.getIntoOunces();
            } else if (Objects.equals(output,pound)) {
                result = mass.getInPounds();
            } else if (Objects.equals(output,kelvin)) {
                result = temperature.getInKelvins();
            } else if (Objects.equals(output,celsius)) {
                result = temperature.getInCelsius();
            } else if (Objects.equals(output,fahrenheit)) {
                result = temperature.getInFahrenheits();
            }
            setResultText(result,output);
        } catch (Exception e){
            Snackbar.make(valueEdit,"Enter A Value!", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(getColor(R.color.orange)).
                    setTextColor(getColor(R.color.black)).show();
        }

    }

    public void setResultText(double result, String unit){
        String resultString = String.valueOf(decimalFormat.format(result));
        resultText.setText("RESULT: " + resultString + " " + unit);
        resultText.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

}