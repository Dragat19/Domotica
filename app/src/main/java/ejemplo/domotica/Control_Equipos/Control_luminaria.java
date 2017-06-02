package ejemplo.domotica.Control_Equipos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextSwitcher;
import android.widget.TextView;

import ejemplo.domotica.R;

import static ejemplo.domotica.Config_Equipos.Config_Luminaria.ID_LUMI;
import static ejemplo.domotica.Config_Equipos.Config_Luminaria.IP_LUMI;
import static ejemplo.domotica.Config_Equipos.Config_Luminaria.LUMI1;
import static ejemplo.domotica.Config_Equipos.Config_Luminaria.LUMI2;
import static ejemplo.domotica.Config_Equipos.Config_Luminaria.LUMI3;
import static ejemplo.domotica.Config_Equipos.Config_Luminaria.LUMI4;
import static ejemplo.domotica.Config_Equipos.Config_Luminaria.NAME_PREF;

/**
 * Created by levaa_000 on 12/14/2015.
 */
public class Control_luminaria extends AppCompatActivity implements Animation.AnimationListener{

    private Switch sw1,sw2,sw3,sw4;
    private TextView tx1,tx2,tx3,tx4;
    private ImageView img1,img2,img3,img4,setting;
    private String ubi1,ubi2,ubi3,ubi4;
    private Animation animationBlink;
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luminaria);
        sw1=(Switch)findViewById(R.id.switch1);
        sw2=(Switch)findViewById(R.id.switch2);
        sw3=(Switch)findViewById(R.id.switch3);
        sw4=(Switch)findViewById(R.id.switch4);
        tx1 = (TextView)findViewById(R.id.txt_lumi_Ubica1);
        tx2 = (TextView)findViewById(R.id.txt_lumi_Ubica2);
        tx3 = (TextView)findViewById(R.id.txt_lumi_Ubica3);
        tx4 = (TextView)findViewById(R.id.txt_lumi_Ubica4);
        img1=(ImageView)findViewById(R.id.imageView1);
        img2=(ImageView)findViewById(R.id.imageView2);
        img3=(ImageView)findViewById(R.id.imageView3);
        img4=(ImageView)findViewById(R.id.imageView4);
        setting = (ImageView)findViewById(R.id.settigs);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);





        animationBlink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        animationBlink.setAnimationListener(this);

        pref = getSharedPreferences(NAME_PREF,0);
        String id = pref.getString(ID_LUMI,"");
        String ip = pref.getString(IP_LUMI,"");
        ubi1 =  pref.getString(LUMI1,"");
        ubi2 =  pref.getString(LUMI2,"");
        ubi3 = pref.getString(LUMI3,"");
        ubi4 =  pref.getString(LUMI4,"");

        tx1.setText(ubi1);
        tx2.setText(ubi2);
        tx3.setText(ubi3);
        tx4.setText(ubi4);

        if (id.equals("")&& ip.equals("")){
            tx1.setText("Error");
            tx2.setText("Error");
            tx3.setText("Error");
            tx4.setText("Error");
            showDialog(this);
        }

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    img1.setImageResource(R.drawable.on);
                    sw1.setText("ON");
                } else {

                    img1.setImageResource(R.drawable.off);
                    sw1.setText("OFF");
                }

            }
        });

        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    img2.setImageResource(R.drawable.on);
                    sw2.setText("ON");
                }else{

                    img2.setImageResource(R.drawable.off);
                    sw2.setText("OFF");
                }

            }
        });
        sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    img3.setImageResource(R.drawable.on);
                    sw3.setText("ON");
                }else{

                    img3.setImageResource(R.drawable.off);
                    sw3.setText("OFF");
                }

            }
        });

        sw4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    img4.setImageResource(R.drawable.on);
                    sw4.setText("ON");
                }else{

                    img4.setImageResource(R.drawable.off);
                    sw4.setText("OFF");
                }
            }
        });


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

    private void showDialog(Context context){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Error Configuracion");
        dialog.setMessage("Necesitas introducir Id y Ip de tu dispositivo en Configuracion de Luminaria" );
        dialog.setIcon(R.drawable.error);
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK!",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.setCancelable(true);
                setting.startAnimation(animationBlink);
            }
        });
        dialog.create().show();
    }
}
