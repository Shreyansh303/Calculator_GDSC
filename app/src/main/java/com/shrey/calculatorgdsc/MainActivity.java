package com.shrey.calculatorgdsc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shrey.calculatorgdsc.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final StringBuilder display = new StringBuilder();
    private float num1;
    private float num2;
    private float num1OG;
    private float num2OG;
    private String operationPerformedOG;
    private DecimalFormat decimalFormat;
    private boolean firstNum = true;
    private String operationPerformed;
    private Intent conversion;
    private Intent history;
    private Bundle bundle;
    private List<String> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        decimalFormat = new DecimalFormat();
        bundle = new Bundle();

        binding.display.setText("0");

        binding.oneButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("1");
                binding.display.setText(display);
            }
        });

        binding.twoButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("2");
                binding.display.setText(display);
            }
        });

        binding.threeButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("3");
                binding.display.setText(display);
            }
        });

        binding.fourButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("4");
                binding.display.setText(display);
            }
        });

        binding.fiveButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("5");
                binding.display.setText(display);
            }
        });

        binding.sixButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("6");
                binding.display.setText(display);
            }
        });

        binding.sevenButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("7");
                binding.display.setText(display);
            }
        });

        binding.eightButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("8");
                binding.display.setText(display);
            }
        });

        binding.nineButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append("9");
                binding.display.setText(display);
            }
        });

        binding.zeroButton.setOnClickListener(view -> {
            if (display.length() < 9 && display.length() != 0 ) {
                display.append("0");
                binding.display.setText(display);
            }
        });

        binding.decimalButton.setOnClickListener(view -> {
            if (display.length() < 9) {
                display.append(".");
                binding.display.setText(display);
            }
        });

        binding.backspaceButton.setOnClickListener(view -> {
            if (display.length() > 0) {
                display.deleteCharAt(display.length()-1);
                if (display.length() == 0) {
                    binding.display.setText("0");
                }
                else binding.display.setText(display);
            }
        });

        binding.acButton.setOnClickListener(view -> {
            display.delete(0,display.length());
            num1 = 0;
            num2 = 0;
            firstNum = true;
            binding.display.setText("0");

        });

        binding.additionButton.setOnClickListener(view -> {
            if (firstNum) {
                receiveNum1();
                operationPerformed = "+";
            } else {
                try {
                    operationPerformed = "+";
                    num2 = Float.parseFloat(display.toString());
                    num1 = this.num1 + num2;
                    display.delete(0, display.length());
                    setDisplay(num1);
                } catch (Exception ignored) {}
            }
        });

        binding.subtractionButton.setOnClickListener(view -> {
            if (firstNum) {
                receiveNum1();
                operationPerformed = "-";
            } else {
                try {
                    operationPerformed = "-";
                    num2 = Float.parseFloat(display.toString());
                    num1 = this.num1 - num2;
                    display.delete(0, display.length());
                    setDisplay(num1);
                } catch (Exception ignored) {}
            }
        });

        binding.multiplyButton.setOnClickListener(view -> {
            if (firstNum) {
                receiveNum1();
                operationPerformed = "*";
            } else {
                try {
                    operationPerformed = "*";
                    num2 = Float.parseFloat(display.toString());
                    num1 = this.num1 * num2;
                    display.delete(0, display.length());
                    setDisplay(num1);
                } catch (Exception ignored) {}
            }
        });

        binding.divideButton.setOnClickListener(view -> {
            if (firstNum) {
                receiveNum1();
                operationPerformed = "/";
            } else {
                try {
                    operationPerformed = "/";
                    num2 = Float.parseFloat(display.toString());
                    num1 = this.num1 / num2;
                    display.delete(0, display.length());
                    setDisplay(num1);
                } catch (Exception ignored) {}
            }
        });

        binding.percentageButton.setOnClickListener(view -> {
            if (firstNum) {
                receiveNum1();
                operationPerformed = "%";
            } else {
                try {
                    operationPerformed = "%";
                    num2 = Float.parseFloat(display.toString());
                    num1 = this.num1 * (num2/100);
                    display.delete(0, display.length());
                    setDisplay(num1);
                } catch (Exception ignored) {}
            }
        });


        binding.equalsButton.setOnClickListener(view -> {

            if (Objects.equals(operationPerformed, "+")) {
                try {
                    num2 = Float.parseFloat(display.toString());
                    num1OG = num1;
                    num2OG = num2;
                    num1 = this.num1 + num2;
                    equals();
                } catch (Exception ignored) {}

            } else if (Objects.equals(operationPerformed, "-")) {
                try {
                    num2 = Float.parseFloat(display.toString());
                    num1OG = num1;
                    num2OG = num2;
                    num1 = this.num1 - num2;
                    equals();
                } catch (Exception ignored) {}

            } else if (Objects.equals(operationPerformed, "*")) {
                try {
                    num2 = Float.parseFloat(display.toString());
                    num1OG = num1;
                    num2OG = num2;
                    num1 = this.num1 * num2;
                    equals();
                } catch (Exception ignored) {}

            } else if (Objects.equals(operationPerformed, "/")) {
                try {
                    num2 = Float.parseFloat(display.toString());
                    num1OG = num1;
                    num2OG = num2;
                    num1 = this.num1 / num2;
                    equals();
                } catch (Exception ignored) {}

            } else if (Objects.equals(operationPerformed, "%")) {
                try {
                    num2 = Float.parseFloat(display.toString());
                    num1OG = num1;
                    num2OG = num2;
                    num1 = this.num1 * (num2/100);
                    equals();
                } catch (Exception ignored) {}
            }

        });

        binding.conversionButton.setOnClickListener(view -> {
            conversion = new Intent(getApplicationContext(), Conversion.class);
            startActivity(conversion);
        });

        binding.historyButton.setOnClickListener(view -> {
            openHistory();
        });

    }

    public void equals() {
        if ((String.valueOf(decimalFormat.format(num1))).length() <= 12 ) {
            operationPerformedOG = operationPerformed;
            historyList.add(String.valueOf(decimalFormat.format(num1OG)) + " " +
                    operationPerformedOG + " " +
                    String.valueOf(decimalFormat.format(num2OG)) + " " + "=" + " " +
                    String.valueOf(decimalFormat.format(num1)));
            display.delete(0,display.length());
            binding.display.setText(decimalFormat.format(num1));
            operationPerformed = "null";
            display.append(String.valueOf(decimalFormat.format(num1)));
            num2 = 0;
            firstNum = true;
        } else {
            display.delete(0,display.length());
            binding.display.setText(R.string.error);
            operationPerformed = "null";
            num2 = 0;
            firstNum = true;
        }

    }

    public void receiveNum1() {
        try {
            num1 = Float.parseFloat(display.toString());
            firstNum = false;
            display.delete(0, display.length());
            binding.display.setText("0");
        } catch (Exception e) {}
    }

    public void openHistory() {
        history = new Intent(MainActivity.this, History.class);
        bundle.putStringArrayList("History", (ArrayList<String>) historyList);
        history.putExtras(bundle);
        startActivity(history);
    }

    public void setDisplay(float num) {
        if ((String.valueOf(decimalFormat.format(num)).length() <= 12)) {
            binding.display.setText(decimalFormat.format(num));
        } else {
            binding.display.setText(R.string.error);
            operationPerformed = "null";
            num2 = 0;
            firstNum = true;
        }

    }


}

