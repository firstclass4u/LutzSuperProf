package me.lutzsuperprof;

import me.lutzsuperprof.model.Kontakt;
import me.lutzsuperprof.view.KontakteGUI;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var kontakt = new Kontakt(
                "Lutz",
                "Superprof",
                "https://www.google.com",
                new ArrayList<>(List.of("list@mai.com"))
        );
        Kontakt.getKontakte().add(kontakt);
        KontakteGUI.start();
    }
}

