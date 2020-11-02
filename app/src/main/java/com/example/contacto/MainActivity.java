package com.example.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static java.util.Calendar.DAY_OF_MONTH;

public class MainActivity extends AppCompatActivity {

    //variables
    private EditText etNombre, etTelefono, etFecha, etEmail,etDescrip;

//variable calendario
    Calendar fecha = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//viculacion de variables con el diseño

        etNombre    = (EditText)findViewById(R.id.etnombre);
        etFecha     = (EditText) findViewById(R.id.etfecha);
        etTelefono  = (EditText)findViewById(R.id.ettelefono);
        etEmail     = (EditText)findViewById(R.id.etemail);
        etDescrip   = (EditText)findViewById(R.id.etdescripcion);

//captura de datos del activity detalles.

        String dato_nom = getIntent().getStringExtra("Nombre");
        String dato_fec = getIntent().getStringExtra("Fecha");
        String dato_tel = getIntent().getStringExtra("Telefono");
        String dato_ema = getIntent().getStringExtra("Email");
        String dato_des = getIntent().getStringExtra("Descripcion");

  //Mostrar datos del activity deatlles en  los campos correspondientes

        etNombre.setText(dato_nom);
        etFecha.setText( dato_fec );
        etTelefono.setText(dato_tel);
        etEmail.setText(dato_ema);
        etDescrip.setText(dato_des);

  //Proceso del Calendario.

        //al hacer click en el EditText

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, dia, fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH), fecha.get(DAY_OF_MONTH)).show();
            }
        });
    }

    //recoger datos de los dias selecionados en el caledario y colocarlo en el EditText de fecha.

        DatePickerDialog.OnDateSetListener dia = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fecha.set(Calendar.YEAR, year);
                fecha.set(Calendar.MONTH, month);
                fecha.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                actualizarInput(view);
            }
        };

//Metodo de Actualizaciíon de EditText a la fecha.

    private void actualizarInput(View view){
        String formatoDeFecha = "MM/dd/yy";
        SimpleDateFormat formato =new SimpleDateFormat(formatoDeFecha, Locale.US);
        etFecha.setText(formato.format(fecha.getTime()));
    }

//Metodo boton guardar.

      public void guardar(View view){
          Intent envio = new Intent(this, Detalle_Contacto.class);
          envio.putExtra("Nombre",etNombre.getText().toString());
          envio.putExtra("Fecha",etFecha.getText().toString());
          envio.putExtra("Telefono",etTelefono.getText().toString());
          envio.putExtra("Email",etEmail.getText().toString());
          envio.putExtra("Descripcion",etDescrip.getText().toString());
          startActivity(envio);
    }

    //Metodo del boton añadir para actualizar los campos.

    public void anadir(View view){
        Intent anadir = new Intent(this, MainActivity.class);
        startActivity(anadir);

    }
}
