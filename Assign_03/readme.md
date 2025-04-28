mylinux@mylinuxserver:~/Downloads$ export MPJ_HOME=/home/mylinux/Downloads/mpj-v0_44

mylinux@mylinuxserver:~/Downloads$ ls $MPJ_HOME/lib

mylinux@mylinuxserver:~/Downloads$ javac -cp $MPJ_HOME/lib/mpj.jar ArrSum.java

mylinux@mylinuxserver:~/Downloads$ $MPJ_HOME/bin/mpjrun.sh -np 4 ArrSum


