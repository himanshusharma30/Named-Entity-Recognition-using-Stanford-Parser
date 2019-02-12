package nlp.stanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class App {

	
    public static void main(String data[])
    {
		String output="";
		System.out.println("point 1");
        Properties props=new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        System.out.println("point 2");
        StanfordCoreNLP pipeline=new StanfordCoreNLP(props);
        System.out.println("point 3");
       // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String text="Himanshu";
        Annotation document=new Annotation(text);
        pipeline.annotate(document);
        List<CoreMap> sentences=document.get(CoreAnnotations.SentencesAnnotation.class);
        for(CoreMap sentence: sentences) {
        	  for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
        	    String word = token.get(CoreAnnotations.TextAnnotation.class);
        	    String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
        	    String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
        	    System.out.print(word);
        	    output+=word;
        	    if(ne.equals("O")==false)
        	    {
        	    	System.out.print("("+ne+")");
        	    	output=output+"("+ne+")";
        	    }
        	    System.out.print(" ");
        	    output+=" ";
        	  }
        }
        System.out.println(".");
        output+=".";
        //return output;
    }

}
