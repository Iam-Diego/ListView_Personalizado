package com.example.listviewpersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TrianguloEscalenoActivity extends AppCompatActivity {
    private EditText ladoAEditText, ladoBEditText, ladoCEditText;
    private Button calcularButton;
    private TextView resultadoAreaTextView, resultadoPerimetroTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_escaleno);

        // Inicializar vistas
        ImageView trianguloImageView = findViewById(R.id.trianguloImageView);
        ladoAEditText = findViewById(R.id.ladoAEditText);
        ladoBEditText = findViewById(R.id.ladoBEditText);
        ladoCEditText = findViewById(R.id.ladoCEditText);
        calcularButton = findViewById(R.id.calcularButton);
        resultadoAreaTextView = findViewById(R.id.resultadoAreaTextView);
        resultadoPerimetroTextView = findViewById(R.id.resultadoPerimetroTextView);

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
                calcularTrianguloEscaleno();
            }
        });
    }

    private void calcularTrianguloEscaleno() {
        try {
            double ladoA = Double.parseDouble(ladoAEditText.getText().toString());
            double ladoB = Double.parseDouble(ladoBEditText.getText().toString());
            double ladoC = Double.parseDouble(ladoCEditText.getText().toString());

            double s = (ladoA + ladoB + ladoC) / 2;
            double area = Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
            double perimetro = ladoA + ladoB + ladoC;

            resultadoAreaTextView.setText("Área: " + area);
            resultadoPerimetroTextView.setText("Perímetro: " + perimetro);
        } catch (NumberFormatException e) {
            resultadoAreaTextView.setText("Ingrese valores válidos");
            resultadoPerimetroTextView.setText("");
        }
    }
}
