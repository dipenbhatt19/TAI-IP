/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adressbook;

/**
 *
 * @author dipen
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

class pInfo{
    String name;
    String address;
    String phoneNumber;
    
    pInfo(String n,String a,String pn){
        name=n;
        address=a;
        phoneNumber=pn;
    }
    void display(){
        JOptionPane.showMessageDialog(null,"Name:"+name+"\nAddress:"+address+"\nPhone Number:"+phoneNumber);
        
    }
}

class AddressBook{
    ArrayList persons;
    
    AddressBook(){
        persons = new ArrayList();
        loadPerson();
    }
    void addPerson(){
        String name = JOptionPane.showInputDialog("Enter Name:");
        String add = JOptionPane.showInputDialog("Enter Address:");
        String pNum = JOptionPane.showInputDialog("Enter Phone number:");
        pInfo p = new pInfo(name,add,pNum);
        persons.add(p);
    }
    void searchPerson(String n){
        for(int i=0;i<persons.size();i++){
            pInfo p = (pInfo)persons.get(i);
            if(n.equals(p.name)){
                p.display();
            }
        }
    }
    void  deletePerson(String n){
        for(int i=0;i<persons.size();i++){
            pInfo p=(pInfo)persons.get(i);
            if(n.equals(p.name)){
                persons.remove(i);
            }
        }
    }
    void savePerson(){
        try{
            pInfo p;
            String line;
            FileWriter fw = new FileWriter("persons.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i =0;i<persons.size();i++){
                p=(pInfo)persons.get(i);
                line=p.name+","+p.address+","+p.phoneNumber;
                pw.println(line);
                pw.flush();
                pw.close();
                fw.close();
                
            }
            
        }catch(IOException ioEx){
            System.out.println(ioEx);
        }
    }
    void loadPerson(){
        String tokens[]=null;
        String name,add,ph;
        try{
            FileReader fr = new FileReader("persons.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null){
                tokens=line.split(",");
                name=tokens[0];
                add=tokens[1];
                ph=tokens[2];
                pInfo p = new pInfo(name,add,ph);
                persons.add(p);
                line=br.readLine();
            }
            br.close();
            fr.close();
        }catch(IOException ioEx){
            System.out.println(ioEx);
        }
    }
}
public class Adressbook {

    public static void main(String[] args) {
        AddressBook ab = new AddressBook(); 
        String input,s;
        int ch;
        
        while(true){
           input=JOptionPane.showInputDialog(" Enter 1 to Add\n Enter 2 to Search\n Enter 3 to delete\n Enter 4 to Exit"); 
           ch=Integer.parseInt(input);
           
           switch(ch){
               case 1:
                   ab.addPerson();
                   break;
               case 2:
                   s=JOptionPane.showInputDialog("Enter name to search:");
                   ab.searchPerson(s);
                   break;
               case 3:
                   s=JOptionPane.showInputDialog("Enter name to delete:");
                   ab.deletePerson(s);
                   break;
               case 4:
                   ab.savePerson();
                   System.exit(0);
           }
        }
        
    }
}
