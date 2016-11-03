package No4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException {
		//处理获取到的输入，处理开始时间和结束时间
		Locale locale = Locale.US;// 提供了一些方便的常量，可用这些常量为常用的语言环境创建 Locale 对象,创建了一个 Locale美国 对象
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale); //定义时间格式
		Date beginDate = inputFormat.parse(args[0]); // 开始时间
		Date endDate = inputFormat.parse(args[1]); // 结束时间
		long lineTimestart = beginDate.getTime(); // 获取开始时间到参考时间的毫秒时间值
		long lineTimestop = endDate.getTime(); // 获取结束时间到参考时间的毫秒时间值
		
		Scanner scanner = new Scanner(System.in);
		// 设置文件数据放置路径
		String filePath = "./access.log";
		// 正则表达式获取数据中所需数据
		String pattern = "(\\d+.\\d+.\\d+.\\d+) ([^ ]* [^ ]*) \\[([^ ]*) ([^ ]*)] \\\"([^ ]+) ([^ ]*) ([^ ]+\") (\\d+) (\\d+) ([^ ]*) (\".*\")";
		Pattern r = Pattern.compile(pattern); // 创建 Pattern 对象
		
		String strIp = null; //初始化访问IP为空
		String strTime = null; //初始化访问时间为空
		while (scanner.hasNext()) {
			// 对每行进行处理
			String line = scanner.nextLine();
			Matcher m = r.matcher(line);//把获取的数据放入正则表达式中筛选
			// 切分获取IP，Time
			if (m.find()) {
				strIp = m.group(1);
				strTime = m.group(3);
				Date lineDate = null;  //初始化获取数据时间为空
				long lineTimestamp;  //初始化获取数据时间与参考点时间计算的变量
				lineDate = inputFormat.parse(strTime);  //把获取的时间转换为设置格式的时间
				lineTimestamp = lineDate.getTime();     //计算获取的时间和参考点时间的差值
				// 判断获取时间是否在条件要求时间取件内，对在时间区间内的数据进行输出
				if(lineTimestamp >= lineTimestart && lineTimestamp <= lineTimestop)
				{
				System.out.println(strIp + "\t" + strTime);//输出IP和时间，以\t隔开
				}
			}
			
		}
	}
}
