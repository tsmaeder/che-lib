/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which is available at http://www.eclipse.org/legal/epl-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.jdb.server.expression;

/** @author andrew00x */
public abstract class ExpressionParser {
  private final String expression;

  protected ExpressionParser(String expression) {
    this.expression = expression;
  }

  /**
   * Create new instance of parser for specified Java expression.
   *
   * @param expression Java language expression
   * @return concrete implementation of ExpressionParser
   */
  public static ExpressionParser newInstance(String expression) {
    // At the moment create instance of ANTLRExpressionParser directly.
    return new ANTLRExpressionParser(expression);
  }

  /**
   * Get expression for this parser.
   *
   * @return expression
   */
  public String getExpression() {
    return expression;
  }

  /**
   * Evaluate expression.
   *
   * @param ev Evaluator
   * @return result of evaluation
   * @throws ExpressionException if specified expression is invalid or another error occurs when try
   *     to evaluate expression
   */
  public abstract com.sun.jdi.Value evaluate(Evaluator ev);
}
