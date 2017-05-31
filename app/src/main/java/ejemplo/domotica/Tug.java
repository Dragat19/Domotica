package ejemplo.domotica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by levaa_000 on 12/11/2015.
 */
public class Tug extends AppCompatActivity {

    private Button Guardar_tug, Conectar_tug;
    private EditText ID_tug;
    private EditText IP_tug;
    private CheckBox CheckBtn1,CheckBtn2,CheckBtn3,CheckBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_tug);
        Guardar_tug=(Button)findViewById(R.id.btn_Guardar2);
        Conectar_tug=(Button)findViewById(R.id.btn_Conectar2);
        ID_tug=(EditText)findViewById(R.id.edit_id1);
        IP_tug=(EditText)findViewById(R.id.edit_ip1);
        CheckBtn1=(CheckBox)findViewById(R.id.radioBtn1);
        CheckBtn2=(CheckBox)findViewById(R.id.radioBtn2);
        CheckBtn3=(CheckBox)findViewById(R.id.radioBtn3);
        CheckBtn4=(CheckBox)findViewById(R.id.radioBtn4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        CargarPreferencia();
        Guardar_tug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GuardarPreferencia();
            }
        });

        Conectar_tug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux_ip= IP_tug.getText().toString();
                String aux_id= ID_tug.getText().toString();
                /*Para pasar del layaout MainActivity a otro */
                if(!aux_ip.matches("") && !aux_id.matches("")) {
                    Intent nuevoform = new Intent(Tug.this, Control_TUG.class);
                    nuevoform.putExtra("IpTUG", aux_ip);
                    nuevoform.putExtra("NombreDisp", aux_id);
                    startActivity(nuevoform);
                }else{
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void CargarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        ID_tug.setText(mispreferencias.getString("NombreDisp",""));
        IP_tug.setText(mispreferencias.getString("IpTUG", ""));
        CheckBtn1.setChecked(mispreferencias.getBoolean("CheckBtn1", false));
        CheckBtn2.setChecked(mispreferencias.getBoolean("CheckBtn2", false));
        CheckBtn3.setChecked(mispreferencias.getBoolean("CheckBtn3", false));
        CheckBtn4.setChecked(mispreferencias.getBoolean("CheckBtn4", false));

    }
    public void GuardarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mispreferencias.edit();
        String NombreDisp= ID_tug.getText().toString();
        String IpTUG= IP_tug.getText().toString();
        boolean Cafetera=CheckBtn1.isChecked();
        boolean Micro= CheckBtn2.isChecked();
        boolean TV= CheckBtn3.isChecked();
        boolean Otros= CheckBtn4.isChecked();

        if( NombreDisp.length()==0 || IpTUG.length()==0) {

            Toast.makeText(this, "Faltan Datos", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Datos Guardado", Toast.LENGTH_SHORT).show();
            editor.putString("NombreDisp", NombreDisp);
            editor.putString("IpTUG", IpTUG);
            editor.putBoolean("CheckBtn1", Cafetera);
            editor.putBoolean("CheckBtn2", Micro);
            editor.putBoolean("CheckBtn3", TV);
            editor.putBoolean("CheckBtn4", Otros);
            editor.commit();
        }


    }
}
