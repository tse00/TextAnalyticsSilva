package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;


import de.tudarmstadt.ukp.dkpro.core.api.featurepath.FeaturePathException;
import de.tudarmstadt.ukp.dkpro.core.api.featurepath.FeaturePathFactory;
import de.unidue.langtech.teaching.pp.type.CountPos1;
import de.unidue.langtech.teaching.pp.type.CountPosCandidate;

public class CandidateCount extends JCasAnnotator_ImplBase{


    public static final String PARAM_FEATURE_PATH = "FeaturePath";
    @ConfigurationParameter(name=PARAM_FEATURE_PATH)
    private String featurePath;

    List<Candidate> candidates = new ArrayList<Candidate>();
    int countPOS = 0;

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {


        try {
            for (Entry<AnnotationFS, String> entry: FeaturePathFactory.select(jcas.getCas(), featurePath)) {
                candidates.add(new Candidate(entry.getValue(), entry.getKey().getBegin(), entry.getKey().getEnd()));
                countPOS ++;
            }
        } catch (FeaturePathException e) {
            throw new AnalysisEngineProcessException(e);
        }

        System.out.println("Selected POS count: "+countPOS+"\n");

        CountPosCandidate count = new CountPosCandidate(jcas);
        count.setCountCandidate(countPOS);
        count.addToIndexes();
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
	    }
}