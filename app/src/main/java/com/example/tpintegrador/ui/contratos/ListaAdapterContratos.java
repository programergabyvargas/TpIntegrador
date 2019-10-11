package com.example.tpintegrador.ui.contratos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tpintegrador.R;

import java.util.List;

public class ListaAdapterContratos extends ArrayAdapter<Contrato> {
    private Context context;
    private List<Contrato> lista;
    private LayoutInflater li;

    public ListaAdapterContratos(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater li) {
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
            itemView = li.inflate(R.layout.item_contrato, parent , false);
        }

        Contrato contrato = lista.get(position);

        TextView fechaInicio = itemView.findViewById(R.id.tvFechaInicio);
        fechaInicio.setText(contrato.getFechaInicio());

        TextView fechaFin = itemView.findViewById(R.id.tvFechaFin);
        fechaFin.setText(contrato.getFechaFin());

        TextView precio = itemView.findViewById(R.id.tvPrecio);
        precio.setText(contrato.getPrecio()+"");

        return itemView;
    }
}
