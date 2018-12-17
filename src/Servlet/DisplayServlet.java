package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.Discipline;
import classe.Personne;
import classe.Recompense;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/personne")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ArrayList<Personne> personnes = new ArrayList<Personne>();
	static ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
	static ArrayList<Recompense> recompenses = new ArrayList<Recompense>();
	/**
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayServlet() throws ServletException {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		Personne p1 = new Personne("Merca", "yo");
		Personne p2 = new Personne("plop", "prenom1");
		Personne p3 = new Personne("plop2", "prenom2");
		Personne p4 = new Personne("plop3", "prenom3");
		p1.addRecompensesAndDiscipline(Recompense.MEDAILLE_ARGENT, Discipline.COURSE_100M);
		p2.addRecompensesAndDiscipline(Recompense.MEDAILLE_BRONZE, Discipline.SAUT_PERCHE);
		p3.addRecompensesAndDiscipline(Recompense.MEDAILLE_ARGENT, Discipline.SAUT_HAUTEUR);
		p4.addRecompensesAndDiscipline(Recompense.MEDAILLE_OR, Discipline.SAUT_PERCHE);
		personnes.add(p1);
		personnes.add(p2);
		personnes.add(p3);
		personnes.add(p4);
		disciplines.add(Discipline.COURSE_100M);
		disciplines.add(Discipline.SAUT_PERCHE);
		disciplines.add(Discipline.SAUT_HAUTEUR);
		
		recompenses.add(Recompense.MEDAILLE_OR);
		recompenses.add(Recompense.MEDAILLE_ARGENT);
		recompenses.add(Recompense.MEDAILLE_BRONZE);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String personne = request.getParameter("personne");
		HttpSession session = request.getSession();
		
		if(action == null && personne == null) {
			session.setAttribute("idPersonne", null);
			session.setAttribute("personnes", personnes);
			session.setAttribute("recompenses", recompenses);
			session.setAttribute("disciplines", disciplines);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else {
			if(action.equals("delete") && !personne.isEmpty()) {
				int id = Integer.parseInt(personne);
				personnes.remove(id);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				//request.setAttribute("personnes", personnes);
			}else if (action.equals("update")) {
				
				if(session.getAttribute("idPersonne")!=null) {
					session.setAttribute("err", null);
					String rec = request.getParameter("recompense");
					Recompense recompense = Recompense.valueOf(rec);
					String dis = request.getParameter("discipline");
					Discipline discipline = Discipline.valueOf(dis);
					Personne indexPersonne =personnes.get((int)session.getAttribute("idPersonne"));
					if(checkIfOk(recompense, discipline,indexPersonne)) {
						indexPersonne.addRecompensesAndDiscipline(recompense, discipline);
						session.setAttribute("personnes", personnes);
						session.setAttribute("idPersonne", null);
						response.sendRedirect(request.getContextPath() + "/index.jsp");
					}else {
						
				        session.setAttribute("err", "cette discipline et cette medaille sont deja affectées");
				        response.sendRedirect(request.getContextPath() + "/insert.jsp");
				    }
					
					
				}else {
					int id = Integer.parseInt(personne);
					session.setAttribute("idPersonne", id);
					response.sendRedirect(request.getContextPath() + "/insert.jsp");
					
				}
				

			}else if (action.equals("insert")) {
				String name = request.getParameter("name");
				String firstname = request.getParameter("firstname");
				String rec = request.getParameter("recompense");
				Recompense recompense = Recompense.valueOf(rec);
				String dis = request.getParameter("discipline");
				Discipline discipline = Discipline.valueOf(dis);
				Personne p = new Personne(name, firstname);
				p.addRecompensesAndDiscipline(recompense, discipline);
				personnes.add(p);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		}

		//response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean checkIfOk(Recompense rec , Discipline dis, Personne per) {
		boolean result = true;
		int index = 0;
		for (Recompense re : per.getRecompenses()) {
			if(per.getDisciplines().get(index) == dis && re == rec) {
				result = false;
			}
			index++;
		}
		
		return result;
	}
}
