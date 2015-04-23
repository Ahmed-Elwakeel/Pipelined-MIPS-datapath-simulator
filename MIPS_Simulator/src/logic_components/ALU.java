package logic_components;

import datapath.ID_EX;


public class ALU {

	public static String output;
	public static boolean zero;
 
 public ALU(String r1,String r2){
	 	
	 ALUControl aluControl = new ALUControl();
	 String funct = ID_EX.address.substring(26,32);
	 String aluOutput = aluControl.getcode(funct, ID_EX.ALUOp);
	 aluoutputmethod(r1 ,r2 , aluOutput);
	 
 }
 
 public void aluoutputmethod(String r1 , String r2 , String aluOutput){
	 int x =  Integer.parseInt(r1, 2);
	   int y =  Integer.parseInt(r2,2);
	   int res = 0;
	 switch(aluOutput){
	 case "0000" : 
	 			   res = x+y;
	 			   output = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
	 			   break;
	 
	 case "0001" : res = x-y;
			 	   output =  String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
			 	   
	 case "0010" : res = x >> y;
	 			   output =  String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
	 case "0011" : res = x << y;
	 			   output =  String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
	 			   
	 case "0100" : res = x & y;
	   			   output =  String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
	 
	 case "0101" : res = x | y;
	 			   output =  String.format("%32s", Integer.toBinaryString(~res)).replace(' ', '0');
	 			   
	 case "0110" : if(x < y) res = 1; else res = 0;
	   			   output =  String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
	   
	 case "0111" : if(x < y) res = 1; else res = 0;
		   			output =  String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');

	 }
	 if(res == 0){
		 zero = true;
	 }else{
		 zero = false;
	 }
 }
 
 
 
}