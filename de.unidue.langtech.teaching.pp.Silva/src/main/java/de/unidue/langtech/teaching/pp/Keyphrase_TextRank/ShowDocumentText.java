package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;

import de.unidue.langtech.teaching.pp.type.ShowDocument;


public class ShowDocumentText extends JCasAnnotator_ImplBase{

    public static final String PARAM_SHOWTEXT = "text";
    @ConfigurationParameter(name=PARAM_SHOWTEXT, mandatory=true)
    private boolean showText;

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		if(showText == true){
			System.out.println("\n----------Document------------");

			System.out.println("\n" + jcas.getDocumentText() + "\n");
		}

		  ShowDocument show = new ShowDocument(jcas);
		  show.setShowDoc(showText);
		  show.addToIndexes();
	}

}
