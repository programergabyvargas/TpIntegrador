package com.example.tpintegrador.ui.pagos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
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
    private Spinner spinner;
    private ArrayAdapter<Pago> adapter;
    private ListView lv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        pagosViewModel =
                ViewModelProviders.of(this).get(PagosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        lv =  root.findViewById(R.id.lista_pagos);
        spinner = root.findViewById(R.id.spinner_propiedades);
        cargarDatos();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String propSeleccionada = (String) adapterView.getItemAtPosition(i);
                ArrayList<Pago> listaAuxiliar = new ArrayList<>();
                listaAuxiliar = mostrarDatos(propSeleccionada);
                adapter = new ListaAdapterPagos(getContext(),R.layout.item_pago, listaAuxiliar, getLayoutInflater());
                lv.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return root;
    }

    public void cargarDatos() {

        lista.add(new Pago(2,"08/11/2019",4200,"Propiedad2"));
        lista.add(new Pago(1,"10/10/2019",4000,"Propiedad1"));
        lista.add(new Pago(4,"09/12/2019",4500,"Propiedad1"));
        lista.add(new Pago(3,"02/02/2019",5500,"Propiedad3"));
    }

    public ArrayList<Pago> mostrarDatos(String prop){
        ArrayList<Pago> listaDePagos = new ArrayList<>();
        for (int i=0; i < lista.size();i++) {
            if ( lista.get(i).getPropiedad().equals(prop)){
                listaDePagos.add(lista.get(i));
            }
        }
        return listaDePagos;
    }

}