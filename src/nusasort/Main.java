
package nusasort;

import java.util.ArrayList;
import nusasort.DB;
import nusasort.Nasabah;
import nusasort.NusaSort;
import nusasort.MergeSort;



public class Main {
    public static void main(String[]args){
        NusaSort nusaSorter = new NusaSort();
        ArrayList<Nasabah> bubbleSort = new ArrayList<Nasabah>();
        ArrayList<Nasabah> insertSort = new ArrayList<Nasabah>();
        ArrayList<Nasabah> selectSort = new ArrayList<Nasabah>();
        ArrayList<Nasabah> reverseSort = new ArrayList<Nasabah>();
        ArrayList<Nasabah> mergeSort = new ArrayList<Nasabah>();
        
        
        bubbleSort = nusaSorter.doBubbleSort();
        System.out.println("BubbleSort Sort By Nama");    
        System.out.println("---------");    
        for (int i=0;i<bubbleSort.size();i++){
            System.out.println("Nama: "+bubbleSort.get(i).getNama());
        }    
        System.out.println(" ");
        
        
        insertSort = nusaSorter.doInsertionSort();
        System.out.println("Insertion Sort By Nama");    
        System.out.println("---------");
        for (int i=0;i<insertSort.size();i++){
            System.out.println("Nama: "+insertSort.get(i).getNama());
        }    
        System.out.println(" ");
        
        selectSort = nusaSorter.doSelectSort();
        System.out.println("Selection Sort By Id");    
        System.out.println("---------");
        for (int i=0; i<selectSort.size(); i++) {
            System.out.println("Nama: "+selectSort.get(i).getNama());
        }    
        System.out.println(" ");
        
        reverseSort = nusaSorter.doReverse();
        System.out.println("Reverse Sort By Nama");    
        System.out.println("---------");
        for (int i=0; i<reverseSort.size(); i++) {
            System.out.println("Nama: "+reverseSort.get(i).getNama());
        }    
        System.out.println(" ");
        
            
        MergeSort mSort = new MergeSort(mergeSort);
        System.out.println("Merge Sort By Nama");    
        System.out.println("---------");
        mSort.sortGivenArray();
        for (Nasabah i:mSort.getSortedArray()) {
            System.out.print(i+" ");
        }    
        System.out.println(" ");
    }
}
    