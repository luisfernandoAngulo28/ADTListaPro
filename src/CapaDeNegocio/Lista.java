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
public class Lista {

    //Atributos
    Nodo L;//Cabezal
    int cantidad;//cantidad de nodos
    //Constructor

    public Lista() {
        L = null;
        cantidad = 0;
    }

    public boolean vacia() {
        //return L==null;
        return cantidad == 0;
    }

    public int cantidad() {
        return cantidad;
    }

    //recorrer una lista
    public String toString() {
        String S = "L->";
        Nodo aux = L;
        while (aux != null) {
            S = S + "[" + aux.getDato() + "|]->";
            aux = aux.getEnlace();

        }
        return S + "null";
    }

    public void insertar(int elemento) {

        if (vacia()) { //si la lista esta vacia
            Nodo p = new Nodo(elemento);
            L = p;
            cantidad++;
        } else {//esta parte es para ubicarme en donde insertamos un valor
            Nodo act = L;
            Nodo ant = null;
            while (act != null && (act.getDato() <= elemento)) {
                ant = act;
                act = act.getEnlace();
            }
            if (ant == null) {
                Nodo nuevo = new Nodo(elemento);
                nuevo.setEnlace(act);
                L = nuevo;
                cantidad++;
            } else {//insertando en el cuerpo
                if (ant.getDato() != elemento) {
                    Nodo nuevoNodo = new Nodo(elemento);
                    ant.setEnlace(nuevoNodo);
                    cantidad++;
                }

            }
        }
    }

    //main
    public static void main(String[] args) {
        Lista listaPrueba = new Lista();
        listaPrueba.insertar(2);
        System.out.println(listaPrueba.toString());

        listaPrueba.insertar(4);
        System.out.println(listaPrueba.toString());

        listaPrueba.insertar(1);
        System.out.println(listaPrueba.toString());

    }

}
