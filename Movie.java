import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class Movie {
		static int t1 = 20, t2 = 20,  t3 = 20,  t4 = 20,  t5 = 20;

		public static synchronized int Lock(int x, int t,int user){
			SimpleDateFormat format = new SimpleDateFormat("YYYY MM dd HH:mm:ss");
            if (t == 1) {
                if(t1 >= x) {
                    t1 -= x;
                    System.out.println(format.format(new Date()) +" : " +"User_"+ user +" Lock Movie : " + 1 + "   ||Seat : "+ x + "  ||Movie"+ 1+ " Remain : "+ t1 );
                    return 1;
                } else {
                    return 0;
                }
			} else if (t == 2) {
                if(t2 >= x) {
                    t2 -= x;
                    System.out.println(format.format(new Date()) +" : " +"User_"+ user +" Lock Movie : " + 2 + "   ||Seat : "+ x + "  ||Movie"+ 2+ " Remain : "+ t2 );
                    return 1;
                } else {
                    return 0;
                }
			} else if  (t == 3) {
                if(t3 >= x) {
                    t3 -= x;
                    System.out.println(format.format(new Date()) +" : " +"User_"+ user +" Lock Movie : " + 3 + "   ||Seat : "+ x + "  ||Movie"+ 3+ " Remain : "+ t3 );
                    return 1;
                } else {
                    return 0;
                }
			} else if (t == 4) {
                if(t4 >= x) {
                    t4 -= x;
                    System.out.println(format.format(new Date()) +" : " +"User_"+ user +" Lock Movie : " + 4 + "   ||Seat : "+ x + "  ||Movie"+ 4+ " Remain : "+ t4 );
                    return 1;
                } else {
                    return 0;
                }
			} else if (t == 5) {
                if(t5 >= x) {
                    t5 -= x;
                    System.out.println(format.format(new Date()) +" : " +"User_"+ user +" Lock Movie : " + 5 + "   ||Seat : "+ x + "  ||Movie"+ 5+ " Remain : "+ t5 );
                    return 1;
                } else {
                    return 0;
                }
			}
            return 0;
		}
		public static synchronized void UnLock(int x, int t){
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
		
		public static synchronized void Decision(int user, int decision, SimpleDateFormat format, int selected_ticket, int selected_movie, Movie m) {
			 if (decision == 0) {
                 m.UnLock(selected_ticket, selected_movie);
                 System.out.println(format.format(new Date()) +" : "+ "User_"+ user +" Cancel Movie : " +  selected_movie + " ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+" Remain : "+ m.Get_remain(selected_ticket, selected_movie));
             } else {
                 System.out.println(format.format(new Date()) +" : "+ "User_"+ user +" Buy Movie : "+ selected_movie +"    ||Seat : "+ selected_ticket + "  ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
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
                        int first_dicision = 0;
                        try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}
                        int selected_movie = rn.nextInt(5 -1 +1) + 1;
                        int selected_ticket = rn.nextInt(5 -1 +1) + 1;
                        int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
                        int decision = rn.nextInt(1 - 0 + 1) + 0;
                        int q = m.Lock(selected_ticket, selected_movie,1);
                        if(q == 1) {
                            try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);}
                            Decision(1, decision, format, selected_ticket, selected_movie, m);
                        }else {
                            System.out.println(format.format(new Date()) +" : "+"User_1 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
                        }
                    }
                }
			};
			Thread t2 = new Thread(){
                public void run(){
                    for(;;){
                        int first_dicision = 0;
                        try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}
                        int selected_movie = rn.nextInt(5 -1 +1) + 1;
                        int selected_ticket = rn.nextInt(5 -1 +1) + 1;
                        int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
                        int decision = rn.nextInt(1 - 0 + 1) + 0;
                        int q = m.Lock(selected_ticket, selected_movie,2);
                        if(q == 1) {
                            try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);}
                            Decision(2, decision, format, selected_ticket, selected_movie, m);
                        }else {
                            System.out.println(format.format(new Date()) +" : "+"User_2 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
                        }
                    }
                }
            };

			Thread t3 = new Thread(){
                public void run(){
                    for(;;){
                        int first_dicision = 0;
						try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}
						int selected_movie = rn.nextInt(5 -1 +1) + 1;
						int selected_ticket = rn.nextInt(5 -1 +1) + 1;
						int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
						int decision = rn.nextInt(1 - 0 + 1) + 0;
						int q = m.Lock(selected_ticket, selected_movie,3);
                        if(q == 1) {
                            try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);}
                            Decision(3, decision, format, selected_ticket, selected_movie, m);
                        }else {
							System.out.println(format.format(new Date()) +" : "+"User_3 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
                        }
                    }
                }
			};

			Thread t4 = new Thread(){
                public void run(){
					for(;;){
                        int first_dicision = 0;
						try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}
						int selected_movie = rn.nextInt(5 -1 +1) + 1;
						int selected_ticket = rn.nextInt(5 -1 +1) + 1;
						int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
						int decision = rn.nextInt(1 - 0 + 1) + 0;
				        int q = m.Lock(selected_ticket, selected_movie,4);
                        if(q == 1) {
                            try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);}
                            Decision(4, decision, format, selected_ticket, selected_movie, m);
                        }else {
                            System.out.println(format.format(new Date()) +" : "+"User_4 Can't Lock Movie : "+ selected_movie+ "         ||Movie"+ selected_movie+ " Remain : "+ m.Get_remain(selected_ticket, selected_movie));
                        }
                    }
                }
			};

			Thread t5 = new Thread(){
                public void run(){
                    for(;;){
                        int first_dicision = 0;
                        try{Thread.sleep(first_dicision);}catch(InterruptedException e){System.out.println(e);}
                        int selected_movie = rn.nextInt(5 -1 +1) + 1;
                        int selected_ticket = rn.nextInt(5 -1 +1) + 1;
                        int selected_time = rn.nextInt(Max_time_decision -  Min_time_decision + 1) + Min_time_decision;
                        int decision = rn.nextInt(1 - 0 + 1) + 0;
                        int q = m.Lock(selected_ticket, selected_movie,5);
                        if(q == 1) {
                            try{Thread.sleep(selected_time);}catch(InterruptedException e){System.out.println(e);}
                            Decision(5, decision, format, selected_ticket, selected_movie, m);
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
