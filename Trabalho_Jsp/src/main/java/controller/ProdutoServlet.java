package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


import model.Produto;

/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Produto> lista = new ArrayList<>();
	
	@Override
	public void init() throws ServletException {

		lista.add(new Produto(1, "mouse sem fio", 25.50));
		lista.add(new Produto(2, "monitor 29", 1200));
		lista.add(new Produto(3, "teclado", 30.99));

	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String troca = request.getParameter("troca");

		// Se pedir novo produto, abre o formulário
		if(troca != null && troca.equals("novo")) {
			request.getRequestDispatcher("CadastroProduto.jsp").forward(request, response);
			return;
		}
		
		//Adicionar a lista ao request
		request.setAttribute("minhaLista", lista);
				
		request.getRequestDispatcher("Produto.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    String nome = request.getParameter("nome");
	    double preco = Double.parseDouble(request.getParameter("preco"));
	    boolean idExiste = false;
	    
	    
	    for(Produto p : lista) {
	    	//verifica se o produto já existe
			if(p.getId() == id) {
				idExiste = true;
				break;
			}
		}
	    
	    if (idExiste) {

			// mensagem de erro
			request.setAttribute("erro", "Já existe um produto com esse ID!");

		} else {

			Produto novo = new Produto(id, nome, preco);
			// adiciona o novo produto
		    lista.add(novo);

		}

	    request.setAttribute("minhaLista", lista);

	    request.getRequestDispatcher("Produto.jsp").forward(request, response);
	}

}
