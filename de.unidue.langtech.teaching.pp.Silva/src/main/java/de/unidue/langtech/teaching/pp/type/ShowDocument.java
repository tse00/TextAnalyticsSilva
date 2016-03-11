

/* First created by JCasGen Thu Mar 10 12:09:11 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Mar 10 12:09:11 CET 2016
 * XML source: /Users/TSE_/git/TextAnalyticsSilva/de.unidue.langtech.teaching.pp.Silva/src/main/resources/desc/type/ShowDocType.xml
 * @generated */
public class ShowDocument extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ShowDocument.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected ShowDocument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ShowDocument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ShowDocument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public ShowDocument(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ShowDoc

  /** getter for ShowDoc - gets 
   * @generated
   * @return value of the feature 
   */
  public boolean getShowDoc() {
    if (ShowDocument_Type.featOkTst && ((ShowDocument_Type)jcasType).casFeat_ShowDoc == null)
      jcasType.jcas.throwFeatMissing("ShowDoc", "de.unidue.langtech.teaching.pp.type.ShowDocument");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((ShowDocument_Type)jcasType).casFeatCode_ShowDoc);}
    
  /** setter for ShowDoc - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setShowDoc(boolean v) {
    if (ShowDocument_Type.featOkTst && ((ShowDocument_Type)jcasType).casFeat_ShowDoc == null)
      jcasType.jcas.throwFeatMissing("ShowDoc", "de.unidue.langtech.teaching.pp.type.ShowDocument");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((ShowDocument_Type)jcasType).casFeatCode_ShowDoc, v);}    
  }

    