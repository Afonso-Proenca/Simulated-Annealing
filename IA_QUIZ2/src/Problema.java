import java.util.ArrayList;

public class Problema {

	private Solucao corrente;
	private Solucao proximo;
	private Solucao melhor;
	private double temperatura;
	private int n_iter;

	public Problema(ArrayList<String> cityList) {

		corrente = new Solucao(cityList);
		melhor = corrente;
		proximo = null;
		temperatura = 100;
		n_iter = 1000;
		System.out.println("Solução inicial: " + corrente.getDistance());
	

	}


	private void decaimentoTemperatura() {
		temperatura *= 0.95;
	}

	private boolean criterio_de_paragem() {
		return temperatura < 0.00000000001;
	}
	private int var_n_iter() {
		return n_iter++;
	}
		
	public Solucao simulatedAnnealing(ArrayList<String> cityList) {

		for (int j = 1; j < n_iter; j++) {
			for (int i = 1; i < cityList.size() * 5; i++) {
				proximo = vizinho(corrente.getSolucao());
				int distanceDiference = proximo.getDistance() - corrente.getDistance();
				if (distanceDiference < 0) {
					corrente = proximo;
					if (corrente.getDistance() < melhor.getDistance()) {
						melhor = corrente;
					}
				} else {
					double prob = Math.random();
					double exp = Math.exp(((-distanceDiference) / temperatura));
					if (prob < exp)
						corrente = proximo;
				}
			}
			
			if (criterio_de_paragem()) {
				return melhor;
			}
			n_iter = var_n_iter();
			decaimentoTemperatura();
		}
	
		return melhor;
	}

	public static Solucao vizinho(ArrayList<String> cityList) {
		String[] s = new String[cityList.size()];
		for (int h = 0; h < cityList.size(); h++)
			s[h] = cityList.get(h);
		ArrayList<String> aux = new ArrayList<String>();
		int i = (int) (Math.random() * 1000 % cityList.size());
		int j = (int) (Math.random() * 1000 % cityList.size());
		int inicio = 0;
		int fim = 0;
		if (i > j) {
			fim = i;
			inicio = j + 1;
		} else if (i < j) {
			fim = j;
			inicio = i + 1;
		} else if (i == j) {
			fim = j;
			inicio = i;
			return new Solucao(cityList);
		}
		while (Math.abs(fim - inicio) >= 1) {
			s[inicio] = cityList.get(fim);
			s[fim] = cityList.get(inicio);
			inicio++;
			fim--;
			if (inicio > fim)
				break;
		}
		for (int h = 0; h < cityList.size(); h++)
			aux.add(s[h]);

		return new Solucao(aux);
	}

}
