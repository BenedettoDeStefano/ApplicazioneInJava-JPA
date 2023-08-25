package ProgettoSettimana06.Interface;

public interface Subject {

	public void register(Observer observer);

	public void unregister(Observer observer);

	public void notifyObserversChanges();

}
