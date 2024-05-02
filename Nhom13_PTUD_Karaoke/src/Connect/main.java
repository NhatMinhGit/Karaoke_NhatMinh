package connect;

import javax.persistence.Persistence;

public class main {
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("KaraokeMMM");
		System.out.println("Success");
	}
}
