package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import static org.apache.commons.io.FilenameUtils.indexOfExtension;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasConsumer_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;

import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.KeyphraseEvaluator;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.KeyphraseEvaluator.EvaluatorType;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.util.EvaluatorUtils;
import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;

public class GoldKeyphrases extends JCasConsumer_ImplBase{


	  // The suffix of the gold keyphrase files. Default is "key".
    // Suffixes should always be given with the ".".
    public static final String PARAM_GOLD_SUFFIX = "GoldSuffix";
    @ConfigurationParameter(name=PARAM_GOLD_SUFFIX, mandatory=false, defaultValue=".key")
    private String goldSuffix;


	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

	    // get the meta data of the document
        DocumentMetaData docMetaData = DocumentMetaData.get(jcas);
        String currentTitle = docMetaData.getDocumentTitle();
        System.out.println("Document title: " + currentTitle);
        System.out.println("Content:" + docMetaData);

        Set<String> goldKeyphrases = new TreeSet<String>();

    	String uri = docMetaData.getDocumentUri();
		URL keyUrl;
		try {
			keyUrl = URI.create(uri.substring(0, indexOfExtension(uri)) + goldSuffix).toURL();

			IOUtils.readLines(keyUrl.openStream(), "UTF-8");

		} catch (IOException e) {
			throw new AnalysisEngineProcessException(e);
		}

        System.out.println(goldKeyphrases.size());

	}

	protected String getGoldSuffix(){

	        return goldSuffix;
	}

}
