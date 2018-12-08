
/*
Lab04	CO224

E/14/009	Adhikari
E/14/403	Wimalasiri
*/

//////////////////ALU//////////////////

module ALU(Result,DATA1,DATA2,Select);
	input [7:0]DATA1,DATA2;
	input [2:0]Select;
	output reg [7:0] Result;
	always@(DATA1,DATA2,Select)
		begin
			case(Select)
			//your code here//
			3'b000: Result = DATA1;
			3'b001: Result = DATA1+DATA2;
			3'b010: Result = DATA1 & DATA2;
			3'b011: Result = DATA1 | DATA2; 

			endcase
		end
endmodule

//////////////////REGISTER//////////////////


module reg_file(IN,OUT1,OUT2,clk,RESET,INaddr,OUT1addr,OUT2addr); 		
	input [2:0] OUT1addr,OUT2addr,INaddr;
	input [7:0] IN;
	input clk,RESET;
	output [7:0] OUT1,OUT2;
	reg OUT1,OUT2;
	integer i;
	reg [7:0] regFile [0:7];
	//reg [8:0] reg0,reg1,reg2,reg3,reg4,reg5,reg6,reg7;

/*
		assign 
		OUT1 =	OUT1addr == 0 ? reg0 :
				OUT1addr == 1 ? reg1 :
				OUT1addr == 2 ? reg2 :
				OUT1addr == 3 ? reg3 : 
				OUT1addr == 4 ? reg4 :
				OUT1addr == 5 ? reg5 :
				OUT1addr == 6 ? reg6 : reg7 ;
				// add until 8 //
		assign 
		OUT2= 	OUT2addr == 0 ? reg0 :
				OUT2addr == 1 ? reg1 :
				OUT2addr == 2 ? reg2 :
				OUT2addr == 3 ? reg3 : 
				OUT2addr == 4 ? reg4 :
				OUT2addr == 5 ? reg5 :
				OUT2addr == 6 ? reg6 : reg7 ;
				//add until 8//
			always @(negedge clk) 
			begin
				case(INaddr)
				// your code here
				
				0: reg0 = IN;
				1: reg1 = IN;
				2: reg2 = IN;
				3: reg3 = IN;
				4: reg4 = IN;
				5: reg5 = IN;
				6: reg6 = IN;
				7: reg7 = IN;
				
				
				endcase
			end // always @ (negedgeclk)
			*/
			
	always @(posedge clk) 
	begin 	
		OUT1 = regFile[OUT1addr];
		OUT2 = regFile[OUT2addr];
	end

	always @(negedge clk) 
	begin 	
		regFile[INaddr] = IN;
	end

	always @(RESET) 
	begin 		
		for(i=0; i<8;i=i+1)regFile[i] = 0;
	end
endmodule
//////////////////MUX///////////////////////

module mux(IN1,IN2,OUT,SELECT);		
	input [7:0] IN1,IN2;
	input SELECT;
	output [7:0] OUT;
	assign OUT = (SELECT) ? IN2 : IN1 ;
endmodule

//////////////////2's COMP/////////////////

module twos_comp(IN,COMPLIMENT);		
	input [7:0] IN;
	output [7:0] COMPLIMENT;

	assign COMPLIMENT = -IN;
	
endmodule

//////////////////PC/////////////////////
module p_counter(clk,RESET,Read_addr);		
	input clk,RESET;
	output [31:0] Read_addr;
	reg Read_addr;

	always @(RESET) 
	begin
		Read_addr = 32'h00000000; //initial address
	end

	always @(negedge clk) 
	begin
		Read_addr = Read_addr + 1;	//Iterating thorugh addresses
	end
endmodule

//////////////////CONTROL UNIT////////////////

module cu(opcode,alu_select,mux1,mux2,mux3,mux4);	
	input [7:0] opcode;
	output [2:0] alu_select;
	output mux1,mux2,mux3,mux4;
	reg mux1,mux2;
	
	assign alu_select = opcode [2:0];
	always @(opcode) 
	begin
		case(opcode)
			8'b00000000:	//mov instruction
				begin 		
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
			8'b00001000:	//loadi instruction
				begin 		
				mux1 = 1'b0;
				end
			8'b00000001:	//add instruction
				begin 		
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
			8'b00001001:	//sub instruction
				begin 		
				mux1 = 1'b1;
				mux2 = 1'b1;
				end
			8'b00000010:	//and instruction
				begin 		
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
			8'b00000011:	//or instruction
				begin 		
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
		endcase
			
	end
endmodule

//////////////////INSTRUCTION MEMORY////////////

module instruction_mem(Read_addr,Instruction);
	input [31:0] Read_addr;
	output [31:0] Instruction;
	reg Instruction;

	always @(Read_addr) begin
		case(Read_addr)
			32'h00000000: Instruction = 32'h080400FF;
			32'h00000001: Instruction = 32'h080600AA;
			32'h00000002: Instruction = 32'h080300BB;
			32'h00000003: Instruction = 32'h01050603;
			32'h00000004: Instruction = 32'h02010405;
			32'h00000005: Instruction = 32'h03020106;
			32'h00000006: Instruction = 32'h00070002;
			32'h00000007: Instruction = 32'h09040703;
		endcase
	end
endmodule

///////////////////INSTRUCTION REGISTERS/////////////

module instruction_reg(Instruction,clk,OPCODE,OUT1addr,OUT2addr,INaddr,Immediate);
	input [31:0] Instruction;
	input clk;
	output[2:0] OUT1addr,OUT2addr,INaddr;
	output [7:0] OPCODE,Immediate;

	assign OUT1addr = Instruction[2:0];
	assign OUT2addr = Instruction[10:8];
	assign INaddr = Instruction[18:16];
	assign Immediate = Instruction[7:0];
	assign OPCODE = Instruction[31:24];
