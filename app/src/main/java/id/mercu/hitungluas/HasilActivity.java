package id.mercu.hitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        TextView tvHasil = (TextView) findViewById(R.id.tvHasil);

        String hasil = getIntent().getStringExtra("hasil");
        tvHasil.setText(hasil);
    }
}
