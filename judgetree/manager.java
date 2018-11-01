package judgetree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class manager {
	
	   public manager() {
		   super();
	   }
	
	   
       public void run() {
    	   //0-23的序号集
    	   ArrayList<Integer>S=new  ArrayList<Integer>();
    	   for(int q=0;q<24;q++) {
    		   S.add(q);
    	   }
    	   
    	   //建树
    	   node s=new node();
    	   s.data="S";
    	   s.isleaf=false;
    	   s.divgroup=null;
    	 
    	   tree judgetree=new tree(s);
    	   
    	   new tree().bulitTree(judgetree,S);
    	   
    	   new tree().printTree(judgetree,0);
       }

}
