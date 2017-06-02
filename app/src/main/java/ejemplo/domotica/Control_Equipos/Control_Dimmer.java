package ejemplo.domotica.Control_Equipos;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import ejemplo.domotica.R;

import static ejemplo.domotica.Config_Equipos.Config_Dimmer.ID_DIMMER;
import static ejemplo.domotica.Config_Equipos.Config_Dimmer.IP_DIMMER;
import static ejemplo.domotica.Config_Equipos.Config_Dimmer.NAME_PREF;

/**
 * Created by levaa_000 on 12/14/2015.
 */
public class Control_Dimmer extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private SeekBar Barra;
    private TextView Progreso,Nombre_dimmer,texto_Extra;
    private ImageView Imag_dimmer;
    private WebView Web_dimmer;
    private ToggleButton toggle_btnon_off;
    private SharedPreferences pref;

   
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dimmer);

        Barra=(SeekBar)findViewById(R.id.seekBar);
        Progreso=(TextView)findViewById(R.id.status);
        texto_Extra=(TextView)findViewById(R.id.textV_extra);
        Nombre_dimmer=(TextView)findViewById(R.id.txt_nombre);
        Imag_dimmer=(ImageView)findViewById(R.id.imageView_dimmer);
        Web_dimmer=(WebView)findViewById(R.id.webView_dimmer);
        toggle_btnon_off=(ToggleButton)findViewById(R.id.toggleBtn);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Barra.setOnSeekBarChangeListener(this);

        pref = getSharedPreferences(NAME_PREF,0);
        final String ipx =pref.getString(IP_DIMMER,"");
        String idx = pref.getString(ID_DIMMER,"");

        Nombre_dimmer.setText(idx);
        Progreso.setText(ipx);


        Web_dimmer.setWebViewClient(new WebViewClient() {
            // evita que los enlaces se abran fuera nuestra app en el navegador de android
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String Progreso) {
                return false;
            }

        });

        toggle_btnon_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Encendido, Apagado;

                if (isChecked) {
                    texto_Extra.setText("Encendido");
                    Imag_dimmer.setImageResource(R.drawable.nivel11_md);
                    Encendido = "http://"+ipx+"/?pin=1";
                    Web_dimmer.loadUrl(Encendido);

                } else {
                    texto_Extra.setText("Apagado!!");
                    Imag_dimmer.setImageResource(R.drawable.nivel1_md);
                    Apagado = "http://"+ipx+"/?pin=0";
                    Web_dimmer.loadUrl(Apagado);

                }

            }
        });


    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        progress= progress*10;
        String Nvl_1,Nvl_2,Nvl_3,Nvl_4,Nvl_5,Nvl_6,Nvl_7,Nvl_8,Nvl_9,Nvl_10,Nvl_11;

        if(progress == 0){

            Imag_dimmer.setImageResource(R.drawable.nivel1_md);
            Progreso.setText(progress + "%");
            Nvl_1="http://192.168.4.1/?nvl=0";
            Web_dimmer.loadUrl(Nvl_1);

        }else{

            if(progress == 10){

                Imag_dimmer.setImageResource(R.drawable.nivel2_md);
                Progreso.setText(progress + "%");
                Nvl_2="http://192.168.4.1/?nvl=1";
                Web_dimmer.loadUrl(Nvl_2);

            }else{
                if(progress == 20){

                    Imag_dimmer.setImageResource(R.drawable.nivel3_md);
                    Progreso.setText(progress + "%");
                    Nvl_3="http://192.168.4.1/?nvl=2";
                    Web_dimmer.loadUrl(Nvl_3);

                }else{
                    if(progress == 30){

                        Imag_dimmer.setImageResource(R.drawable.nivel4_md);
                        Progreso.setText(progress + "%");
                        Nvl_4="http://192.168.4.1/?nvl=3";
                        Web_dimmer.loadUrl(Nvl_4);

                    }else{
                        if(progress == 40){

                            Imag_dimmer.setImageResource(R.drawable.nivel5_md);
                            Progreso.setText(progress + "%");
                            Nvl_5="http://192.168.4.1/?nvl=4";
                            Web_dimmer.loadUrl(Nvl_5);

                        }else{
                            if(progress == 50){

                                Imag_dimmer.setImageResource(R.drawable.nivel6_md);
                                Progreso.setText(progress + "%");
                                Nvl_6="http://192.168.4.1/?nvl=5";
                                Web_dimmer.loadUrl(Nvl_6);

                            }else {
                                if(progress == 60){

                                    Imag_dimmer.setImageResource(R.drawable.nivel7_md);
                                    Progreso.setText(progress + "%");
                                    Nvl_7="http://192.168.4.1/?nvl=6";
                                    Web_dimmer.loadUrl(Nvl_7);

                                }else {
                                    if(progress == 70){

                                        Imag_dimmer.setImageResource(R.drawable.nivel8_md);
                                        Progreso.setText(progress + "%");
                                        Nvl_8="http://192.168.4.1/?nvl=7";
                                        Web_dimmer.loadUrl(Nvl_8);
                                    }else {
                                        if(progress == 80){

                                            Imag_dimmer.setImageResource(R.drawable.nivel9_md);
                                            Progreso.setText(progress + "%");
                                            Nvl_9="http://192.168.4.1/?nvl=8";
                                            Web_dimmer.loadUrl(Nvl_9);
                                        }else{
                                            if(progress == 90){

                                                Imag_dimmer.setImageResource(R.drawable.nivel10_md);
                                                Progreso.setText(progress + "%");
                                                Nvl_10="http://192.168.4.1/?nvl=9";
                                                Web_dimmer.loadUrl(Nvl_10);
                                            }else{
                                                if(progress == 100){

                                                    Imag_dimmer.setImageResource(R.drawable.nivel11_md);
                                                    Progreso.setText(progress + "%");
                                                    Nvl_11="http://192.168.4.1/?nvl=10";
                                                    Web_dimmer.loadUrl(Nvl_11);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}


