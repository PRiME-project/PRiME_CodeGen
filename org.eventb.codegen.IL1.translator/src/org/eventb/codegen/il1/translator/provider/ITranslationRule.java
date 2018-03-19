/**
 *
 */
package org.eventb.codegen.il1.translator.provider;

import org.eventb.core.ast.Formula;
import org.eventb.core.ast.ITypeEnvironment;

/**
 * @author renatosilva
 *
 */
public interface ITranslationRule {

	public String getTranslation();

	public void setTranslation(String translation);

	public String getName();

	public void setName(String name);

	public String getTargetLanguage();

	public ITranslationRule getTranslationRule();

	public ITypeEnvironment getTypeEnvironment();

	public Formula<?> getFormula();

	public void setFormula(Formula<?> formula);

}
