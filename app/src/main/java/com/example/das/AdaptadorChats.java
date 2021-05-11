package com.example.das;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class AdaptadorChats extends ArrayAdapter {
    private Activity context;
    private String[] nombres;

    public AdaptadorChats(Activity context, String[] nombres) {
        super(context, R.layout.fila_chat, nombres);
        this.context = context;
        this.nombres = nombres;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View fila=view;
        LayoutInflater inflater = context.getLayoutInflater();
        fila = inflater.inflate(R.layout.fila_chat, null, true);
        ImageView foto = (ImageView) fila.findViewById(R.id.fotoChat);
        TextView nombre = (TextView) fila.findViewById(R.id.nombreChat);
        foto.setImageResource(R.drawable.logo_google);
        nombre.setText(nombres[position]);
        nombre.setTextColor(Color.BLACK);
        fila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ChatActivity.class);
                i.putExtra("persona", nombres[position]);
                context.startActivity(i);
                context.finish();
            }
        });
        return  fila;
    }
}