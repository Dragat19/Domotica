package ejemplo.domotica;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    public static final int segundos=8;
    public static final int milisegundos=segundos*1000;
    public static final int delay=2;
    private ProgressBar pbprogreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_principal);
        pbprogreso=(ProgressBar)findViewById(R.id.pbprogreso);
        pbprogreso.setMax(maximo_progreso());
        empezaranimacion(1000);
    }
    public void empezaranimacion(int milisegundos)
    {
        new CountDownTimer(milisegundos,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                pbprogreso.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent nuevoform= new Intent(SplashScreen.this,MainActivity.class);
                startActivity(nuevoform);
                finish();
            }
        }.start();

    }

    public int establecer_progreso(long miliseconds)
    {
        return (int)((milisegundos-miliseconds)/1000);
    }

    public int maximo_progreso()
    {
        return segundos-delay;
    }

}
