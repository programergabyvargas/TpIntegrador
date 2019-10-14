package com.example.tpintegrador.ui.contratos;

import android.os.Bundle;
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

import java.util.ArrayList;

public class ContratosFragment extends Fragment {
    private ArrayList<Contrato> lista = new ArrayList<>();
    private Spinner spinner;
    private ArrayAdapter<Contrato> adapter;
    private ListView lv;
    private ContratosViewModel contratosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contratosViewModel =
                ViewModelProviders.of(this).get(ContratosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contratos, container, false);
        lv =  root.findViewById(R.id.lista_contratos);
        cargarDatos();
        spinner = root.findViewById(R.id.spinner_propiedades);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String propSeleccionada = (String) adapterView.getItemAtPosition(i);
            ArrayList<Contrato> listaAuxiliar = new ArrayList<>();
            listaAuxiliar = mostrarDatos(propSeleccionada);
            adapter = new ListaAdapterContratos(getContext(),R.layout.item_pago, listaAuxiliar, getLayoutInflater());
            lv.setAdapter(adapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
      return root;
    }

    public void cargarDatos() {

        lista.add(new Contrato("Propiedad1","2017-05-14","2019-05-14",100000,1));
        lista.add(new Contrato("Propiedad2","2017-09-10","2019-09-10",80000,1));
        lista.add(new Contrato("Propiedad3","2017-02-10","2019-02-10",900000,1));
        lista.add(new Contrato("Propiedad4","2014-12-24","2016-12-24",50000,0));
        lista.add(new Contrato("Propiedad4","2017-01-08","2019-01-08",50000,1));



    }

    public ArrayList<Contrato> mostrarDatos(String prop){
        ArrayList<Contrato> listaDeContrato = new ArrayList<>();
        for (int i=0; i < lista.size();i++) {
            if ( lista.get(i).getNombrePropiedad().equals(prop) && lista.get(i).getActivo() ==1){ //filtro el contrato activo
                listaDeContrato.add(lista.get(i));
            }
        }
        return listaDeContrato;
    }


}