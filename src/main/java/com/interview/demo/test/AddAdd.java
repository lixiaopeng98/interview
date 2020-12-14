package com.interview.demo.test;

/**
 *
 */
public class AddAdd {

    public void addAddNum(){
        int i = 1;
        i++;
        System.out.println(i);
    }
// i++ 汇编语言
//         0: iconst_1               //将int类型的1压入栈
//         1: istore_1               //出栈一个变量放入局部变量表中下标为1的位置,下标为0的位置存放的是this指针,此时栈为空,
//         2: iload_1                //从局部变量表中取出下标为1(实际值此处为1)的变量压入操作数栈中
//         3: iinc          1, 1     //将局部变量表中下标为1的变量进行加1操作
//         6: istore_2               //出栈一个变量放入局部变量表中下标为2的位置,这一步没有对操作栈中的数进行操作,直接出栈到变量表中
//         7: getstatic     #6       //去常量池中引用"#6"符号引用的类与方法                 // Field java/lang/System.out:Ljava/io/PrintStream;
//         10: iload_2               //从局部变量表中取出下标为1(实际值此处为1)的变量压入操作数栈中
//         11: invokevirtual #7      //执行println方法               // Method java/io/PrintStream.println:(I)V
//         14: return
    // 1:入栈 10      2:入局部变量栈 10  3:从局部变量取出10 压入 操作栈 4:在操作栈中执行 ++  5:入局部变量栈
    public void numAddAdd(){
        int i = 1;
        ++i;
        System.out.println(i);
    }
// ++i 汇编语言
//         0: iconst_1            //将int类型的1压入栈
//         1: istore_1            //出栈一个变量放入局部变量表中下标为1的位置,下标为0的位置存放的是this指针,此时栈为空,
//         2: iinc          1, 1    //将局部变量表中下标为1的变量进行加1操作
//         5: iload_1                //从局部变量表中取出下标为1(实际值此处为2)的变量压入操作数栈中
//         6: istore_2            //出栈一个变量放入局部变量表中下标为2的位置,(实际值此处为2)
//         7: getstatic     #6    //去常量池中引用"#6"符号引用的类与方法               // Field java/lang/System.out:Ljava/io/PrintStream;
//         10: iload_2                //从局部变量表中取出下标为1(实际值此处为2)的变量压入操作数栈中
//         11: invokevirtual #7    //执行println方法                 // Method java/io/PrintStream.println:(I)V
//         14: return
    // 1:入栈 10      2:入局部变量栈 10  3:操作局部变量栈的10 ++  4:从局部变量栈中取出压入操作栈

    public static void main(String[] args) {
        new AddAdd().addAddNum();
        new AddAdd().numAddAdd();
    }
}
