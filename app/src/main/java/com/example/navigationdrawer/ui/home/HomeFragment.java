package com.example.navigationdrawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentHomeBinding;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    TextView result;
    TextView textUp;
    Button CE_BTN, C_BTN, divideBTN, sevenBTN, eightBTN, nineBTN, multiplyBTN, fourBTN, fiveTBN,
            sixBTN, minusBTN, oneBTN, twoBTN, threeBTN, addBTN, addMinusBTN, zeroBTN, pointBTN, equalBTN;
    ImageButton backspaceBTN;
    private StringBuffer str = new StringBuffer("");
    private StringBuffer exp = new StringBuffer("");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        result = binding.result;
        textUp = binding.textUp;
        CE_BTN = binding.clearOne;
        C_BTN = binding.clear;
        divideBTN = binding.divide;
        backspaceBTN = binding.backspace;
        sevenBTN = binding.seven;
        eightBTN = binding.eight;
        nineBTN = binding.nine;
        multiplyBTN = binding.multiply;
        fourBTN = binding.four;
        fiveTBN = binding.five;
        sixBTN = binding.six;
        minusBTN = binding.minus;
        oneBTN = binding.one;
        twoBTN = binding.two;
        threeBTN = binding.three;
        addBTN = binding.add;
        minusBTN = binding.minus;
        addMinusBTN = binding.plusMinus;
        zeroBTN = binding.zero;
        pointBTN = binding.point;
        equalBTN = binding.equal;

        CE_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str.delete(0, str.length());
                result.setText(str);
            }
        });
        C_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str.delete(0, str.length());
                exp.delete(0, exp.length());
                result.setText(str);
                textUp.setText(exp);
            }
        });
        divideBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCount("/");
            }
        });
        backspaceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(str.length() != 0){
                    str.deleteCharAt(str.length() - 1);
                }
                result.setText(str);
            }
        });

        sevenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("7");
            }
        });
        eightBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("8");
            }
        });
        nineBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("9");
            }
        });
        multiplyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("*");
            }
        });
        fourBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("4");
            }
        });
        fiveTBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("5");
            }
        });
        sixBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("6");
            }
        });
        minusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("-");
            }
        });
        oneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("1");
            }
        });
        twoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("2");
            }
        });
        threeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("3");
            }
        });
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("+");
            }
        });
        addMinusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("+/-");
            }
        });
        zeroBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("0");
            }
        });
        pointBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(".");
            }
        });
        equalBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCount("");
                System.out.println(exp);
                Double resultExp = null;
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

                try {
                    resultExp = (double)engine.eval(exp.toString());
                } catch (ScriptException e){
                }

                if(resultExp != null){
                    result.setText(String.valueOf(resultExp.doubleValue()));
                }
                str.delete(0, str.length());
                exp.delete(0, exp.length());
            }
        });
        return root;
    }

    private void updateText(String strToAdd){
        if(strToAdd == "+/-"){
            str.insert(0, "- ");
        } else {
            str.append(strToAdd);
        }
        result.setText(str);
    }
    private void updateCount(String strToAdd){
        exp.append(" " + str + " " + strToAdd);
        str.delete(0, str.length());
        textUp.setText(exp);
        result.setText(str);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}