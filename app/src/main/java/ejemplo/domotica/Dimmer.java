package ejemplo.domotica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by levaa_000 on 12/12/2015.
 */
public class Dimmer extends AppCompatActivity {

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
                /*Para pasar del layaout MainActivity a otro */
                if(aux_ipdim.matches("192.168.4.1") && !aux_iddim.matches("")) {
                Intent nuevoform = new Intent(Dimmer.this, Control_Dimmer.class);
                    nuevoform.putExtra("Ipdimmer", aux_ipdim);
                    nuevoform.putExtra("NombreDisp_Dimmer", aux_iddim);
                    startActivity(nuevoform);
                }else{
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void CargarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_MULTI_PROCESS);
        ID_dimmer.setText(mispreferencias.getString("NombreDisp_Dimmer", ""));
        IP_dimmer.setText(mispreferencias.getString("Ipdimmer", ""));

    }

    public void GuardarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=mispreferencias.edit();
        String NombreDisp_dimmer= ID_dimmer.getText().toString();
        String Ipdimer= IP_dimmer.getText().toString();

        if( NombreDisp_dimmer.length()== 0 || Ipdimer.length()== 0){

            Toast.makeText(this,"Faltan Datos", Toast.LENGTH_LONG).show();
        }else {

            Toast.makeText(this, "Datos Guardado", Toast.LENGTH_SHORT).show();
            editor.putString("NombreDisp_Dimmer", NombreDisp_dimmer);
            editor.putString("Ipdimmer", Ipdimer);
            editor.commit();
        }
    }
}
