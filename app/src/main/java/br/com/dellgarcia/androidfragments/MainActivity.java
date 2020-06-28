package br.com.dellgarcia.androidfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txvOperation, txtAcertos, txtErros;
    private EditText edtResult;
    private int acertos = 0, erros = 0;
    private int n1, n2, res;
    private Button btnVerificar, btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvOperation = findViewById(R.id.txvOperation);
        txtAcertos = findViewById(R.id.txtAcertos);
        txtErros = findViewById(R.id.txtErros);

        edtResult = findViewById(R.id.txvResult);

        btnVerificar = findViewById(R.id.btnVerificar);
        btnSkip = findViewById(R.id.btnSkip);

        btnVerificar.setOnClickListener(verifyAction());
        btnSkip.setOnClickListener(skipAction());

        generateRandomOperation();
    }

    private void generateRandomOperation() {
        Random r = new Random();

        n1 = r.nextInt(10) + 1;
        n2 = r.nextInt(10) + 1;
        res = n1 * n2;

        txvOperation.setText(n1 + " x " + n2);
    }

    private View.OnClickListener verifyAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtResult.getText().toString().equals(Integer.toString(res))) {
                    acertos++;
                    txtAcertos.setText(Integer.toString(acertos));
                } else {
                    erros++;
                    txtErros.setText(Integer.toString(erros));
                }
                edtResult.setText("");
                generateRandomOperation();
            }
        };
    }

    private View.OnClickListener skipAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomOperation();
                erros++;
                txtErros.setText(Integer.toString(erros));
            }
        };
    }
}