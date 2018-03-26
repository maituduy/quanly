import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		File file = new File("C:\\Users\\mxw\\IdeaProjects\\Datcho\\src\\input.txt");
		Scanner scanner = new Scanner(file);
		String content = scanner.useDelimiter("\\Z").next();
		String[] tmp = content.split(Pattern.quote("."));
		String[] str = tmp[Integer.parseInt(this.reservationNumber)-1].split(Pattern.quote("\n"));
		for ( int i = 0;i<str.length;i++)
			str[i] = str[i].trim();
		int so_client = Integer.parseInt(str[1]);
		ArrayList<Client> clients = new ArrayList<>();
		int[] values = new int[so_client];
		int j =0;
		for (int i = 2; i<2+so_client;i++) {
			tmp = str[i].split(Pattern.quote("|"));
			for (int k = 0;k<Type.values().length;k++)
				if (Type.values()[k].toString().equals(tmp[1]))
				{
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
		Payment payment = new Payment(Double.parseDouble(str[2+so_client]));
		int max = Integer.MIN_VALUE;
		for (int i:
				values) {
			if (i>max) max = i;
		}
		return payment.getAmount()-(payment.getAmount()*max/10);
	}
}
