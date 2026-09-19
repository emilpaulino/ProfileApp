package com.example.profileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.profileapp.databinding.ActivityProfileBinding;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileView extends AppCompatActivity {

    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] careers = {"Ing. Ciencias de la Computación", "Ing. Telemática", "Ing. Matemáticas y Ciencias de Datos"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, careers);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnCareer.setAdapter(spinnerAdapter);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                validationAndSave();
            }
        });
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    private void validationAndSave() {
        AtomicBoolean validated = new AtomicBoolean(true);
        if(binding.txtName.getText() == null || binding.txtName.getText().toString().isEmpty()){
            binding.txtName.setError("El nombre es obligatorio");
            validated.set(false);
        }
        if(binding.txtSchId.getText() == null || binding.txtSchId.getText().toString().isEmpty()){
            binding.txtSchId.setError("La matrícula es obligatoria");
            validated.set(false);
        }
        if(validated.get()){
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Revise los errores en los campos", Toast.LENGTH_LONG).show();
        }
    }
}