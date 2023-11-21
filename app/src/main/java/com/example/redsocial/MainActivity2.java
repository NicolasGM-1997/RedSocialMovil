package com.example.redsocial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    private EditText userName, ciudad, nombre, fechaNacimiento, passUser;
    private Button registrarse;
    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();
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
                String userText,nombreText,ciudadText,fechaText,passText;
                String userId = data.child("usuarios").push().getKey();
                userText = userName.getText().toString();
                nombreText = nombre.getText().toString();
                ciudadText = ciudad.getText().toString();
                fechaText = fechaNacimiento.getText().toString();
                passText = passUser.getText().toString();
                Usuario newUser = new Usuario(userText,nombreText,ciudadText,fechaText,passText);
                data.child("usuarios").child(userId).setValue(newUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Datos enviados",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
            }
        });
    }
}