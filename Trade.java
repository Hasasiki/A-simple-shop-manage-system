package com.hasasiki.sellproject;

public interface Trade {
	public abstract void CheckStock(String a);
	public abstract void InputProduct(String a, int b, String c);
	public abstract void Receipt();
	public abstract void StoreInformation(String a); 
	public abstract void sum(int a, String b);
	public abstract void Update();
}
