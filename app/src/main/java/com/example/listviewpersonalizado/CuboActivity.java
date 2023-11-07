package com.example.listviewpersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CuboActivity extends AppCompatActivity {
    private EditText ladoEditText;
    private Button calcularButton;
    private TextView resultadoVolumenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        // Inicializar vistas
        ImageView cuboImageView = findViewById(R.id.cuboImageView);
        ladoEditText = findViewById(R.id.ladoEditText);
        calcularButton = findViewById(R.id.calcularButton);
        resultadoVolumenTextView = findViewById(R.id.resultadoVolumenTextView);

        // Botón de regreso
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Regresar al MainActivity
                finish();
            }
        });

        // Configurar el botón de cálculo
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularVolumenCubo();
            }
        });
    }

    private void calcularVolumenCubo() {
        try {
            double lado = Double.parseDouble(ladoEditText.getText().toString());
            double volumen = lado * lado * lado;

            resultadoVolumenTextView.setText("Volumen del cubo: " + volumen);
        } catch (NumberFormatException e) {
            resultadoVolumenTextView.setText("Ingrese un valor válido para el lado");
        }
    }
}
