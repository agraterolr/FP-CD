/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios_examen1;

import java.util.Arrays;

/**
 *
 * @author Angel
 */
public class Exercicios_Examen1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FullException {
        // Stack
        Stack pila=new Stack(5);
        pila.push(" elemento1 ");
        pila.push(2);
        pila.push(" elemento3 ");
        pila.push(4);
        pila.push(" elemento5 ");
        System.out.println("Probando la clase Stack (LIFO): " + pila.pop() + pila.pop() + pila.pop() + pila.pop() + pila.pop() + pila.pop() + pila.pop()); 

        // Queue
        Queue pila2=new Queue(5);
        pila2.put(" element1 ");
        pila2.put(" element2 ");
        pila2.put(" element3 ");
        pila2.put(" element4 ");
        pila2.put(" element5 ");
        System.out.println("Probando la clase Queue (FIFO), los 2  más antigüos de la pila son: " + pila2.get() + pila2.get()); 
        
        // DinArray
        DinArray pila3=new DinArray(3);
        pila3.add(" element1 ");
        pila3.add(" element2 ");
        pila3.add(" element3 ");
        pila3.add(" element4 ");
        pila3.add(" element5 ");
        pila3.add(" element6 ");
        pila3.add(" element7 ");
        System.out.println("Probando la clase DinArray, obtengo último elemento: " + pila3.get(6));
        pila3.put(3,"nuevoElemento");
        System.out.println("Nuevo tamaño del array: " + pila3.length());
        System.out.println("Probando la clase DinArray, obtengo elemento insertado: " + pila3.get(3));
    }
    
}

class Stack {
    private final Object[] pila;
    private int last_object;
    
    public Stack(int size) {
        pila=new Object[size];
        last_object=0;
    }
    
    public void push(Object obj) throws FullException {
        try {
            pila[last_object]=obj;
            last_object++;
        } catch(IndexOutOfBoundsException ex) {
            throw new FullException("No hay más espacio en la pila");
        }
    }
    
    public Object pop() {
        if (last_object>0) {
            last_object--;
            return pila[last_object];
        }
        return null;
    }
}


class Queue {
    private final Object[] queue;
    private int input,output;
    
    public Queue(int size) {
        input=0;
        output=0;
        queue=new Object[size]; 
    }
    
    public void put(Object obj) throws FullException {
        if (queue[input]!=null) throw new FullException("No hay más espacio en la pila");
        queue[input]=obj;
        input++;
        if (input==queue.length) input=0;
     }
    
    public Object get() {
        Object obj=queue[output];
        if (obj!=null) {
            queue[output]=null;
            output++;
            if (output>=queue.length) output=0;
        }
        return obj;
    }
}

class DinArray {
    private int element,size;
    private Object[] elements;
    
    
    public DinArray(int element) {
        elements=new Object[element];
        this.element=element;
        size=0;
    }
    
    public Object get(int idx) {
        if (idx>=size) throw new IndexOutOfBoundsException();
        return elements[idx];
    }
    
    public int length() {
        return size;
    }
    
    public void put(int idx,Object obj) {
        if (idx>=size) throw new IndexOutOfBoundsException();
        elements[idx]=obj;
    }
    
    public int add(Object obj) {
        int position=size;
        try {
            elements[position]=obj;
        } catch(IndexOutOfBoundsException ex) {
            elements = Arrays.copyOf(elements, size + element);    
            elements[position] = obj;
        }
        size++;
        return position;
    }
}
