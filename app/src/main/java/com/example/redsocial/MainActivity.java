package com.example.redsocial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText usuario, password;
    private Button login, registro;
    private FirebaseAuth auth;
    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        registro = findViewById(R.id.registro);
        auth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user, pass;
                user = usuario.getText().toString();
                pass = password.getText().toString();
                verificacion(user, pass);
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
    private void verificacion(String userValid, String passValid) {
        DatabaseReference validar = FirebaseDatabase.getInstance().getReference().child("usuarios");
        validar.orderByChild("name").equalTo(userValid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Obtener el primer y único usuario
                    DataSnapshot userSnapshot = snapshot.getChildren().iterator().next();
                    String passUser = userSnapshot.child("pass").getValue(String.class);

                    // Verificar las credenciales
                    if (passUser != null && passUser.equals(passValid)) {
                        Toast.makeText(getApplicationContext(), "Ha iniciado Sesión", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario no encontrado en la base de datos", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Error de base de datos: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
