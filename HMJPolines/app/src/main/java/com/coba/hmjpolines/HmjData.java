package com.coba.hmjpolines;

import java.util.ArrayList;

public class HmjData {

    public static String[][] data = new String[][]{
            {"0", "HMJ Elektro", "Himpunan Mahasiswa Elektro terdiri dari 5 Program Studi yaitu D3 Teknik Informatika, D3 Teknik Elektronika, D3 Teknik Listrik, D3 Teknik Telekomunikasi, STr Teknik Telekomunikasi", "https://i.postimg.cc/QxdcLRBk/hme.jpg"},
            {"1", "HMJ Sipil", "Himpunan Mahasiswa Sipil terdiri dari 4 Program Studi ", "https://i.postimg.cc/yxBXSxYw/hms.jpg"},
            {"2", "HMJ Mesin", "Himpunan Mahasiswa Mesin terdiri dari 4 Program Studi ", "https://i.postimg.cc/LsL1BS7R/hmm.jpg"},
            {"3", "HMJ Akuntansi", "Himpunan Mahasiswa Akuntansi terdiri dari 5 Program Studi ", "https://i.postimg.cc/3NS4Jxyj/hmak.jpg"},
            {"4", "HMJ Administrasi Bisnis", "Himpunan Mahasiswa Administrasi Bisnis terdiri dari 4 Program Studi ", "https://i.postimg.cc/pLYvD1Z4/hmab.jpg"}

    };

    public static ArrayList<Hmj> getListData(){
        ArrayList<Hmj> list = new ArrayList<>();
        for (String[] aData : data){
            Hmj hmj = new Hmj();
            hmj.setId(Integer.parseInt(aData[0]));
            hmj.setName(aData[1]);
            hmj.setDescription(aData[2]);
            hmj.setPhoto(aData[3]);

            list.add(hmj);
        }
        return list;
    }
}
