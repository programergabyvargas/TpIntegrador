package com.example.tpintegrador.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpintegrador.R;

public class PagosFragment extends Fragment {

    private PagosViewModel pagosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pagosViewModel =
                ViewModelProviders.of(this).get(PagosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        final TextView textView = root.findViewById(R.id.text_pagos);
        pagosViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}