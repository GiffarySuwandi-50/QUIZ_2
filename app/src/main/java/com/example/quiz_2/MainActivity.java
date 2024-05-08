package com.example.quiz_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quiz_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Cost cost = new Cost();

        binding.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (binding.PS5.isChecked()) {
                        cost.setType("PS5");
                        cost.setTarifType(10000);
                    } else if (binding.PS4.isChecked()) {
                        cost.setType("PS4");
                        cost.setTarifType(8000);
                    } else if (binding.PS3.isChecked()) {
                        cost.setType("PS3");
                        cost.setTarifType(5000);
                    } else if (binding.PSVR.isChecked()) {
                        cost.setType("PSVR");
                        cost.setTarifType(20000);
                    } else {
                        Toast.makeText(MainActivity.this, "Pilih type terlebih dahulu!", Toast.LENGTH_SHORT).show();
                    }

                    if (binding.indomie.isChecked()) {
                        cost.setTambahan("Indomie");
                        cost.setTarifTambahan(7000);
                    } else if (binding.mieAyam.isChecked()) {
                        cost.setTambahan("Mie Ayam");
                        cost.setTarifTambahan(10000);
                    } else if (binding.siomay.isChecked()) {
                        cost.setTambahan("Siomay");
                        cost.setTarifTambahan(5000);
                    }

                    String waktu = binding.etWaktu.getText().toString();
                    int waktuMain = Integer.parseInt(waktu);
                    if (waktu.isEmpty()) {
                        binding.etWaktu.setError("Isi Terlebih Dahulu!");
                    } else {
                        cost.setWaktu(waktuMain);
                    }

                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.KEY_DATA, cost);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    binding.etWaktu.setError("Waktu harus berupa angka!");
                }
            }
        });
    }
}