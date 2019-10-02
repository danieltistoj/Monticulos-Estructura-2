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
public class Monticulo {
    public Nodo raiz, nodo_padre;
    public int []valores;
    int altura, conta, altura_hijoder, altura_hijoizq, nivelnodo=0;
    private ArrayList<Nodo> ListaPrincipal = new ArrayList<Nodo>(), Array_aux = new ArrayList<Nodo>();
    
    public void Insertar(int valor){
        if(raiz == null){
            raiz = new Nodo(null);
            raiz.setValor(valor);
        }
        else{
           InsertarValor(raiz,valor);
        }
        
    }
    
    private void InsertarValor(Nodo nodo_actual, int valor){
        if(nodo_actual.contador==0){ // si el contador de hijos es igual a cero se le inserta el valor en el hijo izquierdo 
            Nodo nuevo = new Nodo(nodo_actual);
            nuevo.setValor(valor);
            nodo_actual.setHijoIzq(nuevo);
            nodo_actual.setContador(nodo_actual.getContador()+1);
            
            OrdenarArbol(nuevo);// cada vez que inserta un nuevo valor manda a ordenar el arbol
        }
        else if(nodo_actual.getContador()==1){// si el nodo tiene un hijo el valor se insertara en el hijo derecho 
                Nodo nuevo = new Nodo(nodo_actual);
                nuevo.setValor(valor);
                nodo_actual.setHijoDer(nuevo); 
                nodo_actual.setContador(nodo_actual.getContador()+1);
                
            OrdenarArbol(nuevo);//cada vez que inserta un nuevo valor manda a ordenar el arbol
        }
        else{ // si ya tiene dos hijos  
            if(nodo_actual.getHijoIzq().getContador()<2){// si el hijo izquierdo tiene solo un hijo 
                InsertarValor(nodo_actual.getHijoIzq(), valor);
            }
            else if(nodo_actual.getHijoIzq().getContador()==2&&nodo_actual.getHijoDer().getContador()<2){// si el hijo izquierdo esta lleno manda a insertar el valor al hijo derecho 
                InsertarValor(nodo_actual.getHijoDer(), valor);
            }
            else if(nodo_actual.getHijoIzq().getContador()==2&&nodo_actual.getHijoDer().getContador()==2){// esto evalua donde seguir insertando en el arbol cuando alcanza una altura de 3 o mas. 
               //obtenemos la altura de cada hijo 
               altura_hijoizq = getAltura(nodo_actual.getHijoIzq());
               altura_hijoder = getAltura(nodo_actual.getHijoDer());
               //los nodo que tiene cada hijo izquierda y derecha 
               int nodos_hijoizq = Ordenar_Pre(nodo_actual.getHijoIzq());
               int nodos_hijoder = Ordenar_Pre(nodo_actual.getHijoDer());
               //nodos que deberia tener 
               int nodos_Dizq = NodosSegunAltura(altura_hijoizq);
               int nodos_Dder = NodosSegunAltura(altura_hijoder);
               
               if(altura_hijoizq>altura_hijoder){ // la altura del arbol izquierdo es mayor 
                   if(nodos_hijoizq == nodos_Dizq){ // si tiene los nodos completos segun la altura del arbol se deberia de pasar al lado derecho 
                       InsertarValor(nodo_actual.getHijoDer(), valor);
                   }
                   else{// si no a cumplido con los nodo de su altura se sigue llenando en el lado izquierdo 
                       InsertarValor(nodo_actual.getHijoIzq(), valor);
                   }
                   
               }
               else{// si tienen la misma altura 
                   if (nodos_hijoder == nodos_Dder) {// si los tienen la misma altura y el lado derecho corresponde con los nodos que deberia tener para su altura se debe de enviar el valor al lado izquierdo 
                       InsertarValor(nodo_actual.getHijoIzq(), valor);
                   }
                   else{// si tienen la misma altura y el lado derecho no a cumplido con los nodos que deberia tener se envia a ese lado(derecho)
                       InsertarValor(nodo_actual.getHijoDer(), valor);
                   }
               }
               
                
                
            }
        }
    } 
    
  //reordenar los valores para que cumplan con
    private void OrdenarArbol(Nodo nodo_actual){
        if(nodo_actual.getPadre()!=null){
            if(nodo_actual.getPadre().getValor()>nodo_actual.getValor()){
                int temp = nodo_actual.getPadre().getValor(); 
                nodo_actual.getPadre().setValor(nodo_actual.getValor());
                nodo_actual.setValor(temp);
                OrdenarArbol(nodo_actual.getPadre());
              
            }
            
        }
        
    }
    
