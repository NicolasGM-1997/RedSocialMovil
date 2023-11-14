package com.example.redsocial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText userName, ciudad, nombre, fechaNacimiento, passUser;
    private Button registrarse;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userName = findViewById(R.id.userName);
        ciudad = findViewById(R.id.ciudad);
        nombre = findViewById(R.id.nombre);
        fechaNacimiento = findViewById(R.id.fechaNacimiento);
        passUser = findViewById(R.id.passUser);
        registrarse = findViewById(R.id.registrarse);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                String user,id,ciu,nom,fec,pass,mensaje;
                user = userName.getText().toString();
                ciu = ciudad.getText().toString();
                nom = nombre.getText().toString();
                fec = fechaNacimiento.getText().toString();
                pass = passUser.getText().toString();
                mensaje = "Usuario: "+user+"\nCiudad: "+ciu+"\nNombre: "+nom+"\nFecha de Nacimiento: "+fec+"\nContraseña: "+pass;
                Toast toast = Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}