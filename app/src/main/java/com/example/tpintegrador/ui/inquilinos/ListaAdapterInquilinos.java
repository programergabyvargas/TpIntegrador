package com.example.tpintegrador.ui.inquilinos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tpintegrador.R;

import java.util.List;

public class ListaAdapterInquilinos extends ArrayAdapter<Inquilino> {
    private Context context;
    private List<Inquilino> lista;
    private LayoutInflater li;

    public ListaAdapterInquilinos(@NonNull Context context, int resource, @NonNull List objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View itemView = convertView;
       if(itemView == null){
           itemView = li.inflate(R.layout.iteminquilino, parent , false);
       }

       Inquilino inquilino = lista.get(position);

        TextView dni = itemView.findViewById(R.id.tvNroDni);
        dni.setText(inquilino.getDni());

        TextView apellido = itemView.findViewById(R.id.tvApellido);
        apellido.setText(inquilino.getApellido());

        TextView nombre = itemView.findViewById(R.id.tvNombre);
        nombre.setText(inquilino.getNombre());

        TextView direccion = itemView.findViewById(R.id.tvDireccion);
        direccion.setText(inquilino.getDireccion());

        TextView telefono = itemView.findViewById(R.id.tvTelefono);
        telefono.setText(inquilino.getTelefono());

        return itemView;
    }
}
