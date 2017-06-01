package ejemplo.domotica.Config_Equipos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ejemplo.domotica.Control_Equipos.Control_Aire;
import ejemplo.domotica.R;

/**
 * Created by levaa_000 on 12/12/2015.
 */
public class Config_Aire extends AppCompatActivity {
    public static String NAME_PREF = "PreferenciasUsuario1";
    public static String ID = "NombreDisp_aire";
    public static String IP = "IpAire";
    private Button Guardara , Conectar_Aire;
    private EditText ID_Aire,IP_Aire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_aire);
        Guardara=(Button)findViewById(R.id.btn_GuardarAire);
        Conectar_Aire=(Button)findViewById(R.id.btn_Conectar4);
        ID_Aire=(EditText)findViewById(R.id.edit_id4);
        IP_Aire=(EditText)findViewById(R.id.edit_ip4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        CargarPreferencia1();
        Guardara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarPreferencia1();
            }
        });

        Conectar_Aire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Config_Aire.this, Control_Aire.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void CargarPreferencia1()
    {
        SharedPreferences mispreferencias1=getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        ID_Aire.setText(mispreferencias1.getString(ID, ""));
        IP_Aire.setText(mispreferencias1.getString(IP, ""));
    }

    public void GuardarPreferencia1() {
        SharedPreferences mispreferencias = getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        String NombreDisp_Aire = ID_Aire.getText().toString();
        String Ipaire = IP_Aire.getText().toString();

        if (NombreDisp_Aire.length() == 0 || Ipaire.length() == 0) {
            Toast.makeText(this, "Faltan Datos", Toast.LENGTH_LONG).show();
        } else{
            editor.putString(ID, NombreDisp_Aire);
            editor.putString(IP, Ipaire);
            editor.commit();
        }

    }

}