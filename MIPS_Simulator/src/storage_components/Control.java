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

	public Control() {

	}

	public void controlSignals(String opCode) {
	
		switch (opCode) {
		case "000000":
			regDst = true;branch = false;memRead = false;memToReg = false;ALUOp = "10";
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;
			break;
		case "001000" :
			regDst =false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = false;ALUSrc = true;regWrite = true; bneBranch = false;
			break; // addi
			// 5lst
		case "000100" :
			regDst = false;branch = true;memRead = false;memToReg = false;ALUOp = "01";
			memWrite = false;ALUSrc = false;regWrite = false; bneBranch = false;
			break; // beq
			//5lst
			
		case "000101" : 
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "01";
			memWrite = false;ALUSrc = false;regWrite = false; bneBranch = true;
			break; // bne
			//lessa
			
		case "100011" :
			regDst = false;branch = false;memRead = true;memToReg = true;ALUOp = "00";
			memWrite = false;ALUSrc = true;regWrite = true; bneBranch = false;
			break; // lw
			//5lst
			
		case "100000" : 
			regDst = true;branch = false;memRead = true;memToReg = true;ALUOp = "";
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;
			break; // lb
			// lessa
			
		case "100100" : 
			regDst = true;branch = false;memRead = true;memToReg = true;ALUOp = "";
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;
			break; // lbu
			//lessa
			
		case "101011" : 
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = true;ALUSrc = true;regWrite = false; bneBranch = false;
			break; // sw
			//5lst
			
		case "101000" :
			regDst = false;branch = false;memRead = false;memToReg = false;ALUOp = "00";
			memWrite = true;ALUSrc = true;regWrite = false; bneBranch = false;
			break; // sb
			//lessa
		case "001111" :
			regDst = true;branch = false;memRead = true;memToReg = true;ALUOp = "";
			memWrite = false;ALUSrc = false;regWrite = true; bneBranch = false;
			break; // lui
			//lessa
		
		case "000010" : 
			/*regDst = true;branch = false;memRead = false;memToReg = false;ALUOp = "";
			memWrite = false;ALUSrc = false;regWrite = true;*/
			break; // j
			//lessa
		case "000011" : 
			/*regDst = true;branch = false;memRead = false;memToReg = false;ALUOp = "";
			memWrite = false;ALUSrc = false;regWrite = true;*/
			break; // jal
			//lessa
		
		}
	}

	public void op() {

	}
}
