package org.ulpgc.is1.model;
import java.util.regex.Pattern;

public class NIF {
    public String number;

    public NIF(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }




    public boolean isValid() {

            String regex = "\\d{8}[A-Z]";
            return Pattern.matches(regex, number);
        }



}
