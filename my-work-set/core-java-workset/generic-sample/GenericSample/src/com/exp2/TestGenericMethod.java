package com.exp2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGenericMethod {

	public static void main(String[] args) {
		Serializable s = pick("d", new ArrayList<String>());
		
		Map<String, List<String>> myMap = new HashMap(); 
	}

	static <T> T pick(T a1, T a2) {
		return a2;
	}
}
