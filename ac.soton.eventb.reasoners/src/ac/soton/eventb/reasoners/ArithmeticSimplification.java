/*******************************************************************************
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/

package ac.soton.eventb.reasoners;

import java.math.BigInteger;

import org.eventb.core.ast.AssociativeExpression;
import org.eventb.core.ast.BinaryExpression;
import org.eventb.core.ast.DefaultRewriter;
import org.eventb.core.ast.Expression;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.IFormulaRewriter2;
import org.eventb.core.ast.IntegerLiteral;

/**
 * <p>
 *
 * </p>
 *
 * @author htson
 * @version
 * @see
 * @since
 */
public class ArithmeticSimplification extends DefaultRewriter implements
		IFormulaRewriter2 {

	private static final FormulaFactory FORMULA_FACTORY = FormulaFactory
			.getDefault();

	/**
	 * @param autoFlattening
	 */
	public ArithmeticSimplification(boolean autoFlattening, FormulaFactory ff) {
		super(autoFlattening);
	}

	/* (non-Javadoc)
	 * @see org.eventb.core.ast.DefaultRewriter#rewrite(org.eventb.core.ast.BinaryExpression)
	 */
	@Override
	public Expression rewrite(BinaryExpression expression) {
		Expression left = expression.getLeft();
		Expression right = expression.getRight();
		if (left instanceof IntegerLiteral && right instanceof IntegerLiteral) {
			IntegerLiteral leftLiteral = (IntegerLiteral) left;
			IntegerLiteral rightLiteral = (IntegerLiteral) right;
			BigInteger leftValue = leftLiteral.getValue();
			BigInteger rightValue = rightLiteral.getValue();
			if (expression.getTag() == Expression.MINUS) {
				BigInteger value = leftValue.subtract(rightValue);
				return expression.getFactory().makeIntegerLiteral(value, null);
				//return FORMULA_FACTORY.makeIntegerLiteral(value, null);
			}
			else if (expression.getTag() == Expression.DIV) {
				BigInteger value = leftValue.divide(rightValue);
				return expression.getFactory().makeIntegerLiteral(value, null);
				//return FORMULA_FACTORY.makeIntegerLiteral(value, null);
			}
			else if (expression.getTag() == Expression.EXPN) {
				BigInteger value = leftValue.pow(rightValue.intValue());
				return expression.getFactory().makeIntegerLiteral(value, null);
			}
			else if (expression.getTag() == Expression.MOD) {
				BigInteger value = leftValue.mod(rightValue);
				return expression.getFactory().makeIntegerLiteral(value, null);
			}
			
		}
		return super.rewrite(expression);
	}

	/* (non-Javadoc)
	 * @see org.eventb.core.ast.DefaultRewriter#rewrite(org.eventb.core.ast.AssociativeExpression)
	 */
	@Override
	public Expression rewrite(AssociativeExpression expression) {
		Expression[] children = expression.getChildren();
		BigInteger[] values = new BigInteger[children.length];
		for (int i = 0; i < children.length; i++) {
			if (!(children[i] instanceof IntegerLiteral)) {
				return super.rewrite(expression);
			}
			else {
				values[i] = ((IntegerLiteral) children[i]).getValue();
			}
		}
		
		if (expression.getTag() == Expression.PLUS) {
			BigInteger value = BigInteger.valueOf(0);
			for (int i = 0; i < values.length; i++) {
				value = value.add(values[i]);
			}
			return expression.getFactory().makeIntegerLiteral(value, null);
		}
		else if (expression.getTag() == Expression.MUL) {
			BigInteger value = BigInteger.valueOf(1);
			for (int i = 0; i < values.length; i++) {
				value = value.multiply(values[i]);
			}
			return expression.getFactory().makeIntegerLiteral(value, null);
		}
		
		return super.rewrite(expression);
	}

	
}
