package de.unidue.langtech.teaching.pp.example;

import java.util.Collection;


import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.DetectedLanguage;


/**
 * The baseline always identifies "EN" as the document language.
 *
 * @author zesch
 *
 */
public class BaselineExample
    extends JCasAnnotator_ImplBase
{

	public static final String PARAM_MESSAGE = "PARAM_MESSAGE";
	@ConfigurationParameter(name = PARAM_MESSAGE, mandatory = true, defaultValue = "Hello everyone \n")

	protected String message;

	@Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {

		System.out.println(message);

        System.out.println("Document is: " + jcas.getDocumentText());

        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        System.out.println("CAS contains " + tokens.size() + " tokens.");


        String lang = "";

        for(Token t : tokens){

        	String w = t.getCoveredText().toLowerCase();

        	if(w.equals("das")){

        		 lang = "DE";

        	}

        	if(w.equals("the")){

        		lang = "EN";
        	}

        	if(w.equals("je")){

        		lang = "FR";
        	}

        	if(w.equals("eu")){

        		lang = "PT";
        	}
        }

        DetectedLanguage languageAnno = new DetectedLanguage(jcas);
        languageAnno.setLanguage(lang);
        languageAnno.addToIndexes();

    }
}