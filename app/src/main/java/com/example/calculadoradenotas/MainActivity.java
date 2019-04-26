package com.example.calculadoradenotas;

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
            AllNullM();
            Clear();
        } else if (textInputNota1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 1 está vazia!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // verifica se campo 2 está vazio
        } else if (textInputNota2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 2 está vazia!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // Se os dois campos estiverem preenchidos, faz a conversão do valor pego para double
        } else if (textInputNota3.getText().toString().trim().equals("")) {
            ConvertN1();
            ConvertN2();
            // Verifica se o valor da nota é válido
            if (AP1 < 0 || AP1 > 10) {
                Toast.makeText(this, "Nota 1 com valor inválido!", Toast.LENGTH_LONG).show();
                textView3.setText(null);
                // Verifica se o Valor da nota é válido
            } else if (AP2 < 0 || AP2 > 10) {
                Toast.makeText(this, "Nota 2 com valor inválido!", Toast.LENGTH_LONG).show();
                textView3.setText(null);
                // Se for, faz a média com as duas notas
            } else {
                Media2();
                textView3.setText(Media.toString());
            }
            // se ele não cair nos if de cima, quer dizer que ele tem as 3 notas preenchidas
            // então, converte as 3 notas para double
        } else {
            ConvertN1();
            ConvertN2();
            ConvertN3();
            // Verifica se as notas são válidas
            if (AP1 < 0 || AP1 > 10) {
                Toast.makeText(this, "Nota 1 com valor inválido!", Toast.LENGTH_LONG).show();
                textView3.setText(null);
                // Verifica se as notas são válidas
            } else if (AP2 < 0 || AP2 > 10) {
                Toast.makeText(this, "Nota 2 com valor inválido!", Toast.LENGTH_LONG).show();
                textView3.setText(null);
                // Verifica se as notas são válidas
            } else if (AP3 < 0 || AP3 > 10) {
                Toast.makeText(this, "Nota 3 com valor inválido!", Toast.LENGTH_LONG).show();
                textView3.setText(null);
                // se for, calcula a média com as 3 Notas
            } else {
                Media = (AP1 * 0.3) + (AP2 * 0.3) + (AP3 * 0.4);
                textView3.setText(Media.toString());
            }
        }return Media; }

    // Função de ação do botão de questções
    public void CalcularQuestoesAP3(View view) {
        // Verifica se todos os campos estão vazios
        if (textInputNota1.getText().toString().trim().equals("") && textInputNota2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Todos as notas estão vazias!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // Verifica se a nota 1 ta vazia
        } else if (textInputNota1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 1 está vazia!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // Verifica se a nota 2 está vazia
        } else if (textInputNota2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 2 está vazia!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // Verifica se a nota 3 está preenchida
        } else if (!textInputNota3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Você ja fez a AP3!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // se deu tudo certo, converte as notas para double
        } else {
                ConvertN1();
                ConvertN2();
                Media2();
            if (Media >= 5) {
                Aprovado();
            } else {
                QtdQuest();
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
    public void Aprovado() {
        Toast.makeText(this, "Você não depende da AP3, você já passou com: " + Media, Toast.LENGTH_LONG).show();
        textView3.setText(null);
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
    }
    @Override
    public boolean AllNull() {
        if (textInputNota1.getText().toString().trim().equals("") && textInputNota2.getText().toString().trim().equals("") && textInputNota3.getText().toString().trim().equals("")) {
            return true;
    }
        return false;
    }
    @Override
    public void Clear() {
        textView3.setText(null);
    }
    @Override
    public void AllNullM() {
        Toast.makeText(this, "Todos as notas estão vazias!", Toast.LENGTH_LONG).show();
    }
}

