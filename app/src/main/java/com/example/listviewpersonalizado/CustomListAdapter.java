// CustomListAdapter.java
package com.example.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private String[] areas;
    private String[] perimetros;
    private int[] imageIds;

    public CustomListAdapter(Context context, String[] areas, String[] perimetros, int[] imageIds) {
        this.context = context;
        this.areas = areas;
        this.perimetros = perimetros;
        this.imageIds = imageIds;
    }

    @Override
    public int getCount() {
        return areas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textViewArea = convertView.findViewById(R.id.textViewAreaTitle);
        TextView textViewPerimetro = convertView.findViewById(R.id.textViewPerimetroTitle);
        TextView textViewVolumen = convertView.findViewById(R.id.textViewVolumenTitle);

        imageView.setImageResource(imageIds[position]);


        if (imageIds[position] == R.drawable.cubo) {
            textViewArea.setVisibility(View.GONE);
            textViewPerimetro.setVisibility(View.GONE);
            textViewVolumen.setText("a^3 " );
        } else {
            textViewArea.setText(areas[position]);
            textViewPerimetro.setText(perimetros[position]);
            textViewVolumen.setVisibility(View.GONE);
        }

        return convertView;
    }
}
