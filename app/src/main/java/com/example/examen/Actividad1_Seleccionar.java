package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad1_Seleccionar extends AppCompatActivity {

    private TextView txtNombre, txtFechaNacimiento, txtProvincia, txtSexo, txtConocimientos;
    private Button btnAceptar, btnRechazar;

    @Override
    protected void onCreate(Bundle savedIntance) {
        super.onCreate(savedIntance);
        setContentView(R.layout.actividad1_seleccionar);

        Bundle datos = getIntent().getExtras();

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtFechaNacimiento = (TextView) findViewById(R.id.txtFechaNacimiento);
        txtProvincia = (TextView) findViewById(R.id.txtProvincia);
        txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtConocimientos = (TextView) findViewById(R.id.txtConocimientos);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);

        txtNombre.setText(datos.getString("nombre"));
        txtFechaNacimiento.setText(datos.getString("fecha"));
        txtProvincia.setText(datos.getString("provincia"));
        txtSexo.setText(datos.getString("sexo"));
        ArrayList<String> conocimientos = datos.getStringArrayList("conocimientos");
        String conocs = "";
        for(String con : conocimientos) {
            conocs += con + ", ";
        }
        if(conocs.equals("")) {
            txtConocimientos.setText("Sin conocimientos");
        }
        else {
            txtConocimientos.setText(conocs);
        }
    }

    public void aceptar(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void rechazar(View v) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}