#include <linux/init.h>
#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/list.h>
#include <linux/slab.h>
#include <linux/types.h>
#include <linux/sched.h>
#include <linux/sched/signal.h>


void DFS(struct task_struct *curr_task){	//Depth First Search Implementation

	struct task_struct *task;
	struct list_head *list;

	list_for_each(list, &curr_task->children) {			//Iterate through children
		task = list_entry(list, struct task_struct, sibling);		//Iterate through siblings
		/* task points to the next child in the list */
		printk("name: %s, pid: [%d], state: %li\n", task->comm, task->pid, task->state);
		DFS(task);

}

}

/* This function is called when the module is loaded. */
int simple_init(void)
{
printk(KERN_INFO "Adding Module \n");

DFS(&init_task);

return 0;
}

/* This function is called when the module is removed. */
void simple_exit(void)
{
printk(KERN_INFO "Removing Module \n");
}
/* Macros for registering module entry and exit points. */



module_init(simple_init);
module_exit(simple_exit);
MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Simple Module");
MODULE_AUTHOR("SGG");

