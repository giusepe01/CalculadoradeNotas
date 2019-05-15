package com.example.calculadoradenotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Func{
    EditText textInputNota1;
    EditText textInputNota2;
    EditText textInputNota3;
    TextView textView3;
    Button btnCalcular;

    Double AP1;
    Double AP2;
    Double AP3;
    Double Media;
    Double Resto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputNota1 = (EditText) findViewById(R.id.txtNota1);
        textInputNota2 = (EditText) findViewById(R.id.txtNota2);
        textInputNota3 = (EditText) findViewById(R.id.txtNota3);
        textView3 = (TextView) findViewById(R.id.textView3);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
    }
    public Double CalcularNota(View view) {

        if (AllNull()) {
            Clear();
        } else if (Num1Null()) {
            Clear();
        } else if (Num2Null()) {
            Clear();
        } else if (Num3Null()) {
            ConvertN1();
            ConvertN2();
            if (ValNum1()) {
                Clear();
            } else if (ValNum2()) {
                Clear();
            } else {
                Media2();
            }
        } else {
            ConvertN1();
            ConvertN2();
            ConvertN3();
            if (ValNum1()) {
                Clear();
            } else if (ValNum2()) {
                Clear();
            } else if (ValNum3()) {
                Clear();
            } else {
                Media3();
            }
        }return Media; }

    public void CalcularQuestoesAP3(View view) {

        if (AllNull()) {
            Clear();
        } else if (Num1Null()) {
            Clear();
        } else if (Num2Null()) {
            Clear();
        } else if (Num3Full()) {
            Clear();
        } else {
                ConvertN1();
                ConvertN2();
                if (ValNum1()) {
                Clear();
                } else if (ValNum2()) {
                Clear();
                } else {
                Media2();
                    if (Reprovado()) {
                    } else if (Aprovado()) {
                    }
                    else{
                        QtdQuest();
                    }
            }

    }
}
    @Override
    public void QtdQuest() {
        Resto = (((5 - Media) / 0.4) / 0.4);
        Toast toast = Toast.makeText(this, "Você precisa acertar " + Math.round(Resto) + " Questões para tirar 5", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
    @Override
    public boolean Aprovado() {
        if (Media >= 5) {
            Toast.makeText(this, "Você não depende da AP3, você já passou ", Toast.LENGTH_LONG).show();
            textView3.setText(Media.toString());
            return true;
        }
        return false;
    }
    @Override
    public boolean Reprovado(){
        if (Media < 1) {
            Toast.makeText(this, "INFELIZMENTE, VOCÊ ESTÁ REPROVADO", Toast.LENGTH_LONG).show();
            textView3.setText(Media.toString());
            return true;
        }
        return false;
    }
    @Override
    public void ConvertN1() {
        AP1 = Double.parseDouble(textInputNota1.getText().toString());
    }
    @Override
    public void ConvertN2() {
        AP2 = Double.parseDouble(textInputNota2.getText().toString());
    }
    @Override
    public void ConvertN3() {
        AP3 = Double.parseDouble(textInputNota3.getText().toString());
    }
    @Override
    public void Media2() {
        Media = (AP1 * 0.3) + (AP2 * 0.3);
        textView3.setText(Media.toString());
    }
    @Override
    public void Media3() {
        Media = (AP1 * 0.3) + (AP2 * 0.3) + (AP3 * 0.4);
        textView3.setText(Media.toString());
    }
    @Override
    public boolean AllNull() {
        if (textInputNota1.getText().toString().trim().equals("") && textInputNota2.getText().toString().trim().equals("") && textInputNota3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Todos as notas estão vazias!", Toast.LENGTH_LONG).show();
            return true;
    }
        return false;
}
    @Override
    public boolean Num1Null() {
        if (textInputNota1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 1 está vazia!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
    @Override
    public boolean Num2Null() {
        if (textInputNota2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 2 está vazia!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
    @Override
    public boolean Num3Null() {
        if (textInputNota3.getText().toString().trim().equals("")) {
            return true;
        }
        return false;
    }
    @Override
    public boolean ValNum1() {
        if (AP1 < 0 || AP1 > 10) {
            Toast.makeText(this, "Nota 1 com valor inválido!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
    @Override
    public boolean ValNum2() {
        if (AP2 < 0 || AP2> 10) {
            Toast.makeText(this, "Nota 2 com valor inválido!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
    @Override
    public boolean ValNum3() {
        if (AP3 < 0 || AP3> 10) {
            Toast.makeText(this, "Nota 3 com valor inválido!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
    @Override
    public boolean Num3Full(){
        if (!textInputNota3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Você ja fez a AP3!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
    @Override
    public void Clear() {
        textView3.setText(null);
    }

    public void proximaTela(View view)
    {
        Intent intent = new Intent(this, Tela2.class);
        startActivity(intent);
    }
}

