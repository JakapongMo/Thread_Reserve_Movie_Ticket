import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
public class Movie {
		static int t1 = 20, t2 = 20,  t3 = 20,  t4 = 20,  t5 = 20;
	
		public static void Lock(int x, int t){
			if (t == 1) {
				t1 -= x;
			} else if (t == 2) {
				t2 -= x;
			} else if  (t == 3) {
				t3 -= x;
			} else if (t == 4) {
				t4 -= x;
			} else if (t == 5) {
				t5 -= x;
			}
		}
		public static void UnLock(int x, int t){
			if (t == 1) {
				t1 += x;
			} else if (t == 2) {
				t2 += x;
			} else if  (t == 3) {
				t3 += x;
			} else if (t == 4) {
				t4 += x;
			} else if (t == 5) {
				t5 += x;
			}
			
		}
		public static int Get_remain(int x, int t){
			if (t == 1) {
				return t1;
			} else if (t == 2) {
				return t2;
			} else if  (t == 3) {
				return t3;
			} else if (t == 4) {
				return t4;
			} else {
				return t5;
			}
		}
		
		public static void main(String[] args){
			SimpleDateFormat format = new SimpleDateFormat("YYYY MM dd HH:mm:ss");
	        //System.out.println("2. " + format.format(new Date()));
			Movie m = new Movie();
			Random rn = new Random();
			
			//Tuning time decision here (milisec)
			int Max_time_decision = 1000;
			int Min_time_decision = 1000;
			
			Thread t1 = new Thread(){
				 public void run(){
					 for(;;){  
						 int first_dicision = rn.nextInt(1000 - 500 + 1) + 500;
						 try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}  
						 int selected_movie = rn.nextInt(5 -1 +1) + 1;
						 int selected_ticket = rn.nextInt(5 -1 +1) + 1;
						 int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
						 int decision = rn.nextInt(1 - 0 + 1) + 0;
                         if (selected_ticket <= m.Get_remain(selected_ticket, selected_movie)){				
                        	 m.Lock(selected_ticket, selected_movie);
                        	 System.out.println(format.format(new Date()) +" : " +"User_1"+" Lock Movie : " + selected_movie + "   ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie) );
                        	 try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);} 
                        	 if (decision == 0) {
						 		m.UnLock(selected_ticket, selected_movie); 
						 		System.out.println(format.format(new Date()) +" : "+ "User_1 Cancel Movie : " +  selected_movie + " ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+" Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 		 
                        	 } else {
						 		System.out.println(format.format(new Date()) +" : "+ "User_1 Buy Movie : "+ selected_movie +"    ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 	}
						 }else {
							 System.out.println(format.format(new Date()) +" : "+"User_1 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 }
					 }
				 }
			};
			Thread t2 = new Thread(){
				 public void run(){
					 for(;;){  
						 int first_dicision = rn.nextInt(1000 - 500 + 1) + 500;
						 try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}  
						 int selected_movie = rn.nextInt(5 -1 +1) + 1;
						 int selected_ticket = rn.nextInt(5 -1 +1) + 1;
						 int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
						 int decision = rn.nextInt(1 - 0 + 1) + 0;
						 
						 if (selected_ticket <= m.Get_remain(selected_ticket, selected_movie)){				
                        	 m.Lock(selected_ticket, selected_movie);
                        	 System.out.println(format.format(new Date()) +" : " +"User_2"+" Lock Movie : " + selected_movie + "   ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie) );
                        	 try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);} 
                        	 if (decision == 0) {
						 		m.UnLock(selected_ticket, selected_movie); 
						 		System.out.println(format.format(new Date()) +" : "+ "User_2 Cancel Movie : " +  selected_movie + " ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+" Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 		 
                        	 } else {
						 		System.out.println(format.format(new Date()) +" : "+ "User_2 Buy Movie : "+ selected_movie +"    ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 	}
						 }else {
							 System.out.println(format.format(new Date()) +" : "+"User_2 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 }
					 }
				 }
			};
			
			Thread t3 = new Thread(){
				 public void run(){
					 for(;;){  
						 int first_dicision = rn.nextInt(1000 - 500 + 1) + 500;
						 try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}  
						 int selected_movie = rn.nextInt(5 -1 +1) + 1;
						 int selected_ticket = rn.nextInt(5 -1 +1) + 1;
						 int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
						 int decision = rn.nextInt(1 - 0 + 1) + 0;
						 
						 if (selected_ticket <= m.Get_remain(selected_ticket, selected_movie)){				
                        	 m.Lock(selected_ticket, selected_movie);
                        	 System.out.println(format.format(new Date()) +" : " +"User_3"+" Lock Movie : " + selected_movie + "   ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie) );
                        	 try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);} 
                        	 if (decision == 0) {
						 		m.UnLock(selected_ticket, selected_movie); 
						 		System.out.println(format.format(new Date()) +" : "+ "User_3 Cancel Movie : " +  selected_movie + " ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+" Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 		 
                        	 } else {
						 		System.out.println(format.format(new Date()) +" : "+ "User_3 Buy Movie : "+ selected_movie +"    ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 	}
						 }else {
							 System.out.println(format.format(new Date()) +" : "+"User_3 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 }
					 }
				 }
			};
			
			Thread t4 = new Thread(){
				 public void run(){
					 for(;;){  
						 int first_dicision = rn.nextInt(1000 - 500 + 1) + 500;
						 try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}  
						 int selected_movie = rn.nextInt(5 -1 +1) + 1;
						 int selected_ticket = rn.nextInt(5 -1 +1) + 1;
						 int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
						 int decision = rn.nextInt(1 - 0 + 1) + 0;
						 
						 if (selected_ticket <= m.Get_remain(selected_ticket, selected_movie)){				
                        	 m.Lock(selected_ticket, selected_movie);
                        	 System.out.println(format.format(new Date()) +" : " +"User_4"+" Lock Movie : " + selected_movie + "   ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie) );
                        	 try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);} 
                        	 if (decision == 0) {
						 		m.UnLock(selected_ticket, selected_movie); 
						 		System.out.println(format.format(new Date()) +" : "+ "User_4 Cancel Movie : " +  selected_movie + " ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+" Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 		 
                        	 } else {
						 		System.out.println(format.format(new Date()) +" : "+ "User_4 Buy Movie : "+ selected_movie +"    ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 	}
						 }else {
							 System.out.println(format.format(new Date()) +" : "+"User_4 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 }
					 }
				 }
			};
			
			Thread t5 = new Thread(){
				 public void run(){
					 for(;;){  
						 int first_dicision = rn.nextInt(1000 - 500 + 1) + 500;
						 try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}  
						 int selected_movie = rn.nextInt(5 -1 +1) + 1;
						 int selected_ticket = rn.nextInt(5 -1 +1) + 1;
						 int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
						 int decision = rn.nextInt(1 - 0 + 1) + 0;
						 
						 if (selected_ticket <= m.Get_remain(selected_ticket, selected_movie)){				
                        	 m.Lock(selected_ticket, selected_movie);
                        	 System.out.println(format.format(new Date()) +" : " +"User_5"+" Lock Movie : " + selected_movie + "   ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie) );
                        	 try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);} 
                        	 if (decision == 0) {
						 		m.UnLock(selected_ticket, selected_movie); 
						 		System.out.println(format.format(new Date()) +" : "+ "User_5 Cancel Movie : " +  selected_movie + " ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+" Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 		 
                        	 } else {
						 		System.out.println(format.format(new Date()) +" : "+ "User_5 Buy Movie : "+ selected_movie +"    ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 	}
						 }else {
							 System.out.println(format.format(new Date()) +" : "+"User_5 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
						 }
					 }
				 }
			};
		    t1.start();
		    t2.start();
		    t3.start();
		    t4.start();
		    t5.start();
		}
	
}
