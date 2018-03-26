import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReservationTester {
	public static void main(String[] args) {
        System.out.println("Nhap ma dat cho : ");
        try {
            String n  = (new Scanner(System.in)).nextLine();
            Reservation reservation = new Reservation(n);
            System.out.println(reservation.getDueWithDiscount());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ma khong hop le");
        }
        catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        }
	}
}
