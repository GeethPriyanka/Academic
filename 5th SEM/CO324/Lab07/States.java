/*
E/14/403		KPGP WIMALASIRI			CO324	LAB07
*/


/*
Q1
*/

import java.util.*;


class States{

	private static final int OFF = 0;
	private static final int MEDIUM = 1;
	private static final int HIGH = 2;
		

	public static void main(String[] args) {
		
		int state = -1;
		int onDuty = 1;
		String str = null;
		System.out.println("Enter START to start the state machine\nEnter EXIT to exit");
		
		while(true){
			Scanner sc1 = new Scanner(System.in);
			str = sc1.nextLine();
			if(str.equals("EXIT")){
				onDuty = 0;
				break;
			}else if(str.equals("START")){
				onDuty = 1;
				break;
			}else{
				System.out.println("Enter START to start the state machine\nEnter EXIT to exit");
			}
		}
		if(onDuty==1){
			System.out.println("State machine started..!");
			System.out.println("Enter INC to increase the state\nEnter DEC to decrease the state\nEnter EXIT to exit\n");
			System.out.println("Current State : OFF");
			state =  OFF;
		}

		while(onDuty==1){
			Scanner sc2 = new Scanner(System.in);
			
			str = sc2.nextLine();
			
			if(str.equals("DEC") && state==OFF){
				System.out.println("Current State : OFF");
				state =  OFF;
			}else if(str.equals("INC") && state==OFF){
				System.out.println("Current State : MEDIUM");
				state =  MEDIUM;
			}else if(str.equals("DEC") && state==MEDIUM){
				System.out.println("Current State : OFF");
				state =  OFF;
			}else if(str.equals("INC") && state==MEDIUM){
				System.out.println("Current State : HIGH");
				state =  HIGH;
			}else if(str.equals("DEC") && state==HIGH){
				System.out.println("Current State : MEDIUM");
				state =  MEDIUM;
			}else if(str.equals("INC") && state==HIGH){
				System.out.println("Current State : HIGH");
				state =  HIGH;
			}else if(str.equals("EXIT")){
				onDuty = 0;
			}else{
				System.out.println("Wrong input..!\nEnter INC to increase the state\nEnter DEC to decrease the state\nEnter EXIT to exit\n");
			}

		}
	
	}

}

/*
Q2	It depends. Without any synchronization and without atomic or volatile variables it does not make a difference.
	Multiple threads would override changes from other threads if there is no syncronization.
	
*/
