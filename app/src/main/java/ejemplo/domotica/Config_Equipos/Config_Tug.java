package ejemplo.domotica.Config_Equipos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ejemplo.domotica.Control_Equipos.Control_TUG;
import ejemplo.domotica.R;

/**
 * Created by levaa_000 on 12/11/2015.
 */
public class Config_Tug extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String NAME_PREF = "PreferenciasUsuario";
    public static final String ID_TUG = "NombreDisp";
    public static final String IP_TUG = "IpTUG";
    public static final String SPINNER_TUG ="spinner";
    public static final int DEFAULT_POSITION = 2;
    protected int position;
    protected String selection;
    private Button Guardar_tug, Conectar_tug;
    private Spinner spinner;
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
        spinner = (Spinner) findViewById(R.id.spinnerLoad);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /*Relacionando la escucha*/
        spinner.setOnItemSelectedListener(this);

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
                if(!aux_ip.matches("") && !aux_id.matches("")) {
                    Intent intent = new Intent(Config_Tug.this, Control_TUG.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void CargarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        ID_tug.setText(mispreferencias.getString(ID_TUG,""));
        IP_tug.setText(mispreferencias.getString(IP_TUG, ""));
        spinner.setSelection(mispreferencias.getInt(SPINNER_TUG,0));

    }
    public void GuardarPreferencia()
    {
        SharedPreferences mispreferencias=getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mispreferencias.edit();
        String NombreDisp= ID_tug.getText().toString();
        String IpTUG= IP_tug.getText().toString();
        int posicionSpinner = spinner.getSelectedItemPosition();


        if( NombreDisp.length()==0 || IpTUG.length()==0) {
            Toast.makeText(this, "Faltan Datos", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Datos Guardado", Toast.LENGTH_SHORT).show();
            editor.putString(ID_TUG, NombreDisp);
            editor.putString(IP_TUG, IpTUG);
            editor.putInt(SPINNER_TUG,posicionSpinner);
            editor.commit();
        }


    }

    @Override    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        /*Obtienes el item actualmente seleccionado */
        this.position = i;
        selection = adapterView.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
