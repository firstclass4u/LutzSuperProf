public class Aufgaben {

    public static void main(String[] args) {
        System.out.println("fibunacci(10) = " + fibunacci(10));
    }

    public static int fibunacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibunacci(n - 1) + fibunacci(n - 2);
    }


    /*
    Aufgabe 2:
    1: Rückgabe Wert ist float da public "float"...
    2: der genaue Rückgabewert ist 0.0 da "return 0"...
    3: Die Laufzeit liegt bei O(n^2-n) da wir die for-schleife n-1 mal durchlaufen und
    in der for-schleife die while scheife n mal durchlaufen ist die Laufzeit: O(n^2-n)
    Somit wäre O(n^2) korrekt da die Funktion maximal n^2 mal aufgerufen werden kann.
    4: Die neue Laufzeit ist nun (n) da wir die for schleife nur noch in konstanter Zeit duchlaufen
    und die while schleife nur noch n mal durchlaufen ist die Laufzeit: O(n)
    Somit wäre O(n) korrekt da die Funktion maximal n mal aufgerufen werden kann.
    5: Die Schleife ist in dem Fall unendlich. Da die while schleife immer wieder die for schleife
    aufrufen würde die nach ihrer ersten durchlaufung sofort beendet wird aber dann wieder neustartet.
    und da Count nie kleiner 0 wird ist sie im worstcase infinite.

     */
}
