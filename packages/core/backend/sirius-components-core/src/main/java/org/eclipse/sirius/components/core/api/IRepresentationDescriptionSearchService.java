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
package org.eclipse.sirius.components.core.api;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.eclipse.sirius.components.representations.IRepresentationDescription;

/**
 * Used to find representation descriptions.
 *
 * @author sbegaudeau
 */
public interface IRepresentationDescriptionSearchService {
    Optional<IRepresentationDescription> findById(IEditingContext editingContext, String representationDescriptionId);

    Map<String, IRepresentationDescription> findAll(IEditingContext editingContext);

    /**
     * Implementation which does nothing, used for mocks in unit tests.
     *
     * @author pcdavid
     */
    class NoOp implements IRepresentationDescriptionSearchService {

        @Override
        public Optional<IRepresentationDescription> findById(IEditingContext editingContext, String representationDescriptionId) {
            return Optional.empty();
        }

        @Override
        public Map<String, IRepresentationDescription> findAll(IEditingContext editingContext) {
            return Collections.emptyMap();
        }

    }
}
