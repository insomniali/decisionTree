package judgetree;

import java.util.ArrayList;
import java.util.List;

public class cal {
	   
	   //划分子集
       public ArrayList<ArrayList> divide(int x, ArrayList<Integer> temp) {
    	   //System.out.println(temp);
    	   ArrayList<ArrayList>result=new ArrayList<ArrayList>();
    	   ArrayList<Integer>s1=new ArrayList<Integer>();
    	   ArrayList<Integer>s2=new ArrayList<Integer>();
    	   ArrayList<Integer>s3=new ArrayList<Integer>();
    	   condition cdt=new condition();
    	   for(int i=0;i<temp.size();i++) {
    		   if(cdt.attribute[temp.get(i)][x]==1) {
    			   s1.add(temp.get(i));
    		   }
    		   else if(cdt.attribute[temp.get(i)][x]==2) {
    			   s2.add(temp.get(i));
    		   }
    		   else {
    			   s3.add(temp.get(i));
    		   }
    	   }
    	   result.add(s1);
    	   result.add(s2);
    	   result.add(s3);
    	   return result;
       }

       //计算决策概率
       public ArrayList<Float> probability(List array) {
    	   ArrayList<Float>temp=new ArrayList<Float>();
    	   float u1=0,u2=0,u3=0;
    	   condition cdt=new condition();
    	   for(int i=0;i<array.size();i++) {
    		   if(cdt.decision[(int) array.get(i)]==1) {
    			   u1++;
    		   }
    		   else if(cdt.decision[(int) array.get(i)]==2) {
    			   u2++;
    		   }
    		   else {
    			   u3++;
    		   }
    	   }
    	   if(u1==0) {
    		   temp.add(0.0f);
    	   }
    	   else {
    		   temp.add(u1/array.size());
    	   }
    	   if(u2==0) {
    		   temp.add(0.0f);
    	   }
    	   else {
    		   temp.add(u2/array.size());
    	   }
    	   if(u3==0) {
    		   temp.add(0.0f);
    	   }
    	   else {
    		   temp.add(u3/array.size());
    	   }
    	   return temp;
       }
       
       //计算部分熵
       public float partEntropy( ArrayList<Float> temp) {
    	   float H=0;
    	   for(int i=0;i<temp.size();i++) {
    		   if(temp.get(i)!=0)H-=temp.get(i)*(Math.log(temp.get(i))/Math.log(2));
    		   else H-=0;
    	   }
    	   return H;
       }
  
       //计算条件熵
       public float cdtEntropy(ArrayList<Float> temp,ArrayList<ArrayList> temp2) {
    	   float H=0;
    	   int size=temp2.get(0).size()+temp2.get(1).size()+temp2.get(2).size();
    	   H=((float)temp2.get(0).size()/size)*temp.get(0)+((float)temp2.get(1).size()/size)*temp.get(1)+((float)temp2.get(2).size()/size)*temp.get(2);
		   return H;
       }

} 
