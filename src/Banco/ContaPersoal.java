/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Utils.BancoException;
import Utils.Inputs;
import Utils.Valida;

/**
 *
 * @author DAW
 */
public class ContaPersoal extends ContaCorrente {

    private double comisionMant;

    public ContaPersoal(Persoa titular, String saldo, String iban, String comisionMant) throws BancoException {
        super(titular, Inputs.getDouble(saldo), Valida.validaIban(iban), TipoConta.PERSOAL);
        this.comisionMant = Inputs.getDouble(comisionMant);
    }

    

    @Override
    public String devolverInfoString() {
        return "Titular: " + titular.devolverInfoString() + "\n"
                + "Numero: " + iban + ", Comision Mantemento: " + comisionMant+ "Tipo de conta: " + tipoConta+", Saldo: "+saldo;
    }

}
