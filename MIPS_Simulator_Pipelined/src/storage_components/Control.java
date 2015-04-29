package storage_components;



import java.util.HashMap;

public class Control {

	public static boolean regDst;
	public static boolean branch;
	public static boolean memRead;
	public static boolean memToReg;
	public static String ALUOp;
	public static boolean memWrite;
	public static boolean ALUSrc;
	public static boolean regWrite;
	public static boolean bneBranch;
	public static boolean lb;
	public static boolean sb;
	public static boolean j;
	public static boolean jal;
	public static boolean jr;
	public static boolean lui;
	public Control() {

	}

	public void controlSignals(String opCode , String funct) {
	
		switch (opCode) {
		case "000000":
			if(funct.equals("001000")){
			regDst = true;branch = false;memRead = false;memToReg = false;ALUOp = "10";
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;lb=false;sb=false;
			j = false; jal = false; jr =true; lui=false;
			}else{
				regDst = true;branch = false;memRead = false;memToReg = false;ALUOp = "10";
				memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;lb=false;sb=false;
				j = false; jal = false;jr = false; lui=false;
				//jr
			}
			break;
		case "001000" :
			regDst =false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = false;ALUSrc = true;regWrite = true; bneBranch = false;lb=false;sb=false;
			j = false; jal = false; jr =false;lui=false;

			break; // addi
			// 5lst
		case "000100" :
			regDst = false;branch = true;memRead = false;memToReg = false;ALUOp = "01";
			memWrite = false;ALUSrc = false;regWrite = false; bneBranch = false;lb=false;sb=false;
			j = false;jal = false; jr =false;lui=false;
			break; // beq
			//5lst
			
		case "000101" : 
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "01";
			memWrite = false;ALUSrc = false;regWrite = false; bneBranch = true;lb=false;sb=false;
			j =false; jal = false; jr =false;lui=false;
			break; // bne
			//lessa
			
		case "100011" :
			regDst = false;branch = false;memRead = true;memToReg = true;ALUOp = "00";
			memWrite = false;ALUSrc = true;regWrite = true; bneBranch = false;lb=false;sb=false;
			j = false;jal = false; jr =false;lui=false;
			break; // lw
			//5lst
			
		case "100000" : 
			regDst = false;branch = false;memRead = true;memToReg = true;ALUOp = "00";
			memWrite = false;ALUSrc = true;regWrite = true; bneBranch = false;lb=true;sb=false;
			j = false;jal = false; jr =false;lui=false;

			break; // lb
			// lessa
			
		case "100100" : 
			regDst = true;branch = false;memRead = true;memToReg = true;ALUOp = "";
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;lb=false;sb=false;
			j = false;jal = false; jr =false;lui=false;

			break; // lbu
			//lessa
			
		case "101011" : 
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = true;ALUSrc = true;regWrite = false; bneBranch = false;lb=false;sb=false;
			j = false; jal = false; jr =false;lui=false;

			break; // sw
			//5lst
			
		case "101000" :
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = true;ALUSrc = true;regWrite = false; bneBranch = false;lb=false;sb=true;
			j = false; jal = false; jr =false;lui=false;
 
			break; // sb
			//lessa
		case "001111" :
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "00"; //3shan malosh lazma
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;lb=false;sb=false;
			j = false; jal = false; jr =false;lui=true;

			break; // lui
			//lessa
		
		case "000010" : 
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = false;ALUSrc = false;regWrite = false; bneBranch = false;lb=false;
			j = true; jal = false; jr =false;lui=false;
			break; // j //aluOP is 00 as a dont care
			
			//lessa
		case "000011" : 
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;lb=false;
			j = true; jal = true; jr =false;lui=false;
			break; // jal //aluOP is 00 as a dont care
			//lessa 
		
		}
	}

	public void op() {

	}
}
