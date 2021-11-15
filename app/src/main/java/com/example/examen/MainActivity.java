package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements DialogoLogin.InterfazDialogoInicioSesion {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogoLogin dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fragmentManager, "Dialogo Login");

    }

    @Override
    public void onPossitiveButtonClick(String nombre, String pass) {

        if(!nombre.equals("usuario") || !pass.equals("123456")) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setCancelable(false);
            alertDialog.setTitle("¡ATENCIÓN!");
            alertDialog.setMessage("Usuario y/o Contraseña incorrectos. La aplcación se cerrará");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            alertDialog.show();
        }
    }

    @Override
    public void onNegativeButtonClick() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("¡¡ATENCIÓN!!");
        alertDialog.setMessage("Usuario y password ncesarios para entrar en la aplicación");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.show();
    }

    public void salir(View v) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("ADIÓS");
        alertDialog.setMessage("Esperamos volver a verte muy pronto");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.show();
    }

    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("ADIÓS");
        alertDialog.setMessage("Esperamos volver a verte muy pronto");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.show();
    }

    public void actividad1(View v) {
        Intent intent = new Intent(MainActivity.this, Actividad1.class);
        startActivity(intent);
    }

    public void actividad2(View v) {
        Intent intent = new Intent(MainActivity.this, Actividad2.class);
        startActivity(intent);
    }


}