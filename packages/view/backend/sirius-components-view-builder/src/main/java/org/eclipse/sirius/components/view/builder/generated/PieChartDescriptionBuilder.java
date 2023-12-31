/*******************************************************************************
 * Copyright (c) 2023 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.components.view.builder.generated;

/**
 * Builder for PieChartDescriptionBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class PieChartDescriptionBuilder {

    /**
     * Create instance org.eclipse.sirius.components.view.PieChartDescription.
     * @generated
     */
    private org.eclipse.sirius.components.view.PieChartDescription pieChartDescription = org.eclipse.sirius.components.view.ViewFactory.eINSTANCE.createPieChartDescription();

    /**
     * Return instance org.eclipse.sirius.components.view.PieChartDescription.
     * @generated
     */
    protected org.eclipse.sirius.components.view.PieChartDescription getPieChartDescription() {
        return this.pieChartDescription;
    }

    /**
     * Return instance org.eclipse.sirius.components.view.PieChartDescription.
     * @generated
     */
    public org.eclipse.sirius.components.view.PieChartDescription build() {
        return this.getPieChartDescription();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public PieChartDescriptionBuilder name(java.lang.String value) {
        this.getPieChartDescription().setName(value);
        return this;
    }
    /**
     * Setter for LabelExpression.
     *
     * @generated
     */
    public PieChartDescriptionBuilder labelExpression(java.lang.String value) {
        this.getPieChartDescription().setLabelExpression(value);
        return this;
    }
    /**
     * Setter for ValuesExpression.
     *
     * @generated
     */
    public PieChartDescriptionBuilder valuesExpression(java.lang.String value) {
        this.getPieChartDescription().setValuesExpression(value);
        return this;
    }
    /**
     * Setter for KeysExpression.
     *
     * @generated
     */
    public PieChartDescriptionBuilder keysExpression(java.lang.String value) {
        this.getPieChartDescription().setKeysExpression(value);
        return this;
    }
    /**
     * Setter for Style.
     *
     * @generated
     */
    public PieChartDescriptionBuilder style(org.eclipse.sirius.components.view.PieChartDescriptionStyle value) {
        this.getPieChartDescription().setStyle(value);
        return this;
    }
    /**
     * Setter for ConditionalStyles.
     *
     * @generated
     */
    public PieChartDescriptionBuilder conditionalStyles(org.eclipse.sirius.components.view.ConditionalPieChartDescriptionStyle ... values) {
        for (org.eclipse.sirius.components.view.ConditionalPieChartDescriptionStyle value : values) {
            this.getPieChartDescription().getConditionalStyles().add(value);
        }
        return this;
    }


}

