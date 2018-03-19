/**
 *
 */
package org.eventb.codegen.theory.translator.internal.ui.eventbeditor.manipulation;

import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.TARGET_LANGUAGE_ATTRIBUTE;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.theory.translator.core.ITargetLanguageElement;
import org.eventb.internal.ui.UIUtils;
import org.eventb.internal.ui.eventbeditor.manipulation.AbstractAttributeManipulation;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TargetLanguageAttributeManipulation extends AbstractAttributeManipulation {

	private final String TARGET_LANGUAGE_SEPARATOR = ",";


	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#setDefaultValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		asTargetLanguage(element).setTargetLanguage(UIUtils.COMBO_VALUE_UNDEFINED, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#hasValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		return asTargetLanguage(element).hasTargetLanguage();
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#getValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		return asTargetLanguage(element).getTargetLanguage();
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#setValue(org.rodinp.core.IRodinElement, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {
		asTargetLanguage(element).setTargetLanguage(value, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#removeAttribute(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		asTargetLanguage(element).removeAttribute(TARGET_LANGUAGE_ATTRIBUTE, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#getPossibleValues(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		
		
		//	This used to obtain the allowed target languages from the defined enumeration.
		//	This enumeration has been replaced with an ArrayList of translators that are loaded through extension points.
		//	Now it will drag the list in from the IL1TranslationManager.
		ArrayList<String> supportedLanguages = IL1TranslationManager.coreSupportedLanguageDisplayNames;
		
		String [] supportedLanguagesArray = new String[supportedLanguages.size()];
		return supportedLanguages.toArray(supportedLanguagesArray);
		
//		TargetLanguage[] targetLanguages = TargetLanguage.values();
//		String[] targetLanguagesValues =  new String[targetLanguages.length];
//		for(int i=0;i<targetLanguages.length;i++){
//			targetLanguagesValues[i]=targetLanguages[i].toString();
//		}
//		return targetLanguagesValues; //TARGET_LANGUAGES.split(TARGET_LANGUAGE_SEPARATOR);
	}

	protected ITargetLanguageElement asTargetLanguage(IRodinElement element){
		assert element instanceof ITargetLanguageElement;
		return (ITargetLanguageElement) element;
	}

}
