package com.example.redsocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, password;
    private Button login, registro;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        registro = findViewById(R.id.registro);
        login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                String userName = usuario.getText().toString();
                String passName = password.getText().toString();
                String mensaje = "Usuario: "+userName+"\n"+"Contraseña: "+passName;
                Toast toast = Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG);
                toast.show();
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}