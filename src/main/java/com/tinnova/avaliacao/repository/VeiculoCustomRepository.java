package com.tinnova.avaliacao.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tinnova.avaliacao.dto.VeiculoPorDecada;
import com.tinnova.avaliacao.dto.VeiculoPorFabricante;
import com.tinnova.avaliacao.model.Veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class VeiculoCustomRepository {

	private final EntityManager em;

	public VeiculoCustomRepository(EntityManager em) {
		this.em = em;
	}

	public List<VeiculoPorFabricante> findVeiculosPorFabricante() {
		String jpql = "SELECT marca, count(veiculo) FROM Veiculo GROUP BY marca";

		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

		List<Object[]> result = query.getResultList();
		List<VeiculoPorFabricante> veiculoPorFabricante = new ArrayList<VeiculoPorFabricante>();

		for (Object[] object : result) {
			veiculoPorFabricante.add(new VeiculoPorFabricante((String) object[0], (Long) object[1]));
		}
		return veiculoPorFabricante;
	}

	public List<VeiculoPorDecada> findVeiculosPorDecada() {
		String jpql = "SELECT CASE " 
				+ "			WHEN ano BETWEEN 1990 and 1999 then 'Década 1990' "
				+ "    		WHEN ano BETWEEN 2000 and 2009 then 'Década 2000' "
				+ "			WHEN ano BETWEEN 2010 and 2019 then 'Década 2010' "
				+ "    		WHEN ano BETWEEN 2020 and 2029 then 'Década 2020' " + "    		ELSE 'Década antiga' "
				+ "    		END AS Decada," + "    		Count(veiculo)" + "		FROM Veiculo" + "		GROUP BY"
				+ "		  CASE" + "			WHEN ano BETWEEN 1990 and 1999 then 'Década 1990'"
				+ "			WHEN ano BETWEEN 2000 and 2009 then 'Década 2000'"
				+ "			WHEN ano BETWEEN 2010 and 2019 then 'Década 2010'"
				+ "			WHEN ano BETWEEN 2020 and 2029 then 'Década 2020'" + "			ELSE 'Década antiga'"
				+ "			END";

		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

		List<Object[]> result = query.getResultList();
		List<VeiculoPorDecada> veiculoPorDecada = new ArrayList<VeiculoPorDecada>();

		for (Object[] object : result) {
			veiculoPorDecada.add(new VeiculoPorDecada((String) object[0], (Long) object[1]));
		}
		return veiculoPorDecada;

	}
	
	public List<String> findCarrosRegistradosUltimaSemana(Date dataInicial, Date dataFinal){
		String jpql = " SELECT veiculo FROM Veiculo WHERE created BETWEEN :dataInicial and :dataFinal ";
		
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
	
		List<Object[]> result = query.getResultList();
		List<String> carros = new ArrayList<String>();
		
		for(Object[] object : result) {
			carros.add((String) object[0]);
		}
		return carros;
	}

}
