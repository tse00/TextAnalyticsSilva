package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;


// Candidate Selection - Noun and Adjective

public class BaselineSelection extends JCasAnnotator_ImplBase {

	public static final String PARAM_MESSAGE = "PARAM_MESSAGE";
	@ConfigurationParameter(name = PARAM_MESSAGE, mandatory = true, defaultValue = "Just a List from all Nouns and Adjectives presented on the text: \n")

	protected String message;


	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {


		System.out.println(message);

		String candidateN = "";
		String candidateADJ = "";


		for (Sentence sentence : JCasUtil.select(jcas, Sentence.class)) {

			for (N noun: JCasUtil.selectCovered(jcas, N.class, sentence)) {

    		candidateN = noun.getCoveredText();
    		System.out.printf("N: '%s'\n", noun.getCoveredText());

			}

			for(ADJ adjectiv : JCasUtil.selectCovered(jcas, ADJ.class, sentence)){

				candidateADJ = adjectiv.getCoveredText();
				System.out.printf("ADJ: '%s'\n", adjectiv.getCoveredText());

			}
    	}

    	Keyphrase pos1 = new Keyphrase(jcas);
    	pos1.setKeyphrase(candidateN);
    	pos1.addToIndexes();

    	Keyphrase pos2 = new Keyphrase(jcas);
    	pos2.setKeyphrase(candidateADJ);
    	pos2.addToIndexes();

  }

}