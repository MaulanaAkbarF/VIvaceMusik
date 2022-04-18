/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allform;

import java.sql.Connection;

/**
 *
 * @author Maulana Akbar
 */
public  class auto_id extends Dashboard {
    
    public void autoidbarang(){
       try{
        String sql = "SELECT MAX(RIGHT(idalatmusik,3)) FROM alatmusik";
        java.sql.Connection con = (Connection) Config.configDB();
        java.sql.Statement st = con.createStatement();
        java.sql.ResultSet rst = st.executeQuery(sql);
        if(rst.next()) {
            
            String auto_kode, tambah;
            
            int kdb;
            auto_kode = Integer.toString(rst.getInt(1)+1);
            kdb = auto_kode.length();
            tambah = "";
            for (int i = 1; i <= 3 - kdb; i++ ){
                tambah = tambah + "0";
            }
            idbarangfield.setText("AM"+tambah+auto_kode);
            
         }
        }
        catch (Exception e) {
            idbarangfield.setText("AM069");
        }
    }
    public void autoidsupp(){
       try{
        String sql = "SELECT MAX(RIGHT(idalatmusik,3)) FROM alatmusik";
        java.sql.Connection con = (Connection) Config.configDB();
        java.sql.Statement st = con.createStatement();
        java.sql.ResultSet rst = st.executeQuery(sql);
        if(rst.next()) {
            
            String auto_kode, tambah;
            
            int kdb;
            auto_kode = Integer.toString(rst.getInt(1)+1);
            kdb = auto_kode.length();
            tambah = "";
            for (int i = 1; i <= 3 - kdb; i++ ){
                tambah = tambah + "0";
            }
            idbarangfield.setText("AM"+tambah+auto_kode);
            
         }
        }
        catch (Exception e) {
            idbarangfield.setText("AM069");
        }
    }
}
