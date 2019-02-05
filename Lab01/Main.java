/**
 * @Author Ian Thomas , Chad Manning
 * Created on : February 4th, 2019
 * Instructor : Dr. Wang
 */
package Lab01;

import java.io.*;
import java.util.*;
import java.awt.Desktop;

public class Main {
    public static void main( String args[] ) {
        boolean exit = false;
        Member[] array = null;
        while (!exit) {
            System.out.print("Enter H/h/? for help, or command: \n");
            Scanner scan = new Scanner(System.in);
            char c = scan.next().charAt(0);
            switch (c) {
                case 'H': //Print the menu
                case 'h':
                case '?':
                    System.out.print(
                            "======================== CS 3990 Assignment 1" +
                            " ===============\n" +
                            "G/g/ : Ask for a N, and generate N members " +
                            "of mixed Member class's objects, and store in a" +
                            " Vector and a array Objects.\n" +
                            "S/s/ : Sort the members in the vector and array " +
                            "in ascending order.\n" +
                            "V/v/ : Show the members in the vector and " +
                            "array.\n" +
                            "O/o/ : Save objects inside vector into a HTML." +
                            " file with objects saved in the format of HTML" +
                            "Table.\n" +
                            "F/f/ : Show HTML file contents on screen.\n" +
                            "L/l/ : Launch the default internet browser to" +
                            " display the generated HTML file.\n" +
                            "----------------------------------------------" +
                            "----\n" +
                            "H/h/?: Display this menu.\n" +
                            "E/e/ : Exit\n" +
                            "===============================================" +
                            "===============\n");
                    break;
                case 'G':
                case 'g':
                    System.out.print("How many objects do you want to generate? ");
                    n = scan.nextInt();
                    array = new Member[n];
                    for (int i = 0; i < n; i++) {
                        int rand = rnd.nextInt(4) + 1;
                        //Generates random n number of random objects
                        switch (rand) {
                            case 1:
                                array[i] = new Member();
                                array[i].generate();
                                break;
                            case 2:
                                array[i] = new Student();
                                array[i].generate();
                                break;
                            case 3:
                                array[i] = new Faculty();
                                array[i].generate();
                                break;
                            case 4:
                                array[i] = new Staff();
                                array[i].generate();
                                break;
                            case 5:
                                array[i] = new Employee();
                                array[i].generate();
                                break;
                            default:
                                System.out.print("Please enter a valid option. \n");
                        }
                    }
                    break;
                case 'S':
                case 's':
                    for (int i = 0; i < n; i++) {       //Uses compare to in Member to sort array
                        for (int j = 0; j < n - 1; j++) { 
                            if (array[j].compareTo(array[j+1]) > 0) {
                                Member temp = array[j];
                                array[j] = array[j+1];
                                array[j+1] = temp;
                            }
                        }
                    }
                    System.out.print("Array sorted \n");
                    break;
                case 'V':
                case 'v':
                    int count = 0;
                    //Prints array onto console
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%s\n", array[i].toString(true));
                        if (count == 39) {
                            System.out.print("(enter)");
                            try {
                                System.in.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            count = -1;
                        }
                        count++;
                    }
                    break;
                case 'O':
                case 'o':
                    //Output string into HTML file called "output.html"
                    try {
                        PrintWriter output = new PrintWriter("output.html");
                        output.write(
                                "<!DOCTYPE html>\n" +
                                "   <html>\n" +
                                "       <head>\n" +
                                "           <Title> Lab 1 </Title>\n" +
                                "       </head>\n" +
                                "       <body>\n" +
                                "           <table cellspacing=\"20\">\n" +
                                "               <tr>\n" +
                                "                   <th>ID</th>\n" +
                                "                   <th>Last Name</th>\n" +
                                "                   <th>First Name</th>\n" +
                                "                   <th>Major&nbsp</th>\n" +
                                "                   <th>GPA&nbsp</th>\n" +
                                "                   <th>Department</th>\n" +
                                "                   <th>Year Hired</th>\n" +
                                "                   <th>Job Title</th>\n" +
                                "                   <th>Degree Held</th>\n" +
                                "               </tr>\n");
                        for (int i = 0; i < n; i++) {
                            output.write(array[i].htmlRow());
                            output.write("\n");
                        }
                        output.write(
                                "           </table>\n" +
                                "       </body>\n" +
                                "   </html>\n");
                        output.close();
                    }
                    catch (IOException e) { }
                    break;
                case 'F':
                case 'f':
                    //Reads output.html onto console
                    try(BufferedReader br = new BufferedReader(new FileReader("output.html"))) {
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();
                        while (line != null) {
                            sb.append(line);
                            sb.append(System.lineSeparator());
                            line = br.readLine();
                        }
                        System.out.printf("%s", sb.toString());
                    }
                    catch (IOException e) { }
                    break;
                case 'L':
                case 'l':
                    if (Desktop.isDesktopSupported()) {
                        try {
                            File file = new File("output.html");
                            Desktop.getDesktop().browse(file.toURI());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 'E':
                case 'e':
                    exit = true;
                    break;
            }
        }
    }
    static Random rnd = new Random();
    static int n;      //number of Member objects
}

