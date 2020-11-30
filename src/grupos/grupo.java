/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class grupo {

    
    public static  class ListaEnlazada <String> implements Lista<String> {

       private final Nodo<String> head;

    public ListaEnlazada() {
        // se crea un nodo cabeza, cuya información es nula y
        // también se pone en el campo next el valor null.
        head = new Nodo<String>(null, null);
    }

    public void add(String x) {
        // se mueve una variable (tmp) hasta el final de la lista para
        // poder insertar
        Nodo<String> tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        // se crea un nuevo nodo y se enlace con el último
        Nodo<String> newNodo = new Nodo<String>(x);
        tmp.setNext(newNodo);
    }

    private Nodo caminar(int index) {
        // este metodo mueve una variable hasta el nodo anterior a la 
        // posición index, de tal manera que se hagan de manera sencilla
        // las operaciones de inserción y eliminación.
        Nodo<String> tmp = head;
        int i = 1;
        while (i < index) {
            i++;
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void add(int index, String x) throws PosicIncE {
        // pregunta si la posición de inserción es correcta, 
        // si lo es se camina a la posición anterior, se crea un nuevo
        // nodo y se enlaza, 
        // si no lo es se lanza una excepción
        if (1 <= index && index <= size()) {
            Nodo<String> tmp = caminar(index);
            Nodo<String> newNodo = new Nodo<String>(x);
            newNodo.setNext(tmp.getNext());
            tmp.setNext(newNodo);
        } else {
            throw new PosicIncE();
        }
    }

   






    public int size() {
        // recorre la lista contando los elementos.
        int i = 0;
        Nodo<String> tmp = head.getNext();
        while (tmp != null) {
            tmp = tmp.getNext();
            i++;
        }
        return i;
    }

   
    public void remove(int index) throws PosicIncE {
        // pregunta si la posición de eliminación es correcta, 
        // si lo es se camina a la posición anterior, y se ajustan los enlaces
        // si no lo es se lanza una excepción   
        if (1 <= index && index <= size()) {
            Nodo<String> tmp = caminar(index);
            String o = tmp.getNext().getInfo();
            tmp.setNext(tmp.getNext().getNext());
           
        } else {
            throw new PosicIncE();
        }
    }

    public void remove(String x) throws ElemNoEncE {
        // este metodo busca un objeto en la lista.
        // es necesario tener presente que se utiliza el método equals()
        // si lo encuentra lo elimina y sino lanza una excepción
        // observar que la variable tmpa se va quedando atrás para poder
        // enlazar
        Nodo<String> tmp = head.getNext();
        Nodo<String> tmpa = head;
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmpa = tmp;
            tmp = tmp.getNext();
        }
        if (tmp == null) // no se encontró
        {
            throw new ElemNoEncE();
        } else {
            tmpa.setNext(tmp.getNext());
        }
    }

    public boolean contains(String x) {
        // este método busca un objeto en la lista. 
        // utiliza el equals() para comparar.
        Nodo<String> tmp = head.getNext();
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmp = tmp.getNext();
        }
        return tmp != null;
    }

    
    public String get(char index) throws PosicIncE {
        // comprueba si la posición es correcta.
        // si lo es avanza una variable hasta la posición anterior
        // y devuelve la información del siguiente.
        // si la posición no es correcta eleva una excepción
        if (1 <= index && index <= size()) {
            Nodo<String> tmp = caminar(index);
            String o = tmp.getNext().getInfo();
            return o;
        } else {
            throw new PosicIncE();
        }
    }

    public int getIndex(String x) {
        // mueve una variable hasta que encuentra al objeto.
        // utiliza el equals para comparar.
        // devuelve la posición donde lo encontró o -1 si no lo encontró.
        int i = 1;
        Nodo<String > tmp = head.getNext();
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmp = tmp.getNext();
            i++;
        }
        return ((tmp != null) ? i : -1);
    }
    
    public void clear() {
        // limpia la lista, hace que el nodo cabeza apunte a null de nuevo
        head.setNext(null);
    }

    public Iterador<String> iter() {
        // crea un objeto iterador para poder recorrer la lista.    
        Iterador<String > it = new IterEnlazada<String>(head);
        return it;
    }

    public boolean isEmpty() {
        // determina si la lista está vacía o no.
        return head.getNext() == null;
    }    

    public void set(int index, String element) throws PosicIncE{
       if (1 <= index && index <= size()) {
            Nodo<String> tmp = caminar(index);
            tmp.getNext().setInfo(element);
        } else {
            throw new PosicIncE();
        }         
     }

        @Override
        public String get(int index) throws PosicIncE {
            if (1 <= index && index <= size()) {
            Nodo<String> tmp = caminar(index);
            String o = tmp.getNext().getInfo();
            return o;
        } else {
            throw new PosicIncE();
        }

        }

       
       

       
      
    
}
    
    public static class estudiantes{
    public void getnombre(String ola) throws PosicIncE{
         Lista<String> l = new ListaEnlazada<String>();
        
         l.add(ola);
         l.add("pedrito   60");
         l.add("albertano 50");
         l.add("albertano 40");
         Iterador<String> it = l.iter();
        int i = 1;
        while (it.hasNext()) {
            System.out.println("Elemento: " + i + "  " + it.next());
            i++;
        }
    }
    
    public void darbaja(String z) throws PosicIncE, ElemNoEncE{
         Lista<String> l = new ListaEnlazada<String>();
         
         l.remove(z);
         Iterador<String> it = l.iter();
      
           int i = 1;
            while (it.hasNext()) {
                System.out.println("Elemento: " + i + "  " + it.next());
                i++;
            }

        
     
    }}
    

    
    public static void main(String[] args) throws PosicIncE, ElemNoEncE {
        
       Scanner sc=new Scanner(System.in);
       estudiantes q = new estudiantes();
       Lista<String> l = new ListaEnlazada<String>();
        String salir = "no" ; 
       while(!"si".equals(salir)){
              System.out.println("------------------------------");
       System.out.println("Eliga la operacion");
       System.out.println("1 - ingresar alumno");
       System.out.println("2 - calificacion ");
       
       String campo;
       campo = sc.next();
      
       
       if("1".equals(campo)){
           
           System.out.println("ingrese nombre");
           String pala = sc.next();
         q.getnombre(pala);
      
         System.out.println("Quiere eliminar a un estudiante?");
         String cpa = sc.next();
         if("si".equals(cpa)){
            System.out.println("quiere dar de baja a un estudiante?");
            String palo = sc.next();
            q.darbaja(palo);
       

       }
       } 
       if("2".equals(campo)){
          System.out.println("116.6 ");
       }
       System.out.println("desea terminar?");
        salir = sc.next();
       }
        
        
        
       
         
       }
      
    }
    
    

