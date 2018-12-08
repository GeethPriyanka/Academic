module ALU(RESULT,DATA1,DATA2,SELECT);	//arithamtic and logic unit

	input [7:0] DATA1,DATA2;
	input [2:0] SELECT;
	output [7:0] RESULT;
	reg RESULT;

	always @(DATA1,DATA2,SELECT) begin
		case(SELECT)
			3'b000:RESULT = DATA1;			//loadi,mov
			3'b001:RESULT = DATA1 + DATA2;	//add,sub
			3'b010:RESULT = DATA1 & DATA2;	//and
			3'b011:RESULT = DATA1 | DATA2;	//or
			default:RESULT =1'd0;			//unused select combination makes output 0
		endcase
	end

endmodule

module reg_file(IN,OUT1,OUT2,clk,RESET,INaddr,OUT1addr,OUT2addr); 		//register file
	input [2:0] OUT1addr,OUT2addr,INaddr;
	input [7:0] IN;
	input clk,RESET;
	output [7:0] OUT1,OUT2;
	reg OUT1,OUT2;
	integer i;
	reg [7:0] regFile [0:7];	//regfile
	
	// reg [7:0] reg0, reg1, reg2, reg3,reg4,reg5,reg6,reg7;

	// assign OUT1 = OUT1addr == 0 ? reg0 :
	// OUT1addr == 1 ? reg1 :
	// OUT1addr == 2 ? reg2 :
	// OUT1addr == 3 ? reg3 :
	// OUT1addr == 4 ? reg4 :
	// OUT1addr == 5 ? reg5 :
	// OUT1addr == 6 ? reg6 :
	// OUT1addr == 7 ? reg7 : 0;

	// assign OUT2 = OUT2addr == 0 ? reg0 :
	// OUT2addr == 1 ? reg1 :
	// OUT2addr == 2 ? reg2 :
	// OUT2addr == 3 ? reg3 :
	// OUT2addr == 4 ? reg4 :
	// OUT2addr == 5 ? reg5 :
	// OUT2addr == 6 ? reg6 :
	// OUT2addr == 7 ? reg7 : 0;

	// always @(negedge clk) begin
	// case(INaddr)
	// 	3'b000:reg0 = IN;
	// 	3'b001:reg1 = IN;
	// 	3'b010:reg2 = IN;
	// 	3'b011:reg3 = IN;
	// 	3'b100:reg4 = IN;
	// 	3'b101:reg5 = IN;
	// 	3'b110:reg6 = IN;
	// 	3'b111:reg7 = IN;
	// 	endcase
	// end 

	always @(posedge clk) begin 	//reading from register file
		OUT1 = regFile[OUT1addr];
		OUT2 = regFile[OUT2addr];
	end

	always @(negedge clk) begin 	//writing to the register file
		regFile[INaddr] = IN;
	end

	always @(RESET) begin 		//resetting register file
		for(i=0; i<8;i=i+1)regFile[i] = 0;
	end

endmodule

module twos_comp(IN,COMP);		//twos complement unit
	input [7:0] IN;
	output [7:0] COMP;

	assign COMP = -IN;
endmodule

module mux(IN1,IN2,OUT,SELECT);		//multiplexer
	input [7:0] IN1,IN2;
	input SELECT;
	output [7:0] OUT;

	assign OUT = (SELECT) ? IN2 : IN1 ;
	
endmodule

module p_counter(clk,reset,Read_addr);		//program counter
	input clk,reset;
	output [31:0] Read_addr;
	reg Read_addr;

	always @(reset) begin
		Read_addr = 32'h00000000;
	end

	always @(negedge clk) begin
		Read_addr = Read_addr + 1;
	end
endmodule

