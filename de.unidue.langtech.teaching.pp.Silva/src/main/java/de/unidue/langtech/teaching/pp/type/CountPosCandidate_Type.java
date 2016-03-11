
/* First created by JCasGen Wed Mar 09 23:54:59 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Mar 09 23:54:59 CET 2016
 * @generated */
public class CountPosCandidate_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CountPosCandidate_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CountPosCandidate_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CountPosCandidate(addr, CountPosCandidate_Type.this);
  			   CountPosCandidate_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CountPosCandidate(addr, CountPosCandidate_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CountPosCandidate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.CountPosCandidate");
 
  /** @generated */
  final Feature casFeat_CountCandidate;
  /** @generated */
  final int     casFeatCode_CountCandidate;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getCountCandidate(int addr) {
        if (featOkTst && casFeat_CountCandidate == null)
      jcas.throwFeatMissing("CountCandidate", "de.unidue.langtech.teaching.pp.type.CountPosCandidate");
    return ll_cas.ll_getIntValue(addr, casFeatCode_CountCandidate);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountCandidate(int addr, int v) {
        if (featOkTst && casFeat_CountCandidate == null)
      jcas.throwFeatMissing("CountCandidate", "de.unidue.langtech.teaching.pp.type.CountPosCandidate");
    ll_cas.ll_setIntValue(addr, casFeatCode_CountCandidate, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public CountPosCandidate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_CountCandidate = jcas.getRequiredFeatureDE(casType, "CountCandidate", "uima.cas.Integer", featOkTst);
    casFeatCode_CountCandidate  = (null == casFeat_CountCandidate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_CountCandidate).getCode();

  }
}



    