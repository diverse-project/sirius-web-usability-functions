/*******************************************************************************
 * Copyright (c) 2019, 2023 Obeo.
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
package org.eclipse.sirius.web.graphql.datafetchers.editingcontext;

import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.eclipse.sirius.components.annotations.spring.graphql.QueryDataFetcher;
import org.eclipse.sirius.components.collaborative.api.IEditingContextEventProcessorRegistry;
import org.eclipse.sirius.components.collaborative.api.RepresentationDescriptionMetadata;
import org.eclipse.sirius.components.collaborative.dto.EditingContextRepresentationDescriptionsInput;
import org.eclipse.sirius.components.collaborative.dto.EditingContextRepresentationDescriptionsPayload;
import org.eclipse.sirius.components.graphql.api.IDataFetcherWithFieldCoordinates;
import org.eclipse.sirius.web.graphql.pagination.PageInfoWithCount;

import graphql.relay.Connection;
import graphql.relay.ConnectionCursor;
import graphql.relay.DefaultConnection;
import graphql.relay.DefaultConnectionCursor;
import graphql.relay.DefaultEdge;
import graphql.relay.DefaultPageInfo;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import reactor.core.publisher.Mono;

/**
 * The data fetcher used to retrieve the representation descriptions accessible to a viewer.
 *
 * @author pcdavid
 * @author sbegaudeau
 */
@QueryDataFetcher(type = "EditingContext", field = "representationDescriptions")
public class EditingContextRepresentationDescriptionsDataFetcher implements IDataFetcherWithFieldCoordinates<CompletableFuture<Connection<RepresentationDescriptionMetadata>>> {

    private static final String OBJECT_ID_ARGUMENT = "objectId";

    private final IEditingContextEventProcessorRegistry editingContextEventProcessorRegistry;

    public EditingContextRepresentationDescriptionsDataFetcher(IEditingContextEventProcessorRegistry editingContextEventProcessorRegistry) {
        this.editingContextEventProcessorRegistry = Objects.requireNonNull(editingContextEventProcessorRegistry);
    }

    @Override
    public CompletableFuture<Connection<RepresentationDescriptionMetadata>> get(DataFetchingEnvironment environment) throws Exception {
        String editingContextId = environment.getSource();
        String objectId = environment.getArgument(OBJECT_ID_ARGUMENT);

        EditingContextRepresentationDescriptionsInput input = new EditingContextRepresentationDescriptionsInput(UUID.randomUUID(), editingContextId, objectId);

        // @formatter:off
        return this.editingContextEventProcessorRegistry.dispatchEvent(input.editingContextId(), input)
                .filter(EditingContextRepresentationDescriptionsPayload.class::isInstance)
                .map(EditingContextRepresentationDescriptionsPayload.class::cast)
                .map(this::toConnection)
                .switchIfEmpty(Mono.just(new DefaultConnection<>(List.of(), new DefaultPageInfo(null, null, false, false))))
                .toFuture();
        // @formatter:on
    }

    private Connection<RepresentationDescriptionMetadata> toConnection(EditingContextRepresentationDescriptionsPayload payload) {
        // @formatter:off
        List<Edge<RepresentationDescriptionMetadata>> representationDescriptionEdges = payload.representationDescriptions().stream()
                .map(representationDescription -> {
                    String value = Base64.getEncoder().encodeToString(representationDescription.getId().getBytes());
                    ConnectionCursor cursor = new DefaultConnectionCursor(value);
                    Edge<RepresentationDescriptionMetadata> edge = new DefaultEdge<>(representationDescription, cursor);
                    return edge;
                })
                .toList();
        // @formatter:on

        ConnectionCursor startCursor = representationDescriptionEdges.stream().findFirst().map(Edge::getCursor).orElse(null);
        ConnectionCursor endCursor = null;
        if (!representationDescriptionEdges.isEmpty()) {
            endCursor = representationDescriptionEdges.get(representationDescriptionEdges.size() - 1).getCursor();
        }
        PageInfo pageInfo = new PageInfoWithCount(startCursor, endCursor, false, false, payload.representationDescriptions().size());
        return new DefaultConnection<>(representationDescriptionEdges, pageInfo);
    }

}
