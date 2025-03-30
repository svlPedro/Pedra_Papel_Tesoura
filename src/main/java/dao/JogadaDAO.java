package dao;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import entidades.Jogada;
import util.JPAUtil;

public class JogadaDAO {

	public static void save(Jogada jogada) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(jogada);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void update(Jogada jogada) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(jogada);
		em.getTransaction().commit();
		em.close();
	}
	

	public static void delete(Jogada jogada) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		jogada = em.find(Jogada.class, jogada.getId());
		em.remove(jogada);
		em.getTransaction().commit();
		em.close();
	}
	

	public static List<Jogada> listAll() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select j from Jogada j");
		List<Jogada> lista = q.getResultList();
		em.close();
		return lista;
	}
	
}
