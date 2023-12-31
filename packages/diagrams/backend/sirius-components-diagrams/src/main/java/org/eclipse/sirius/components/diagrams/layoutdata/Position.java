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
package org.eclipse.sirius.components.diagrams.layoutdata;

/**
 * The position of an element.
 *
 * @author sbegaudeau
 */
public record Position(double x, double y) {
    public Position translate(double dx, double dy) {
        return new Position(this.x + dx, this.y + dy);
    }

    public Position midPoint(Position other) {
        return new Position((this.x + other.x) / 2.0, (this.y + other.y) / 2.0);
    }
}
