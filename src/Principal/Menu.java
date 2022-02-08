/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Menu {

    enum Direccion {
        HORIZONTAL, VERTICAL
    }
    private String titulo;
    private String[] opcions;
    private String validas;
    private Direccion direccion = Direccion.VERTICAL;

    
    

    /**
     * Constructor con todos os parametros.
     *
     * @param opcions
     * @param validas
     * @param direccion
     */
    public Menu(String titulo, String[] opcions, String validas, Direccion direccion) {
        this.titulo = titulo;
        this.opcions = opcions;
        this.validas = validas;
        this.direccion = direccion;
    }

    /**
     * Constructor sen especificar direccion, usaria a direccion vertical por
     * defecto.
     *
     * @param opcions
     * @param validas
     */
    public Menu(String titulo, String[] opcions, String validas) {
        this.titulo = titulo;
        this.opcions = opcions;
        this.validas = validas;
    }

     

    private void showMenu() {
        String opt;
        System.out.print(titulo);
        salta();
        for (int i = 0; i < opcions.length; i++) {
            System.out.print(opcions[i]);
            salta();
        }
    }

    public char getOpcion() {
        Scanner lec = new Scanner(System.in);
        String opt;
        do {
            showMenu();
            opt = lec.nextLine();
        } while (!validas.contains(opt));
        return opt.toLowerCase().charAt(0);
    }

    public void salta() {
        if (direccion == Direccion.HORIZONTAL) {
            System.out.print(", ");
        } else {
            System.out.println();
        }
    }

}
