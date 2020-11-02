package com.example.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalle_Contacto extends AppCompatActivity {

    //Variables.
    private TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__contacto);

        //Variables vinculando al diseño.

        tvNombre = (TextView)findViewById(R.id.tvnombre);
        tvFecha = (TextView)findViewById(R.id.tvfecha2);
        tvTelefono = (TextView)findViewById(R.id.tvtel2);
        tvEmail = (TextView)findViewById(R.id.tvema2);
        tvDescrip = (TextView)findViewById(R.id.tvdesc2);

        //Recofiendo datos del MainActivity.

        String dato_nom = getIntent().getStringExtra("Nombre");
        String dato_fec = getIntent().getStringExtra("Fecha");
        String dato_tel = getIntent().getStringExtra("Telefono");
        String dato_ema = getIntent().getStringExtra("Email");
        String dato_des = getIntent().getStringExtra("Descripcion");

        // Asignando datos compilados en sus respectivo campo.

        tvNombre.setText(dato_nom);
        tvFecha.setText(dato_fec );
        tvTelefono.setText(dato_tel);
        tvEmail.setText( dato_ema);
        tvDescrip.setText( dato_des);

    }

 //Metodo del boton Editar.

 public void editar(View view){
     Intent perfil = new Intent(this, MainActivity.class);
     perfil.putExtra("Nombre", tvNombre.getText().toString());
     perfil.putExtra("Fecha", tvFecha.getText().toString());
     perfil.putExtra("Telefono", tvTelefono.getText().toString());
     perfil.putExtra("Email", tvEmail.getText().toString());
     perfil.putExtra("Descripcion", tvDescrip.getText().toString());
     startActivity(perfil);


 }
}