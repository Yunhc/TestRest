package com.example.TestRest;

public class Util {
	//
	public static String GetData(Object obj) {
		String data = "";
		String  rtn = "";
		
		if (obj.equals(null) ) {
			data = "";
		}
		else {
			data = (String) obj;
		}
		
		if (data.equals("null")) data = "";
		 
	    if (data != null && data != ""){
	       int npos1 = data.indexOf("[",0);
	       int npos2 = data.indexOf("]",0);
	       if (npos1 > -1 && npos2 > -1){
	         rtn = data.substring(npos1 + 1, npos2 );
	       }
	       else{
	         rtn = data;
	       }
	    }
	    
	    return rtn;
	}

}
