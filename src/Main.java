import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args) {
        zadanie1();
        try{
            System.out.println("5! = "+ silnia(5));
        }catch (silniaError e){
            System.out.println("error "+ e.getMessage());
        }
        try {
            Adres adres = new Adres(null, 56, "39-200", null);
        } catch (NieprawidlowyAdresException e) {
            System.out.println("Wystąpił wyjątek: " + e.getMessage());
        }


    }
    public static void zadanie1(){
        System.out.println("Podaj liczbe: ");
        Scanner input = new Scanner(System.in);
        double liczba =0;
        while (true){
            try{
                liczba = input.nextDouble();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Podaj poprawną wartość");
                input.next();
            }
        }
        if (liczba <0) throw new IllegalArgumentException(String.format("Pierwiastek "+
            "kwadratowy z liczby %.4f nie istnieje",liczba));
        System.out.println(String.format("Pierwiatsek z liczby %.4f = %.4f", liczba, Math.sqrt(liczba)));


    }
    public static int silnia(int n) throws silniaError{
        if(n<0) throw new silniaError("Silenia z ujemnej nie istnieje");

        int wynik =1;
        for (int i = 2; i <=n ; i++) {
            wynik*=i;
        }
        return wynik;
    }
    static class silniaError extends Exception{
        public silniaError(String message){
            super(message);
        }


    }

}
class NieprawidlowyAdresException extends Exception {
    public NieprawidlowyAdresException(String message) {
        super(message);
    }
}
 class Adres {
    private String ulica;
    private int numerDomu;
    private String kodPocztowy;
    private String miasto;

    public Adres(String ulica, int numerDomu, String kodPocztowy, String miasto) throws NieprawidlowyAdresException {
        String bledy = "";

        if (ulica == null) {
            bledy = bledy + "Ulica nie może być nullem. ";
        }

        if (numerDomu <= 0) {
            bledy = bledy + "Numer domu musi być liczbą większą od zera,. ";
        }

        if (kodPocztowy == null) {
            bledy = bledy + "Kod pocztowy nie może być nullem. ";
        }

        if (miasto == null) {
            bledy = bledy + "Miasto nie może być nullem. ";
        }

        if (!bledy.isEmpty()) {
            throw new NieprawidlowyAdresException(bledy);
        }

        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }


}
