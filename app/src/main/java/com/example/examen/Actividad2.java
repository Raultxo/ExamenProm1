package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class Actividad2 extends AppCompatActivity {

    private String[] provincias;
    private ArrayList<Localidad> arrayListLocalidades = new ArrayList<Localidad>();

    private Spinner spinProvincias;
    private LinearLayout ubicaciones;
    private RadioButton radioCosta, radioInterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        cargarDatos();

        spinProvincias = (Spinner) findViewById(R.id.spinProvincia);
        ubicaciones = (LinearLayout) findViewById(R.id.ubicacion);
        radioCosta = (RadioButton) findViewById(R.id.radioCosta);
        radioInterior = (RadioButton) findViewById(R.id.radioInterior);
        radioInterior.setChecked(true);

        ubicaciones.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provincias);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProvincias.setAdapter(adaptador);
        spinProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String provincia = (String) adapterView.getItemAtPosition(i);
                if(provincia != "") {
                    ArrayList<Localidad> localidadesDeProvincia = new ArrayList<Localidad>();
                    for(Localidad loc : arrayListLocalidades){
                        if(loc.getProvincia().equals(provincia)) {
                            localidadesDeProvincia.add(loc);
                        }
                    }

                    if(localidadesDeProvincia.size() == 0) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Actividad2.this).create();
                        alertDialog.setCancelable(false);
                        alertDialog.setTitle("Información");
                        alertDialog.setMessage("Las localidades de esta provincia no estan disposibles actualmente");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {}
                                });
                        alertDialog.show();
                    }
                    else {
                        boolean tieneCosta = false;
                        for (Localidad loc : localidadesDeProvincia) {
                            if(loc.getTipo().equals("Costa")) {
                                tieneCosta = true;
                            }
                        }
                        if(tieneCosta) {
                            ubicaciones.setVisibility(View.VISIBLE);
                        }
                        else {
                            ubicaciones.setVisibility(View.INVISIBLE);
                            radioInterior.setChecked(true);
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    public void volver(View v) {
        finish();
    }

    public void visualizar(View v) {
        String provincia = (String) spinProvincias.getSelectedItem();
        if(provincia != "") {
            String tipo;
            if(radioInterior.isChecked()) {
                tipo = radioInterior.getText().toString();
            }
            else {
                tipo = radioCosta.getText().toString();
            }

            ArrayList<Object> localidadesAVisualizar = new ArrayList<Object>();
            for(Localidad loc : arrayListLocalidades) {
                if(loc.getProvincia().equals(provincia) && loc.getTipo().equals(tipo)) {
                    localidadesAVisualizar.add(loc);
                }
            }

            Intent intent = new Intent(Actividad2.this, Actividad2_Lista.class);
            intent.putExtra("provincia", provincia);
            intent.putExtra("tipo", tipo);

            startActivity(intent);
        }
    }

    private void cargarDatos() {
        Localidad localidad;
        localidad = new Localidad("Orduña", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.orduna),"http://www.urduna.com/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Ondarroa", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.ondarroa),"http://www.ondarroa.eu/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Areatza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.areatza),"http://www.areatza.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Gernika", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.gernika), "http://www.gernika-lumo.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Bermeo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.bermeo),"http://www.bermeo.eus/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Balmaseda", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.balmaseda),"http://www.balmaseda.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Karrantza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.karrantza),"http://www.karrantza.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Lekeitio", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.lekeitio),"http://www.lekeitio.com/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Getxo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.getxo),"http://www.getxo.eus/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Laguardia", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.laguardia),"http://www.laguardia-alava.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Hondarribia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.hondarribia),"http://www.hondarribia.eus/es/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Zarautz", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.zarautz),"http://www.zarautz.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Pasaia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.pasaia),"http://www.pasaia.eus/es");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Astigarraga", "Gipuzkoa", "Interior", ContextCompat.getDrawable(this, R.drawable.astigarraga),"http://astigarraga.eus");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Donostia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.donostia),"http://www.donostia.eus");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Vitoria-Gasteiz", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.vitoria_gasteiz),"http://www.vitoria-gasteiz.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Añana", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.anana),"http://www.cuadrilladeanana.es/anana/");
        arrayListLocalidades.add(localidad);

        provincias = new String[] {"", "Bizkaia", "Araba", "Gipuzkoa", "Nafarroa", "Lapurdi", "Behe-Nafarroa", "Zuberoa"};
    }
}