 // encontrar altura del arbol    
    private void Altura(Nodo actual, int altura){
        if(actual!=null){
            Altura(actual.getHijoIzq(), altura+1);
            if(altura>this.altura){
                this.altura = altura;
            }
            Altura(actual.getHijoDer(), altura+1);
        }
    }
    
    public int getAltura(Nodo nodo){
        altura=0;
        Altura(nodo,1);
        return altura;
       
    }
  // retorna la cantidad de nodo de un arbol 
      public int Ordenar_Pre(Nodo nodo){
        conta =0;
        Nodo aux = nodo;
        Preorden(aux);
        return conta;
        
    }
       private void Preorden(Nodo nodo_raiz){
        if(nodo_raiz!=null){
            conta++;
            Preorden(nodo_raiz.getHijoIzq());
            Preorden(nodo_raiz.getHijoDer());
        }
        
    }
  //buscar 
      public String Buscar(Nodo nodo,int valor){
        conta=0;
        BuscarValor(nodo, valor);
    
        if(conta>0){
            return "Existe";
        }
        else{
            return "No existe";
        }
        
    }
       private void BuscarValor(Nodo nodo_raiz,int valor){
        if(nodo_raiz!=null){
            if(nodo_raiz.getValor()==valor){
              conta++;  
            }
            BuscarValor(nodo_raiz.getHijoIzq(),valor);
            BuscarValor(nodo_raiz.getHijoDer(),valor);
        }
        
    }       

       
       
 // nodos que dediria tener el arbol segun su altura. esto es para ver si se debe seguir insertando por la izquiera o pasarce a la dereccha 
       public int NodosSegunAltura(int altura){
           int resul = ((int)Math.pow(2,altura))-1;  
           return resul;
       }
 //Mostrar los nodos 
       public void Mostrar(){
           if(raiz!=null){// primero se ve que la raiz sea distinta de nulo
               int NodosEnArbol = Ordenar_Pre(raiz); // obtenemos cuantos nodos tiene el arbol
               ArrayList<Nodo> aux = new ArrayList<Nodo>(); // inicializamos un array auxiliar 
               aux.add(raiz); // ingresamos la raiz en el array auxiliar 
               MostrarNodos(aux, NodosEnArbol); //llamamos a ala funcion 
               for(Nodo nodo: ListaPrincipal){
                   System.out.print(nodo.getValor()+" ,");
               }
           }
           
       }
       private void MostrarNodos(ArrayList<Nodo> array_aux,int NodosEnArbol){
           if(ListaPrincipal.size()!=NodosEnArbol){// se verifica que los elementos que contenga el array principal no sea igual a la cantidad de nodos del arbol
           ArrayList<Nodo> aux = new ArrayList<Nodo>(); // se crea un array auxiliar 
           for(Nodo nodo:array_aux){ // se recorre el array_aux para ir obtreniendo los nodos que contenga 
               ListaPrincipal.add(nodo);// se ingresa cada nodo del array_aux en el array principal 
               //En esta parte se van a ir ingresando los hijos de cadada nodo que contienene el array_aux y se van a ingresar en el array aux 
               if(nodo.getHijoIzq()!=null&&nodo.getHijoDer()!=null){// esta condicion es si el nodo tiene dos hijos 
               aux.add(nodo.getHijoIzq());
               aux.add(nodo.getHijoDer()); 
               }
               else if(nodo.getHijoIzq()!=null&&nodo.getHijoDer()==null){// esta condicion es si el nodo solo tiene un hijo 
                 aux.add(nodo.getHijoIzq());  
               }
               
              
               
           }
               MostrarNodos(aux, NodosEnArbol);// se vuelve a llamar a la funcion pero ahora le enviamos el array aux con los hijos de cada nodo que contiene el array array_aux
           }
           
       }
 //Buscar padre de un nodo
       public Nodo Padre(Nodo nodo,int valor){
        Nodo aux = nodo;
        BuscarPadre(aux,valor);
        return nodo_padre ;
        
    }
       private void BuscarPadre(Nodo nodo_raiz,int valor){
        if(nodo_raiz!=null){
            if(nodo_raiz.getValor()==valor){
               nodo_padre = nodo_raiz.getPadre();
            }
            BuscarPadre(nodo_raiz.getHijoIzq(),valor);
            BuscarPadre(nodo_raiz.getHijoDer(),valor);
        }
        
    }
       
       
// Retornar valor del nodo 
    public void Nivel(int valor,int opcion, int nivel){
           if(raiz!=null){
               int NodosEnArbol = Ordenar_Pre(raiz);
               ListaPrincipal.clear(); // Se limpia el array que guarda todos los valores de los nodos del arbol 
               Array_aux.clear(); // Se limpia el array auxiliar 
               conta=0;
               nivelnodo=0;
               ArrayList<Nodo> aux = new ArrayList<Nodo>();
               aux.add(raiz);
               if(opcion==0){
                   NivelNodo(aux, NodosEnArbol, valor);
                   
               }
               else if(opcion == 1){
                  if(nivel == 1){
                      for(Nodo nodo:aux){
                          System.out.println(nodo.getValor());
                      }
                  }
                  else{
                      nivel = nivel-1;
                      RetornarFila(aux, NodosEnArbol, nivel);
                  
                   for(Nodo nodo:Array_aux){
                      
                       System.out.print(nodo.getValor()+", ");
                   }
                  }
               }
               

           }
           
       }
 // se optiene el nivel del valor iguandolo a la varible global nivelnodo 
       private void NivelNodo(ArrayList<Nodo> array_aux,int NodosEnArbol, int valor){
           if(ListaPrincipal.size()!=NodosEnArbol){
            conta++;
           ArrayList<Nodo> aux = new ArrayList<Nodo>(); 
           for(Nodo nodo:array_aux){ 
               ListaPrincipal.add(nodo);
               if(nodo.getValor()==valor){
                   nivelnodo = conta;
               }
               if(nodo.getHijoIzq()!=null&&nodo.getHijoDer()!=null){
               aux.add(nodo.getHijoIzq());
               aux.add(nodo.getHijoDer()); 
               }
               else if(nodo.getHijoIzq()!=null&&nodo.getHijoDer()==null){
                 aux.add(nodo.getHijoIzq());  
               }
               
              
               
           }
               NivelNodo(aux, NodosEnArbol,valor);// se vuelve a llamar a la funcion pero ahora le enviamos el array aux con los hijos de cada nodo que contiene el array array_aux
           }     
       }
 //Encontrar fila. retorna toda la fila perteneciente al nivel del arbol 
       
