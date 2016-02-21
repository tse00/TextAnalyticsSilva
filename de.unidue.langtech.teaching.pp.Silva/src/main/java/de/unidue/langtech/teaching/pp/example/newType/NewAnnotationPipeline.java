package de.unidue.langtech.teaching.pp.example.newType;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;


import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.BaselineSelection;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.KeyphraseReader;
import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.example.ReaderExample;

public class NewAnnotationPipeline
{

    public static void main(String[] args)
        throws Exception
    {
    	SimplePipeline.runPipeline(
                CollectionReaderFactory.createReader(
                		KeyphraseReader.class,
                		KeyphraseReader.PARAM_INPUTDIR, "src/test/resources/test2/",
                		KeyphraseReader.PARAM_LANGUAGE, "en",
                		KeyphraseReader.PARAM_DATA_SUFFIX, "txt"
                ),

                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
                AnalysisEngineFactory.createEngineDescription(BaselineExample.class),
                AnalysisEngineFactory.createEngineDescription(BaselineSelection.class),
                AnalysisEngineFactory.createEngineDescription(LetterAnnotator.class),
                AnalysisEngineFactory.createEngineDescription(Printer.class)
        );
    }
}
