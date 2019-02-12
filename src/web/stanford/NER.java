package web.stanford;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import nlp.stanford.App;

/**
 * Servlet implementation class NER
 */
public class NER extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	static StanfordCoreNLP pipeline;

	public void init(ServletConfig config) {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
		pipeline = new StanfordCoreNLP(props);
	}

	static {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = request.getParameter("input");
		System.out.println(data);
		App app = new App();
		String output = "";
		try {
			String text = data;
			System.out.println(data);
			Annotation document = new Annotation(text);
			pipeline.annotate(document);
			List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
			for (CoreMap sentence : sentences) {
				for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
					String word = token.get(CoreAnnotations.TextAnnotation.class);
					String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
					System.out.print(word);
					output += word;
					if (ne.equals("O") == false) {
						output = output + "(" + ne + ")";
					}
					output += " ";
				}
			}
			
			//output += ".";
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("output", output);
		request.setAttribute("input", data);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

}
