package de.unidue.langtech.teaching.pp.example;

import static de.tudarmstadt.ukp.dkpro.core.api.io.ResourceCollectionReaderBase.INCLUDE_PREFIX;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.filter.factory.StopwordFilterFactory;
import de.tudarmstadt.ukp.dkpro.lab.engine.TaskContext;
import de.tudarmstadt.ukp.dkpro.lab.storage.StorageService.AccessMode;
import de.tudarmstadt.ukp.dkpro.lab.task.Discriminator;
import de.tudarmstadt.ukp.dkpro.lab.uima.task.impl.UimaTaskBase;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class BaselineStopWord extends JCasAnnotator_ImplBase{

	 //Stopword filter
    @Discriminator
    private boolean runStopwordFilter;
    @Discriminator
    private Set<String> stopwordlists;


    // Set up stemmer and lemmatizer


	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		StopWordRemover stop = new StopWordRemover();

		List<AnalysisEngineDescription> engines = new LinkedList<AnalysisEngineDescription>();

		engines.add(createEngineDescription(StopWordRemover.class,
     		   StopWordRemover.PARAM_MODEL_LOCATION, "src/main/resources/stopwords/english_keyphrase_stopwords.txt",
     		   StopWordRemover.PARAM_PATHS, Token.class.getName()));

		System.out.println("Without Stopword: ");

/*	public AnalysisEngineDescription getAnalysisEngineDescription(TaskContext aContext)
			throws ResourceInitializationException, IOException {

		List<AnalysisEngineDescription> engines = new LinkedList<AnalysisEngineDescription>();

		if(runStopwordFilter)
            engines.add(StopwordFilterFactory.getStopwordFilter(stopwordlists));

        return createEngine(engines);*/


/*	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {

		List<AnalysisEngineDescription> engines = new LinkedList<AnalysisEngineDescription>();

		engines.add(createEngine(
				StopWordRemover.class,
				StopWordRemover.PARAM_MODEL_LOCATION, new String[] {
					//"[de]classpath:/stopwords/german_stopwords.txt",
					"[en]classpath:/stopwords/english_stopwords.txt",
				"[en]classpath:/stopwords/english_keyphrase_stopwords.txt"}));

		   if(runStopwordFilter){
	            engines.add(StopwordFilterFactory.getStopwordFilter(stopwordlists));
	        }
	}*/
	}
}