package com.campusdual.classroom;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FreshMerchandise extends Merchandise {

    String pattern = "dd-MM-yyyy";
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    protected Date expirationDate;
    protected String formattedDate;

    public FreshMerchandise(String name, String uniqueId, String responsibleId, Date expirationDate) {
        super(name, uniqueId, responsibleId);
        this.expirationDate = expirationDate;
        this.formattedDate = this.getFormattedDate(expirationDate);
    }

    public FreshMerchandise(String name, String uniqueId, String responsibleId, int zone, String area, String shelf, int quantity, Date expirationDate) {
        super(name, uniqueId, responsibleId, zone, area, shelf, quantity);
        this.expirationDate = expirationDate;
        this.formattedDate = this.getFormattedDate(expirationDate);
    }

    @Override
    public String getSpecificData() {
        StringBuilder builder = new StringBuilder();
        builder.append("Localizacion: ");
        builder.append(this.getLocation());
        builder.append(". Caducidad: ");
        builder.append(this.formattedDate);
        return builder.toString();
    }

    public void printSpecificData() {
        System.out.println(getSpecificData());
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getFormattedDate(Date date) {
        this.formattedDate = dateFormat.format(date);
        return formattedDate;
    }
}
