package org.eventb.codegen.theory.translator.core.sc.state;

import org.eventb.codegen.theory.translator.core.ISCTranslatorRuleElement;
import org.eventb.codegen.theory.translator.core.ISCTranslatorTypeRuleElement;
import org.eventb.codegen.theory.translator.core.sc.TranslatorProblem;
import org.eventb.core.EventBAttributes;
import org.eventb.core.sc.IMarkerDisplay;
import org.eventb.core.sc.state.ILabelSymbolInfo;
import org.eventb.core.sc.state.ISymbolInfo;
import org.eventb.internal.core.sc.symbolTable.ISymbolProblem;
import org.eventb.internal.core.sc.symbolTable.LabelSymbolInfo;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinDBException;


public class TranslatorSymbolFactory {

	private static TranslatorSymbolFactory factory = new TranslatorSymbolFactory();
	private static TranslatorLabelSymbolProblem translatorLabelSymbolProblem = new TranslatorLabelSymbolProblem();

	public static TranslatorSymbolFactory getInstance() {
		return factory;
	}

	@SuppressWarnings("restriction")
	private static class TranslatorLabelSymbolProblem implements ISymbolProblem {

		public TranslatorLabelSymbolProblem() {
			// public constructor
		}

		@Override
		public void createConflictError(ISymbolInfo<?, ?> symbolInfo,
				IMarkerDisplay markerDisplay) throws RodinDBException {
			markerDisplay.createProblemMarker(symbolInfo.getProblemElement(),
					symbolInfo.getProblemAttributeType(),
					TranslatorProblem.TranslatorLabelConflictError, symbolInfo.getSymbol());
		}

		@Override
		public void createConflictWarning(ISymbolInfo<?, ?> symbolInfo,
				IMarkerDisplay markerDisplay) throws RodinDBException {
			markerDisplay.createProblemMarker(symbolInfo.getProblemElement(),
					symbolInfo.getProblemAttributeType(),
					TranslatorProblem.TranslatorLabelConflictWarning, symbolInfo.getSymbol());
		}
	}

	/**
	 * Creates a new instance of ILabelSymbolInfo for a local translator element
	 * with the given parameters.
	 *
	 * @param symbol
	 *            the name of the translator
	 * @param persistent
	 *            <code>true</code> iff the resulting info shall be persistent
	 * @param problemElement
	 *            an element to which to attach problem markers
	 * @param component
	 *            the name of the component that contains this symbol
	 * @return a new instance of ILabelSymbolInfo
	 * @see ISymbolInfo
	 */
	@SuppressWarnings("restriction")
	public ILabelSymbolInfo makeLocalRuleTranslator(String symbol,
			boolean persistent, IInternalElement problemElement,
			String component) {
		return new LabelSymbolInfo(symbol, ISCTranslatorRuleElement.ELEMENT_TYPE,
				persistent, problemElement, EventBAttributes.LABEL_ATTRIBUTE,
				component, translatorLabelSymbolProblem);
	}

	/**
	 * Creates a new instance of ILabelSymbolInfo for a local translator element
	 * with the given parameters.
	 *
	 * @param symbol
	 *            the name of the translator
	 * @param persistent
	 *            <code>true</code> iff the resulting info shall be persistent
	 * @param problemElement
	 *            an element to which to attach problem markers
	 * @param component
	 *            the name of the component that contains this symbol
	 * @return a new instance of ILabelSymbolInfo
	 * @see ISymbolInfo
	 */
	@SuppressWarnings("restriction")
	public ILabelSymbolInfo makeLocalTypeRuleTranslator(String symbol,
			boolean persistent, IInternalElement problemElement,
			String component) {
		return new LabelSymbolInfo(symbol, ISCTranslatorTypeRuleElement.ELEMENT_TYPE,
				persistent, problemElement, EventBAttributes.LABEL_ATTRIBUTE,
				component, translatorLabelSymbolProblem);
	}
}
