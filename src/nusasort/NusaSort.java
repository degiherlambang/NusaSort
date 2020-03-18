package nusasort;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import nusasort.Nasabah;
import nusasort.DB;




public class NusaSort {

    private ArrayList<Nasabah> listNasabah;
    private boolean isSorted;
    private Nasabah nsb;

    public NusaSort() {

    }

    public ArrayList<Nasabah> getDbList() {
        listNasabah = new ArrayList<Nasabah>();
        try {
            PreparedStatement ps = DB.getConnection()
                    .prepareStatement("select*from nasabah");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nsb = new Nasabah();
                nsb.setId(rs.getInt("id_nasabah"));
                nsb.setNama(rs.getString("nama"));
                listNasabah.add(nsb);
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNasabah;
    }

    public ArrayList<Nasabah> doBubbleSort() {

        listNasabah = getDbList();

        Nasabah temp = null;
        // algo
        if (listNasabah.size()>1) 
        {
            for (int x=0; x < listNasabah.size(); x++)
            {
                for (int i=0; i < listNasabah.size()-x-1; i++) {
                    if (listNasabah.get(i).getNama().compareTo(listNasabah.get(i+1).getNama()) > 0)
                    {
                        temp = listNasabah.get(i);
                        listNasabah.set(i,listNasabah.get(i+1) );
                        listNasabah.set(i+1, temp);
                        }
                }
            }
        }

        return listNasabah;
    }

    public ArrayList<Nasabah> doReverse() {

        listNasabah = getDbList();

        Nasabah temp = null;
        if (listNasabah.size()>1) 
        {
            for (int x=0; x < listNasabah.size(); x++)
            {
                for (int i=0; i < listNasabah.size()-x-1; i++) {
                    if (listNasabah.get(i).getNama().compareTo(listNasabah.get(i+1).getNama()) < 0)
                    {
                        temp = listNasabah.get(i);
                        listNasabah.set(i,listNasabah.get(i+1) );
                        listNasabah.set(i+1, temp);
                        }
                }
            }
        }

        return listNasabah;
    }
    

    public ArrayList<Nasabah> doInsertionSort() {
        listNasabah = getDbList();

        for (int i = 1; i < listNasabah.size(); i++) {
            String keyName;
            Nasabah key = new Nasabah();
            key.setNama(listNasabah.get(i).getNama());
            keyName = key.getNama();
            int j = i-1;
            while ((j >= 0) && (keyName.compareToIgnoreCase(listNasabah.get(j).getNama()) < 0)) {
                listNasabah.set(j+1, listNasabah.get(j));
                j--;
            }
                listNasabah.set(j+1, key);
        }
        return listNasabah;
    }
    
    
    
    public ArrayList<Nasabah> doSelectSort() {
        Nasabah nasabah = new Nasabah();
        listNasabah = getDbList();
        for (int i=0; i<listNasabah.size();i++){
            int min = listNasabah.get(i).getId();
            int minIndex = 1;
            
            for (int j = i+1; j < listNasabah.size(); j++) {
                if (listNasabah.get(j).getId() < min) {
                    min = listNasabah.get(j).getId();
                }
            }
            if (i != minIndex) {
                Collections.swap(listNasabah, i, minIndex);
            }
        }
        return listNasabah;
    }    
}