           private void RetornarFila(ArrayList<Nodo> array_aux,int NodosEnArbol, int nivel){
             
           if(ListaPrincipal.size()!=NodosEnArbol){
           conta++;

           ArrayList<Nodo> aux = new ArrayList<Nodo>(); 
           for(Nodo nodo:array_aux){ 
               ListaPrincipal.add(nodo);
               if(nodo.getHijoIzq()!=null&&nodo.getHijoDer()!=null){
               aux.add(nodo.getHijoIzq());
               aux.add(nodo.getHijoDer()); 
               }
               else if(nodo.getHijoIzq()!=null&&nodo.getHijoDer()==null){
                 aux.add(nodo.getHijoIzq());  
               }
              
           }// fin del for 
           if(nivel == conta){
               
              Array_aux = aux; // se 
              
           }
               RetornarFila(aux, NodosEnArbol,nivel);// se vuelve a llamar a la funcion pero ahora le enviamos el array aux con los hijos de cada nodo que contiene el array array_aux
           }//fin del primer if      
       }
       
 //clase nodo 
    class Nodo {
     private Nodo HijoIzq, HijoDer, Padre;
     private int valor, posicion, contador;
  

        public Nodo(Nodo padre) {
            this.HijoIzq = null;
            this.HijoDer = null;
            this.Padre = padre;
            this.contador = 0;
        }

        public Nodo getHijoIzq() {
            return HijoIzq;
        }

        public void setHijoIzq(Nodo HijoIzq) {
            this.HijoIzq = HijoIzq;
        }

        public Nodo getHijoDer() {
            return HijoDer;
        }

        public void setHijoDer(Nodo HijoDer) {
            this.HijoDer = HijoDer;
        }

        public Nodo getPadre() {
            return Padre;
        }

        public void setPadre(Nodo Padre) {
            this.Padre = Padre;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
            
        }

        public int getPosicion() {
            return posicion;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }

        public int getContador() {
            return contador;
        }

        public void setContador(int contador) {
            this.contador = contador;
           
        }

       
       
    
    }
}
