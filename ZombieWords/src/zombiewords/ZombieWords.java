/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewords;
import java.util.*;
import java.io.*;

/**
 *
 * @author chengyang
 */
public class ZombieWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chengyang\\Documents\\NetBeansProjects\\ZombieWords\\src\\zombiewords\\words.txt"));
        String line;
        int size = 0;
        while((line = br.readLine()) != null) {
            size++;
        }
        br = new BufferedReader(new FileReader("C:\\Users\\chengyang\\Documents\\NetBeansProjects\\ZombieWords\\src\\zombiewords\\words.txt"));
        String[] words = new String[size];
        for (int i = 0; i <size;i++) {
            words[i] = br.readLine();
        }
        BufferedReader essayReader = new BufferedReader(new FileReader("C:\\Users\\chengyang\\Documents\\NetBeansProjects\\ZombieWords\\src\\zombiewords\\essay.txt"));
        ArrayList<String[]> inital = new ArrayList<String[]>();
        int wordCount = 0;
        while((line = essayReader.readLine()) != null) {
            String[] breaker = line.split(" ");
            wordCount += breaker.length;
            inital.add(breaker);
        }
        String[] totalEssay = new String[wordCount]; 
        
        for (int i = 0; i < inital.size(); i++) {
            String[] s = inital.get(i);
            for (int j = 0; j < s.length; j++) {
                boolean change = false;
                for (int k = 0; k < size; k++) {
                    if (s[j].equals(words[k])) {
                        System.out.print(s[j] + "*" + " ");
                        change = true;
                        break;
                    }
                    else if (s[j].substring(0, s[j].length()-1).equals(words[k])) {
                        System.out.print(s[j].substring(0, s[j].length()-1) + "*" + s[j].substring(s[j].length()-1) + " ");
                        change = true;
                        break;
                    }
                }
                
                if (change == false) {
                    System.out.print(s[j] + " ");
                }
            }
            System.out.println("\n");
        }
        System.out.println("end");
    }
    
}
