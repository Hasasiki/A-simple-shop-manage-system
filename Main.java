package com.hasasiki.sellproject;

import java.util.Scanner;

public class Main {
	
		
	public static void main(String[] args) {
	/*	UI_1 ui = new UI_1();
		Manager manager = new Manager();	
		// show the first ui, and input the choose.
		System.out.println("*************************************");
		System.out.println("Welcome to Sports Store!");
		System.out.println("------------------------------------");
		System.out.println("1) Clerk Log in   2) Manager   0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		switch(num) {
			case 0 : System.exit(0);break;//0) Exit
			case 1 : ui.print2();break;//1) Clerk Log in, jump to clerk.LogIn();
			case 2 : manager.Log();break;//2) Manager, jump to Manager.LogIn();
		}
		*/
		UI_1 ui = new UI_1();
		ui.print1();
	}
	
	/*public void choose(int num) {
		
		switch(num){
			case 1 : ui.print2();break;//1) Clerk Log in, jump to clerk.LogIn();
			case 2 : manager.Log();break;//2) Manager, jump to Manager.LogIn();
			case 3 : ui.print1();break;//3) Log Out
			case 4 : ui.print5();break;//4) Purchase
			case 5 : ui.print8();break;//5) Complete Transaction
			case 6 : ui.print9();break;//6) Stop
			case 7 : ui.print15();break;//7) Return
			case 8 : ui.print1();break;//8) Try again
			case 9 : ui.print14();break;//9) Refund
			case 10: manager.Summary(1);break;//10)days
			case 11: manager.Summary(2);break;//11)weeks
			case 12: manager.Summary(3);break;//12)months
			case 13: manager.Summary(4);break;//13)years
			case 14: ui.print5();break;
			case 0 : System.exit(0);break;//0) Exit
			default:System.out.println("Error input!");
		}
	}*/
}
