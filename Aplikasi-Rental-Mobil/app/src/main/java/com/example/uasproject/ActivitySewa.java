package com.example.uasproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ActivitySewa extends AppCompatActivity {
    DatePickerDialog picker;
    Button bt_tgl;
    TextView tvtgl;

    EditText edtnama,edtalamat,edthp,edtlama,edtktp;
    Spinner spinmerk;
    Button btnsimpan;


    String Nama,Alamat,Nohp,Merk,lama,Tanggal,KTP;
    String[] merk_mobil={"Avanza","Ertiga","Xpander","APV","Elf","innova","Pregio"};
    String tempmerk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa);
        getSupportActionBar().setTitle("Sewa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvtgl=findViewById(R.id.tvtgl);
        bt_tgl=findViewById(R.id.bt_tgl);
        edtktp=findViewById(R.id.edtktp);
        edtnama=findViewById(R.id.edtnama);
        edtalamat=findViewById(R.id.edtalamat);
        edthp=findViewById(R.id.edthp);
        edtlama=findViewById(R.id.edtlama);
        spinmerk=findViewById(R.id.spinmerk);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,merk_mobil);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinmerk.setAdapter(adapter);
        spinmerk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tempmerk=merk_mobil[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        bt_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(ActivitySewa.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvtgl.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


        btnsimpan=findViewById(R.id.btnsimpan);
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KTP=edtktp.getText().toString();
                Nama=edtnama.getText().toString();
                Alamat=edtalamat.getText().toString();
                Nohp=edthp.getText().toString();
                lama=edtlama.getText().toString();
                Merk= tempmerk;
                Tanggal=tvtgl.getText().toString();

                if (KTP.isEmpty()||Nama.isEmpty()||Alamat.isEmpty()||Nohp.isEmpty()||lama.isEmpty()||Merk.isEmpty()||Tanggal.isEmpty()){
                    Toast.makeText(ActivitySewa.this,"(*) tidak boleh kosong !",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i=new Intent(getApplicationContext(),DetailSewa.class);
                i.putExtra("Nama",Nama);
                i.putExtra("Alamat",Alamat);
                i.putExtra("Nohp",Nohp);
                i.putExtra("lama",lama);
                i.putExtra("Merk",Merk);
                i.putExtra("KTP",KTP);
                i.putExtra("Tanggal",Tanggal);
                startActivity(i);
            }
        });
    }

}
