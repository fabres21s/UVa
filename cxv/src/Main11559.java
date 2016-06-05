import java.util.Scanner;

/**
*	11559 - Event Planning
*
*
*	Submision:	17044777
*	Date:		2016-03-18 21:19:13
*	Runtime:	0.109
*	Ranking:	5489
*/
public class Main11559 {

	/**
	 * - Validaciones
	 */
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
         
         int persons, budget, hotels, weeks;
         int priceWeek;
         
         while (input.hasNext()) {
                 persons = input.nextInt();
                 budget = input.nextInt();
                 hotels = input.nextInt();
                 weeks = input.nextInt();
                 
                 
                 int price = Integer.MAX_VALUE;
                 for (int i = 0; i < hotels; i++) {
                         priceWeek = input.nextInt();
                         
                         boolean availableHotel = priceWeek * persons <= budget;
                         boolean availableBeds = false;
                         for (int j = 0; j <weeks; j++) {
                                 if ( input.nextInt() >= persons) {
                                         availableBeds = true;
                                         //no se puede usar este hotel, si las habitaciones no alcanzan
                                 }
                         }
                         
                         if (availableHotel && availableBeds) {
                                 price = Math.min(price, priceWeek*persons);
                         }
                 }
                 
                 if (price == Integer.MAX_VALUE) {
                         System.out.println("stay home");
                 } else {
                         System.out.println(price);
                 }
         }
	}
}
