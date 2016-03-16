package com.example.omerf.kitapuygulamasi;

import android.content.Context;
import android.database.sqlite.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;



public class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DB_PATH = "/data/data/kitap-uygulamasi/databases/";
    private static final String DB_NAME ="Kitap-Uygulamasi";
    private SQLiteDatabase sqLiteDatabase;
    private Context mContext;


    public DatabaseHelper (Context context)
    {
        super (context, DB_NAME, null, VERSION);
        mContext = context;

    }


    /*
         * E�er veritaban� yoksa kopyalay�p olu�turacak varsa hi�bir �ey yapmayacak
         * metodumuz.
         */
     public void createDataBase() throws IOException {

       boolean dbExist = checkDataBase();

        if(dbExist){
            //Veritaban� daha �nce mevcut o y�zden herhangi bir i�lem yapmaya gerek yok.
        }
        else{
            //Veritaban� daha �nce hi� olu�turulmam�� o y�zden veritaban�n� kopyala
            this.getReadableDatabase();
            try{
                copyDataBase();
            }
            catch (IOException e)
            {
                throw new Error("Veritaban� kopyalanamad�");
            }
        }

     }
   //  Veritaban� daha �nce olu�turulmu� mu olu�turulmam�� m� bunu ��renmek i�in yaz�lan method.

    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try
        {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }
        catch(SQLiteException e )
        {}
        if (checkDB != null)
        {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    /* Veritaban�n� assets'ten al�p
    * "/data/data/com.gelecegiyazanlar.orneksozluk/databases/" alt�na
    * kopyalayacak metod*/

    private void copyDataBase() throws IOException{

        InputStream myInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte [] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0 ){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    //Uygulama i�inde kullanaca��m�z db �rne�i

    public SQLiteDatabase getDatabase(){
        return sqLiteDatabase;
    }

    //  Veritaban�n� uygulamada kullanaca��m�z zaman a�mak i�in gerekli metod

    public void openDataBase () throws SQLException{
        String myPath = DB_PATH + DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    //Veritaban�n� i�imiz bitti�inde kapatmak i�in kullanaca��m�z metod

    @Override
    public synchronized void close(){
        if (sqLiteDatabase != null)
            sqLiteDatabase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db){
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
    }













}
