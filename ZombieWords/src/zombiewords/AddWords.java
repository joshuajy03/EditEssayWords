/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewords;

import java.io.*;
import java.util.*;

/**
 *
 * @author chengyang
 */

public class AddWords {
    public static void main(String[] args) throws IOException{
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
        BufferedReader system = new BufferedReader(new InputStreamReader(System.in));
        boolean close = false;
        FileWriter writer = new FileWriter(new File("C:\\Users\\chengyang\\Documents\\NetBeansProjects\\ZombieWords\\src\\zombiewords\\words.txt"));
        for (int i = 0; i < size; i++) {
            writer.write(words[i] + "\n");
        }
        ArrayList<String> newone = new ArrayList<String>();
        while (true) {
            System.out.println("Add word:");
            String word = system.readLine();
            if (word.equals("q")) {
                writer.close();
                break;
            }
            for (int k = 0; k < size; k++) {
                    if (word.equals(words[k])) {
                        newone.add(word);
                        System.out.print("Already In");
                        break;
                    }
                    else if (newone.contains(word)) {
                        System.out.print("Already In");
                        break;
                    }
            }
            System.out.println("Added");
            writer.write(word+ "\n");
        }
    }
}
