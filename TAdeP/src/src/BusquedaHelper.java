package src;

public class BusquedaHelper extends Busqueda<ContenedorHelper> {

	public BusquedaHelper(String referencia) {
		this.referencia = referencia;
		this.valor = referencia;
	}

	public BusquedaHelper(Class<?> tipo) {
		this.tipo = tipo;
		this.valor = tipo.getSimpleName();
	}

	@Override
	public boolean buscasPorReferencia(ContenedorHelper helper) {
		return helper.getReferencia().equalsIgnoreCase(this.referencia);
	}

	@Override
	public boolean buscasPorTipo(ContenedorHelper helper) {
		return helper.getTipo().equals(this.tipo);
	}

}
