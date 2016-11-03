package No4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReducerOfIPFilter {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Locale locale = Locale.US;// 提供了一些方便的常量，可用这些常量为常用的语言环境创建 Locale 对象,创建了一个 Locale美国 对象
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale); //定义时间格式
		String strIp = null; //初始化访问IP为空
		String strTime = null; //初始化访问时间为空
		Set<String> set =new HashSet();//哈希定义集合
		String pattern = "(\\d+.\\d+.\\d+.\\d+)\t(.*)";//正则表达式获取MAP输入
		Pattern r = Pattern.compile(pattern); 
		while (scanner.hasNext()){
			// 对每行进行处理
			String line = scanner.nextLine();
			Matcher m = r.matcher(line);//把获取的数据放入正则表达式中筛选
			// 切分获取IP
			if (m.find()) {
				strIp = m.group(1);
			}
			set.add(strIp);	//加入集合
		}
		System.out.println(set.size());//输出计数
	}
}
