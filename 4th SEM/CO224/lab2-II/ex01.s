@ ARM Assembly - Exercise 1


	.text 	@ instruction memory
	.global main
	
main:
	
	sub sp, sp, #4
	str lr, [sp, #0]

		
	@ Store the result in r5

	@ ---------------------

	mov r5, #1



loop:
	
	
	@ load aguments and print
	ldr r0, =format
	mov r1,r5
	bl printf

	add r5, r5, #1

	cmp r5, #11

	blo loop


	@ ---------------------

	@ stack handling (pop lr from the stack) and return
	ldr lr, [sp, #0]
	add sp, sp, #4
	mov pc, lr
	
	.data	@ data memory
	
format: .asciz "This value is %d\n"
	
	
