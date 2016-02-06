package com.example.omerf.kitapuygulamasi;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.InputSource;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    ListView list1;
    String baslik,aciklama;
    Button ekle,cikar;


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
                    case "Yüzüklerin Efendisi":
                        aciklama = getResources().getString(R.string.yuzuklerinefendisi);
                        break;
                    //strings.xml den veri çekmek için kullanılır.
                    //getResources().getString(R.string.yuzuklerinefendisi);

                    case "Harry Potter":
                        aciklama = getResources().getString(R.string.harrypotter);
                        break;
                    case "Kitap3":
                        aciklama = getResources().getString(R.string.kitap3);
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
                Toast.makeText(MainActivity.this,"Çıkarıldı",Toast.LENGTH_LONG).show();
            }
        });



    }
}

