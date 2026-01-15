package fms;

import java.util.Scanner;

import fms.filesystem.FileSystem;

public class Main {
    
    public static void main(String[] args){

        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("File System started. Type command.");

        while(true){
            System.out.print("> ");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("exit")){
                System.out.println("Exiting file system.");
                break;
            }

            System.out.println("Command received: " + input);
        }
        
        scanner.close();
    }

}
