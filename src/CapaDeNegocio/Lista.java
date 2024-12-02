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
                    nuevoNodo.setEnlace(act);
                    cantidad++;
                }

            }
        }
    }

    public void eliminar(int elemento) {
        if (!vacia()) {
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() != elemento)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) {
                L = aux.getEnlace();
                cantidad--;

            } else {
                if (aux != null) {
                    // System.out.println("ant"+ant.toString());
                    //System.out.println("aux"+aux.toString());
                    //System.out.println("aux.getEnlace()"+aux.getEnlace().toString());
                    ant.setEnlace(aux.getEnlace());
                    cantidad--;
                }

            }
        }

    }

    public boolean existe(int elemento) {
        Nodo aux = L;
        while ((aux != null) && (aux.getDato() != elemento)) {
            aux = aux.getEnlace();
        }
        return (aux != null);

    }

    public void invertir() {
        Nodo ant = null;
        Nodo aux = L;
        Nodo pos = aux.getEnlace();
        while (pos != null) {
            aux.setEnlace(ant);
            //cambios de punteros
            ant = aux;
            aux = pos;
            pos = pos.getEnlace();
        }
        aux.setEnlace(ant);
        L = aux;
    }

    public void invertirR() {
        invertirAmigo(L);
    }

    private void invertirAmigo(Nodo nodoActual) {
        if (nodoActual == null) {
            //nada
        } else {
            if (nodoActual.getEnlace() == null) {//tiene un nodo
                L = nodoActual;
            } else {
                invertirAmigo(nodoActual.getEnlace());
                nodoActual.getEnlace().setEnlace(nodoActual);
                nodoActual.setEnlace(null);
            }
        }
    }

    public void intercambiar2() {//12345
        if (L == null || L.getEnlace() == null) {
            return;
        }
        Nodo aux = L;
        Nodo pos = L.getEnlace();//aux.getEnlace();
        Nodo ant = null;//
        while (pos != null) {
            aux.setEnlace(pos.getEnlace());
            pos.setEnlace(aux);
            if (aux == L) {
                L = pos;
            } else {
                ant.setEnlace(pos);
            }
            ant = aux;
            aux = aux.getEnlace();
            if (aux != null) {//si tengo mas nodos avanza pos
                pos = aux.getEnlace();
            } else {
                pos = null;
            }
        }
    }

    public void intercambiar2V2() {//12345
        if (L != null || L.getEnlace() != null) {
            Nodo aux = L;
            Nodo pos = L.getEnlace();//aux.getEnlace();
            Nodo ant = null;//
            while (pos != null) {
                aux.setEnlace(pos.getEnlace());
                pos.setEnlace(aux);
                if (aux == L) {
                    L = pos;
                } else {
                    ant.setEnlace(pos);
                }
                ant = aux;
                aux = aux.getEnlace();
                if (aux != null) {//si tengo mas nodos avanza pos
                    pos = aux.getEnlace();
                } else {
                    pos = null;
                }
            }
        }

    }
    
    public void intercambiar2V3() {//12345
        if (cantidad()>1) {
            Nodo aux = L;
            Nodo pos = L.getEnlace();//aux.getEnlace();
            Nodo ant = null;//
            while (pos != null) {
                aux.setEnlace(pos.getEnlace());
                pos.setEnlace(aux);
                if (aux == L) {
                    L = pos;
                } else {
                    ant.setEnlace(pos);
                }
                ant = aux;
                aux = aux.getEnlace();
                if (aux != null) {//si tengo mas nodos avanza pos
                    pos = aux.getEnlace();
                } else {
                    pos = null;
                }
            }
        }

    }
    
    
    
    
    
public void intercambiarDea2R(){//oficial
    intercambiarDea2RAmigo(L);
}

private void intercambiarDea2RAmigo(Nodo actual) {
    if (actual==null) {
      L=actual;    
    }else{
        if (actual.getEnlace()==null) {
            L=actual;
        }else{
            intercambiarDea2RAmigo(actual.getEnlace().getEnlace());
            actual.getEnlace().setEnlace(L);
            Nodo sig=actual.getEnlace();
            actual.setEnlace(sig.getEnlace());
            sig.setEnlace(actual);
            L=sig;
            
            
            
        }
    }
}    
  
 public void  intercambiar2V4() {
        if (cantidad > 1) {
            Nodo aux1 = L;
            Nodo aux2 = L.getEnlace();
            aux1.setEnlace(aux2.getEnlace());
            aux2.setEnlace(aux1);
            L = aux2;
            if (cantidad > 3) {
                Nodo A = aux1.getEnlace();
                Nodo B = A.getEnlace();
                Nodo ant = aux1;
                while (A.getEnlace() != null) {
                    ant.setEnlace(B);
                    A.setEnlace(B.getEnlace());
                    B.setEnlace(A);
                    if (A.getEnlace() != null) {
                        A = A.getEnlace();
                        B = A.getEnlace();
                        ant = ant.getEnlace().getEnlace();
                    }
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    

    //main
    public static void main(String[] args) {
        Lista listaPrueba = new Lista();
        /*  listaPrueba.insertar(2);
        //System.out.println(listaPrueba.toString());
        listaPrueba.insertar(4);
        //System.out.println(listaPrueba.toString());
        listaPrueba.insertar(1); 
        //System.out.println(listaPrueba.toString());
           listaPrueba.insertar(3); 
               listaPrueba.insertar(5); */
        for (int elemento = 1; elemento <= 5; elemento++) {
            listaPrueba.insertar(elemento);
        }
        System.out.println(listaPrueba.toString());
        listaPrueba.intercambiar2V4();
        System.out.println(listaPrueba.toString());

    }

   

}
