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
import de.tudarmstadt.ukp.dkpro.core.io.bincas.BinaryCasReader;

public class BaselineStopWord extends UimaTaskBase{

	 //Stopword filter
    @Discriminator
    private boolean runStopwordFilter;
    @Discriminator
    private Set<String> stopwordlists;

	public CollectionReaderDescription getCollectionReaderDescription(TaskContext aContext)
			throws ResourceInitializationException, IOException {

		File inputRoot = aContext.getStorageLocation(KEY_INPUT_BIN, AccessMode.READONLY);
	        return createReader(BinaryCasReader.class,
	                BinaryCasReader.PARAM_SOURCE_LOCATION, inputRoot,
	                BinaryCasReader.PARAM_PATTERNS, new String[] { INCLUDE_PREFIX + "**/*.bin" });

	}
	public AnalysisEngineDescription getAnalysisEngineDescription(TaskContext aContext)
			throws ResourceInitializationException, IOException {

		List<AnalysisEngineDescription> engines = new LinkedList<AnalysisEngineDescription>();

		if(runStopwordFilter)
            engines.add(StopwordFilterFactory.getStopwordFilter(stopwordlists));

        return createEngine(engines);

	}

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
