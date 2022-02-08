package Principal;

import Banco.Banco;
import Banco.ContaAforro;
import Banco.ContaBancaria;
import Banco.ContaEmpresa;
import Banco.ContaPersoal;
import Persoa.Persoa;
import Utils.BancoException;
import Utils.Error;
import Utils.Valida;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Principal {

    private final Banco banco = new Banco();
    private String tipoConta;
    Scanner lec = new Scanner(System.in);

    void run() {
        char opt = 0;
        String iban;
        String lista[] = null;
        double cant;
        boolean estado;
        double saldo;
        Menu m = new Menu("Banco do Hio, escolle unha opcion.", new String[]{"(A)brir nova conta.", "(V)er listado de contas.", "(O)bter datos dunha conta.", "(I)ngresar efectivo en conta.", "(R)etirar efectivo de conta.", "(C)onsultar saldo en conta.", "(S)air."}, "avoircs");
        do {
            try {
                opt = m.getOpcion();
                switch (opt) {
                    case 'a' ->
                        abreConta();
                    case 'v' -> {
                        {
                            try {
                                lista = banco.listadoContas();
                            } catch (BancoException ex) {
                                System.out.println(ex.getCodigo());
                            }
                        }
                        for (String lista1 : lista) {
                            System.out.println(lista1);
                        }
                    }

                    case 'o' -> {
                        System.out.println("Introduce o IBAN: ");
                        System.out.println(banco.informacionConta(lec.nextLine()));
                    }
                    case 'i' -> {
                        try {
                        System.out.println("Introduce o IBAN: ");
                        iban = lec.nextLine();
                        System.out.println("Introduce a cantidade: ");
                        cant = Double.parseDouble(lec.nextLine());
                        estado = banco.ingresoConta(iban, cant);
                        if (estado) {
                            System.out.println("Operacion realizada con exito!");
                        } else {
                            System.out.println("Houbo un erro na operacion.");
                        }
                        } catch (NumberFormatException n) {
                        throw new BancoException (Error.NONVALIDO);
                        }
                    }
                    case 'r' -> {
                        try {
                        System.out.println("Introduce o IBAN: ");
                        iban = lec.nextLine();
                        System.out.println("Introduce a cantidade a retirar: ");
                        cant = Double.parseDouble(lec.nextLine());
                        estado = banco.retiradaConta(iban, cant);
                        if (estado) {
                            System.out.println("Operacion realizada con exito!");
                        } else {
                            System.out.println("Houbo un erro na operacion.");
                        }
                    } catch (NumberFormatException n){
                        throw new BancoException (Error.NONVALIDO);
                    }
                    }
                    case 'c' -> {
                        System.out.println("Introduce o IBAN da conta: ");
                        saldo = banco.obterSaldo(lec.nextLine());
                        if (saldo < 0) throw new BancoException (Error.NONEXISTE);
                        System.out.println("O saldo da conta e: "+saldo);
                    }
                    case 's' -> {
                    }
                }
            } catch (BancoException ex) {
                System.out.println(ex.getCodigo());
            }
        } while (opt != 's');
    }

    private Persoa novaPersoa() {
        String dni = null;
        String nome = null;
        String apelidos = null;
        Persoa p = null;
        boolean sigue = true;
        do {
            try {
                System.out.println("Introduce os datos do cliente.");
                System.out.println("Nome.");
                nome = lec.nextLine();
                System.out.println("Apelidos.");
                apelidos = lec.nextLine();
                System.out.println("DNI.");
                dni = lec.nextLine();
                Valida.validaDni(dni);
                sigue=true;
            } catch (BancoException ex) {
                sigue = false;
                System.out.println(ex.getCodigo());
            }
            p = new Persoa(nome, apelidos, dni);
        } while (!sigue);
        return p;
    }

    private void abreConta() {
        ContaBancaria conta = null;
        Persoa p = null;
        int[] opts;
        Object[] datos = new Object[7];
        boolean abrirConta = false;
        String[] opcions = new String[]{"Saldo.", "Numero de conta.", "Tipo de interes.", "Comision de mantemento.", "Maximo descuberto permitido.", "Tipo de interes por descuberto.", "Comision fija por descuberto."};
        p = novaPersoa();
        do {
            try {
                opts = getTipo();
                System.out.println("Introduce os datos da conta.");
                for (int i = 0; i < opts.length; i++) {
                    System.out.println(opcions[opts[i]]);
                    datos[opts[i]] = lec.nextLine();
                }
                try {
                    switch (tipoConta.charAt(0)) {
                        case 'e' ->
                            conta = new ContaEmpresa(p, (Double.parseDouble(datos[opts[0]].toString())), (Valida.validaIban((String) datos[opts[1]])), (Double.parseDouble(datos[opts[2]].toString())), (Double.parseDouble(datos[opts[3]].toString())), (Double.parseDouble(datos[opts[4]].toString())), ContaBancaria.TipoConta.EMPRESA);
                        case 'p' ->
                            conta = new ContaPersoal(p, (Double.parseDouble(datos[opts[0]].toString())), (Valida.validaIban((String) datos[opts[1]])), (Double.parseDouble(datos[opts[2]].toString())), ContaBancaria.TipoConta.PERSOAL);
                        case 'a' ->
                            conta = new ContaAforro(p, (Double.parseDouble(datos[opts[0]].toString())), (Valida.validaIban((String) datos[opts[1]])), (Double.parseDouble(datos[opts[2]].toString())), ContaBancaria.TipoConta.AFORRO);
                        default -> {
                        }
                    }
                    abrirConta = banco.abrirConta(conta);
                } catch (NumberFormatException n) {
                    throw new BancoException(Error.NONVALIDO, "Asegurate de introducir ben todos os datos");
                }
                if (!abrirConta) {
                    throw new BancoException(Error.NONVALIDO);
                }
            } catch (BancoException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!abrirConta);
    }

    public int[] getTipo() {
        char escolle;
        int[] opts = null;
        Menu m = new Menu("Que tipo de conta desexas crear?", new String[]{"Conta de (E)mpresa", "Conta (P)ersoal", "Conta de (A)forro"}, "epa", Menu.Direccion.HORIZONTAL);
        escolle = m.getOpcion();
        switch (escolle) {
            case 'e' -> {
                tipoConta = "empresa";
                opts = new int[]{0, 1, 4, 5, 6
                };
            }
            case 'p' -> {
                tipoConta = "persoal";
                opts = new int[]{0, 1, 3};
            }
            case 'a' -> {
                tipoConta = "aforro";
                opts = new int[]{0, 1, 2};
            }
            default -> {
            }
        }
        return opts;
    }

    public static void main(String[] args) {
        Principal main = new Principal();
        main.run();
    }

}
