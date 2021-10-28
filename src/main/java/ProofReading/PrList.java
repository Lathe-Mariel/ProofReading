/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProofReading;

import java.util.ArrayList;

/**
 *
 * @author n11ak
 */
public class PrList {
    
    ArrayList<PdfFile> pdfList;
       
    int[] finished = new int[5];
//野：0　松：1　仲：2　永：3　青：4
    
    public PrList(){
        pdfList = new ArrayList<PdfFile>();
    }
    
    public void add(String fileName){
        pdfList.add(new PdfFile(fileName));
    }
    
    public String getWorstPerson(){
        int[] order;
        order = new int[5];
        
        int worstValue = finished[0];
        int worstPerson=0;
        String names[] = {"野", "松", "仲", "永", "青"};
        
        for(int i=1; i<names.length; i++){
            System.out.println(names[i] + " : " + finished[i]);
            if(worstValue > finished[i]){
                worstValue = finished[i];
                worstPerson = i;
            }
        }
        String name=null;
        switch (worstPerson){
            case 0:
                name = "野";
                break;
            case 1:
                name = "松";
                break;
            case 2:
                name = "仲";
                break;
            case 3:
                name = "永";
                break;
            case 4:
                name = "青";
                break;
            case 5:
                break;
                
        }
        return name;
    }
    
    String printState(PRForm form){
        form.nomuValue.setText(finished[0] + "");
        form.matsuValue.setText(finished[1] + "");
        form.nakaValue.setText(finished[2] + "");
        form.nagaValue.setText(finished[3] + "");
        form.aokiValue.setText(finished[4] + "");
        String state = "野村：　" + finished[0] + "    松元：　" + finished[1] + "　　仲井：　" + finished[2] +  "　　　永井：　" + finished[3] + "　　　青木：　" + finished[4];
        return state;
    }
            
    class PdfFile{
        String fullFilename;
        String articleName;
        
        public PdfFile(String fileName){
            fullFilename = fileName;
            parse();
        }
        
        public void parse(){
            int position = fullFilename.indexOf("校_");
            int position2 = fullFilename.indexOf("校-");
            if(position < position2){
                position = position2;
            }
            if(position == -1)return;
        
            articleName = fullFilename.substring(0, position);
            String latterHalf = fullFilename.substring(position+1);
            System.out.println(latterHalf);
            if(latterHalf.contains("野")){
                finished[0]++;
                System.out.println("野: " + finished[0]);
            }
            if(latterHalf.contains("松")){
                finished[1]++;
                System.out.println("松: " + finished[1]);
            }
            if(latterHalf.contains("仲")){
                finished[2]++;
                System.out.println("仲: " + finished[2]);
            }
            if(latterHalf.contains("永")){
                finished[3]++;
                System.out.println("永: " + finished[3]);
            }
            if(latterHalf.contains("青")){
                finished[4]++;
                System.out.println("青" + finished[4]);
            }
        }
        
    }
}
