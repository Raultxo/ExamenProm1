package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorLocalidad extends ArrayAdapter<Localidad> {

    private Localidad[] datos;

    public AdaptadorLocalidad(@NonNull Context context, Localidad[] datos) {
        super(context, R.layout.listaitem, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listaitem, null);

        ImageView img = (ImageView) item.findViewById(R.id.img);
        img.setImageDrawable(datos[position].getImg());

        TextView txtNombre = (TextView) item.findViewById(R.id.txtNombre);
        txtNombre.setText(datos[position].getNombre());

        return item;
    }

}