endmodule

/////////////////Data mem////////////////////

module data_mem(
    clk,
    rst,
    read,
    write,
    address,
    write_data,
    read_data,
	busy_wait
);
input           clk;
input           rst;
input           read;
input           write;
input[7:0]      address;
input[7:0]      write_data;
output[7:0]     read_data;
output			busy_wait;

reg[7:0]     read_data;

integer  i;

// Declare memory 256x8 bits 
reg [7:0] memory_array [255:0];
//reg [7:0] memory_ram_q [255:0];



always @(posedge rst)
begin
    if (rst)
    begin
        for (i=0;i<256; i=i+1)
            memory_array[i] <= 0;
    end
end


always @(*)
begin
    if (write && !read)
	begin
		busy_wait <= 1;
		// artificially delay 100 cycles
		repeat (100) begin
		@ (posedge clk) ;
    	end
        memory_ram_d[address] = write_data;
		busy_wait <= 0;
	end
    if (!write && read)
	begin
		busy_wait <= 1;
		// artificially delay 100 cycles
		repeat (100) begin
		@ (posedge clk) ;
    	end
        read_data = memory_ram_q[address];
		busy_wait <= 0;
	end
end
 
endmodule




//////////////////SIMULATION//////////////////


module processor();		
	reg clk,reset,reset_reg;
	wire [31:0] Read_addr,Instruction;
	wire [7:0] OPCODE,Immediate,OUT1,OUT2,RESULT,twosComplement,mux2_out,mux1_out;
	wire [2:0] alu_select,OUT1addr,OUT2addr,INaddr;
	wire mux1,mux2;

	p_counter pc(clk,reset,Read_addr);
	instruction_mem ins_mem(Read_addr,Instruction);
	instruction_reg ins_reg(Instruction,clk,OPCODE,OUT1addr,OUT2addr,INaddr,Immediate);
	cu cu(OPCODE,alu_select,mux1,mux2);
	reg_file regf(RESULT,OUT1,OUT2,clk,reset_reg,INaddr,OUT1addr,OUT2addr);
	twos_comp t_cmp(OUT1,twosComplement);
	mux m2(OUT1,twosComplement,mux2_out,mux2);
	mux m1(Immediate,mux2_out,mux1_out,mux1);
	ALU alu(RESULT,mux1_out,OUT2,alu_select);
	data_mem datamem(clk,reset,read,write,address,RESULT,read_data,busy_wait);


	always #10 clk = ~clk;

	initial 
	begin
		$dumpfile("wavedata.vcd");
		$dumpvars(0,processor);	
		clk = 0;
		reset = 1;
		reset = 0;
		reset_reg = 1;
		reset_reg = 0;
		#160 $finish;
	end

	initial begin
		while(1) begin
		#20 $display("%h %d ",Instruction,RESULT);
		end
	end
endmodule




/*
module simulate2;

	reg clk;
	reg [2:0] INaddr;
	reg [7:0] IN;
	reg [2:0] OUT1addr;
	wire [7:0] OUT1;
	reg [2:0] OUT2addr;
	wire [7:0] OUT2,OUT3,OUT4;
	
	reg [2:0] Select;
	wire [7:0] Result;	
	
	CU control(instruction, OUT1addr, OUT2addr, INaddr);

	regfile8x8a regfile(clk,INaddr,IN,OUT1addr,OUT1,OUT2addr,OUT2);
	alu ALU1(Result,OUT1,OUT2,Select);
	
	regfile8x8a regfile2(clk,INaddr,Result,OUT1addr,OUT3,OUT2addr,OUT4);

	
	initial
	
	
	begin
	
	clk = 1;
	instruction = 32'h00000001;
	IN = 4;
	clk = 0;
	#2
	
	#2
	$display ("OUT1 = %d",OUT1);	
	
	
	clk = 1;
	
	IN = 6;
	clk = 0;
	#2
	
	#2
	$display ("OUT2 = %d",OUT2);
	
	Select = 2;
	#2
	//$display ("result = %d",Result);
	
	clk = 1;
	
	clk = 0;
	#2
	
	#2
	$display ("Result = %d",OUT4);	
		

	
	
	
	end


endmodule






/*

module simulate;
	reg clk;
	reg [2:0] INaddr;
	reg [7:0] IN;
	reg [2:0] OUT1addr;
	wire [7:0] OUT1;
	reg [2:0] OUT2addr;
	wire [7:0] OUT2;
	
	
	regfile8x8a regfile(clk,INaddr,IN,OUT1addr,OUT1,OUT2addr,OUT2);
	
	initial
	
	begin
	
	clk = 1;
	INaddr = 3;
	IN = 4;
	clk = 0;
	#2
	OUT1addr = 3;
	#2
	$display ("OUT1 = %d",OUT1);
	#2
	clk = 1;
	INaddr = 4;
	IN = 2;
	clk = 0;
	#2
	OUT2addr = 4;
	#2
	$display ("OUT2 = %d",OUT2);
	#2
	clk = 1;
	INaddr = 5;
	IN = OUT1+OUT2;
	clk = 0;
	#2
	OUT2addr = 5;
	#2
	$display ("OUT2 = %d",OUT2);
	
	
	
	
	
	end


endmodule

*/


/*



module simulate;
	reg [7:0] DATA1,DATA2;
	reg [2:0] Select;
	wire [7:0] Result;

	alu ALU1(Result,DATA1,DATA2,Select);
	
	initial
	
	begin
	
	DATA1 = 4'b0110;
	DATA2 = 4'b0010;
	Select = 2;
	#10
	$display ("Answer is %b",Result);
	
	$finish; 

	end
endmodule 

*/

