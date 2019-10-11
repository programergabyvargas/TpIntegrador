package com.example.tpintegrador.ui.pagos;

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

public class ListaAdapterPagos extends ArrayAdapter<Pago> {
    private Context context;
    private List<Pago> lista;
    private LayoutInflater li;


    public ListaAdapterPagos(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater li) {
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
            itemView = li.inflate(R.layout.item_pago, parent , false);
        }
        Pago pago = lista.get(position);

        TextView nroPago = itemView.findViewById(R.id.tvFechaInicio);
        nroPago.setText(pago.getNroPago()+"");

        TextView fechaPago = itemView.findViewById(R.id.tvFechaFin);
        fechaPago.setText(pago.getFecha());

        TextView importe = itemView.findViewById(R.id.tvPrecio);
        importe.setText(pago.getImporte()+"");

        return itemView;
    }
}
