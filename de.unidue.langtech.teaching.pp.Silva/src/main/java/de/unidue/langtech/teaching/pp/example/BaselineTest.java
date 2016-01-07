package de.unidue.langtech.teaching.pp.example;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasConsumer_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.constituent.NP;

public class BaselineTest extends JCasConsumer_ImplBase {
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {

    /* all sentences */
    for (Sentence sentence : JCasUtil.select(aJCas, Sentence.class)) {

      /* all Noun Phrases within that sentence */
      for (NP nounphrase : JCasUtil.selectCovered(aJCas, NP.class, sentence)) {

        /* all Named Entities within that noun phrase */
        for (NamedEntity ne : JCasUtil.selectCovered(aJCas, NamedEntity.class, nounphrase)) {

            System.out.printf("NP: '%s'\tNE: '%s'\n", nounphrase.getCoveredText(), ne.getCoveredText());

        } /* for each NamedEntity within the noun phrase */
      } /* for each noun phrase within the sentence */
    } /* for each sentence */
  } /* process() */
} /* class */