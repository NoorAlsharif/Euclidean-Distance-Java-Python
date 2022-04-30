/*
 * Assignment #1
 * 1725009
 * Noor AlGhalib AlSharif
 * CPIT 455
 * HAR
 */
package pkg00000;

/*
 * @author nooralsharif
 */


//i refactored the imports
//made them general 
//to clean some space
//not make it look cluttered.
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class refactor {

    static int consNum = 32;

    public static void main(String[] args) throws FileNotFoundException {

        //---------------------------FIRST PART (TRACING)----------------------------------
        //the developer made it clear what type of file to enter.
        System.out.println("Enter Input file name: ");
        Scanner input = new Scanner(System.in);

        //good naming.
        //it is clear as to what type of action it will perform.
        //pointer created to traverse the input file.
        String traceFile = input.nextLine();

        //developer has created a new file
        //to store in the traced information gathered from the user's input file.
        File file = new File(traceFile);
        //scanner to scan the new file
        Scanner scnr = new Scanner(file);

        //array list of type string called traces to store in the traced lines.
        ArrayList<String> traces = new ArrayList<>();

        int k = 0;
        //looping the new file as long as it is not empty.
        while (scnr.hasNextLine()) {

            //1) go no the next line
            String line = scnr.nextLine();

            //2) add each line in the arraylist traces
            traces.add(line);
        }
        //closing the scanner to allow for following scanners to work. 
        scnr.close();

        //---------------------------SECOND PART (BUCKETS)---------------------------------
        //developer started with creating an integer number_of_buckets 
        //that is the traces arraylist's size divided by the constant number 32 aka consNum.
        int number_of_buckets = traces.size() / consNum;

        //the console will show the number of buckets.
        System.out.println("number_of_buckets " + number_of_buckets);

        //an arraylist called bucket of type string will be created.
        ArrayList<String> bucket = new ArrayList<>();//Buckets[number_of_buckets];

        //the user will be asked to enter the file where the buckets are stored.
        //a good indication of what file the developer wants the user to enter.
        System.out.println("Enter Buckets file name: ");
        input = new Scanner(System.in);

        //inFile is created as a pointer to traverse the buckets file.
        String inFile = input.nextLine();

        //a new file is created.
        file = new File(inFile);
        scnr = new Scanner(file);

        k = 0;
        //loop while file is not empty.
        while (scnr.hasNextLine()) {

            //go to next line
            String line = scnr.nextLine();

            //string array of ids will store each line 
            //that is split at the comma (,).
            String[] ids = line.split(", ");

            //then the developer makes a for loop
            //it goes through the ids array and:
            for (int i = 0; i < ids.length; i++) {

                //removes both brackets sourounding each element of the array.
                ids[i] = ids[i].replace("[", "").replace("]", "");

                //then turns the string into integer using parseInt.
                //thus creating a new int variable called id.
                int id = Integer.parseInt(ids[i]);

                //lastly it will add the id to the bucket arraylist that was made earlier.
                bucket.add(traces.get(id));
            }

            k++;
        }
        //close the scanner to allow future scanner  to work.
        scnr.close();

        //------------------------THIRD PART (WRITE IN ARRANGED FILE)----------------------
        //surround statements with try and catch.
        try {
            //create a new file named "Arranged Input 1024".
            String arrangedFile = "ArrangedInput1024.txt";

            //display file name in console.
            System.out.println(arrangedFile);

            //initiate bufferwriter to write inside the file created.
            BufferedWriter writer = new BufferedWriter(new FileWriter(arrangedFile));

            //for loop the bucket arraylist.
            for (int j = 0; j < bucket.size(); j++) {

                //get the output which is each item in the arraylist.
                String output = bucket.get(j);

                //write the output in the file.
                writer.write(output + "\n");
            }
            //close the writer.
            writer.close();

        } catch (IOException e) {
            System.out.println("IOException");
        }

    }

    //---------------------------PYTHON CODE REENGINEERED-------------------------------
    public static double euclidean_dist(String point1, String point2) {

        double dist = 0;

        String[] x = point1.split(" ");
        String[] y = point2.split(" ");

        for (int i = 0; i < x.length; i++) {

            int x1 = Integer.parseInt(x[i]);
            int y1 = Integer.parseInt(y[i]);

            dist = dist + (x1 - y1) * (x1 - y1);

            dist = Math.sqrt(dist);

        }

        return dist;
    }
}
