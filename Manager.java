package com.hasasiki.sellproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Manager extends Staff implements Manage {
	UI_1 ui = new UI_1();
	Csv usecsv = new Csv();
	Scanner input = new Scanner(System.in);
	public void Log() {
		/**this method should accept id&password input and check it in datebase
		//if it find in datebase should go to the clerk ui and show the name of clerk*/
		String Id = input.nextLine();
		String password = input.nextLine();
		String csvFilePath = "";//give the src of manager.csv
		super.setId(Id);
		super.setPassword(password);
		super.LogIn(csvFilePath);
		//ui.print4(/*Name:String*/);
	}
	@Override
	public void Abstract() {
		/** return the abstract to ui.print10
		// A summary of all items currently in stock  */
		usecsv.ShowDatebase();
	}

	public void Detailed(String code) {
		/** Details relating to specific items in stock  */
		usecsv.ShowDetails(code);
		
	}

	@Override
	public void Summary(int a) {
		/** A summary of all sales over a chosen period of time (days/weeks/months/years) */
		if (a == 1){
			System.out.println("Days Summary:");
			//Date date=new Date();
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			//String str1=s.format(date);//当前的时间
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -1);//计算30天后的时间
			String str2=s.format(c.getTime());
			usecsv.PrintTheSummeryOfTimeslot(str2);
		}
		else if (a == 2) {
			System.out.println("Weeks Summary:");
			//Date date=new Date();
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			//String str1=s.format(date);//当前的时间
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -7);//计算30天后的时间
			String str2=s.format(c.getTime());
			usecsv.PrintTheSummeryOfTimeslot(str2);
		}
		else if (a == 3) {
			System.out.println("Month Summary:");
			//Date date=new Date();
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			//String str1=s.format(date);//当前的时间
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -30);//计算30天后的时间
			String str2=s.format(c.getTime());
			usecsv.PrintTheSummeryOfTimeslot(str2);
		}
		else if (a == 4){
			System.out.println("year Summary:");
			//Date date=new Date();
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			//String str1=s.format(date);//当前的时间
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -365);//计算30天后的时间
			String str2=s.format(c.getTime());
			usecsv.PrintTheSummeryOfTimeslot(str2);
		}
	}

	@Override
	public void Refund(String CodeNumber) {
		/** decide to return items to a supplier*/
		usecsv.ManagerReturn(CodeNumber);
	}
}
