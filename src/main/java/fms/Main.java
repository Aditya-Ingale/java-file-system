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

            try {
                String[] parts = input.split(" ");

                switch(parts[0]){

                    case "create":
                        fs.createFile(parts[1], new fms.permission.Permission(true, true, false));
                        System.out.println("File created.");
                        break;

                    case "write":
                        byte[] data = parts[3].getBytes();
                        fs.writeFile(parts[1], data, fms.filesystem.WriteMode.valueOf(parts[2].toUpperCase()));
                        System.out.println("Write Successful.");

                    case "read":
                        byte[] content = fs.readFile(parts[1]);
                        System.out.println(new String(content));
                        break;

                    case "delete":
                        fs.deleteFile(parts[1]);
                        System.out.println("File deleted.");
                        break;

                    case "chmod":
                        boolean r = parts[2].contains("r");
                        boolean w = parts[2].contains("w");
                        boolean x = parts[2].contains("x");
                        fs.changePermission(parts[1], new fms.permission.Permission(r, w, x));
                        System.out.println("Permission changed.");
                        break;

                    default:
                        System.out.println("Unknown command.");
                }
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
