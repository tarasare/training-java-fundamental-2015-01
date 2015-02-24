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
        try {
            data = br.readLine();
            while (data != null) {
                System.out.println(data);
                data = br.readLine();
            }
            br.close();

            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(ImporterKehadiranTextfile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal membaca file");
        }
        return hasil;
    }
}