package com.hasasiki.sellproject;

import java.util.Scanner;

public class UI_1{              /**the home ui*/
	Clerk clerk = new Clerk();
	Manager manager = new Manager();
	Scanner input = new Scanner(System.in);
	private static Scanner input2;
	public void print1() {
		System.out.println("*************************************");
		System.out.println("Welcome to Sports Store!");
		System.out.println("------------------------------------");
		System.out.println("1) Clerk Log in   2) Manager   0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print2() {                   /**clerk log ui*/
		System.out.println("************************************");
		System.out.println("Welcome to Sports Store! CLERK");
		System.out.println("------------------------------------");
		System.out.println("Please Enter Your Employee ID ");
		System.out.println("************************************");
		clerk.Log();
	}
	public void print3() {                   /**manager log ui*/
		System.out.println("************************************");
		System.out.println("Welcome to Sports Store! MANAGER");
		System.out.println("------------------------------------");
		System.out.println("Please Enter YourEmployee ID ");
		System.out.println("************************************");
		manager.Log();
	}
	public void print4(String Name) {          /**clerk ui*/
		System.out.println("*****************************************************");
		System.out.println("Welcome" + Name );
		System.out.println("-----------------------------------------------------");
		System.out.println("3) Log Out     4) Purchase    9) Refund     0) Exit");
		System.out.println("*****************************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print5() {                    /**purchase ui*/
		System.out.println("************************************");
		System.out.println("Enter Purchase Code:");
		System.out.println("************************************");
		String ProductCode = input.nextLine();
		clerk.CheckStock(ProductCode);
	}
	public void print6(String ProductName, String Price) {                   /**input product ui*/
		System.out.println("************************************");
		System.out.println("How many would you like to purchase "+ ProductName+"?");
		System.out.println("************************************");
		int addNumber = input.nextInt();
		clerk.InputProduct(ProductName, addNumber, Price);
	}
	public void print7(int items) {         /**reinput product ui*/
		System.out.println("************************************");
		if(items == 0 )
			System.out.println("Please add number of goods!");
		else if(items >= 1)
			System.out.println("These items have been added!");
		System.out.println("------------------------------------");
		System.out.println("4) Purchase  5) Complete Transaction");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print8() {                  /**Complete Transaction ui*/
		System.out.println("************************************");
		clerk.Receipt();
		System.out.println("------------------------------------");
		System.out.println("4) Contine               6£© Stop");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print9() {                  /**Finish shopping ui*/
		System.out.println("************************************");
		System.out.println("Thank you for your purchase. Your receipt has been printed!");
		System.out.println("------------------------------------");
		System.out.println("3) Log Out     4) Purchase    0) Exit");
		
		clerk.Update();
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print10() {                 /**manager Abstract ui*/
		System.out.println("************************************");
		manager.Abstract();
		System.out.println("------------------------------------");
		System.out.println("3) Log Out     7)Return      0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print11() {                 /**manager detailed ui*/
		System.out.println("************************************");
		System.out.println("Please input Product ID:");
		String code = input.nextLine();
		manager.Detailed(code);
		System.out.println("------------------------------------");
		System.out.println("3) Log Out     7)Return      0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print12() {                /**manager summary ui*/
		System.out.println("************************************");
		System.out.println("Show the summary of ");
		System.out.println("10)days  11)weeks  12)months  13)years");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
		System.out.println("------------------------------------");
		System.out.println("3) Log Out     7)Return      0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num1 = input2.nextInt();
		choose(num1);
	}
	public void print13() {                 /**manager refund ui*/
		System.out.println("************************************");
		System.out.println("Please input the Goods Code which youto refund:");
		System.out.println("------------------------------------");
		String CodeNumber = input.nextLine();
		manager.Refund(CodeNumber);
		System.out.println("------------------------------------");
		System.out.println("3) Log Out     7)Return      0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void print14() {                 /**Refund ui*/
		System.out.println("************************************");
		System.out.println("Please inter the No¡£Number of product");
		System.out.println("");
		System.out.println("************************************");
		String NoNumber = input.nextLine();
		clerk.ReturnStock(NoNumber);
	}
	public void print15() {                 /**manager ui*/
		
	}
	public void ErrorMessagePrint() {       /**employee error input*/
		System.out.println("************************************");
		System.out.println("8) Try again    0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public void ErrorMessagePrintOfProduct() {/**product error input*/
		System.out.println("************************************");
		System.out.println("9) Try again    0) Exit");
		System.out.println("************************************");
		input2 = new Scanner(System.in);
		int num = input2.nextInt();
		choose(num);
	}
	public static void choose(int num) {
		UI_1 ui = new UI_1();
		Manager manager = new Manager();
		switch(num){
			case 1 : ui.print2();break;/**1) Clerk Log in, jump to clerk.LogIn();*/
			case 2 : manager.Log();break;/**2) Manager, jump to Manager.LogIn();*/
			case 3 : ui.print1();break;/**3) Log Out*/
			case 4 : ui.print5();break;/**4) Purchase*/
			case 5 : ui.print8();break;/**5) Complete Transaction*/
			case 6 : ui.print9();break;/**6) Stop*/
			case 7 : ui.print15();break;/**7) Return*/
			case 8 : ui.print1();break;/**8) Try again*/
			case 9 : ui.print14();break;/**9) Refund*/
			case 10: manager.Summary(1);break;/**10)days*/
			case 11: manager.Summary(2);break;/**11)weeks*/
			case 12: manager.Summary(3);break;/**12)months*/
			case 13: manager.Summary(4);break;/**13)years*/
			case 14: ui.print5();break;
			case 0 : System.exit(0);/**0) Exit*/
			default:System.out.println("Error input!");
		}
	}
}
