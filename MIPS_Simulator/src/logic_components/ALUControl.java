package logic_components;

import java.util.HashMap;
import java.util.Map;

public class ALUControl {
	
	static Map<String , String> opsixbits;
	
	public ALUControl( ){

	opsixbits();
	}
	
	public void opsixbits(){
	
		
		opsixbits = new HashMap<String,String>();
		opsixbits.put("100000" , "0000"); //add
		opsixbits.put("100010" , "0001"); //sub
		opsixbits.put("000000" , "0010"); //sll
		opsixbits.put("000010" , "0011"); //srl
		opsixbits.put("100100" , "0100"); //and
		opsixbits.put("100111" , "0101"); //nor
		opsixbits.put("101010" , "0110"); //slt
		opsixbits.put("101011" , "0111"); //sltu
		opsixbits.put("001000" , "1000"); //jr
		

	}
	//http://www.cs.carleton.edu/faculty/adalal/teaching/f04/207/notes/oct29.pdf
	public String getcode (String sixbits,String ALUOp){
		if(ALUOp.equals("00")){ //add
			return "0000";
		}else if(ALUOp.equals("01")){ //sub
			return "0001"; 
		}else { //funct
			opsixbits.get(sixbits);
			return opsixbits.get(sixbits);
		}
	}
}
