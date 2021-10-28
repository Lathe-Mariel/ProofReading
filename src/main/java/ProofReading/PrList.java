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
//��F0�@���F1�@���F2�@�i�F3�@�F4
    
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
        String names[] = {"��", "��", "��", "�i", "��"};
        
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
                name = "��";
                break;
            case 1:
                name = "��";
                break;
            case 2:
                name = "��";
                break;
            case 3:
                name = "�i";
                break;
            case 4:
                name = "��";
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
        String state = "�쑺�F�@" + finished[0] + "    �����F�@" + finished[1] + "�@�@����F�@" + finished[2] +  "�@�@�@�i��F�@" + finished[3] + "�@�@�@�؁F�@" + finished[4];
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
            int position = fullFilename.indexOf("�Z_");
            int position2 = fullFilename.indexOf("�Z-");
            if(position < position2){
                position = position2;
            }
            if(position == -1)return;
        
            articleName = fullFilename.substring(0, position);
            String latterHalf = fullFilename.substring(position+1);
            System.out.println(latterHalf);
            if(latterHalf.contains("��")){
                finished[0]++;
                System.out.println("��: " + finished[0]);
            }
            if(latterHalf.contains("��")){
                finished[1]++;
                System.out.println("��: " + finished[1]);
            }
            if(latterHalf.contains("��")){
                finished[2]++;
                System.out.println("��: " + finished[2]);
            }
            if(latterHalf.contains("�i")){
                finished[3]++;
                System.out.println("�i: " + finished[3]);
            }
            if(latterHalf.contains("��")){
                finished[4]++;
                System.out.println("��" + finished[4]);
            }
        }
        
    }
}
