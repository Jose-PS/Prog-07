/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Persoa.Persoa;

/**
 *
 * @author DAW
 */
public class ContaPersoal extends ContaCorrente {

    private double comisionMant;

    public ContaPersoal(Persoa titular, double saldo, String iban, double comisionMant, TipoConta tipoConta) {
        super(titular, saldo, iban, tipoConta);
        this.comisionMant = comisionMant;
    }

    

    @Override
    public String devolverInfoString() {
        return "Titular: " + titular.devolverInfoString() + "\n"
                + "Numero: " + iban + ", Comision Mantemento: " + comisionMant+ "Tipo de conta: " + tipoConta+", Saldo: "+saldo;
    }

}
