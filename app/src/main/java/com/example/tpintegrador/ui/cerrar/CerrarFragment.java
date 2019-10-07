package com.example.tpintegrador.ui.cerrar;

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

public class CerrarFragment extends Fragment {

    private CerrarViewModel cerrarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cerrarViewModel =
                ViewModelProviders.of(this).get(CerrarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cerrar, container, false);
        final TextView textView = root.findViewById(R.id.text_cerrar);
        cerrarViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}