package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */

	+public class TimestampTransfer {   //创建类
 	@SuppressWarnings("resource")      //错误自动注释
 	public static void main(String[] args){    //主函数
 		Scanner scanner = new Scanner(System.in);   //创建一个Scanner输入
 		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //创建一个输入，格式是“年-月-日 时：分：秒”
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   //创建一个输出，格式是“年-月-日 时：分：秒”
 		while (scanner.hasNext()){  //循环获取输入，当没有下一个输入时结束
 			String line = scanner.nextLine();   //创建一个字符串变量，用于获取读入的数据
 			Date lineDate = null;      //创建一个日期变量，初始值为空
 			long lineTimestamp;     //创建一个长整型变量，用于存储时间的计算值
 			try {                    //捕获异常
 				lineDate = inputFormat.parse(line);     //把读取的字符串数据中的日期放入日期变量中
 				lineTimestamp = lineDate.getTime();    //把获取到的日期计算后赋值给长整型变量
 				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);  //输出获取的日期和计算后的时间值
 			} catch (ParseException e) {   //如果异常则输出下面错误
  				// TODO Auto-generated catch block
 -				e.printStackTrace();
			}
		}
	}
}
