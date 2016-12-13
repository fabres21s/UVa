import java.util.Scanner;

/**
*	1237 - Expert Enough?
*
*
*	Submision:	16894546
*	Date:		2016-02-24 01:05:42
*	Runtime:	0.612
*	Ranking:	1336
*/
public class Main1237 {

	/**
	 * - Simulación
	 * 
	 * De un conjunto de registros (marca, menor y
	 * mayor) y un número dado, determinar la marca de ese rango, si no hay o hay
	 * varias, indeterminado
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		while (testCases-- > 0) {
			int registros = input.nextInt();
			Record[] records = new Record[registros];

			for (int i = 0; i < registros; i++) {
				Record record = new Record();
				record.setMarca(input.next());
				record.setMenor(input.nextInt());
				record.setMayor(input.nextInt());
				records[i] = record;
			}
			int querys = input.nextInt();

			for (int i = 0; i < querys; i++) {
				int value = input.nextInt();
				String marca = "UNDETERMINED";
				for (Record r : records) {
					if (value >= r.getMenor() && value <= r.getMayor()) {
						if (marca.equals("UNDETERMINED")) {
							marca = r.getMarca();
						} else {
							marca = "UNDETERMINED";
							break;
						}
					}
				}
				System.out.println(marca);

			}
			if (testCases > 0) {
				System.out.println();
			}
		}
		input.close();
	}

}

class Record {
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getMenor() {
		return menor;
	}

	public void setMenor(int menor) {
		this.menor = menor;
	}

	public int getMayor() {
		return mayor;
	}

	public void setMayor(int mayor) {
		this.mayor = mayor;
	}

	private String marca;
	private int menor;
	private int mayor;
}
