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
public class ContaEmpresa extends ContaCorrente {

    private double interesDesc;
    private double maxDesc;
    private double comisionDesc;

    public ContaEmpresa(Persoa titular, double saldo, String iban, double maxDesc, double interesDesc, double comisionDesc, TipoConta tipoConta) {
        super(titular, saldo, iban, tipoConta);
        this.interesDesc = interesDesc;
        this.maxDesc = maxDesc;
        this.comisionDesc = comisionDesc;
    }

    

    @Override
    public String devolverInfoString() {
        return "Titular: "+titular.devolverInfoString()+"\n"
                + "Numero: "+iban+", Maximo Descuberto: "+maxDesc+", Tipo Interes Descuberto: "+interesDesc+"\n"
                + "Comision Descuberto: "+comisionDesc+"Tipo de conta: "+tipoConta+", Saldo: "+saldo;
    }

}
