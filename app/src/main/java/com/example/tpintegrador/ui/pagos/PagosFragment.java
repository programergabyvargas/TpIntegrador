package com.example.tpintegrador.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpintegrador.R;
import com.example.tpintegrador.ui.inquilinos.Inquilino;
import com.example.tpintegrador.ui.inquilinos.ListaAdapterInquilinos;

import java.util.ArrayList;

public class PagosFragment extends Fragment {
    private ArrayList<Pago> lista = new ArrayList<>();
    private PagosViewModel pagosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pagosViewModel =
                ViewModelProviders.of(this).get(PagosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        cargarDatos();

        ArrayAdapter<Pago> adapter = new ListaAdapterPagos(getContext(),R.layout.item_pago, lista, getLayoutInflater());
        ListView lv =  root.findViewById(R.id.lista_pagos);
        lv.setAdapter(adapter);


        return root;
    }

    public void cargarDatos() {
        lista.add(new Pago(1,"10/10/2019",4000));
        lista.add(new Pago(2,"10/11/2019",4000));
        lista.add(new Pago(3,"10/12/2019",4500));
    }

}