package ejemplo.domotica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by levaa_000 on 12/11/2015.
 */
public class luminaria extends AppCompatActivity {
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

                /*Para pasar del layaout MainActivity a otro */
                Intent nuevoform = new Intent(luminaria.this, Control_luminaria.class);
                startActivity(nuevoform);
            }
        });
    }

    public void CargarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        ID_lumi.setText(mispreferencias.getString("NombreDisp_Lumi",""));
        IP_lumi.setText(mispreferencias.getString("IpLuminaria", ""));
        Ubic1.setText(mispreferencias.getString("Ubicacion1", ""));
        Ubic2.setText(mispreferencias.getString("Ubicacion2",""));
        Ubic3.setText(mispreferencias.getString("Ubicacion3",""));
        Ubic4.setText(mispreferencias.getString("Ubicacion4", ""));

    }
     public void GuardarPreferencia()
     {
         SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
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
             editor.putString("NombreDisp_Lumi", NombreDisp);
             editor.putString("IpLuminaria", IpLuminaria);
             editor.putString("Ubicacion1", Ubicacion1);
             editor.putString("Ubicacion2", Ubicacion2);
             editor.putString("Ubicacion3", Ubicacion3);
             editor.putString("Ubicacion4", Ubicacion4);
             editor.commit();
         }

     }
}
