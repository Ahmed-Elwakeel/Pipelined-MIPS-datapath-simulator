package logic_components;

import datapath.ID_EX;


public class ALU {

	public static String output;
	public static boolean zero;
 
 public ALU(String r1,String r2 ){
	 ALUControl aluControl = new ALUControl();
	 String funct = ID_EX.address.substring(26,32);
	 String shamt = ID_EX.address.substring(22,26);
	 String aluOutput = aluControl.getcode(funct, ID_EX.ALUOp);
	 aluoutputmethod(r1 ,r2 , aluOutput ,  shamt);
	 
 }
 
 
 
 public void aluoutputmethod(String r1 , String r2 , String aluOutput , String shamt){

	 long x =  Long.parseLong(r1, 2);
	   long y =  Long.parseLong(r2,2);
	   int shmt = Integer.parseInt(shamt,2);
	   long res = 0;
		 int intRes= 0;
	 switch(aluOutput){
	 
	 case "0000" :res =  x+y;
	 			   break;
	 case "0001" : res = x-y;
			 	   break;
	 case "0011" : res = y >> shmt;
	 			   break;
	 case "0010" : res = y << shmt;
	 			   break;
	 case "0100" : res = x & y;
	   			   break;
	 case "0101" : res = x | y;
	 case "0110" : if(x < y) res = 1; else res = 0;
	   			   break;
	 case "0111" : if(x < y) res = 1; else res = 0;
	 case "1000" : break;
	 }
	 
	 	intRes = (int) res;
		output = String.format("%32s", Integer.toBinaryString(intRes)).replace(' ', '0');
	 if(res == 0){
		 zero = true;
	 }else{
		 zero = false;
	 }
 }
 
 
 
}