import java.util.ArrayList;

import DistantMatrix.DistanceMatrix;

public class Solucao {

	private int distancia;
	private ArrayList<String> cityList;

	public Solucao(ArrayList<String> cityList) {
		DistanceMatrix d = new DistanceMatrix("Cities.txt");
		this.cityList = cityList;
		for (int i = 0; i < cityList.size() - 1; i++) {
			distancia += d.distance(cityList.get(i), cityList.get(i + 1));
		}
		distancia += d.distance(cityList.get(0), cityList.get(cityList.size() - 1));
	}

	public int getDistance() {
		return distancia;
	}
	public ArrayList<String> getSolucao() {
		return cityList;
	}

}
