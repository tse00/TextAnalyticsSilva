package de.unidue.langtech.teaching.pp.example;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
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


    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        System.out.println("Document is: " + jcas.getDocumentText());

        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        System.out.println("CAS contains " + tokens.size() + " tokens.");

        String lang = "";



        for(Token t : tokens){

        	System.out.println( "\n" + t.getCoveredText() + "\n");

        	String a = t.getCoveredText();

        	if(a.equals("Beispiel")){

        		 lang = "DE";

        	}

        	if(a.equals("arrived")){

        		lang = "EN";
        	}

        	if(a.equals("finis")){

        		lang = "FR";
        	}
        }

        DetectedLanguage languageAnno = new DetectedLanguage(jcas);
        languageAnno.setLanguage(lang);
        languageAnno.addToIndexes();

    }
}