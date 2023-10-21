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




    public boolean valid() {
        String regex = "\\d{8}[A-Z]";
        return Pattern.compile(regex).matcher(number).matches();
    }

    @Override
    public String toString() {
        if (valid()) {
            return number;
        } else {
            return "XXXX";
        }
    }



}
