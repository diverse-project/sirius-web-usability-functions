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
package org.eclipse.sirius.components.collaborative.dto;

import java.util.Objects;
import java.util.UUID;

import org.eclipse.sirius.components.core.api.IPayload;
import org.eclipse.sirius.components.representations.IRepresentationDescription;

/**
 * Used to retrieve a representation description.
 *
 * @author sbegaudeau
 */
public record GetRepresentationDescriptionPayload(UUID id, IRepresentationDescription representationDescription) implements IPayload {
    public GetRepresentationDescriptionPayload {
        Objects.requireNonNull(id);
    }
}
