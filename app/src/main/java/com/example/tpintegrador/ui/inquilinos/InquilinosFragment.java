package com.example.tpintegrador.ui.inquilinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpintegrador.R;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment {
    private ArrayList<Inquilino> lista = new ArrayList<>();

    private InquilinosViewModel inquilinosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inquilinosViewModel =
                ViewModelProviders.of(this).get(InquilinosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);
        cargarDatos();
       // generarListView();

        ArrayAdapter<Inquilino> adapter = new ListaAdapterInquilinos(getContext(),R.layout.iteminquilino, lista, getLayoutInflater());
        ListView lv =  root.findViewById(R.id.lista_inquilinos);
        lv.setAdapter(adapter);

        return root;
      // return inflater.inflate(R.layout.fragment_inquilinos,container,false);
       // return root;
    }

    public void cargarDatos() {
        lista.add(new Inquilino("32872636","Vargas","Juan Gabriel","Antartida Arg. 2796","266-4678211"));
        lista.add(new Inquilino("33874654","Salomoni","Ayelen Karen","Gabriela Mistral 167","266-4623476"));
    }

    public void generarListView (){

        ArrayAdapter<Inquilino> adapter = new ListaAdapterInquilinos(getContext(),R.layout.iteminquilino, lista, getLayoutInflater());
      // ListView lv = (ListView) findViewById(R.id.listaInquilinos);
       // lv.setAdapter(adapter);
    }
}