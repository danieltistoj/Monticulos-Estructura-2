/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmonticulo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MainMonticulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> ValoresPreMonticulo = new ArrayList<>();
        Monticulo monticulo = new Monticulo();
        monticulo.Insertar(10);
        ValoresPreMonticulo.add(10);
        
        monticulo.Insertar(11);
        ValoresPreMonticulo.add(10);
        
        monticulo.Insertar(32);
        ValoresPreMonticulo.add(32);
        
        monticulo.Insertar(23);
        ValoresPreMonticulo.add(23);
        
        monticulo.Insertar(4);
        ValoresPreMonticulo.add(4);
        
        monticulo.Insertar(5);
        ValoresPreMonticulo.add(5);
        
        monticulo.Insertar(23);
        ValoresPreMonticulo.add(23);
        
        monticulo.Insertar(18);
        ValoresPreMonticulo.add(18);
        
        monticulo.Insertar(19);
        ValoresPreMonticulo.add(19);
        
        monticulo.Insertar(32);
        ValoresPreMonticulo.add(32);
        
        monticulo.Insertar(64);
        ValoresPreMonticulo.add(64);
        
        monticulo.Insertar(11);
        ValoresPreMonticulo.add(11);
        
        System.out.println("Valores a ingresar");
       for(Integer num:ValoresPreMonticulo){
           System.out.print(num+", ");
       }
        System.out.println("\n");
        System.out.println("Valores ya ingresados al monticulo");
        monticulo.Mostrar();
        
        System.out.println("\n");
        System.out.println("*** Buscar valores: 50, 5, 64. ***");
        System.out.println("El valor 50: "+monticulo.Buscar(monticulo.raiz, 50));
        System.out.println("El valor 5: "+monticulo.Buscar(monticulo.raiz, 5));
        System.out.println("El valor 64: "+monticulo.Buscar(monticulo.raiz, 64));
           
        /*
        System.out.println(monticulo.raiz.getValor());
        System.out.println(monticulo.raiz.getHijoIzq().getValor());
        System.out.println(monticulo.raiz.getHijoDer().getValor());
        System.out.println("posicion 3 y 4");
        
        System.out.println(monticulo.raiz.getHijoIzq().getHijoIzq().getValor());
        System.out.println(monticulo.raiz.getHijoIzq().getHijoDer().getValor());
        
         System.out.println("posicion 5 y 6");
        
        System.out.println(monticulo.raiz.getHijoDer().getHijoIzq().getValor());
        System.out.println(monticulo.raiz.getHijoDer().getHijoDer().getValor());
        System.out.println("\n");
        
        System.out.println("Altura del hijo izquierdo: "+monticulo.getAltura(monticulo.raiz.getHijoIzq()));
        System.out.println("Altura del hijo derecho: "+monticulo.getAltura(monticulo.raiz.getHijoDer()));
        System.out.println("nodos del arbol: "+monticulo.Ordenar_Pre(monticulo.raiz));
       
       // System.out.println("nodo que deberia tener: "+monticulo.NodosSegunAltura(3));
        */
        
    }
    
}
