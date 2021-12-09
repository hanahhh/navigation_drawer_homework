package com.example.navigationdrawer.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

public class Convert extends Fragment {

    private FragmentGalleryBinding binding;
    private Spinner spinnerCategory, spinnerCategoryConvert;
    private EditText number;
    private TextView result;
    private String s1 = "Convert";
    private String s2 = "Convert";
    private int dec;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        spinnerCategory = binding.spinnerCategory;
        spinnerCategoryConvert = binding.spinnerCategoryConvert;
        number = binding.number1;
        result = binding.number2;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);
        spinnerCategoryConvert.setAdapter(adapter);

        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s1 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), s1, Toast.LENGTH_SHORT).show();

                if(s1.equals("Binary")) {
                    dec = Integer.parseInt(number.getText().toString(), 2);
                } else if (s1.equals("Octal")) {
                    dec = Integer.parseInt(number.getText().toString(), 8);
                } else if (s1.equals("Decimal")) {
                    dec = Integer.parseInt(number.getText().toString());
                } else if (s1.equals("Hexadecimal")) {
                    dec = Integer.parseInt(number.getText().toString(), 16);
                }

                if(s2.equals("Binary")) {
                    result.setText(Integer.toBinaryString(dec));
                } else if (s2.equals("Octal")) {
                    result.setText(Integer.toOctalString(dec));
                } else if (s2.equals("Decimal")) {
                    result.setText(Integer.toString(dec));
                } else if (s2.equals("Hexadecimal")) {
                    result.setText(Integer.toHexString(dec));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerCategoryConvert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(s1.equals("Binary")) {
                    dec = Integer.parseInt(number.getText().toString(), 2);
                } else if (s1.equals("Octal")) {
                    dec = Integer.parseInt(number.getText().toString(), 8);
                } else if (s1.equals("Decimal")) {
                    dec = Integer.parseInt(number.getText().toString());
                } else if (s1.equals("Hexadecimal")) {
                    dec = Integer.parseInt(number.getText().toString(), 16);
                }

                s2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), s2, Toast.LENGTH_SHORT).show();

                if(s2.equals("Binary")) {
                    result.setText(Integer.toBinaryString(dec));
                } else if (s2.equals("Octal")) {
                    result.setText(Integer.toOctalString(dec));
                } else if (s2.equals("Decimal")) {
                    result.setText(Integer.toString(dec));
                } else if (s2.equals("Hexadecimal")) {
                    result.setText(Integer.toHexString(dec));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}