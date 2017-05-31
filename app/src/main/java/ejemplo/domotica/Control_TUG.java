package ejemplo.domotica;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by levaa_000 on 12/14/2015.
 */
public class Control_TUG extends AppCompatActivity {
    ToggleButton toggle_btn;
    TextView Status,Nombre_tug;
    ImageView tv;
    WebView Web_tug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tug);
        toggle_btn=(ToggleButton)findViewById(R.id.toggleButton);
        Status=(TextView)findViewById(R.id.status);
        Nombre_tug=(TextView)findViewById(R.id.tv_tug);
        tv=(ImageView)findViewById(R.id.imageView_tv);
        Web_tug=(WebView)findViewById(R.id.web_tug);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("NombreDisp");
        final String xip = extras.getString("IpTUG");


        Nombre_tug.setText(id);
        Status.setText(xip);


        Web_tug.setWebViewClient(new WebViewClient() {
            // evita que los enlaces se abran fuera nuestra app en el navegador de android
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String Status) {
                return false;
            }

        });


        toggle_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Encendido, Apagado;


                if (isChecked) {
                    Status.setText("Encendido");
                    tv.setImageResource(R.drawable.tvonmd);
                    Encendido="http://"+xip+"/?nvl=2";
                    Web_tug.loadUrl(Encendido);

                } else {
                    Status.setText("Apagado");
                    tv.setImageResource(R.drawable.tvmed);
                    Apagado="http://"+xip+"/?nvl=4";
                    Web_tug.loadUrl(Apagado);

                }

            }
        });


    }
}
