package com.hasasiki.sellproject;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Clerk extends Staff implements Trade, Refund {
	
	Scanner input = new Scanner(System.in);
	UI_1 ui = new UI_1();
	Csv usecsv = new Csv();
	Clerk clerk = new Clerk();
	ArrayList<String> StoreList = new ArrayList<String>();
	ArrayList<Double> list = new ArrayList<Double>();
	
	public void Log() {
		/**this method should accept id&password input and check it in datebase
		*if it find in datebase should go to the clerk ui and show the name of clerk*/
		String Id = input.nextLine();
		String password = input.nextLine();
		String csvFilePath = "D:\\workarea\\Project1\\Database1.csv";//give the src of clerk.csv 
		super.setId(Id);
		super.setPassword(password);
		super.LogIn(csvFilePath);
		//ui.print4(/*Name:String*/);
	}
	
	@Override
	public void CheckData() {
		/** use interface refund
		Date date=new Date();*/
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		/**String str1=s.format(date);//当前的时间*/
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -30);//计算30天后的时间
		String str2=s.format(c.getTime());
		usecsv.CheckData(str2);
	}

	@Override
	public void ReturnStock(String NoNumber) {
		/** use interface refund
		* return product to stock(Write back to CsvWriteFile2  Datebase2 )*/
		usecsv.ReturnStock(NoNumber);
	}

	@Override
	public void CheckStock(String ProductCode) {
		/** If true,number&price of product should be output*/
		String csvFilePath = "D:\\workarea\\Project1\\Database2.csv";//give the src of clerk.csv 
		System.out.println("Please input the PRODUCT CODE.");
		/**CheckSQL.OnlineSQL(product);//and if it has it should go to inputproduct ui*/
		usecsv.CheckDatebase(csvFilePath, ProductCode);
		/**should get the goods name(type String)*/
		//ui.print6(Name);
	}

	@Override
	public void InputProduct(String ProductName, int addNumber, String Price) {
		/** A loop of input, if end, go to sum method(use array)
		*ui.print6 will return the add number of goods 
		*when the method end it should jump to ui.print7 to readd goods*/
		String CsvWriteFilePath = "D:\\workarea\\Project1\\Database3.csv";/**To write the update in a new csv file datebase 2*/
		clerk.sum(addNumber, Price);
		String num = String.valueOf(addNumber);
		String[] contents = {num};  //add sale number to datebase
		usecsv.writeCsv(CsvWriteFilePath, contents);
		ui.print7(addNumber);
	}
	
	@Override
	public void Receipt() {
		/** ui.print8 should connect to this method to print the bill of purchase
		*sum the goods*/
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		Double sum = 0.0;
		usecsv.showProducts();
		for(int i = 0; i < list.size() ; i++)
		{
			sum = sum + list.get(i);
			usecsv.AddBills(Double.toString(list.get(i)),df.format(new Date()));
		}
		System.out.print("The total price is:" + sum);
	}

	@Override
	public void StoreInformation(String information) {
		/** to store date of purchase*/
		StoreList.add(information);
	}

	@Override
	public void sum(int addNumber,String Price) {
		/** to sum the goods*/
		Double price = Double.valueOf(Price);
		Double number = (double)addNumber;
		Double sum = price * number;
		list.add(sum);
	}
	
	public void Update() {
		/**This method is to update the datebase after finish shopping*/
		usecsv.UpdateDatebase();
	}

}
