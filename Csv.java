package com.hasasiki.sellproject;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.IOException;
//import org.junit.Test;
//import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Csv {
	/**This class should have three method.
			//first method should reader the csv and check if the date in it(Id and password),should return true and Name.
			//second method should check is the date given in datebase and return flause or True and the goods details.
			//third method should allow to write new date in datebase.
			//fourth method should give back what manager want.*/
 /*Csv employee Datebase Type follows D:\workarea\Project1\Database1.csv
	 * -------------------------------------
	 *  Id         Password        Name 
	 * -------------------------------------
	 * row(0)[0]   row(0)[1]      row(0)[2]
	 * -------------------------------------
	 * row(1)[0]   row(1)[1]      row(1)[2]
	 * -------------------------------------
	 * ...
	 * -------------------------------------
	 * */
	/*Csv product  Datebase1 Type follows D:\workarea\Project1\Database2.csv
	 * -------------------------------------------------
	 * Code        ProductName      Price       Number
	 * --------------------------------------------------
	 * row(0)[0]   row(0)[1]      row(0)[2]    row(0)[3]
	 * --------------------------------------------------
	 * row(1)[0]   row(1)[1]      row(1)[2]    row(1)[3]
	 * --------------------------------------------------
	 * ...
	 * --------------------------------------------------
	 */
	/*CsvWriteFile  Datebase D:\workarea\Project1\Database3.csv
	 * to store data
	 * 
	 * */
	
	/*Csv CsvWriteFile  Datebase Type follows D:\workarea\Project1\Database4.csv
	 * ---------------------------------------------------------------
	 * Code        ProductName      Price       Number      NumberNew
	 * ---------------------------------------------------------------
	 * row(0)[0]   row(0)[1]      row(0)[2]    row(0)[3]     row(0)[4]
	 * ---------------------------------------------------------------
	 * row(1)[0]   row(1)[1]      row(1)[2]    row(1)[3]     row(1)[4]
	 * ---------------------------------------------------------------
	 * ...
	 * ---------------------------------------------------------------
	 */
	/*New stock CsvWriteFile2  Datebase2 Type follows to store update D:\workarea\Project1\Database5.csv
	 * -------------------------------------------------
	 * Code        ProductName      Price       Number
	 * --------------------------------------------------
	 * row(0)[0]   row(0)[1]      row(0)[2]    row(0)[3]
	 * --------------------------------------------------
	 * row(1)[0]   row(1)[1]      row(1)[2]    row(1)[3]
	 * --------------------------------------------------
	 * ...
	 * --------------------------------------------------
	 */
	/*csvFilePath3 Datebase3 to store bill D:\workarea\Project1\Database6.csv
	 * --------------------------------------------------------------------------------------
	 * ProductName        Price        Number      sum        Data      no.*     Code
	 * --------------------------------------------------------------------------------------
	 *  row(0)[0]      row(0)[1]    row(0)[2]    row(0)[3]   row(0)[4]  row(0)[5]  row(0)[6]
	 * ---------------------------------------------------------------------------------------
	 */
	/*csvFilePath4 the update database after manager return goods D:\workarea\Project1\Database6.csv
	 * 
	 */
	UI_1 ui = new UI_1();
	Clerk clerk = new Clerk();
	Csv csv = new Csv();
	
	public void CheckDatebase(String csvFilePath, String id, String password) {
		/**check employeethis method is used to check employee.*/
		try {  
			ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据 
			CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));   
			reader.readHeaders(); 
			while(reader.readRecord()){  
             csvList.add(reader.getValues());  
			}              
			reader.close();   
			for(int row=0;row<csvList.size();row++){  
              String  idc = csvList.get(row)[0]; //取得第row行第0列的数据(id in datebase) 
              String  passwordc = csvList.get(row)[1]; //取得第row行第1列的数据(password in datebase) 
             //System.out.println(cell);  
				if(idc.equals(id)){	
						if(passwordc.equals(password)){
							String  name = csvList.get(row)[2]; //取得第row行第2列name
							ui.print4(name);
						}
						else {
							System.out.println("Please input right password!");
							ui.ErrorMessagePrint();
						}
					}
				else {
					System.out.println("Please input right ID!");
					ui.ErrorMessagePrint();
				}
			} 
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
	public void CheckDatebase(String csvFilePath, String ProductCode) {
		/**check stock*/
		try {  
			ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据 
			CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));    //一般用这编码读就可以了      
			reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。  
			while(reader.readRecord()){ //逐行读入除表头的数据      
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			for(int row=0;row<csvList.size();row++){  
              //查询csv文件中是否存在与传递过来的参数相同的数据
				String  pdc = csvList.get(row)[0]; //取得第row行第0列的数据(code of product in datebase) 
				if(pdc.equals(ProductCode)){
					String  ProductName = csvList.get(row)[1]; //取得第row行第1列的数据(name of product in datebase)
					String  Price = csvList.get(row)[2]; //取得第row行第1列的数据(price of product in datebase)
					//clerk.StoreInformation(csvList.get(row));
					String CsvWriteFilePath = "D:\\workarea\\Project1\\Database3.csv";//To write the update in a new csv file
					csv.writeCsv(CsvWriteFilePath,csvList.get(row) );
					ui.print6(ProductName,Price);
				}
				else {
					System.out.println("This product isn't in stock!");
					ui.ErrorMessagePrintOfProduct();
				}
             //System.out.println(cell);  
			} 
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
	public void writeCsv(String csvFilePath, String[] contents){  
		/**to write in database*/
        try {  
              
             CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS"));  
             // String[] contents = {"aaaaa","bbbbb","cccccc","ddddddddd"};                      
             wr.writeRecord(contents);  
             wr.close();  
         } catch (IOException e) {  
            e.printStackTrace();  
         }  
    }  
	public void showProducts() {
		/**to show the goods*/
		String CsvWriteFilePath = "D:\\workarea\\Project1\\Database2.csv";//The same as up src.
		try {  
			ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据 
			CsvReader reader = new CsvReader(CsvWriteFilePath,',',Charset.forName("SJIS"));    //一般用这编码读就可以了      
			reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。  
			while(reader.readRecord()){ //逐行读入除表头的数据      
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			for(int row=0;row<csvList.size();row++){  
				//show products id,name
				String  ProductInformation = csvList.get(row)[1] + csvList.get(row)[2]; //get name and price
				System.out.println(ProductInformation);
			} 
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}

	public void UpdateDatebase() {
		/** to update datebase*/
		try {  
			ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
			ArrayList<String[]> csvList2 = new ArrayList<String[]>();//save which has been saled
			String csvFilePath = "D:\\workarea\\Project1\\Database2.csv";//give the src of clerk.csv 
			String CsvWriteFilePath = "D:\\workarea\\Project1\\Database3.csv";//To write the update in a new csv file
			String CsvWriteFilePath2 = "D:\\workarea\\Project1\\Database5.csv";//To write the update in a new csv file
			CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));       
			CsvReader reader2 = new CsvReader(CsvWriteFilePath,',',Charset.forName("SJIS")); 
			reader.readHeaders(); 
			while(reader.readRecord()){  
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			reader2.readHeaders();
			while(reader2.readRecord()){ 
             csvList2.add(reader2.getValues());  
			}              
			reader2.close();  
			for(int row=0;row<csvList.size();row++){  
				String  ProductNameInOldDatebase = csvList.get(row)[1]; //get the name of product in datebase1
				String  ProductNumberInOldDatebase = csvList.get(row)[3];//get the Number of product in datebase1
				String  ProductNameInNewDatebase = csvList2.get(row)[1];//get the name of product in datebase2
				String  ProductNumberInNewDatebase = csvList2.get(row)[4];//get the Number of product in datebase2
				int i = Integer.parseInt(ProductNumberInOldDatebase); 
				int j = Integer.parseInt(ProductNumberInNewDatebase); 
				if(ProductNameInOldDatebase.equals(ProductNameInNewDatebase)){//if name same , creat a new row include old's information but number-!
					String[] NewContents = {csvList2.get(row)[0], csvList2.get(row)[1], csvList2.get(row)[2],String.valueOf(i-j)};
					csv.writeCsv(CsvWriteFilePath2,NewContents);
				}
				else {
					csv.writeCsv(CsvWriteFilePath2,csvList.get(row));//if not, write the row in new datebase.
				}
             //System.out.println(cell);  
			} 
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
	
	public void AddBills(String sum,String Data) {
		/**creat a datebase foe billthe bill datebase*/
		//String[] contents = {};
		//csv.writeCsv(csvFilePath3, contents);
		try {  
			String csvFilePath3 = "D:\\workarea\\Project1\\Database6.csv";//The bill datebase
			String csvFilePath2 = "D:\\workarea\\Project1\\Database4.csv";
			ArrayList<String[]> csvList = new ArrayList<String[]>();  
			int count = 0;
			CsvReader reader = new CsvReader(csvFilePath2,',',Charset.forName("SJIS"));   
			reader.readHeaders();   
			while(reader.readRecord()){  
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			for(int row=0;row<csvList.size();row++){  
				String  ProductCode = csvList.get(row)[0]; 
				String  ProductName = csvList.get(row)[1]; 
				String  Number = csvList.get(row)[3]; 
				String  Price = csvList.get(row)[2]; 
				String  NoNumber = String.valueOf(count);  //help to refund
				String[] contonts = {ProductName,Price, Number, sum, Data, NoNumber, ProductCode};//To write the update in a new csv file
				csv.writeCsv(csvFilePath3,contonts);
				count++;
				}
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
	
	public void CheckData(String data) {
		/**to check if the data less than 30 days after bought*/
		try {  
			String csvFilePath3 = "D:\\workarea\\Project1\\Database6.csv";//the bill datevase
			ArrayList<String[]> csvList = new ArrayList<String[]>(); 
			CsvReader reader = new CsvReader(csvFilePath3,',',Charset.forName("SJIS")); 
			reader.readHeaders(); 
			while(reader.readRecord()){  
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			for(int row=0;row<csvList.size();row++){  
				String DataInBill = csvList.get(row)[4];
				int int1 = Integer.parseInt(DataInBill);
				int int2 = Integer.parseInt(data);
				int result = int1-int2;
				//result大于0，则t1>t2；  result等于0，则t1=t2； result小于0，则t1<t2；
				if (result <=0) {
					ui.print14();
				}
			} 
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}

	public void ReturnStock(String NoNumber) {
		/**This method can add product number of datebase3
		check the number in bill to find witch product it is
		and rewrite it into datebase2
		i can't update the datebase2's Number rightly when refund goods now, but it still can let the product back to datebase. */
		try {  
			ArrayList<String[]> csvList = new ArrayList<String[]>();  
			String csvFilePath3 = "D:\\workarea\\Project1\\Database6.csv"; //Datebase3
			CsvReader reader = new CsvReader(csvFilePath3,',',Charset.forName("SJIS"));     
			reader.readHeaders(); 
			while(reader.readRecord()){ 
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			for(int row=0;row<csvList.size();row++){  
				String  identifier  = csvList.get(row)[5]; 
				if(identifier.equals(NoNumber)){
					String productCode = csvList.get(row)[6];
					String productName = csvList.get(row)[0];
					String productPrice = csvList.get(row)[1];
					String[] contents = {productCode,productName,productPrice,"1"};
					String CsvWriteFilePath2 = "D:\\workarea\\Project1\\Database5.csv";//to rewrite the update datebase
					csv.writeCsv(CsvWriteFilePath2,contents);
				}
				else {
					System.out.println("This product isn't in stock!");
					ui.ErrorMessagePrintOfProduct();
				}
             //System.out.println(cell);  
			} 
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
	
	public void ShowDatebase() {
		/**A summary of all items currently in stock (show all product name) */
		try {  
			ArrayList<String[]> csvList = new ArrayList<String[]>();  
			String CsvWriteFile2 = "D:\\workarea\\Project1\\Database5.csv";//Show updated datebase2
			CsvReader reader = new CsvReader(CsvWriteFile2,',',Charset.forName("SJIS"));     
			reader.readHeaders(); 
			while(reader.readRecord()){ 
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			for(int row=0;row<csvList.size();row++)
					System.out.println(csvList.get(row)[1]);
			} 
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
	
	public void ShowDetails(String code) {
		/**Details relating to specific items in stock */
		try {  
				ArrayList<String[]> csvList = new ArrayList<String[]>();  
				String CsvWriteFile2 = "D:\\workarea\\Project1\\Database5.csv";//Show updated datebase2
				CsvReader reader = new CsvReader(CsvWriteFile2,',',Charset.forName("SJIS"));     
				reader.readHeaders(); 
				while(reader.readRecord()){ 
					csvList.add(reader.getValues());  
				}              
				reader.close();  
				for(int row=0;row<csvList.size();row++) {
					String ProductCode = csvList.get(row)[0];
					if(code.equals(ProductCode)) {
						System.out.println(csvList.get(row)[0] + csvList.get(row)[1] + csvList.get(row)[2] + csvList.get(row)[3]);
					}
					else {
						continue;
					}
				}
			} 
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
	
	public void PrintTheSummeryOfTimeslot(String date) {
		/**This method should allowed user to print the database of input time slot.
	    	after choose a  period of time then should get the now time of pc and calculate the last date and search the bill database.
	    	print the date [last_date,new_date] of the bill database include selled purchases' [Name] [price] [Number]and [sum]*/
		try {  
			String csvFilePath3 = "D:\\workarea\\Project1\\Database6.csv";//the bill datevase
			ArrayList<String[]> csvList = new ArrayList<String[]>(); 
			CsvReader reader = new CsvReader(csvFilePath3,',',Charset.forName("SJIS")); 
			reader.readHeaders(); 
			while(reader.readRecord()){  
             csvList.add(reader.getValues());  
			}              
			reader.close();  
			for(int row=0;row<csvList.size();row++){  
				String DataInBill = csvList.get(row)[4];
				int int1 = Integer.parseInt(DataInBill);
				int int2 = Integer.parseInt(date);
				int result = int1-int2;
				//result大于0，则t1>t2；  result等于0，则t1=t2； result小于0，则t1<t2；
				if (result <=0) {
					System.out.println(csvList.get(row)[0] + csvList.get(row)[1] + csvList.get(row)[2] + csvList.get(row)[3]);
				}
			} 
		}
		catch(Exception ex){  
	        System.out.println(ex);  
		}
	}

	public void ManagerReturn(String CodeNumber) {
		/**This method should accept a code number and search it in database2 .
	    	if find it then delect it and give back a "have succeed return" message.*/
		try {  
			ArrayList<String[]> csvList = new ArrayList<String[]>(); 
			ArrayList<String[]> csvList2 = new ArrayList<String[]>();//save which has been saled
			String CsvFilePath2 = "D:\\workarea\\Project1\\Database5.csv";//read update database
			String CsvWriteFilePath4 = "D:\\workarea\\Project1\\Database7.csv";//To write the update in a new csv file
			CsvReader reader = new CsvReader(CsvFilePath2,',',Charset.forName("SJIS"));
			reader.readHeaders();
			while(reader.readRecord()){ 
             csvList.add(reader.getValues());  
			}              
			reader.close();   
			for(int row=0;row<csvList.size();row++){  
				//if not same then write data in a new array 
              String  idc = csvList.get(row)[0];
				if(idc.equals(CodeNumber))
					continue;
				else 
					csvList2.add(csvList.get(row));  
			}
			for(int row=0;row<csvList.size();row++) {
				String[] contents =   {csvList2.get(row)[0], csvList2.get(row)[1], csvList2.get(row)[2],csvList2.get(row)[3]};
				csv.writeCsv(CsvWriteFilePath4,contents);
			}
			
		}
		catch(Exception ex){  
	        System.out.println(ex);  
	    }
	}
}
