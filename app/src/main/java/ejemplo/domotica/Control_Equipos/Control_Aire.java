package ejemplo.domotica.Control_Equipos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import ejemplo.domotica.R;

import static ejemplo.domotica.Config_Equipos.Config_Aire.ID;
import static ejemplo.domotica.Config_Equipos.Config_Aire.IP;
import static ejemplo.domotica.Config_Equipos.Config_Aire.NAME_PREF;

/**
 * Created by levaa_000 on 12/14/2015.
 */
public class Control_Aire extends AppCompatActivity implements Animation.AnimationListener{
    private ToggleButton Sw_aire;
    private ImageView aire,settings;
    private TextView Status1;
    private SharedPreferences pref;
    private Animation animationBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aire);
        Sw_aire=(ToggleButton)findViewById(R.id.toggleButton1);
        Status1=(TextView)findViewById(R.id.status1);
        aire=(ImageView)findViewById(R.id.imageView_aire);
        settings = (ImageView)findViewById(R.id.settigs);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        pref = getSharedPreferences(NAME_PREF,0);
        String id = pref.getString(ID,"");
        String ip = pref.getString(IP,"");

        animationBlink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        animationBlink.setAnimationListener(this);

        if (id.equals("")&& ip.equals("")){
            showDialog(this);
        }

        Sw_aire.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Status1.setText("Encendido");
                } else {
                    Status1.setText("Apagado");
                }
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
                settings.startAnimation(animationBlink);
            }
        });
        dialog.create().show();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animationBlink){

        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}