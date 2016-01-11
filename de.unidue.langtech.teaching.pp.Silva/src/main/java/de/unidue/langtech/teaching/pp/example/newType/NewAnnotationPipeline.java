package de.unidue.langtech.teaching.pp.example.newType;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.example.BaselineSelection;
import de.unidue.langtech.teaching.pp.example.KeyphraseReader;
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
               // AnalysisEngineFactory.createEngineDescription(LetterAnnotator.class),
               // AnalysisEngineFactory.createEngineDescription(Printer.class),
                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
                		CooccurrenceGraph.PARAM_FEATURE_PATH, N.class, CooccurrenceGraph.PARAM_FEATURE_PATH, ADJ.class),
                AnalysisEngineFactory.createEngineDescription(NodeDegreeRanking.class, NodeDegreeRanking.PARAM_WEIGHTED, true)
        );
    }
}
