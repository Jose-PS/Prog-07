package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Inputs {

    private static Scanner lec = new Scanner(System.in);

    public static int getInt() {
        int numero = 0;
        try {
            numero = Integer.parseInt(lec.nextLine());
        } catch (NumberFormatException e) {
        }
        return numero;
    }
    
    public static double getDouble(String num) throws BancoException {
        double numd = 0;
        try {
            numd = Double.parseDouble(num);           
        } catch (NumberFormatException e) {
            throw new BancoException(Error.NONVALIDO, "Debes introducir un numero.");
        }
        return numd;
    }
    
    public static String getString(String menu) throws CancelException {
        System.out.println(menu);
        String txt;
        txt = lec.nextLine();
        if (txt.charAt(0)=='*') throw new CancelException();
        return txt;
    }

    public static int getInt(String txt) {
        System.out.println(txt);
        int numero = 0;
        try {
            numero = Integer.parseInt(lec.nextLine());
        } catch (NumberFormatException e) {
        }
        return numero;

    }

    public static int getInt(String txt, int min, int max) throws CancelException {
        String input = null;
        int numero = 0;
        boolean sigue = false;
        while (!sigue) {
            try {
                System.out.println(txt);
                input = lec.nextLine();
                if (input.charAt(0) == '*') {
                    throw new CancelException();
                }
                numero = Integer.parseInt(input);
                if (numero < min || numero > max) {
                    System.out.println("O numero debe ser maior que " + min + " e menor que " + max);
                } else {
                    sigue = true;
                }
            } catch (NumberFormatException ne) {
            }
        }
        return numero;
    }

    public static Calendar getDate(String str) throws CancelException {
        Calendar data1 = Calendar.getInstance();
        String data;
        boolean sigue = false;
        while (!sigue) {
            try {
                System.out.println(str);
                data = lec.nextLine();
                if (data.charAt(0)=='*') {
                    throw new CancelException();
                }
                SimpleDateFormat dataf = new SimpleDateFormat("dd/MM/yyyy");
                dataf.setLenient(false);
                data1.setTime(dataf.parse(data));
                sigue = true;
            } catch (ParseException pa) {
                System.out.println("Non e unha data valida");
                sigue = false;
            }
        }
        return data1;
    }

    public static String calendarToString(Calendar c) {
        Date date = c.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
