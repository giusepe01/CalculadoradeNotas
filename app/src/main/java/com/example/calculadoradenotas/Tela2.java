package com.example.calculadoradenotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    private Object TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        TextView=(TextView) findViewById(R.id.textView2);

        ((TextView) TextView).setText("O valor é calculado da seguinte forma: " +
                "Nota AP1 * 0,3"+
                "Nota AP2 * 0,3"+
                "Nota AP3 * 0,4"
        );
    }

    public void telaPrincipal(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
