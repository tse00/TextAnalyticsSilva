package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.util.Level;

import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;
import de.unidue.langtech.teaching.pp.type.CountPos1;
import de.tudarmstadt.ukp.dkpro.core.api.featurepath.FeaturePathException;
import de.tudarmstadt.ukp.dkpro.core.api.featurepath.FeaturePathFactory;


public class CandidateSelect extends JCasAnnotator_ImplBase {


    public static final String PARAM_FEATURE_PATH = "FeaturePath";
    @ConfigurationParameter(name=PARAM_FEATURE_PATH)
    private String featurePath;

    List<Candidate> candidates = new ArrayList<Candidate>();

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {


		getContext().getLogger().log(Level.FINE, "Entering " + this.getClass().getSimpleName());

        // get the candidates according to the parameters

        try {
            for (Entry<AnnotationFS, String> entry: FeaturePathFactory.select(jcas.getCas(), featurePath)) {
                candidates.add(new Candidate(entry.getValue(), entry.getKey().getBegin(), entry.getKey().getEnd()));

            }
        } catch (FeaturePathException e) {
            throw new AnalysisEngineProcessException(e);
        }

        System.out.println("\nSelected candidate - " +featurePath+": \n" + candidates);

        AnnotationIndex<Annotation> candidateIndex = jcas.getAnnotationIndex(Keyphrase.type);
        for (Candidate candidate : candidates) {
            Keyphrase keyphrase = new Keyphrase(jcas);
            keyphrase.setKeyphrase(candidate.term);
            keyphrase.setBegin(candidate.begin);
            keyphrase.setEnd(candidate.end);
            keyphrase.addToIndexes();

            if (!candidateIndex.contains(keyphrase)) {
                keyphrase.addToIndexes(jcas);
            }
        }

  }

	   private class Candidate {
	        private final String term;
	        private final int begin;
	        private final int end;
	        public Candidate(String term, int begin, int end) {
	            super();
	            this.term = term;
	            this.begin = begin;
	            this.end = end;
	        }
	        @Override
			public String toString() {

	        	return term + "(" + begin + " - " + end + ")" ;
	        }

	    }
}