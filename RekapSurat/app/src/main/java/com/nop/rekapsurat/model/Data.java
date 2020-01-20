package com.nop.rekapsurat.model;

public class Data {
    String nosurat;
    //int amount;
    String pengirim;
    String perihal;
    String note;
    String date;
    String id;

    public Data(){

    }

    public Data(String nosurat, String pengirim, String perihal, String note, String id){
        this.nosurat = nosurat;
        //this.amount = amount;
        this.pengirim = pengirim;
        this.perihal = perihal;
        this.note = note;
        this.date = date;
        this.id = id;
    }

    public String getNosurat() {
        return nosurat;
    }

    public void setNosurat(String nosurat) {
        this.nosurat = nosurat;
    }

//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPerihal() {
        return perihal;
    }

    public void setPerihal(String perihal) {
        this.perihal = perihal;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
