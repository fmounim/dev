package jf;

import org.apache.commons.collections4.Predicate;

public class MonPredicat<T> implements Predicate<Object> {

	public MonPredicat() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean evaluate(Object arg0) {
		System.out.println("Valeur: " + arg0);
		int x = (int) Integer.parseInt((String)arg0);
		// TODO Auto-generated method stub
		if (x< 50){
			return true;
		}
		else{
		return false;
		}
	}

}