module cu(opcode,alu_select,mux1,mux2);	//control unit
	input [7:0] opcode;
	output [2:0] alu_select;
	output mux1,mux2;
	reg mux1,mux2;
	
	assign alu_select = opcode [2:0];
	always @(opcode) begin
		case(opcode)
			8'b00000000:begin 		//mov
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
			8'b00001000:begin 		//loadi
				mux1 = 1'b0;
				end
			8'b00000001:begin 		//add
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
			8'b00001001:begin 		//sub
				mux1 = 1'b1;
				mux2 = 1'b1;
				end
			8'b00000010:begin 		//and
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
			8'b00000011:begin 		//or
				mux1 = 1'b1;
				mux2 = 1'b0;
				end
		endcase
			
	end
endmodule

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

module instruction_reg(Instruction,clk,OPCODE,OUT1addr,OUT2addr,INaddr,Immediate);
	input [31:0] Instruction;
	input clk;
	output[2:0] OUT1addr,OUT2addr,INaddr;
	output [7:0] OPCODE,Immediate;
	// reg OPCODE,OUT1addr,OUT2addr,INaddr,Immediate;

	// always @(negedge clk) begin
	// 	OUT1addr = Instruction[2:0];
	// 	OUT2addr = Instruction[10:8];
	// 	INaddr = Instruction[18:16];
	// 	Immediate = Instruction[7:0];
	// 	OPCODE = Instruction[31:24];
	// end

	assign OUT1addr = Instruction[2:0];
	assign OUT2addr = Instruction[10:8];
	assign INaddr = Instruction[18:16];
	assign Immediate = Instruction[7:0];
	assign OPCODE = Instruction[31:24];
endmodule

module testbed_processor();		//testbed for processor
	reg clk,reset,reset_reg;
	wire [31:0] Read_addr,Instruction;
	wire [7:0] OPCODE,Immediate,OUT1,OUT2,RESULT,twosComplement,mux2out,mux1out;
	wire [2:0] alu_select,OUT1addr,OUT2addr,INaddr;
	wire mux1,mux2;

	p_counter c(clk,reset,Read_addr);
	instruction_mem mem(Read_addr,Instruction);
	instruction_reg r1(Instruction,clk,OPCODE,OUT1addr,OUT2addr,INaddr,Immediate);
	cu cu1(OPCODE,alu_select,mux1,mux2);
	reg_file regf(RESULT,OUT1,OUT2,clk,reset_reg,INaddr,OUT1addr,OUT2addr);
	twos_comp tcmp(OUT1,twosComplement);
	mux m2(OUT1,twosComplement,mux2out,mux2);
	mux m1(Immediate,mux2out,mux1out,mux1);
	ALU alu(RESULT,mux1out,OUT2,alu_select);


	always #10 clk = ~clk;

	initial begin
		$dumpfile("wavedata.vcd");
		$dumpvars(0,testbed_processor);	
		clk = 0;
		reset = 1;
		reset = 0;
		reset_reg = 1;
		reset_reg = 0;
		#160 $finish;
	end

	initial begin
		while(1) begin
		#20 $display("%h a1=%d 	a2=%d 	ina=%d 	1=%d 	2=%d 	im=%d 	m1=%d 	m2=%d 	%d",Instruction,OUT1addr,OUT2addr,INaddr,OUT1,OUT2,Immediate,mux1out,mux2out,RESULT);
		end
	end
endmodule









// module testbed_insreg();		//testbed for instruction register
// 	reg clk,reset;
// 	wire [31:0] Read_addr,Instruction;
// 	wire [7:0] OPCODE,Immediate;
// 	wire [2:0] OUT1addr,OUT2addr,INaddr;

// 	p_counter c(clk,reset,Read_addr);
// 	instruction_mem mem(Read_addr,Instruction);
// 	instruction_reg r1(Instruction,clk,OPCODE,OUT1addr,OUT2addr,INaddr,Immediate);

// 	always #10 clk = ~clk;

// 	initial begin
// 		$dumpfile("wavedata.vcd");
// 		$dumpvars(0,testbed_insreg);	
// 		clk = 0;
// 		reset = 1;
// 		reset = 0;
// 		#180 $finish;
// 	end

// 	initial begin
// 		while(1) begin
// 		#20 $display("%h %b %h %h %h %h",Instruction,OPCODE,OUT1addr,OUT2addr,INaddr,Immediate);
// 		end
// 	end
// endmodule









