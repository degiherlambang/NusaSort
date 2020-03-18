/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nusasort;

import java.util.ArrayList;
/**
 *
 * @author User
 */
public class MergeSort {
    
    private final ArrayList<Nasabah> inputArray;
    
    public ArrayList<Nasabah> getSortedArray() {
        return inputArray;
    }
 
    public MergeSort(ArrayList<Nasabah> inputArray){
        this.inputArray = inputArray;
    }
    
    public void sortGivenArray(){       
        divide(0, this.inputArray.size()-1);
    }
    
    public void divide(int startIndex,int endIndex){
        
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);        
            
            merger(startIndex,mid,endIndex);            
        }       
    }   
    
    public void merger(int startIndex,int midIndex,int endIndex){
        
        
        ArrayList<Nasabah> mergedSortedArray = new ArrayList<Nasabah>();
        
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
        Nasabah key = new Nasabah();
        String keyName;
        keyName = key.getNama();
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(keyName.compareToIgnoreCase(inputArray.get(leftIndex).getNama())<=keyName.compareToIgnoreCase(inputArray.get(rightIndex).getNama())){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }       
        
        while(leftIndex<=midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }
        
        while(rightIndex<=endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }
        
        int i = 0;
        int j = startIndex;
        
        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}
