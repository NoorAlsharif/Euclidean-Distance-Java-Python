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
import java.util.ArrayList;

public class Buckets {
	ArrayList<Trace>  traces = new ArrayList<Trace>();
	public void add(Trace trace) {
		traces.add(trace);
	}
	public String toString() {
		StringBuilder str = new StringBuilder("");
        for(int i=0; i< traces.size(); i++){
            str.append(traces.get(i).m + " " + traces.get(i).n + "\n");
        }
		return str.toString();
	}
}