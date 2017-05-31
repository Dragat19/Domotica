package ejemplo.domotica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * Created by levaa_000 on 12/14/2015.
 */
public class Control_luminaria extends AppCompatActivity {

    Switch sw1,sw2,sw3,sw4;
    ImageView img1,img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luminaria);
        sw1=(Switch)findViewById(R.id.switch1);
        sw2=(Switch)findViewById(R.id.switch2);
        sw3=(Switch)findViewById(R.id.switch3);
        sw4=(Switch)findViewById(R.id.switch4);
        img1=(ImageView)findViewById(R.id.imageView1);
        img2=(ImageView)findViewById(R.id.imageView2);
        img3=(ImageView)findViewById(R.id.imageView3);
        img4=(ImageView)findViewById(R.id.imageView4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
}
