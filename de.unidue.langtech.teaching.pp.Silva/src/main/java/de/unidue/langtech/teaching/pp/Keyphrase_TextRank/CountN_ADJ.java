package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.unidue.langtech.teaching.pp.type.CountPos1;
import de.unidue.langtech.teaching.pp.type.CountPos2;


public class CountN_ADJ extends JCasAnnotator_ImplBase {

	public static final String PARAM_MESSAGE = "PARAM_MESSAGE";
	@ConfigurationParameter(name = PARAM_MESSAGE, mandatory = true, defaultValue = "Number of Nouns and Adjectives in the text: ")

	protected String message;


	@Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {

		System.out.println(message);

	int countN = 0;
	int countADJ = 0;

	for (Sentence sentence : JCasUtil.select(jcas, Sentence.class)) {

    	for (N noun: JCasUtil.selectCovered(jcas, N.class, sentence)) {


    		countN ++;
    	}

    	for(ADJ adjectiv : JCasUtil.selectCovered(jcas, ADJ.class, sentence)){

  		  countADJ ++;
    	}
    }

	CountPos1 posN = new CountPos1(jcas);
    posN.setCountN(countN);
    posN.addToIndexes();

    System.out.println("\nNouns count: " + countN);


    CountPos2 posADJ = new CountPos2(jcas);
    posADJ.setCountADJ(countADJ);
    posADJ.addToIndexes();

    System.out.println("Adjetives count: " + countADJ + "\n");
  }
}
