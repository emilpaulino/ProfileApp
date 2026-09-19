package com.example.profileapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.profileapp.databinding.ActivityProfileBinding;

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
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


    }
}