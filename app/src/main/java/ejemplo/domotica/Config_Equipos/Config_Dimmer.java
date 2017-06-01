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

import ejemplo.domotica.Control_Equipos.Control_Dimmer;
import ejemplo.domotica.R;

/**
 * Created by levaa_000 on 12/12/2015.
 */
public class Config_Dimmer extends AppCompatActivity {
    public static final String NAME_PREF = "PreferenciasUsuario";
    public static final String ID_DIMMER = "NombreDisp_Dimmer";
    public static final String IP_DIMMER = "Ipdimmer";
    private Button Guardar_dimmer , Conectar_dimmer;
    private EditText ID_dimmer,IP_dimmer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_dimmer);
        Guardar_dimmer=(Button)findViewById(R.id.btn_GuardarDimmer);
        Conectar_dimmer=(Button)findViewById(R.id.btn_Conectar3);
        ID_dimmer=(EditText)findViewById(R.id.edit_id3);
        IP_dimmer=(EditText)findViewById(R.id.edit_ip3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        CargarPreferencia();
        Guardar_dimmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarPreferencia();
            }
        });

        Conectar_dimmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux_ipdim= IP_dimmer.getText().toString();
                String aux_iddim= ID_dimmer.getText().toString();

                if(aux_ipdim.matches("192.168.4.1") && !aux_iddim.matches("")) {
                Intent intent = new Intent(Config_Dimmer.this, Control_Dimmer.class);
                    intent.putExtra(ID_DIMMER, aux_ipdim);
                    intent.putExtra(IP_DIMMER, aux_iddim);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void CargarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences(NAME_PREF, Context.MODE_MULTI_PROCESS);
        ID_dimmer.setText(mispreferencias.getString( ID_DIMMER, ""));
        IP_dimmer.setText(mispreferencias.getString(IP_DIMMER, ""));

    }

    public void GuardarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences(NAME_PREF, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=mispreferencias.edit();
        String NombreDisp_dimmer= ID_dimmer.getText().toString();
        String Ipdimer= IP_dimmer.getText().toString();

        if( NombreDisp_dimmer.length()== 0 || Ipdimer.length()== 0){

            Toast.makeText(this,"Faltan Datos", Toast.LENGTH_LONG).show();
        }else {

            Toast.makeText(this, "Datos Guardado", Toast.LENGTH_SHORT).show();
            editor.putString(ID_DIMMER, NombreDisp_dimmer);
            editor.putString(IP_DIMMER, Ipdimer);
            editor.commit();
        }
    }
}
