
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class CodonCount {
    private HashMap<String, Integer> map;
    
    //private CodonCount() {
    //    map = new HashMap<String, Integer>();
    //}
    
    public void buildCodonMap(int start, String dna) {
        //start should be an value of 0, 1,or2.
        map = new HashMap<String, Integer>();
        map.clear();
        //Returns a copy of the string, with leading and trailing whitespace omitted.
        dna = dna.trim();
        //String codon = null;
        for(int k= start; k <= dna.length()-3; k += 3) {
            String codon = dna.substring(k, k+3); 
            if(!map.containsKey(codon)) {
                map.put(codon,1);
            } else {
                map.put(codon,map.get(codon)+1);
            }
        }
    }
    
    public String getMostCommonCodon() {
        int max = 0;
        String codonMost = "";
        for(String s : map.keySet()) {
            if(map.containsKey(s)) {
                int v = map.get(s);
                if(v > max) {
                max = v;
                codonMost = s;
                }
            }
        }
        return codonMost;
    }
    
    public void printCodonCounts(int start, int end) {
        System.out.println("start is " + start + "\t" + "end is " + end);
        for(String s : map.keySet()) {
            int v = map.get(s);
            if(v >= start && v <= end) {
                System.out.println(s + "\t" + v);
            }
        }
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.toUpperCase();
        //String dna = "CGTTCAAGTTCAA";
        //
        buildCodonMap(0, dna);
        String codonMost = getMostCommonCodon();
        int indexMost = map.get(codonMost);
        System.out.println("most common codon is " + codonMost + "\t" + indexMost);
        printCodonCounts(1, 5);
        //
        buildCodonMap(1, dna);
        codonMost = getMostCommonCodon();
        indexMost = map.get(codonMost);
        System.out.println("most common codon is " + codonMost + "\t" + indexMost);
        printCodonCounts(1, 5);
        //
        buildCodonMap(2, dna);
        codonMost = getMostCommonCodon();
        indexMost = map.get(codonMost);
        System.out.println("most common codon is " + codonMost + "\t" + indexMost);
        printCodonCounts(1, 5);
    }
}
