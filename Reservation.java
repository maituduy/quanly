import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reservation {
	private String reservationNumber;

	public Reservation(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	void print() {
		System.out.println("reservationNumber = " + reservationNumber);
	}
	double getDueWithDiscount() throws FileNotFoundException {
		// read file
		File file = new File("C:\\Users\\mxw\\IdeaProjects\\Datcho\\src\\input.txt");
		Scanner scanner = new Scanner(file);
		String content = scanner.useDelimiter("\\Z").next();

		// string to array
		String[] tmp = content.split(Pattern.quote("."));
		String[] str = tmp[Integer.parseInt(this.reservationNumber)-1].split(Pattern.quote("\n"));
		for ( int i = 0;i<str.length;i++)
			str[i] = str[i].trim();
		int so_client = Integer.parseInt(str[1]); // tong so khach hang
		ArrayList<Client> clients = new ArrayList<>();
		int[] values = new int[so_client];
		int j =0;

		// doc du lieu cac khach hang
		for (int i = 2; i<2+so_client;i++) {
			tmp = str[i].split(Pattern.quote("|"));
			for (int k = 0;k<Type.values().length;k++)
				if (Type.values()[k].toString().equals(tmp[1]))
				{
					// ghi gia tri cho cac type, gold = 2,silver = 1,normal = 0;
					switch (Type.values()[k].toString()){
						case "gold" : {values[j] = 2;break;}
						case "silver" : {values[j] = 1;break;}
						case "normal" : {values[j] = 0;break;}
					}
					j++;
					clients.add(new Client(tmp[0],Type.values()[k]));
					break;
				}
		}
		Payment payment = new Payment(Double.parseDouble(str[2+so_client])); // so tien phai tra
		IntSummaryStatistics stat = Arrays.stream(values).summaryStatistics();
		int max = stat.getMax(); // max cua mang values (lay Type co gia tri lon nhat de giam gia)
		return payment.getAmount()-(payment.getAmount()*max/10); // so tien phai tra sau khi giam gia
	}
}
