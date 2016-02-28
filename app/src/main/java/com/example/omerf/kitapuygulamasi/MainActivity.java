package com.example.omerf.kitapuygulamasi;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.InputSource;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    ListView list1;
    String baslik,aciklama;
    Button ekle,cikar;
    private ImageView resim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView) findViewById(R.id.list1);
        ekle = (Button) findViewById(R.id.ekle);
        cikar = (Button) findViewById(R.id.cikar);


        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                baslik = (String) ((TextView) view).getText();
                builder.setTitle(baslik);

                switch (baslik) {
                    case "Y�z�klerin Efendisi":
                        aciklama = getResources().getString(R.string.yuzuklerinefendisi);
                        break;
                    //strings.xml den veri �ekmek i�in kullan�l�r.
                    //getResources().getString(R.string.yuzuklerinefendisi);

                    case "Harry Potter":
                        aciklama = getResources().getString(R.string.harrypotter);
                        break;
                    case "Sherlock Holmes":
                        aciklama = getResources().getString(R.string.sherlockholmes);
                        break;
                    case "Taht Oyunlar�":
                        aciklama = getResources().getString(R.string.gameofthrones);
                        break;
                    case "Simyac�":
                        aciklama = getResources().getString(R.string.simyaci);
                        break;
                    case "Y�zy�ll�k Yaln�zl�k":
                        aciklama = getResources().getString(R.string.yuzyillikyalnizlik);
                        break;
                    case "Kitap6":
                        aciklama = getResources().getString(R.string.Kitap6);
                        break;
                    case "Kitap7":
                        aciklama = getResources().getString(R.string.Kitap7);
                        break;
                    case "Kitap8":
                        aciklama = getResources().getString(R.string.Kitap8);
                        break;
                    case "Kitap9":
                        aciklama = getResources().getString(R.string.Kitap9);
                        break;
                    case "Kitap10":
                        aciklama = getResources().getString(R.string.Kitap10);
                        break;
                    case "Kitap11":
                        aciklama = getResources().getString(R.string.Kitap11);
                        break;
                    case "Kitap12":
                        aciklama = getResources().getString(R.string.Kitap12);
                        break;
                    case "Kitap13":
                        aciklama = getResources().getString(R.string.Kitap13);
                        break;
                    case "Kitap14":
                        aciklama = getResources().getString(R.string.Kitap14);
                        break;
                    case "Kitap15":
                        aciklama = getResources().getString(R.string.Kitap15);
                        break;


                }
                builder.setMessage(aciklama);
                builder.show();
            }
        });
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Eklendi", Toast.LENGTH_LONG).show();
            }
        });
        cikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"��kar�ld�",Toast.LENGTH_LONG).show();
            }
        });



    }
}

