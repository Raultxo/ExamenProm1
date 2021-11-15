package com.example.examen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoLogin extends DialogFragment {

    private InterfazDialogoInicioSesion listener;
    private EditText txtNombre, txtPass;

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = onCreateView(inflater, null,null);
        builder.setView(inflater.inflate(R.layout.dialogo_login, null))
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onPossitiveButtonClick(txtNombre.getText().toString(), txtPass.getText().toString());
                    }
                }).setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onNegativeButtonClick();
            }
        });
        return builder.create();
    }

    public void onStart() {
        super.onStart();
        txtNombre = (EditText) getDialog().findViewById(R.id.txtNombre);
        txtPass = (EditText) getDialog().findViewById(R.id.txtPass);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (InterfazDialogoInicioSesion) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " no Implemento InterfazDialogoInicioSesion");
        }
    }

    public interface InterfazDialogoInicioSesion {
        void onPossitiveButtonClick(String nombre, String pass);
        void onNegativeButtonClick();
    }

}
