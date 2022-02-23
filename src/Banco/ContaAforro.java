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
public class ContaAforro extends ContaBancaria {

    private double tipoInteres;

    public ContaAforro(Persoa titular, String saldo, String iban, String tipoInteres) throws BancoException {
        super(titular, Inputs.getDouble(saldo), Valida.validaIban(iban), TipoConta.AFORRO);
        this.tipoInteres = Inputs.getDouble(tipoInteres);
    }

    @Override
    public String devolverInfoString() {
        return "Titular: " + titular.devolverInfoString() + "\n"
                + "Numero: " + iban + ", Tipo Interes: " + tipoInteres + "Tipo de conta: " + tipoConta + ", Saldo: " + saldo;
    }

}
