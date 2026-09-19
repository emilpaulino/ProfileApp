package com.example.profileapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.profileapp.databinding.ActivityProfileBinding;
import com.example.profileapp.databinding.ActivityProfileSummaryBinding;

public class ProfileSummary extends AppCompatActivity {

    ActivityProfileSummaryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityProfileSummaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        String name = getIntent().getStringExtra("name");
        String schId = getIntent().getStringExtra("schId");
        String career = getIntent().getStringExtra("career");

        binding.txtName2.setText(name);
        binding.txtSchId2.setText(schId);
        binding.txtCareer2.setText(career);

        binding.btnEdit.setOnClickListener(v -> {
            finish();
        });

    }
}