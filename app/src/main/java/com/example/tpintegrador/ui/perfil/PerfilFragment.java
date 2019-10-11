package com.example.tpintegrador.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpintegrador.R;

public class PerfilFragment extends Fragment {
    private PerfilViewModel perfilViewModel;
    private EditText etDni, etApellido, etNombre, etTelefono,etEmail,etPassword;
    private Button btEditar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        etDni = root.findViewById(R.id.etDni);
        etApellido = root.findViewById(R.id.etApellido);
        etNombre = root.findViewById(R.id.etNombre);
        etTelefono = root.findViewById(R.id.etTelefono);
        etEmail = root.findViewById(R.id.etEmail);
        etPassword = root.findViewById(R.id.etPassword);

        btEditar = (Button) root.findViewById(R.id.btEditar);

        btEditar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            etDni.setEnabled(true);
                                            etApellido.setEnabled(true);
                                            etNombre.setEnabled(true);
                                            etTelefono.setEnabled(true);
                                            etEmail.setEnabled(true);
                                            etPassword.setEnabled(true);
                                            etDni.requestFocus();
                                        }
                                    });

                    // btEditar = root.findViewById(R.id.btEditar);
        final TextView textView = root.findViewById(R.id.tvNroDoc);
        perfilViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);



            }
        });
       // editar();
        return root;
    }

    public void editar(View view){
       etNombre.setEnabled(true);
    }
}