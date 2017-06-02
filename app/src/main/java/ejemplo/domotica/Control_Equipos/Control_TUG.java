package ejemplo.domotica.Control_Equipos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import ejemplo.domotica.Config_Equipos.Config_Tug;
import ejemplo.domotica.R;

import static ejemplo.domotica.Config_Equipos.Config_Tug.ID_TUG;
import static ejemplo.domotica.Config_Equipos.Config_Tug.IP_TUG;
import static ejemplo.domotica.Config_Equipos.Config_Tug.NAME_PREF;
import static ejemplo.domotica.Config_Equipos.Config_Tug.SPINNER_TUG;

/**
 * Created by levaa_000 on 12/14/2015.
 */
public class Control_TUG extends AppCompatActivity implements Animation.AnimationListener{
    private ToggleButton toggle_btn;
    private TextView Status,Nombre_tug;
    private ImageView load;
    private ImageView settings;
    private WebView Web_tug;
    private SharedPreferences pref;
    private Animation animateBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tug);
        toggle_btn=(ToggleButton)findViewById(R.id.toggleButton);
        Status=(TextView)findViewById(R.id.status);
        Nombre_tug=(TextView)findViewById(R.id.tv_tug);
        load=(ImageView)findViewById(R.id.imageView_tv);
        settings=(ImageView) findViewById(R.id.settigs);
        Web_tug=(WebView)findViewById(R.id.web_tug);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        pref = getSharedPreferences(NAME_PREF,0);
        String id = pref.getString(ID_TUG,"");
        final String xip = pref.getString(IP_TUG,"");
        final int PosicionSpinner= pref.getInt(SPINNER_TUG,0);

        //Nombre_tug.setText(id);
        Status.setText(xip);
        animateBlink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        animateBlink.setAnimationListener(this);


        // evita que los enlaces se abran fuera nuestra app en el navegador de android
        Web_tug.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String Status) {
                return false;
            }

        });


        switch (PosicionSpinner){
            case 0:
                Nombre_tug.setText("Cafetera");
                load.setImageResource(R.drawable.cafetera);
                break;
            case 1:
                Nombre_tug.setText("Microondas");
                load.setImageResource(R.drawable.micro);
                break;
            case 2:
                Nombre_tug.setText("Televisor");
                load.setImageResource(R.drawable.tvonmd);
                break;
            case 3:
                Nombre_tug.setText("Otras Cargas");
                load.setImageResource(R.drawable.tug);
                break;
        }

        if (id.equals("") && xip.equals("")){
            Status.setText("Error");
            showDialog(this);
        }


        toggle_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Encendido, Apagado;
                if (isChecked) {
                    Status.setText("Encendido");
                    //load.setImageResource(R.drawable.tvonmd);
                    Encendido="http://"+xip+"/?nvl=2";
                    Web_tug.loadUrl(Encendido);

                } else {
                    Status.setText("Apagado");
                    //load.setImageResource(R.drawable.tvmed);
                    Apagado="http://"+xip+"/?nvl=4";
                    Web_tug.loadUrl(Apagado);

                }

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Control_TUG.this, Config_Tug.class);
                startActivity(intent);
                finish();
            }
        });




    }

    public void showDialog(Context context){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Error Configuracion");
        dialog.setMessage("Necesitas introducir Id y Ip de tu dispositivo en Configuracion de Tug" );
        dialog.setIcon(R.drawable.error);
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK!",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.setCancelable(true);
                settings.startAnimation(animateBlink);
            }
        });
        dialog.create().show();
    }




    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animateBlink){

        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
