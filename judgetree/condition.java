package judgetree;

//条件类
public class condition {
	   public condition() {
		   super();
	   }
	
	  //训练集
       public int [][]attribute= {
    		   {1,1,1,1},
    		   {1,1,1,2},
    		   {1,1,2,1},
    		   {1,1,2,2},
    		   {1,2,1,1},
    		   {1,2,1,2},
    		   {1,2,2,1},
    		   {1,2,2,2},
    		   {2,1,1,1},
    		   {2,1,1,2},
    		   {2,1,2,1},
    		   {2,1,2,2},
    		   {2,2,1,1},
    		   {2,2,1,2},
    		   {2,2,2,1},
    		   {2,2,2,2},
    		   {3,1,1,1},
    		   {3,1,1,2},
    		   {3,1,2,1},
    		   {3,1,2,2},
    		   {3,2,1,1},
    		   {3,2,1,2},
    		   {3,2,2,1},
    		   {3,2,2,2}
       };
       
       //决策集
       public int []decision= {
    		   3,2,3,1,3,2,3,1,3,2,3,1,3,2,3,3,3,3,3,1,3,2,3,3,
       };
}
