package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad1 extends AppCompatActivity {

    private final String[] provincias = new String[] {"Alava", "Madrid", "Gipuzkoa", "Bizkaia"};
    private Spinner spinProvincias;
    private EditText txtNombre, txtDia, txtMes, txtAnio;
    private RadioButton radioMasc, radioFem;
    private CheckBox checkPhp, checkJava, checkHtml, checkCss;
    private Button btnEvaluar, btnSalir;
    private TextView txtCandidatos;
    private static int numCandidatos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1);

        spinProvincias = (Spinner) findViewById(R.id.spinProvincia);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDia = (EditText) findViewById(R.id.txtDia);
        txtMes = (EditText) findViewById(R.id.txtMes);
        txtAnio = (EditText) findViewById(R.id.txtAnio);
        radioMasc = (RadioButton) findViewById(R.id.radioMasc);
        radioFem = (RadioButton) findViewById(R.id.radioFem);
        checkPhp = (CheckBox) findViewById(R.id.checkPhp);
        checkJava = (CheckBox) findViewById(R.id.checkJava);
        checkHtml = (CheckBox) findViewById(R.id.checkHtml);
        checkCss = (CheckBox) findViewById(R.id.checkCss);
        txtCandidatos = (TextView) findViewById(R.id.txtCandidatos);
        btnEvaluar = (Button) findViewById(R.id.btnvaluar);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        radioMasc.setChecked(true);

        btnSalir.setVisibility(View.INVISIBLE);
        btnEvaluar.setVisibility(View.VISIBLE);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provincias);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProvincias.setAdapter(adaptador);
    }

    public void salir(View v) {
        finish();
    }

    public void evaluar(View v) {

        String nombre = txtNombre.getText().toString();
        int dia = 0;
        int mes = 0;
        int anio = 0;
        try {
            dia = Integer.parseInt(txtDia.getText().toString());
            mes = Integer.parseInt(txtMes.getText().toString());
            anio = Integer.parseInt(txtAnio.getText().toString());
        } catch(NumberFormatException e) {}

        String provincia = (String) spinProvincias.getSelectedItem();
        String sexo;
        if(radioMasc.isChecked()) {
            sexo = radioMasc.getText().toString();
        }
        else {
            sexo = radioFem.getText().toString();
        }

        ArrayList<String> conocimiento = new ArrayList<String>();
        if(checkCss.isChecked()) {
            conocimiento.add(checkCss.getText().toString());
        }
        if(checkHtml.isChecked()) {
            conocimiento.add(checkHtml.getText().toString());
        }
        if(checkJava.isChecked()) {
            conocimiento.add(checkJava.getText().toString());
        }
        if(checkPhp.isChecked()) {
            conocimiento.add(checkPhp.getText().toString());
        }

        if(!(nombre.equals("") || dia == 0 || mes == 0 || anio == 0)) {
            Intent intent = new Intent(Actividad1.this, Actividad1_Seleccionar.class);
            String fecha = dia + "/" + mes + "/" + anio;
            intent.putExtra("nombre", nombre);
            intent.putExtra("fecha", fecha);
            intent.putExtra("provincia", provincia);
            intent.putExtra("sexo", sexo);
            intent.putExtra("conocimientos", conocimiento);
            startActivityForResult(intent, 1);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                numCandidatos++;
                if(numCandidatos < 4) {
                    btnSalir.setVisibility(View.INVISIBLE);
                    btnEvaluar.setVisibility(View.VISIBLE);
                }
                else {
                    btnSalir.setVisibility(View.VISIBLE);
                    btnEvaluar.setVisibility(View.INVISIBLE);
                }
                txtCandidatos.setText("Candidatos: " + numCandidatos);
                txtNombre.setText("");
                txtDia.setText("");
                txtMes.setText("");
                txtAnio.setText("");
                spinProvincias.setSelection(0);
                checkPhp.setChecked(false);
                checkJava.setChecked(false);
                checkHtml.setChecked(false);
                checkCss.setChecked(false);
                radioMasc.setChecked(true);
            }
        }
    }
}