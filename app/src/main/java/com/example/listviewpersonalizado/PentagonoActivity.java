package com.example.listviewpersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PentagonoActivity extends AppCompatActivity {
    private EditText ladoEditText;
    private Button calcularButton;
    private TextView resultadoAreaTextView, resultadoPerimetroTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pentagono);

        // Inicializar vistas
        ImageView pentagonoImageView = findViewById(R.id.pentagonoImageView);
        ladoEditText = findViewById(R.id.ladoEditText);
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
                calcularPentagono();
            }
        });
    }

    private void calcularPentagono() {
        try {
            double lado = Double.parseDouble(ladoEditText.getText().toString());

            double apotema = (lado / 2) / Math.tan(Math.toRadians(36));
            double perimetro = 5 * lado;
            double area = (perimetro * apotema) / 2;

            resultadoAreaTextView.setText("Área: " + area);
            resultadoPerimetroTextView.setText("Perímetro: " + perimetro);
        } catch (NumberFormatException e) {
            resultadoAreaTextView.setText("Ingrese valores válidos");
            resultadoPerimetroTextView.setText("");
        }
    }
}
