package id.mercu.hitungluas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    EditText etPanjang;
    EditText etLebar;
    TextView tvHasil;
    Animation animFadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPanjang = (EditText) findViewById(R.id.etPanjang);
        etLebar = (EditText) findViewById(R.id.etLebar);
        //tvHasil = (TextView) findViewById(R.id.tvHasil);
        Button btnHitung = (Button) findViewById(R.id.btnHitung);

        animFadein = AnimationUtils.loadAnimation(this,
                R.anim.fade_in);

        // set animation listener
        animFadein.setAnimationListener(this);
        btnHitung.setAnimation(animFadein);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double panjang = Double.parseDouble(etPanjang.getText().toString());
                    double lebar = Double.parseDouble(etLebar.getText().toString());
                    double hasil = hitungLuasPersegi(panjang, lebar);
                    //tvHasil.setText(String.valueOf(hasil));
                    Intent i = new Intent(MainActivity.this,
                            HasilActivity.class);
                    i.putExtra("hasil", String.valueOf(hasil));
                    startActivity(i);
                } catch (Exception ex) {
                    etPanjang.setError("Masukkan angka!");
                }
            }
        });
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fade in animation
        if (animation == animFadein) {
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

    private double hitungLuasPersegi(double panjang, double lebar) {
        return panjang*lebar;
    }
}
