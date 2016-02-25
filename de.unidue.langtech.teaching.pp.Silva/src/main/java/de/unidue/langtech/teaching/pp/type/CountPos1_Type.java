
/* First created by JCasGen Wed Feb 24 21:30:42 CET 2016 */
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
 * Updated by JCasGen Thu Feb 25 09:32:51 CET 2016
 * @generated */
public class CountPos1_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CountPos1_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CountPos1_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CountPos1(addr, CountPos1_Type.this);
  			   CountPos1_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CountPos1(addr, CountPos1_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CountPos1.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.CountPos1");
 
  /** @generated */
  final Feature casFeat_CountN;
  /** @generated */
  final int     casFeatCode_CountN;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getCountN(int addr) {
        if (featOkTst && casFeat_CountN == null)
      jcas.throwFeatMissing("CountN", "de.unidue.langtech.teaching.pp.type.CountPos1");
    return ll_cas.ll_getIntValue(addr, casFeatCode_CountN);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountN(int addr, int v) {
        if (featOkTst && casFeat_CountN == null)
      jcas.throwFeatMissing("CountN", "de.unidue.langtech.teaching.pp.type.CountPos1");
    ll_cas.ll_setIntValue(addr, casFeatCode_CountN, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public CountPos1_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_CountN = jcas.getRequiredFeatureDE(casType, "CountN", "uima.cas.Integer", featOkTst);
    casFeatCode_CountN  = (null == casFeat_CountN) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_CountN).getCode();

  }
}



    