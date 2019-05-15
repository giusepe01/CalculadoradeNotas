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

        ((TextView) TextView).setText("De acordo com as regras da instituição DEVRY as notas não tem o mesmo peso pelo fato de serem ponderadas diferentes em relação entre as primeiras provas e a última. O valor é calculado da seguinte forma: " + "\n" +
                "Nota AP1 = 30%" + "\n" +
                " Nota AP2 = 30%"+ "\n" +
                " Nota AP3 = 40%"
        );
    }

    public void telaPrincipal(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
