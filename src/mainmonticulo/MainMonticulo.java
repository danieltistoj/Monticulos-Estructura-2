/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmonticulo;

import java.util.ArrayList;
import java.util.Scanner;

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
      Scanner input = new Scanner(System.in);
        int n, n2, temp;
       
        int opcion, k;

        boolean flag;
        flag = true;
       

        while (flag)
        {
             System.out.println("\n\tM\tE\tN\tU\n");
        System.out.println("1. Ingresar valor");
        System.out.println("2. Altura del monticulo");
        System.out.println("3. Mostrar monticulo");
        System.out.println("4. Mostrar nivel");
        System.out.println("5. Mostrar los valores de nivel");
        System.out.println("6. Mostrar padre del valor");
        System.out.println("7. Salir");

            System.out.print("\nSeleccionar opcion::");
            opcion = input.nextInt();
            if (opcion == 7) {             
                System.exit(0);
                flag = false;
                break;
            } else {
                switch (opcion) {
                    case 1: 
                        System.out.print("¿Cuantos valores desean ingresar?: ");
                        n2 = input.nextInt();

                        for (int i = 0; i < n2; i++) {
                            System.out.print("\nIngrese valor: ");
                            System.out.println(i + 1);
                            temp = input.nextInt();
                            monticulo.Insertar(temp);
                        }

                        break;

                    case 2:
                        if(monticulo.raiz == null){
                            System.out.println("El monticulo esta vacio");
                        }
                        else{
                           System.out.println("La altura del arbol es: "+monticulo.getAltura(monticulo.raiz)); 
                        }
                       
                        break;

                    case 3:
                       monticulo.Mostrar();

                        break;
                    case 4:
                      System.out.print("\nIngrese valor: ");
                      temp = input.nextInt();
                      monticulo.Nivel(temp,0,0);
                      if(monticulo.nivelnodo==0){
                          System.out.println("El valor no existe");
                      }
                      else{
                          System.out.println("El nivel del valor es: "+monticulo.nivelnodo);
                      }
                      
                        break;
                        
                    case 5:
                      System.out.print("\nIngrese nivel: ");
                      temp = input.nextInt();
                      monticulo.Nivel(0,1,temp);
                        break;
                    case 6:
                      System.out.print("\nIngrese valor de referencia: ");
                      temp = input.nextInt();
                      if(monticulo.Buscar(monticulo.raiz, temp) == "Existe"){
                      monticulo.Padre(monticulo.raiz,temp);
                      if(monticulo.Padre(monticulo.raiz,temp)!=null){
                          System.out.println("El padre del valor es: "+monticulo.nodo_padre.getValor());
                      }
                      else{
                          System.out.println("El padre es nulo");
                      }
                      }//fin primera condicion
                      
                      else{
                          System.out.println("El valor de referencia no existe");
                      }
                        break;
                    case 7:
                      System.exit(0);
                        break;

                    default: 
                        System.out.println("\nError\n");
                        break;
                }
            }
        }
        
    }
    
}
