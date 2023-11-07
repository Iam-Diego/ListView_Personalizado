package com.example.listviewpersonalizado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Datos de ejemplo para las filas de la lista
        String[] areas = {"(b*h)/2", "(perimetro*apotema)/2","" , "√s*(s-a)*(s-b)*(s-c)"};
        String[] perimetros = {"a + b + c", "5 * L", "", "a + b + c"};
        int[] imageIds = {R.drawable.triangulo_rectangulo, R.drawable.pentagono, R.drawable.cubo, R.drawable.triangulo_escaleno};

        // Inicializar el ListView
        listView = findViewById(R.id.listView);

        // Crear un adaptador personalizado para las filas
        CustomListAdapter adapter = new CustomListAdapter(this, areas, perimetros, imageIds);

        // Configurar el adaptador en el ListView
        listView.setAdapter(adapter);

        // Agregar un escuchador de clics a la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Determinar qué elemento se hizo clic según la posición
                switch (position) {
                    case 0:
                        // Triángulo Rectángulo
                        Intent intent1 = new Intent(MainActivity.this, TrianguloRectanguloActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        // Pentágono
                        Intent intent2 = new Intent(MainActivity.this, PentagonoActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        // Cubo
                        Intent intent3 = new Intent(MainActivity.this, CuboActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        // Triángulo Escaleno
                        Intent intent4 = new Intent(MainActivity.this, TrianguloEscalenoActivity.class);
                        startActivity(intent4);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
