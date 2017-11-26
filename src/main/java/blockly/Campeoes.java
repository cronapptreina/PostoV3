package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Campeoes {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Campeoes
	public static Var CarrosCampeoes() throws Exception {
		return new Callable<Var>() {

			private Var lista_retorno = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;
			private Var valor_parcial = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(Var.valueOf("Calcula Carros Campeoes").getObjectAsString());
				lista_retorno = cronapi.list.Operations.newList();
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.Abastecimento"),
						Var.valueOf(
								"select a.carro.marca, a.carro.modelo, SUM(a.valor)/SUM(a.km) from Abastecimento a  group by a.carro.marca, a.carro.modelo  order by SUM(a.valor)/SUM(a.km) asc"),
						Var.VAR_NULL);
				while (cronapi.database.Operations.hasElement(consulta).getObjectAsBoolean()) {
					System.out.println(Var.valueOf("Registro").getObjectAsString());
					valor_parcial = cronapi.map.Operations.createObjectMapWith(
							Var.valueOf("marca",
									cronapi.database.Operations.getField(consulta, Var.valueOf("this[0]"))),
							Var.valueOf("modelo",
									cronapi.database.Operations.getField(consulta, Var.valueOf("this[1]"))),
							Var.valueOf("customedio_km",
									cronapi.database.Operations.getField(consulta, Var.valueOf("this[2]"))));
					System.out.println(valor_parcial.getObjectAsString());
					cronapi.list.Operations.addLast(lista_retorno, valor_parcial);
					cronapi.database.Operations.next(consulta);
				} // end while
				return lista_retorno;
			}
		}.call();
	}

}
