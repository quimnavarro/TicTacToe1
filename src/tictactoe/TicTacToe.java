/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * El joc tic tac tou, el joc del 3 en ralla.
 * @author Quim Navarro Clares
 * @version 28.02.2023
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] tauler = new int[3][3];
        imprimirTauler(tauler);
        iniciJoc(tauler);
        System.out.println("");
        System.out.println("");
        imprimirTauler(tauler);
        while(true) {
            tirJugador(tauler);
            imprimirTauler(tauler);
            tirContrincant(tauler);
            imprimirTauler(tauler);
        }                
                
    }
    
    /**
     * S'inicialitza el tauler de joc a "-N", on N és la llargada/amplada del tauler
     * El tauler conté "-N" si és una casella buida, "0" si és una casella amb la fitxa del contrincant i "1" si és una casella amb la fitxa del jugador
     * És a dir, aquest mètode marca totes les cel·les del tauler com a buides.
     * @param taulerJoc 
     */
    public static void iniciJoc(int[][] taulerJoc) {
        for(int i = 0; i < taulerJoc.length; i++) {
            for(int j = 0; j < taulerJoc.length; j++) {
                taulerJoc[i][j] = -3;
            }
        }
    }
    
    /**
     * L'amplada del tauler ha de ser igual a la seva llargada (tauler quadrat)
     * @param taulerJoc 
     */
    public static void imprimirTauler(int[][] taulerJoc) {  
        System.out.println("  1 2 3 ");
        for(int i = 0; i < taulerJoc.length; i++) {
            //System.out.println(" ______");            
            System.out.print("| ");
            for(int j = 0; j < taulerJoc.length; j++) {
                System.out.print(crossOrCircle(taulerJoc[i][j]) + " ");
            }
            System.out.print("| "+(i+1));
            System.out.println("");
        }
        //System.out.println(" ______");
    }
    
    /**
     * Retora diferents caracters segons el parametre i del metode
     * 
     * @param i El contingut del element del tauler de soc
     * @return '_ si  i = -3 el simbol de la 'O' si la i es 0 i el simbol de la 'X' és diferent que 0
     */
    
    public static char crossOrCircle(int i){
        if(i==-3) return '_';
        return (i==0)?'O':'X';
    }
    
    /**
     * Retorna el valor de una array unidimensional
     * 
     * BI   UNI
     * 0,0  0
     * 0,1  1
     * 0,2  2
     * 1,0  3
     * 1,1  4
     * @param x Obte el contingut de les files de l'array bidimensional
     * @param y Obte el contingut de les columnes de l'array bidimensional
     * @return Retorna els valors de l'array Unidimensionals
     */
    
    private static int bidimensionalToUnidimensional(int x, int y){
        return (y-1)*3 + x;
    }    
    
    /**
     * Apliquem l'objecte random per aque ens doni uns numeros aleatoris a les nostres variavles, 
     * en aquest cas sera del 0 al 3 els numeros random que podra donar l'objecte random
     * @param taulerJoc Obte el contingu de l'array bidimensionl
     */
    
    public static void tirContrincant(int[][] taulerJoc){
        System.out.println("");
        System.out.println("TIR CONTRINCANT");
        
        int random_x;
        int random_y;
        
        Random rand = new Random();
        
        do {
            random_x = rand.nextInt(3);
            random_y = rand.nextInt(3);
        } while(taulerJoc[random_x][random_y] != -3);
        
        taulerJoc[random_x][random_x]=0; // 0 = 'O', és a dir, la màquina        
    }
    

    /**
     * Apliquem els prints per poder veure en la consola lo que hem de introduir, declararem unes variables per poder passar aquestos valors.
     * @param taulerJoc 
     */
    public static void tirJugador(int[][] taulerJoc){
        System.out.println("");
        System.out.println("TIR JUGADOR");
        
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream  
        System.out.print("[X] Entra la columna (1-3)");
        int x = sc.nextInt();
        System.out.print("[Y] Entra la fila (1-3)");
        int y = sc.nextInt();
        
        taulerJoc[y-1][x-1]=1; // 1 = 'X', és a dir, el jugador 
    }
    
    /**
     * Revisa totes les files (F), columnes (C) i diagonals (D) del tauler per determinar si un jugador ha guanyat o no.
     * 
     * El tauler ha de tenir una llargada/amplada fixa, que anomenem "N".
     * Un jugador guanya quan aconsegueix tenir N caselles seguides en qualsevol fila, columna o diagonal.
     * El contrincant guanya quan la suma dels valors d'una fila, columna o diagonal dóna exactament 0.
     * El jugador guanya quan la suma dels valors d'una fila, columna o diagonal dóna exactament N.
     * 
     * @param taulerJoc que representa les cel·les del tauler de joc, de mida NxN. 
     * @return "-1" si no guanya ningú; "0" si guanya el contrincant; i "1" si guanya el jugador
     */
    public static int determinarGuanyador(int[][] taulerJoc){
        //TODO
        throw new UnsupportedOperationException();
    }
    
}
