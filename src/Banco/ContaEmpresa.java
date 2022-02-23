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
public class ContaEmpresa extends ContaCorrente {

    private double interesDesc;
    private double maxDesc;
    private double comisionDesc;

    public ContaEmpresa(Persoa titular, String saldo, String iban, String maxDesc, String interesDesc, String comisionDesc) throws BancoException {
        super(titular, Inputs.getDouble(saldo), Valida.validaIban(iban), TipoConta.EMPRESA);
        this.interesDesc = Inputs.getDouble(interesDesc);
        this.maxDesc = Inputs.getDouble(maxDesc);
        this.comisionDesc = Inputs.getDouble(comisionDesc);
    }

    

    @Override
    public String devolverInfoString() {
        return "Titular: "+titular.devolverInfoString()+"\n"
                + "Numero: "+iban+", Maximo Descuberto: "+maxDesc+", Tipo Interes Descuberto: "+interesDesc+"\n"
                + "Comision Descuberto: "+comisionDesc+"Tipo de conta: "+tipoConta+", Saldo: "+saldo;
    }

}
