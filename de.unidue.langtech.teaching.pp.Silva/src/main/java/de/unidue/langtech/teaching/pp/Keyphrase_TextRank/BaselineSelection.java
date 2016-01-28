package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;

// Candidate Selection - Noun and Adjective

public class BaselineSelection extends JCasAnnotator_ImplBase {

	@Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {

		System.out.println("\n" + aJCas.getDocumentText() + "\n");
    /* all sentences */
    for (Sentence sentence : JCasUtil.select(aJCas, Sentence.class)) {

      // all Noun Phrases within that sentence
    	for (N nounphrase : JCasUtil.selectCovered(aJCas, N.class, sentence)) {

    		  System.out.printf("N: '%s'\n", nounphrase.getCoveredText());
    	}

    	for(ADJ adjectiv : JCasUtil.selectCovered(aJCas, ADJ.class, sentence)){

  		  System.out.printf("ADJ: '%s'\n", adjectiv.getCoveredText());
    	}


    }
  }
}