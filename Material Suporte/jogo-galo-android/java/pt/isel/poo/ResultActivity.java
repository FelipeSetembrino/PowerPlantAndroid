package pt.isel.poo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import pt.isel.leic.poo.jogogalo.R;
import pt.isel.poo.jogogalo.GaloActivity;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String winner = intent.getStringExtra(GaloActivity.WINNER);

        TextView result = findViewById(R.id.result);
        result.setText(winner + " wins!");

        Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
