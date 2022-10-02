package colaCircular;

public interface ColaCircular{
	
	public Object desencolar();

	public boolean encolarFin(Object elem);
	// Encola un elemento al inicio de la cola
	public boolean encolarInic(Object elem);
	// Desencola un elemento al final de la cola
	public boolean desencolarFin();
	// Encola un elemento al final de la cola
	@Override
	public String toString();
}