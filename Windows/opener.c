#include <stdio.h>
#include <windows.h>
int main(int argc, char *argv[])
{
	if(argc == 3)
	{
		ShellExecute(NULL, "open", argv[1], NULL, argv[2], SW_SHOWNORMAL);
		return 0;
	}
	return -1;
}