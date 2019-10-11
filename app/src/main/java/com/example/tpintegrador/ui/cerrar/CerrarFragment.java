package com.example.tpintegrador.ui.cerrar;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        cerrar();

        return root;
    }


    private void cerrar(){
        new AlertDialog.Builder(getContext())
                .setTitle("Cerrar Aplicacion")
                .setMessage("Esta seguro?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                      //  System.exit(0);
                    }
                })
                 .setNegativeButton("No", new DialogInterface.OnClickListener(){

                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.cancel();
                     }
                 }).show();


    }
}