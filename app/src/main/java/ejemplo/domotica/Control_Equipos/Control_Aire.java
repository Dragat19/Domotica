package ejemplo.domotica.Control_Equipos;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import ejemplo.domotica.R;

/**
 * Created by levaa_000 on 12/14/2015.
 */
public class Control_Aire extends AppCompatActivity {
    ToggleButton Sw_aire;
    ImageView aire;
    TextView Status1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aire);
        Sw_aire=(ToggleButton)findViewById(R.id.toggleButton1);
        Status1=(TextView)findViewById(R.id.status1);
        aire=(ImageView)findViewById(R.id.imageView_aire);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
}