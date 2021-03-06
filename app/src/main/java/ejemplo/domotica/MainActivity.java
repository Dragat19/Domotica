package ejemplo.domotica;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import ejemplo.domotica.Config_Equipos.Config_Aire;
import ejemplo.domotica.Config_Equipos.Config_Dimmer;
import ejemplo.domotica.Config_Equipos.Config_Luminaria;
import ejemplo.domotica.Config_Equipos.Config_Tug;
import ejemplo.domotica.Control_Equipos.Control_Aire;
import ejemplo.domotica.Control_Equipos.Control_Dimmer;
import ejemplo.domotica.Control_Equipos.Control_TUG;
import ejemplo.domotica.Control_Equipos.Control_luminaria;

public class MainActivity extends AppCompatActivity {
    private ImageButton luminaria, tug,dimmer, aire;
    private PrefManager prefManager;
    private TextView menu1,menu2,menu3,menu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        luminaria = (ImageButton) findViewById(R.id.btnluminaria);
        tug = (ImageButton) findViewById(R.id.btntug);
        dimmer = (ImageButton) findViewById(R.id.btndimmer);
        aire = (ImageButton) findViewById(R.id.btnaire);
        menu1= (TextView) findViewById(R.id.txt_menu1);
        menu2= (TextView) findViewById(R.id.txt_menu2);
        menu3= (TextView) findViewById(R.id.txt_menu3);
        menu4= (TextView) findViewById(R.id.txt_menu4);
        prefManager = new PrefManager(this);

        menu1.setPaintFlags(menu1.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prefManager.isFirstTug() == false){
                    prefManager.setFirstTug(false);
                    startActivity(new Intent(MainActivity.this, Control_TUG.class));
                }else {
                    prefManager.setFirstTug(false);
                    startActivity(new Intent(MainActivity.this, Config_Tug.class));
                }
            }
        });

        menu2.setPaintFlags(menu2.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prefManager.isFirstLumi() == false){
                    prefManager.setFirstLumi(false);
                    startActivity(new Intent(MainActivity.this, Control_luminaria.class));
                }else {
                    prefManager.setFirstLumi(false);
                    startActivity(new Intent(MainActivity.this, Config_Luminaria.class));
                }
            }
        });

        menu3.setPaintFlags(menu3.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prefManager.isFirstDimmer() == false){
                    prefManager.setFirstDimmer(false);
                    startActivity(new Intent(MainActivity.this, Control_Dimmer.class));
                }else {
                    prefManager.setFirstDimmer(false);
                    startActivity(new Intent(MainActivity.this, Config_Dimmer.class));
                }
            }
        });

        menu4.setPaintFlags(menu4.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prefManager.isFirstTimeAire()== false){
                    prefManager.setFirstAire(false);
                    startActivity(new Intent(MainActivity.this, Control_Aire.class));
                }else {
                    prefManager.setFirstAire(false);
                    startActivity(new Intent(MainActivity.this, Config_Aire.class));
                }
            }
        });


        tug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefManager.isFirstTug() == false){
                    prefManager.setFirstTug(false);
                    startActivity(new Intent(MainActivity.this, Control_TUG.class));
                }else {
                    prefManager.setFirstTug(false);
                    startActivity(new Intent(MainActivity.this, Config_Tug.class));
                }
            }
        });

        luminaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefManager.isFirstLumi() == false){
                    prefManager.setFirstLumi(false);
                    startActivity(new Intent(MainActivity.this, Control_luminaria.class));
                }else {
                    prefManager.setFirstLumi(false);
                    startActivity(new Intent(MainActivity.this, Config_Luminaria.class));
                }
            }
        });
        dimmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefManager.isFirstDimmer() == false){
                    prefManager.setFirstDimmer(false);
                    startActivity(new Intent(MainActivity.this, Control_Dimmer.class));
                }else {
                    prefManager.setFirstDimmer(false);
                    startActivity(new Intent(MainActivity.this, Config_Dimmer.class));
                }
            }
        });

        aire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefManager.isFirstTimeAire()== false){
                    prefManager.setFirstAire(false);
                    startActivity(new Intent(MainActivity.this, Control_Aire.class));
                }else {
                    prefManager.setFirstAire(false);
                    startActivity(new Intent(MainActivity.this, Config_Aire.class));
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_homtech, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_Conf_lumi:
                startActivity(new Intent(MainActivity.this, Config_Luminaria.class));
                break;

            case R.id.menu_tug:
                startActivity(new Intent(MainActivity.this, Config_Tug.class));
                break;


            case R.id.menu_dimmer:
                startActivity(new Intent(MainActivity.this, Config_Dimmer.class));
                break;

            case R.id.menu_Conf_aire:
                startActivity(new Intent(MainActivity.this, Config_Aire.class));
                break;

            case R.id.menu_info:
               /* LayoutInflater inflater=getLayoutInflater();
                View dialoglayout=inflater.inflate(R.layout.contacto, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(dialoglayout);
                builder.show();*/
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}


