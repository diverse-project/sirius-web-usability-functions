/*******************************************************************************
 * Copyright (c) 2021, 2023 Obeo.
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
package org.eclipse.sirius.components.collaborative.editingcontext;

import java.util.List;
import java.util.Objects;

import org.eclipse.sirius.components.annotations.Builder;
import org.eclipse.sirius.components.collaborative.api.IDanglingRepresentationDeletionService;
import org.eclipse.sirius.components.collaborative.api.IEditingContextEventHandler;
import org.eclipse.sirius.components.collaborative.api.IRepresentationEventProcessorComposedFactory;
import org.eclipse.sirius.components.collaborative.editingcontext.api.IEditingContextEventProcessorExecutorServiceProvider;
import org.eclipse.sirius.components.collaborative.messages.ICollaborativeMessageService;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextPersistenceService;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Parameters of the editing context event processor.
 *
 * @author sbegaudeau
 */
public record EditingContextEventProcessorParameters(
        ICollaborativeMessageService messageService,
        IEditingContext editingContext,
        IEditingContextPersistenceService editingContextPersistenceService,
        ApplicationEventPublisher applicationEventPublisher,
        List<IEditingContextEventHandler> editingContextEventHandlers,
        IRepresentationEventProcessorComposedFactory representationEventProcessorComposedFactory,
        IDanglingRepresentationDeletionService danglingRepresentationDeletionService,
        IEditingContextEventProcessorExecutorServiceProvider executorServiceProvider
) {
    public EditingContextEventProcessorParameters {
        Objects.requireNonNull(messageService);
        Objects.requireNonNull(editingContext);
        Objects.requireNonNull(editingContextPersistenceService);
        Objects.requireNonNull(applicationEventPublisher);
        Objects.requireNonNull(editingContextEventHandlers);
        Objects.requireNonNull(representationEventProcessorComposedFactory);
        Objects.requireNonNull(danglingRepresentationDeletionService);
        Objects.requireNonNull(executorServiceProvider);
    }

    public static EditingContextEventProcessorParametersBuilder newEditingContextEventProcessorParameters() {
        return new EditingContextEventProcessorParametersBuilder();
    }

    /**
     * The builder used to create the parameters.
     *
     * @author sbegaudeau
     */
    @Builder
    @SuppressWarnings("checkstyle:HiddenField")
    public static final class EditingContextEventProcessorParametersBuilder {
        private ICollaborativeMessageService messageService;

        private IEditingContext editingContext;

        private IEditingContextPersistenceService editingContextPersistenceService;

        private ApplicationEventPublisher applicationEventPublisher;

        private List<IEditingContextEventHandler> editingContextEventHandlers;

        private IRepresentationEventProcessorComposedFactory representationEventProcessorComposedFactory;

        private IDanglingRepresentationDeletionService danglingRepresentationDeletionService;

        private IEditingContextEventProcessorExecutorServiceProvider executorServiceProvider;

        private EditingContextEventProcessorParametersBuilder() {
            // Prevent instantiation
        }

        public EditingContextEventProcessorParametersBuilder messageService(ICollaborativeMessageService messageService) {
            this.messageService = Objects.requireNonNull(messageService);
            return this;
        }

        public EditingContextEventProcessorParametersBuilder editingContext(IEditingContext editingContext) {
            this.editingContext = Objects.requireNonNull(editingContext);
            return this;
        }

        public EditingContextEventProcessorParametersBuilder editingContextPersistenceService(IEditingContextPersistenceService editingContextPersistenceService) {
            this.editingContextPersistenceService = Objects.requireNonNull(editingContextPersistenceService);
            return this;
        }

        public EditingContextEventProcessorParametersBuilder applicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
            this.applicationEventPublisher = Objects.requireNonNull(applicationEventPublisher);
            return this;
        }

        public EditingContextEventProcessorParametersBuilder editingContextEventHandlers(List<IEditingContextEventHandler> editingContextEventHandlers) {
            this.editingContextEventHandlers = Objects.requireNonNull(editingContextEventHandlers);
            return this;
        }

        public EditingContextEventProcessorParametersBuilder representationEventProcessorComposedFactory(IRepresentationEventProcessorComposedFactory representationEventProcessorComposedFactory) {
            this.representationEventProcessorComposedFactory = Objects.requireNonNull(representationEventProcessorComposedFactory);
            return this;
        }

        public EditingContextEventProcessorParametersBuilder danglingRepresentationDeletionService(IDanglingRepresentationDeletionService danglingRepresentationDeletionService) {
            this.danglingRepresentationDeletionService = Objects.requireNonNull(danglingRepresentationDeletionService);
            return this;
        }

        public EditingContextEventProcessorParametersBuilder executorServiceProvider(IEditingContextEventProcessorExecutorServiceProvider executorServiceProvider) {
            this.executorServiceProvider = Objects.requireNonNull(executorServiceProvider);
            return this;
        }

        public EditingContextEventProcessorParameters build() {
            return new EditingContextEventProcessorParameters(
                    this.messageService,
                    this.editingContext,
                    this.editingContextPersistenceService,
                    this.applicationEventPublisher,
                    this.editingContextEventHandlers,
                    this.representationEventProcessorComposedFactory,
                    this.danglingRepresentationDeletionService,
                    this.executorServiceProvider
            );
        }
    }
}
