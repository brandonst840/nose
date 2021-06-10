/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionUno;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @HECHO POR GRUPO #5
 * -BRANDON STEVE TURCIOS MEJIA
 * -JORGE DANIEL PINEDA SUAZO
 * -YAHIR ANTONIO GUARDADO ABREGO
 * -EDGAR RICARDO AYALA POLANCO
 */

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        //Variables
        Scanner lea = new Scanner(System.in);
        Random radm = new Random();
        int cantidadPalabras;
        int control;
        String jugador1, jugador2;
        int juegos = 0;
        int puntajeJugador1 = 0, puntajeJugador2 = 0;
        boolean turnoJugador1, turnoJugador2;

        System.out.println("Ingresar cantidad de palabras: ");
        cantidadPalabras = lea.nextInt();
        String palabrasLista[] = new String[cantidadPalabras];
            
        for(control=0; control < cantidadPalabras; control++) {
            System.out.println("Ingresar palabras: ");
            palabrasLista[control] = lea.next().toLowerCase();
        }
        
        System.out.println("Nombre Jugador 1:");
        jugador1=lea.next();
        System.out.println("Nombre Jugador 2:");
        jugador2=lea.next();
        String respuesta;

        do {
            //Seleccion aleatoria de la cadena
            String adivinar = palabrasLista[radm.nextInt(cantidadPalabras)];

            //Formar el arreglo de la cadena en adivinar
            char formar[] = new char[adivinar.length()];
            for (int fila = 0; fila < formar.length; fila++) {
                formar[fila] = '_';
            }

            turnoJugador1 = true;
            turnoJugador2 = false;
            char caracter = '\0';
            boolean buscar = false;
            boolean gane = false;

            //Jugar
            while(true) {
                if(turnoJugador1 == true) {
                    System.out.println("\n" + jugador1 + " es tu turno!");
                    
                    //Generacion de espacios
                    for(char letra:formar) {
                        System.out.print(letra + " ");
                    }
                    
                    //Ingresar el caracter a adivinar
                    System.out.print("\nCaracter en adivinar: ");
                    caracter = lea.next().charAt(0);
                    
                    //Buscar el caracter 
                    char temp = '\0';
                    buscar = false;
                    for(int fila = 0; fila<adivinar.length(); fila++){
                        if(caracter == adivinar.charAt(fila)){
                            //Si existe, formar la palabra o cadena
                            formar[fila] = adivinar.charAt(fila);
                            buscar = true;
                        }
                    }

                    if(!buscar){
                        System.out.println("No esta!");
                        turnoJugador1 = false;
                        turnoJugador2 = true;
                    }else{
                        gane = true;

                        for(char letra:formar){
                            if(letra == '_'){
                                gane = false;
                            }
                        }
                        
                        if(gane){
                            System.out.println(jugador1 + " ganaste! La palabra era: " + adivinar);
                            puntajeJugador1++;
                            break;
                        }
                    }
                }
                
                if(turnoJugador2 == true) {
                    System.out.println("\n" + jugador2 + " es tu turno!");

                    for(char letra:formar) {
                        System.out.print(letra + " ");
                    }
                    
                    //Ingresar el caracter a adivinar
                    System.out.print("\nCaracter en adivinar: ");
                    caracter = lea.next().charAt(0);
                    
                    //Buscar el caracter 
                    buscar = false;
                    for(int fila = 0; fila<adivinar.length(); fila++){
                        if(caracter == adivinar.charAt(fila)){
                            //Si existe, formar la palabra o cadena
                            formar[fila] = adivinar.charAt(fila);
                            buscar = true;
                        }
                    }
                    
                    if(!buscar){
                        System.out.println("No esta!");
                        turnoJugador1 = true;
                        turnoJugador2 = false;
                    }else{
                        gane = true;

                        for(char letra:formar){
                            if(letra == '_'){
                                gane = false;
                            }
                        }
                        
                        if(gane){
                            System.out.println(jugador2 + " ganaste! La palabra era: " + adivinar);
                            puntajeJugador2++;
                            break;
                        }
                    }
                }
            } 
            
            juegos++;
            
            if(juegos == cantidadPalabras)
                break;
            
            System.out.println("Jugar otra vez? (si | no) ");
            respuesta = lea.next().toUpperCase();
        }while(respuesta.equalsIgnoreCase("si"));
        
        //Puntaje / Final del Juego
        System.out.println("\nRESULTADOS:");
        System.out.println(jugador1 + " gano " + puntajeJugador1 + " juegos");
        System.out.println(jugador2 + " gano " + puntajeJugador2 + " juegos");
    }
}
