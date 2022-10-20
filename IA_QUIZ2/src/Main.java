
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Main.execute_commands();
	}

	private static void execute_commands() {

		ArrayList<String> cityList = new ArrayList<String>(); 
		//String[] s = { "D", "F", "G", "J", "M", "P", "Q", "R" };
		//String[] s = { "A", "B", "F", "H", "I", "J", "K", "L", "M", "N", "P", "T", "U", "V", "W", "X", };
		String[] s = { "A", "B","C","D", "E" ,"F","G", "H", "I", "J", "K", "L", "M", "O", "P", "Q","S" , "T", "U", "V", "W", "X","Y","Z" };
		for (int i = 0; i < s.length; i++)
			cityList.add(s[i]);

		Problema p = new Problema(cityList);
		Solucao solucao = p.simulatedAnnealing(cityList);
		
		System.out.println("Melhor solução: " + solucao.getDistance());

	}

}
