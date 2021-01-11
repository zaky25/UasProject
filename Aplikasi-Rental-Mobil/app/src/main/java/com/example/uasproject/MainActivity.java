package com.example.uasproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.temporal.IsoFields;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Rental Mobil");

        Button btShow = (Button) findViewById(R.id.bt_customdialog);
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Initiate Custom Dialog
                 */
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.layout_customdialog);
                dialog.setTitle("Kelompok 1");

                /**
                 * Mengeset komponen dari custom dialog
                 */
                TextView satu= dialog.findViewById(R.id.Zaky);
                satu.setText("Creat By , Abdullah Zaky Al Luthfi");
                TextView dua= dialog.findViewById(R.id.Aziz);
                dua.setText("Muhamad Aziz Mulyana");
                TextView tiga= dialog.findViewById(R.id.Agus);
                tiga.setText("Muhamamad Agus Bahesti");
                TextView empat= dialog.findViewById(R.id.Gilang);
                empat.setText("Gilang Rama Maulana");
                TextView lima= dialog.findViewById(R.id.Rio);
                lima.setText("Rio Al Fikri");
                ImageView image =dialog.findViewById(R.id.icon);
                image.setImageResource(R.mipmap.ic_launcher);

                Button dialogButton = dialog.findViewById(R.id.bt_ok);
                /**
                 * Jika tombol diklik, tutup dialog
                 */

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        Button btn_informasi = findViewById(R.id.btn_info_mobil);
        Button btn_sewa = findViewById(R.id.btn_sewa);

        btn_informasi.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DaftarMobilActivity.class));
        });
        btn_sewa.setOnClickListener(v -> {
            Intent sew = new Intent(getApplicationContext(), ActivitySewa.class);
            startActivity(sew);
        });

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
