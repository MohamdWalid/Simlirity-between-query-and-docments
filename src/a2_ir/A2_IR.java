package a2_ir;

import java.util.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class A2_IR {

    // Fn to split sentence to words
    public static String[] wordList(String line){
        return line.split(" ");
    }
    // Fn to get Union from 2 Array
    public static Object[] Union (String[] Q,String[] doc){
        
        List list = new ArrayList(Arrays.asList(Q));
        list.addAll(Arrays.asList(doc));
        Object[] str3 = list.toArray();         //converting list to array  
        //System.out.println(Arrays.toString(str3));
     //   return str3;
        return str3;
    } 
     // Fn to get jaccard_coefficient 
    public static double jaccard_coefficient (Set intersec,Set union){
      double a =intersec.size();
      double b =union.size();
      double J_C=a/b;
      return J_C;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //the Query and Documents
        String Query = "idea of March";
	String Doc1= "Ceaser died in March";
	String Doc2 = "the long March";
        
        // Lower Case for Query and Documents
        Query=Query.toLowerCase();
        Doc1=Doc1.toLowerCase();
        Doc2=Doc2.toLowerCase();
        
        // split the Query and Documents to Array Words
        String[] Q_word = wordList(Query);
        String[] Doc1_word = wordList(Doc1);
        String[] Doc2_word = wordList(Doc2);
        
        // convert the Union  from Array[] to set
        Set<String> Q_w=new HashSet<>(Arrays.asList(Q_word));
        Set<String> DOc1=new HashSet<>(Arrays.asList(Doc1_word));
        Set<String> DOc2=new HashSet<>(Arrays.asList(Doc2_word));
        
        // intersection btw Query and Documents
        Set<String> inter_Q_D1 = new HashSet(Q_w);
        inter_Q_D1.retainAll(DOc1);
        
        Set<String> inter_Q_D2 = new HashSet(Q_w);
        inter_Q_D2.retainAll(DOc2);
        
        // get  the Union of Query and Documents    
        Object[] Q_D1= Union(Q_word,Doc1_word);
        Object[] Q_D2= Union(Q_word,Doc2_word);

       //convert the Union  from Object[] to list
        List Q_DOC1 = Arrays.asList(Q_D1);
        List Q_DOC2 = Arrays.asList(Q_D2);
       
       //convert the Union  from list to set
        Set<String> UNION_Q_DOc1=new HashSet<String>(Q_DOC1);
        Set<String> UNION_Q_DOc2=new HashSet<String>(Q_DOC2);
         
        // get jaccard_coefficient for 
        double j_coe_Q_D1 =jaccard_coefficient(inter_Q_D1,UNION_Q_DOc1);
        double j_coe_Q_D2 =jaccard_coefficient(inter_Q_D2,UNION_Q_DOc2);
        System.out.println("J(q,Doc1) =" +j_coe_Q_D1);
        System.out.println("J(q,Doc1) =" +j_coe_Q_D2);
        
        // Get The Winner
        if(j_coe_Q_D1 > j_coe_Q_D2)
        {
              System.out.println("THE J(q,Doc1) =" +j_coe_Q_D1 + " is Win") ;   
        }
        else if(j_coe_Q_D1 < j_coe_Q_D2)
        {
              System.out.println("THE J(q,Doc2) =" +j_coe_Q_D2 + " is Win") ;   
        }
    }
}