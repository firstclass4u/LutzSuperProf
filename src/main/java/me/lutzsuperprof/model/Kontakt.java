package me.lutzsuperprof.model;

import java.util.ArrayList;

public class Kontakt {
    private static ArrayList<Kontakt> kontakte = new ArrayList<>();


    private String vorname;
    private String name;
    private String imagepath;
    private ArrayList<String> emails;

    public Kontakt(String vorname, String name, String imagepath, ArrayList<String> emails) {
        this.vorname = vorname;
        this.name = name;
        this.imagepath = imagepath;
        for (String email : emails) {
            if (!checkEmail(email)) {
                throw new IllegalArgumentException("Email is not valid");
            }
        }
        this.emails = emails;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public boolean setEmails(ArrayList<String> emails) {
        for (var email : emails) {
            if (!checkEmail(email)) return false;
        }
        this.emails = emails;
        return true;
    }

    public boolean addEmail(String email) {
        if (!checkEmail(email)) return false;
        emails.add(email);
        return true;
    }

    public boolean checkEmail(String email) {
        if (!email.contains("@"))
            return false;
        else if (email.startsWith("@")) return false;
        else if (email.endsWith("@")) return false;
        return true;
    }

    public void removeEmail(String email) {
        emails.remove(email);
    }

    public static ArrayList<Kontakt> getKontakte() {
        return kontakte;
    }

    public static void setKontakte(ArrayList<Kontakt> kontakte) {
        Kontakt.kontakte = kontakte;
    }
}

