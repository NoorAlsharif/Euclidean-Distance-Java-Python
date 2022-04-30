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
public class euclidean_dist {
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
