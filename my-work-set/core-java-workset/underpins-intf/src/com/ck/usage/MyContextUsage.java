package com.ck.usage;

import com.ck.impl.MyBasicContext;
import com.ck.impl.MyPhoneContext;
import com.ck.intf.MyContext;

public class MyContextUsage {

	private MyContext myContext;

	private MyContextUsage() {

		try {
			
			String className = MyBasicContext.class.getName();
			
			Class<MyBasicContext> classIniti = (Class<MyBasicContext>) Class.forName(className);
			myContext =  classIniti.newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public MyContextUsage(MyContext myContext) {
		this.myContext = myContext;
	}

	public void getContextUsage() {
		System.out.println("Here I am using: "+myContext.getName());
	}

	public static void main(String args[]) {

		MyContextUsage contextUsage = new MyContextUsage();
		contextUsage.getContextUsage();

		contextUsage = new MyContextUsage(new MyPhoneContext());
		contextUsage.getContextUsage();
	}

}
