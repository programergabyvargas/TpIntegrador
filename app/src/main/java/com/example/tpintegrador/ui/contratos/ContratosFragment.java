package com.example.tpintegrador.ui.contratos;

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

import java.util.ArrayList;

public class ContratosFragment extends Fragment {
    private ArrayList<Contrato> lista = new ArrayList<>();

    private ContratosViewModel contratosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contratosViewModel =
                ViewModelProviders.of(this).get(ContratosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contratos, container, false);
        cargarDatos();

        ArrayAdapter<Contrato> adapter = new ListaAdapterContratos(getContext(),R.layout.item_contrato, lista, getLayoutInflater());
        ListView lv =  root.findViewById(R.id.lista_contratos);
        lv.setAdapter(adapter);

        return root;
    }

    public void cargarDatos() {
        lista.add(new Contrato("2017-05-14","2019-05-14",100000));
    }
}