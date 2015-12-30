package de.unidue.langtech.teaching.pp.example.newType;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.unidue.langtech.teaching.pp.type.DetectedLanguage;
import de.unidue.langtech.teaching.pp.type.GoldLanguage;
import de.unidue.langtech.teaching.pp.type.MyType;
import de.unidue.langtech.teaching.pp.type.MyType2;

public class Printer
    extends JCasAnnotator_ImplBase
{

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        // This API always returns a collection even if you know that there should be only one
        Collection<MyType> letterECount = JCasUtil.select(jcas, MyType.class);
        Collection<MyType2> letterACount = JCasUtil.select(jcas, MyType2.class);

        // There is a special API for the case you know that there is exactly one annotation
        GoldLanguage gold = JCasUtil.selectSingle(jcas, GoldLanguage.class);
        DetectedLanguage detected = JCasUtil.selectSingle(jcas, DetectedLanguage.class);

        for (MyType t : letterECount) {
            System.out.println("Detected: " + detected.getLanguage() + " Gold:"
                    + gold.getLanguage());
            System.out.println("Number of e/E: " + t.getCountLetterE());
        }

     /*   for (MyType t : letterACount) {
            System.out.println("Detected: " + detected.getLanguage() + " Gold:"
                    + gold.getLanguage());
            System.out.println("Number of a/A: " + t.);

        }*/


    }

}