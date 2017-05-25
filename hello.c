#include  <stdio.h>
#include  <stdlib.h>
#include  <dirent.h>
int main(int  argc,  char  *argv[])
{
  DIR  *dirp;
  struct  dirent  *dp;
  dirp = opendir(argv[1]);//打开目录流 
  while (  (dp=readdir(dirp) ) != NULL )//读取目录中的下一个目录项
｛
    printf(“inode number=%d\t”, dp->d_ino);//输出目录项中的文件inode号
    printf(“name=%s\n”, dp->d_name);//输出目录项中的文件名称
｝ 
closedir(dirp);//关闭目录流
return 0;
}
