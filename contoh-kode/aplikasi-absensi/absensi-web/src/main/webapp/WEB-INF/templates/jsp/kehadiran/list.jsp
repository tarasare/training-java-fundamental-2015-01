<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Kehadiran</title>
    </head>
    <body>
        <h1>Data Kehadiran</h1>
        
        <form>
            
            Karyawan : 
            <select name="idKaryawan">
                <option>Pilih Karyawan</option>
            </select>
            
            <input type="submit" value="Cari" />
            
        </form>
        
        <hr>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Tanggal</th>
                    <th>Datang</th>
                    <th>Pulang</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1 Februari 2015</td>
                    <td>08:00</td>
                    <td>17:00</td>
                </tr>
            </tbody>
        </table>

        
    </body>
</html>
