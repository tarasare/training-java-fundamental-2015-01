package com.muhardin.endy.absensi.importer.file;

import com.muhardin.endy.absensi.importer.ImporterKehadiran;
import com.muhardin.endy.absensi.Kehadiran;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImporterKehadiranTextfile
        implements ImporterKehadiran {

    private File sumberData;

    // constructor, untuk membuat object dari class ini
    // harus menyediakan file sumber data
    public ImporterKehadiranTextfile(File f) {
        this.sumberData = f;
    }

    public List<Kehadiran> importData() throws FileNotFoundException {
        FileReader fr = null;
        BufferedReader br = null;
        List<Kehadiran> hasil = new ArrayList<Kehadiran>();
        System.out.println("Nanti memproses file di sini");
        fr = new FileReader(sumberData);
        br = new BufferedReader(fr);
        String data;
        
        String polaWaktu = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat parserWaktu = new SimpleDateFormat(polaWaktu);
        
        SortedMap<Integer, List<Date>> dataAbsensi = new TreeMap<Integer, List<Date>>();
        
        try {
            data = br.readLine();
            while (data != null) {
                System.out.println(data);
                String[] dipecah = data.trim().split("[\\s]+");
                tampilkanHasilSplit(dipecah);
                
                try {
                    // parsing data tanggal
                    Date waktu = parserWaktu.parse(dipecah[1]+" "+dipecah[2]);
                    System.out.println("Waktu : "+waktu);
                    
                    Integer id = Integer.valueOf(dipecah[0]);
                    List<Date> dataAbsensiKaryawan = dataAbsensi.get(id);
                    
                    if(dataAbsensiKaryawan == null){
                        dataAbsensiKaryawan = new ArrayList<Date>();
                    }
                    
                    dataAbsensiKaryawan.add(waktu);
                    dataAbsensi.put(id, dataAbsensiKaryawan);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ImporterKehadiranTextfile.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                data = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(ImporterKehadiranTextfile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal membaca file");
        }
        
        System.out.println("============= Data Absensi =================");
        for (Integer x : dataAbsensi.keySet()) {
            System.out.println("Data Absensi ID "+x+" : "+dataAbsensi.get(x));
        }
        System.out.println("============= Data Absensi =================");
        
        return hasil;
    }

    private void tampilkanHasilSplit(String[] dipecah) {
        System.out.println("Jumlah data setelah split : "+dipecah.length);
        System.out.println("Data 1 "+dipecah[0]);
        System.out.println("Data 2 "+dipecah[1]);
        System.out.println("Data 3 "+dipecah[2]);
        System.out.println("Data 4 "+dipecah[3]);
        System.out.println("Data 5 "+dipecah[4]);
        System.out.println("Data 6 "+dipecah[5]);
        System.out.println("Data 7 "+dipecah[6]);
    }
}