// module testbed_insmem();			//testbed of instruction memomry
// 	reg clk,reset;
// 	wire [31:0] Read_addr,Instruction;


// 	p_counter c(clk,reset,Read_addr);
// 	instruction_mem mem(Read_addr,Instruction);

// 	always #10 clk = ~clk;

// 	initial begin
// 		$dumpfile("wavedata.vcd");
// 		$dumpvars(0,testbed_insmem);	
// 		clk = 0;
// 		reset = 1;
// 		reset = 0;
// 		#160 $finish;
// 	end

// 	initial begin
// 		while(1) begin
			
// 		#20 $display("%h",Instruction);
// 		end
// 	end
// endmodule








// module testbed_counter();		//testbed for program counter
// 	reg clk,reset;
// 	wire [31:0] Read_addr;

// 	p_counter c(clk,reset,Read_addr);

// 	always #10 clk = ~clk;

// 	initial begin
// 		$dumpfile("wavedata.vcd");
// 		$dumpvars(0,testbed_counter);	
// 		clk = 0;
// 		reset = 1;
// 		reset = 0;
// 		#1000 $finish;
// 	end

// 	initial begin
// 		while(1) begin
			
// 		#20 $display("%d",Read_addr);
// 		end
// 	end
// endmodule







// module testbed_mux();		//testbed for multiplexer
// 	reg [7:0] a = 8'b00000010, b = 8'b11001010;
// 	reg i = 1'b1;
// 	wire [7:0] o;
// 	mux m(a,b,o,i);
// 	initial begin
// 		#5
// 	$display("%d %d %d",a,b,o);
// 	end
// endmodule








// module testbed_twos();		//testbed for twos complement unit
// 	reg [7:0] a = 8'b00000010;
// 	wire [7:0] o;
// 	twos_comp t(a,o);
// 	initial begin
		
// 	$display("%b %b",a,o);
// 	end
// endmodule









// module regfile_testbed();		//testbed of register file
// 	reg [2:0] OUT1addr,OUT2addr,INaddr;
// 	reg [7:0] IN;
// 	reg clk,RESET;
// 	wire [7:0] OUT1,OUT2;
// 	integer i;

// 	always #10 clk = ~clk;

// 	reg_file r1(IN,OUT1,OUT2,clk,RESET,INaddr,OUT1addr,OUT2addr);

// 	initial
// 	begin
// 		$dumpfile("wavedata.vcd");
// 		$dumpvars(0,regfile_testbed);	
// 		clk = 1'b1;
// 		#5 RESET = 1'b1;
// 		RESET = 1'b0;
// 		#20

// 		for(i=0;i<8;i = i+1)begin
// 			#20 IN = i;
// 			INaddr = i;
// 		end
// 		for(i=0;i<7;i = i+1)begin
// 			#10 OUT1addr = i;
// 			OUT2addr = i+1;
// 			#10 $display("%d %d",OUT1, OUT2);
// 		end
		

// 		$finish;
// 	end
// endmodule








// module alu_testbest();		//testbed of ALU
// 	reg [7:0] data1,data2;
// 	reg [2:0] SELECT;
// 	wire [7:0] out;

// 	ALU alu(out,data1,data2,SELECT);

// 	initial
// 		begin
// 		data1 = 8'b10101011;
// 		data2 = -8;
// 		#5 SELECT = 3'b000;
// 		#5 $display("%d %d %b %d",data1,data2,SELECT,out);
		
// 		#5 SELECT = 3'b001;
// 		#5 $display("%d %d %b %d",data1,data2,SELECT,out);
// 		#5 SELECT = 3'b010;
// 		#5 $display("%b %b %b %b",data1,data2,SELECT,out);
// 		#5 SELECT = 3'b011;
// 		#5 $display("%b %b %b %b",data1,data2,SELECT,out);
// 		#5 SELECT = 3'b101;
// 		#5 $display("%b %b %b %b",data1,data2,SELECT,out);
// 		end		

// endmodule