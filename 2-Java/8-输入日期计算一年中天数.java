package extra;

import java.util.Scanner;

public class Extra_3 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("month=");
		int month = scan.nextInt();
		if (month > 12 || month < 1) {
			System.out.println("月份输入错误");
		} else {
			System.out.print("day=");
			int day = scan.nextInt();
			int days = 0;
			if (day > 31 || day < 1) {
				System.out.println("输入错误");
			} else {
				switch (month) {
				case 12:
					days += 30;
				case 11:
					days += 31;
				case 10:
					days += 30;
				case 9:
					days += 31;
				case 8:
					days += 31;
				case 7:
					days += 30;
				case 6:
					days += 31;
				case 5:
					days += 30;
				case 4:
					days += 31;
				case 3:
					days += 28;
				case 2:
					days += 31;
				case 1:
					days += day;
				}

				if (days > 365) {
					System.out.println("你输入的已经超过了365天了");
				} else {
					System.out.println(month + "月" + day + "日是今年的第" + days + "天");
				}
			}
		}
	}
}
