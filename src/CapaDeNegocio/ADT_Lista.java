/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDeNegocio;

/**
 *
 * @author ferna
 */
public class ADT_Lista {

  public class Nodo {
    //atributos
    int dato;
    Nodo enlace;
    //Constructor
    public Nodo(){
        //dato=0;
        enlace=null;
    }

    public Nodo(int dato) {
        this.dato = dato;
        enlace=null;
    }

    

    public Nodo(int dato, Nodo enlace) {
        this.dato = dato;
        this.enlace = enlace;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setEnlace(Nodo otroNodo) {//enlazar 2 nodos
        this.enlace = otroNodo;
    }
    public int getDato() {//devolver dato
        return dato;
    }

    public Nodo getEnlace() {//devolvemos un nodo
        return enlace;
    }

    @Override
    public String toString() {
       String s="[dato=";
       s=s+getDato();
       return s+"|]";
    }
    
    
    //metodo main
    public static void main(String[] args) {
        Nodo nodoA=new Nodo();
        nodoA.setDato(23);
        System.out.println(nodoA.toString());
        Nodo nodoB=new Nodo(8);
        System.out.println(nodoB.toString());
        //enlazando 2 nodos
        nodoA.setEnlace(nodoB);
        System.out.println(nodoA+"->"+nodoA.getEnlace());
        
    }
  }
    
}
