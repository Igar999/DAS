package com.example.das;

import android.content.Context;

public class GestorChats {

    private static GestorChats gestorChats;
    private AdaptadorChats adaptadorChats;
    private Boolean flagNuevoMensaje = false;

    public static GestorChats getGestorListas() {
        if (gestorChats == null) {
            gestorChats = new GestorChats();
        }
        return gestorChats;
    }

    public void asignarAdaptadorChats(AdaptadorChats adaptador){
        this.adaptadorChats = adaptador;
    }

    public void actualizarChats(){
        this.adaptadorChats.notifyDataSetChanged();
    }

    public void activarNuevoMensaje(){
        flagNuevoMensaje = true;
    }

    public Boolean comprobarNuevoMensaje(){
        Boolean res = false;
        if(flagNuevoMensaje){
            res = true;
            flagNuevoMensaje = false;
        }
        return res;
    }
}