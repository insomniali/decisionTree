package judgetree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tree {
	   public node Node;
	   public List<tree>childs;
	   
	   
	   public tree() {
		   super();
		  
	   }
	   
	   public tree(node NODE) {
		   super();
		   Node=NODE;
		   childs=new ArrayList<tree>();

	   }
	
       public void bulitTree(tree Tree,ArrayList<Integer> S) {
    	   
           if(Tree.Node.isleaf==false) {
    	   condition cdt=new condition();
    	   
    	   //保存计算的决策概率
    	   ArrayList<Float>temp5=new ArrayList<Float>();
    	   //保存划分的序号子集
    	   ArrayList<ArrayList>temp6=new ArrayList<ArrayList>();
    	   
    	   
    	       for(int i=0;i<4;i++) {
    		   ArrayList<ArrayList> temp=new ArrayList<ArrayList>();
    		   //保存一次划分的序号子集
        	   temp=new cal().divide(i,S);
        	   temp6.add(temp);
        	   
        	   /*System.out.println(i);
        	   for(List o:temp) {
        		   for(int n=0;n<o.size();n++) {
        			   System.out.print(o.get(n)+",     "); 
        		   }
        		   System.out.println();
        	   }*/
        	   
        	   //保存所以的部分熵
        	   ArrayList<Float>temp4=new ArrayList<Float>();
        	   for(int k=0;k<temp.size();k++) {
        		   ArrayList<Float>temp2=new ArrayList<Float>();
        		   //保存一次的决策概率
        		   temp2=new cal().probability(temp.get(k));
        		   //System.out.println(temp2);
        		   float temp3=0;
        		   //保存一次的部分熵
            	   temp3=new cal().partEntropy(temp2);
            	  //System.out.println(temp3);
            	   temp4.add(temp3);
        	   }
        	  
        	  /* for(float m:temp4) {
    		   System.out.println(m);
    	       }*/
        	   
        	   //计算条件熵
        	   float H=new cal().cdtEntropy(temp4, temp);
        	   
        	   temp5.add(H);
        	  // System.out.println(H);
    	   
    	       }
    	       
    	    //获得使熵下降最快的属性列号
    	   int temp7=temp5.indexOf(Collections.min(temp5));
    	  // System.out.println(temp6.get(temp7));
    	  
    	   //temp9用来保存每次属性列的值，temp10是对应的决策集的值
    	   int temp9 = 0,temp10 = 0;
    	   String data="";
    	   for(int m=0;m<temp6.get(temp7).size();m++) {
    		   
    		   //System.out.println(temp6.get(temp7).get(m));
    		   
    		   //temp8是用来获得使熵下降最快的属性列
    		   ArrayList<Integer> temp8=(ArrayList<Integer>) temp6.get(temp7).get(m);
    		   
    		   //判断是否能决定一个决策，能则为叶子结点，不能则为非叶子结点
    		   if(temp8.isEmpty()!=true) {
    			    temp9=cdt.attribute[temp8.get(0)][temp7];
    			    temp10=cdt.decision[temp8.get(0)];
    		   }
    		   
    		   int flag=0;
    		   
    		   for(int l:temp8) {
    			   if(temp10!=cdt.decision[l]) {
    					   flag=1;
    					   break;
    			   }
    		   }
    		   
    		   node child=new node();
    		   if(temp8.isEmpty()!=true) {
    		   if(flag==0) {
    			   data="("+new Integer(temp7).toString()+","+new Integer(temp9).toString()+";"+new Integer(temp10).toString()+")";
    		       child.data=data;
    		       child.divgroup=temp8;
    		       Tree.add(new tree(child));
    		   }
    		   else {
    			   data="("+new Integer(temp7).toString()+","+new Integer(temp9).toString()+")";
    			   child.data=data;
    			   child.isleaf=false;
    			   child.divgroup=temp8;
    			   Tree.add(new tree(child));
    		   }
    		   
    		  
    		   //System.out.println(data);
    		   }
    		   flag=0;  
    	   }
    	  
    	  /* System.out.println("parent:"+Tree.Node.data+"     "+Tree.Node.isleaf+"     "+Tree.Node.divgroup);
    	   System.out.println();*/
    	   for(tree t:Tree.childs) {
    		  
    		  // System.out.println("child"+t.Node.data+"     "+t.Node.isleaf+"     "+t.Node.divgroup);
    		   if(t.Node.isleaf==false) { 
    			   
    			  /* System.out.println();
        		   System.out.println();
        		   System.out.println();*/
    			   new tree().bulitTree(t,t.Node.divgroup);
    		   }
    	   }
    	   
    	   
    	   
    	   
           }
           else return;
       }
       
       public void add(tree Tree) {
    	   childs.add(Tree);
       }
       
       public void printTree(tree Tree,int count) {
    	   
    	   //凹入法打印树
    	   if(Tree.Node.isleaf==false) {
    		   //先对第一个结点操作
    		   printTree(Tree.childs.get(0),count+1);
    		   
    		   for(int i=0;i<count;i++)System.out.print("         ");
    		   
    		   //操作父节点
    		   System.out.println(Tree.Node.data);
    		   
    		   //操作其余结点
    		   for(int j=1;j<Tree.childs.size();j++) {
    			   printTree(Tree.childs.get(j),count+1);
    		   }
    	   }
    	   else {
    		   for(int i=0;i<count;i++)System.out.print("         ");
    		  
    		   System.out.println(Tree.Node.data);
    	   }
       }

}
