/*******************************************************************************
 * Copyright (c) 2021, 2022 Obeo.
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
package org.eclipse.sirius.components.diagrams;

import java.text.MessageFormat;
import java.util.Objects;

import org.eclipse.sirius.components.annotations.Immutable;

/**
 * The list container item node style.
 *
 * @author aallain
 */
@Immutable
public final class EmptyNodeStyle implements INodeStyle {

    private boolean empty;

    private EmptyNodeStyle() {
        // Prevent instantiation
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public static Builder newEmptyNodeStyle() {
        return new Builder();
    }

    @Override
    public String toString() {
        String pattern = "{0}";
        return MessageFormat.format(pattern, this.getClass().getSimpleName());
    }

    /**
     * The builder used to create the list container item node style.
     *
     * @author aallain
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public static final class Builder {

        private boolean empty;

        private Builder() {
            // Prevent instantiation
        }

        public Builder empty(boolean empty) {
            this.empty = Objects.requireNonNull(empty);
            return this;
        }

        public EmptyNodeStyle build() {
            EmptyNodeStyle nodeStyleDescription = new EmptyNodeStyle();
            nodeStyleDescription.empty = Objects.requireNonNull(this.empty);
            return nodeStyleDescription;
        }
    }
}
