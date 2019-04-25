package com.example.calculadoradenotas;
// Importando as Bibliotecas do Android
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.calculadoradenotas.Func.*;

// Declara os campos da parte gráfica
public class MainActivity extends AppCompatActivity implements Func{
    EditText textInputNota1;
    EditText textInputNota2;
    EditText textInputNota3;
    TextView textView3;
    Button btnCalcular;

    // Declaração de variáveis
    Double AP1;
    Double AP2;
    Double AP3;
    Double Resultado;
    Double Media;
    Double Resto;



    // Pegando os valores e instanciado os campos, informa que o valor de tal campo, refere-se a tal variável
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


    // Função de ação do botão Calcular Nota
    public Double CalcularNota(View view) {

        // Verifica se todos os campos estão vazios
        if (textInputNota1.getText().toString().trim().equals("") && textInputNota2.getText().toString().trim().equals("") && textInputNota3.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Todos as notas estão vazias!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // Verifica se campo 1 está vazio
        } else if (textInputNota1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 1 está vazia!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // verifica se campo 2 está vazio
        } else if (textInputNota2.getText().toString().trim().equals("")) {
            Toast.makeText(this, "A nota 2 está vazia!", Toast.LENGTH_LONG).show();
            textView3.setText(null);
            // Se os dois campos estiverem preenchidos, faz a conversão do valor pego para double
        } else if (textInputNota3.getText().toString().trim().equals("")) {
            AP1 = Double.parseDouble(textInputNota1.getText().toString());
            AP2 = Double.parseDouble(textInputNota2.getText().toString());
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
                Media = (AP1 * 0.3) + (AP2 * 0.3);
                textView3.setText(Media.toString());
            }
            // se ele não cair nos if de cima, quer dizer que ele tem as 3 notas preenchidas
            // então, converte as 3 notas para double
        } else {
            AP1 = Double.parseDouble(textInputNota1.getText().toString());
            AP2 = Double.parseDouble(textInputNota2.getText().toString());
            AP3 = Double.parseDouble(textInputNota3.getText().toString());
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
            AP1 = Double.parseDouble(textInputNota1.getText().toString());
            AP2 = Double.parseDouble(textInputNota2.getText().toString());

            Media = (AP1 * 0.3) + (AP2 * 0.3);

            // verifica se a média ja está aprovada
            if (Media > 5) {
                Toast.makeText(this, "Você não está dependendo da AP3 para passar, este app não é para você!!!", Toast.LENGTH_LONG).show();
                textView3.setText(null);
                // Verifica se a média ja está aprovada
            } else if (Media == 5) {
                Toast.makeText(this, "Você não está dependendo da AP3 para passar, você já passou com 5.", Toast.LENGTH_LONG).show();
                textView3.setText(null);
                // Se não, ve quanto falta para tirar, média necessaria - media real
                // dividido por 0,4 para saber o valor em média que tem que tirar
                // dividido por 0,4 novamente para saber em quantidade de questões
            } else {

            }
    }

}

}

    // TODA VEZ QUE ENCONTRADO UM RESULTADO NÃO ESPERADO, COMO VALOR DA NOTA INVÁLIDO, CAMPO VAZIO, OU ALGO DO TIPO
    // O CAMPO TextView3 (CAMPO ONDE É EXIBIDO O RESULTADO DA CONTA DE MÉDIA) É RESETADO PARA NULL
    // UTILIZANDO A FUNÇÃO textView3.setText(null)
    // TODA VEZ QUE DER SUCESSO, ELE TAMBÉM RESETA O CAMPO E FAZ A CONTA DNV, APAGANDO O RESULTADO ANTIGO
    // Repositorio no GIT https://github.com/giusepe01/CalculadoradeNotas
