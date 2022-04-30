/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg00000;

/**
 *
 * @author nooralsharif
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Enter Input file name: ");
        Scanner scanner = new Scanner(System.in);
        String traceFile = scanner.nextLine();
        File file = new File(traceFile);
        Scanner scnr = new Scanner(file);
        ArrayList<String> traces = new ArrayList<String>();
        int k = 0, in = 0;
        Trace aTrace;
        while (scnr.hasNextLine()) {
            aTrace = new Trace();
            String line = scnr.nextLine();
            traces.add(line);
            //System.out.print("m n " +  split[2] + " " + split[3] + ", ");
        }

        scnr.close();

        int number_of_buckets = traces.size() / 32;
        System.out.println("number_of_buckets " + number_of_buckets);
        ArrayList<String> bucket = new ArrayList<String>();//Buckets[number_of_buckets];
        System.out.println("Enter Buckets file name: ");
        scanner = new Scanner(System.in);
        String inFile = scanner.nextLine();
        file = new File(inFile);
        scnr = new Scanner(file);
        k = 0;
        while (scnr.hasNextLine()) {
            //bucket[k] = new Buckets();
            String line = scnr.nextLine();
            String[] ids = line.split(", ");
            for (int i = 0; i < ids.length; i++) {
                //System.out.println(ids[i]);
                ids[i] = ids[i].replace("[", "");
                ids[i] = ids[i].replace("]", "");
                int id = Integer.parseInt(ids[i]);
                bucket.add(traces.get(id));
            }
            k++;
        }
        scnr.close();
        try {
            String f1 = "ArrangedInput1024.txt";
            System.out.println(f1);
            BufferedWriter writer = new BufferedWriter(new FileWriter(f1));
            for (int j = 0; j < bucket.size(); j++) {
                String output = bucket.get(j);//.toString();
                writer.write(output + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /*************** PYTHON CODE ***************************************
    def euclidean_dist(point1,point2):
    #print("from dist")
    dist =0
    x = point1.split()
    y = point2.split()
    for i in range(len(x)):
    x1 = int(x[i])
    y1 = int(y[i])
    dist = dist + (x1-y1)*(x1-y1)
    dist = math.sqrt(dist)
    return dist
    ****************END OF PYTHON CODE **********************************/

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

