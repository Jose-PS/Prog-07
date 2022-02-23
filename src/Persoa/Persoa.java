/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persoa;

import Interfaz.Imprimible;
import Utils.BancoException;
import Utils.CancelException;
import Utils.Valida;

/**
 *
 * @author DAW
 */
public class Persoa implements Imprimible {

    private String nombre;
    private String apellidos;
    private String dni;

    public Persoa(String nombre, String apellidos, String dni) throws BancoException, CancelException {
        Valida.validaDni(dni);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    @Override
    public String devolverInfoString() {
        return "Nome: "+nombre+", Apelidos: "+apellidos+", DNI: "+dni;
    }

}
