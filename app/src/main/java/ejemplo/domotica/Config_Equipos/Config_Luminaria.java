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

import ejemplo.domotica.Control_Equipos.Control_luminaria;
import ejemplo.domotica.R;

/**
 * Created by levaa_000 on 12/11/2015.
 */
public class Config_Luminaria extends AppCompatActivity {

    public static final String NAME_PREF = "PreferenciasUsuario";
    public static final String ID_LUMI = "NombreDisp_Lumi";
    public static final String IP_LUMI = "IpLuminaria";
    public static final String LUMI1 = "Ubicacion1";
    public static final String LUMI2 = "Ubicacion2";
    public static final String LUMI3 = "Ubicacion3";
    public static final String LUMI4 = "Ubicacion4";
    private Button Guardar_lumi , Conectar_lumi;
    private EditText ID_lumi,IP_lumi,Ubic1,Ubic2,Ubic3,Ubic4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_luminaria);
        Guardar_lumi=(Button)findViewById(R.id.btn_Guardar);
        Conectar_lumi=(Button)findViewById(R.id.btn_Conectar);
        ID_lumi=(EditText)findViewById(R.id.edit_id2);
        IP_lumi=(EditText)findViewById(R.id.edit_ip2);
        Ubic1=(EditText)findViewById(R.id.edit_Ubic1);
        Ubic2=(EditText)findViewById(R.id.edit_Ubic2);
        Ubic3=(EditText)findViewById(R.id.edit_Ubic3);
        Ubic4=(EditText)findViewById(R.id.edit_Ubic4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        CargarPreferencia();
        Guardar_lumi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GuardarPreferencia();
            }
        });

        Conectar_lumi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Config_Luminaria.this, Control_luminaria.class);
                intent.putExtra(LUMI1,Ubic1.getText().toString());
                intent.putExtra(LUMI2,Ubic2.getText().toString());
                intent.putExtra(LUMI3,Ubic3.getText().toString());
                intent.putExtra(LUMI4,Ubic4.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void CargarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        ID_lumi.setText(mispreferencias.getString(ID_LUMI,""));
        IP_lumi.setText(mispreferencias.getString(IP_LUMI, ""));
        Ubic1.setText(mispreferencias.getString(LUMI1, ""));
        Ubic2.setText(mispreferencias.getString(LUMI2,""));
        Ubic3.setText(mispreferencias.getString(LUMI3,""));
        Ubic4.setText(mispreferencias.getString(LUMI4, ""));

    }
     public void GuardarPreferencia()
     {
         SharedPreferences mispreferencias=getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
         SharedPreferences.Editor editor=mispreferencias.edit();
         String NombreDisp= ID_lumi.getText().toString();
         String IpLuminaria= IP_lumi.getText().toString();
         String Ubicacion1= Ubic1.getText().toString();
         String Ubicacion2= Ubic2.getText().toString();
         String Ubicacion3= Ubic3.getText().toString();
         String Ubicacion4= Ubic4.getText().toString();

         if( NombreDisp.length()==0 || IpLuminaria.length()==0 || Ubicacion1.length()==0 || Ubicacion2.length()==0 || Ubicacion3.length()==0 || Ubicacion4.length()==0) {

             Toast.makeText(this, "Faltan Datos", Toast.LENGTH_LONG).show();

         }else {
             Toast.makeText(this, "Datos Guardado", Toast.LENGTH_SHORT).show();
             editor.putString(ID_LUMI, NombreDisp);
             editor.putString(IP_LUMI, IpLuminaria);
             editor.putString(LUMI1, Ubicacion1);
             editor.putString(LUMI2, Ubicacion2);
             editor.putString(LUMI3, Ubicacion3);
             editor.putString(LUMI4, Ubicacion4);
             editor.commit();
         }

     }
}
