package INNOVATIVE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class setMap {
    protected static HashMap<String, String> users = new HashMap<>();
    protected static HashMap<String, String> mobileEmailUserMap = new HashMap<>();
    protected static HashMap<String, String> mobileEmailMap = new HashMap<>();
    
    setMap(File file) {
        try {
            Scanner sc = new Scanner(file);
            String userString="",passwordString="",mobileString="",emailString="";
            int i=0;
            while (sc.hasNextLine()) {
                if(i%4==0){
                    userString=sc.nextLine();
                }
                else if(i%4==1){
                    passwordString=sc.nextLine();
                }
                else if(i%4==2){
                    mobileString=sc.nextLine();
                }
                else{
                    emailString=sc.nextLine();
                    users.put(userString, passwordString);
                    mobileEmailMap.put(mobileString, emailString);
                    mobileEmailUserMap.put(mobileString+emailString, userString);
                }
                i++;
            }
            sc.close(); 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }


    protected void setTextFile(File file){

        try {
            FileWriter fileWriter = new FileWriter("All_info.txt", false);

            fileWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file: " + e.getMessage());
        }


        textFileAppend txt = new textFileAppend();
        String mob="",emails="",usr="",pss="";
        for (String key : mobileEmailMap.keySet()) {
            mob=key;
            emails=mobileEmailMap.get(key);
            usr=mobileEmailUserMap.get(mob+emails);
            pss=users.get(usr);
            txt.append(usr, file);
            txt.append(pss, file);
            txt.append(mob, file);
            txt.append(emails, file);
        }
    }
}
