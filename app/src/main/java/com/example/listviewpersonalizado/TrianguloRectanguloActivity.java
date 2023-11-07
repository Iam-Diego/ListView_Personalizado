package com.example.listviewpersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TrianguloRectanguloActivity extends AppCompatActivity {
    private EditText baseEditText, alturaEditText;
    private Button calcularButton;
    private TextView resultadoAreaTextView, resultadoPerimetroTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_rectangulo);

        // Inicializar vistas
        baseEditText = findViewById(R.id.baseEditText);
        alturaEditText = findViewById(R.id.alturaEditText);
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
                calcularTrianguloRectangulo();
            }
        });
    }

    private void calcularTrianguloRectangulo() {
        try {
            double base = Double.parseDouble(baseEditText.getText().toString());
            double altura = Double.parseDouble(alturaEditText.getText().toString());

            double area = (base * altura) / 2;
            double hipotenusa = Math.sqrt(base * base + altura * altura);
            double perimetro = base + altura + hipotenusa;

            resultadoAreaTextView.setText("Área: " + area);
            resultadoPerimetroTextView.setText("Perímetro: " + perimetro);
        } catch (NumberFormatException e) {
            resultadoAreaTextView.setText("Ingrese valores válidos");
            resultadoPerimetroTextView.setText("");
        }
    }
}
