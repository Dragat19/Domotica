package ejemplo.domotica;

import android.app.AlertDialog;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button luminaria, tug,dimmer, aire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        luminaria = (Button) findViewById(R.id.btnluminaria);
        tug = (Button) findViewById(R.id.btntug);
        dimmer = (Button) findViewById(R.id.btndimmer);
        aire = (Button) findViewById(R.id.btnaire);

        tug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoform = new Intent(MainActivity.this, Tug.class);
                startActivity(nuevoform);

            }
        });

        luminaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, luminaria.class));
            }
        });
        dimmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Dimmer.class));
            }
        });
        aire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Aire.class));
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

                break;

            case R.id.menu_tug:

                break;


            case R.id.menu_dimmer:

                break;

            case R.id.menu_Conf_aire:

                break;

            case R.id.menu_info:
                LayoutInflater inflater=getLayoutInflater();
                View dialoglayout=inflater.inflate(R.layout.contacto, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(dialoglayout);
                builder.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

}


