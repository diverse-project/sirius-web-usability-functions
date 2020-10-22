/*******************************************************************************
 * Copyright (c) 2019, 2020 Obeo.
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
package org.eclipse.sirius.web.spring.collaborative.forms.handlers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

import org.eclipse.sirius.web.collaborative.forms.api.IFormService;
import org.eclipse.sirius.web.collaborative.forms.api.dto.EditRadioInput;
import org.eclipse.sirius.web.forms.AbstractWidget;
import org.eclipse.sirius.web.forms.Form;
import org.eclipse.sirius.web.forms.Group;
import org.eclipse.sirius.web.forms.Page;
import org.eclipse.sirius.web.forms.Radio;
import org.eclipse.sirius.web.forms.RadioOption;
import org.eclipse.sirius.web.representations.Status;
import org.junit.Test;

/**
 * Unit tests of the edit radio event handler.
 *
 * @author sbegaudeau
 */
public class EditRadioEventHandlerTestCases {
    private static final UUID FORM_ID = UUID.randomUUID();

    @Test
    public void testRadioEdition() {
        String id = "Radio id"; //$NON-NLS-1$

        var input = new EditRadioInput(UUID.randomUUID(), FORM_ID, id, "optionId"); //$NON-NLS-1$

        AtomicBoolean hasBeenExecuted = new AtomicBoolean();
        Function<String, Status> newValueHandler = newValue -> {
            hasBeenExecuted.set(true);
            return Status.OK;
        };

        // @formatter:off
        RadioOption option = RadioOption.newRadioOption("optionId") //$NON-NLS-1$
                .label("Option label") //$NON-NLS-1$
                .selected(false)
                .build();

        Radio radio = Radio.newRadio(id)
                .label("label") //$NON-NLS-1$
                .newValueHandler(newValueHandler)
                .options(List.of(option))
                .build();

        Group group = Group.newGroup("groupId") //$NON-NLS-1$
                .label("group label") //$NON-NLS-1$
                .widgets(List.of(radio))
                .build();

        Page page = Page.newPage("pageId") //$NON-NLS-1$
                .label("page label") //$NON-NLS-1$
                .groups(List.of(group))
                .build();

        Form form = Form.newForm(FORM_ID)
                .targetObjectId("targetObjectId") //$NON-NLS-1$
                .label("form label") //$NON-NLS-1$
                .pages(List.of(page))
                .build();
        // @formatter:on

        IFormService formService = new NoOpFormService() {
            @Override
            public Optional<AbstractWidget> findWidget(Form form, String widgetId) {
                return Optional.of(radio);
            }
        };
        EditRadioEventHandler handler = new EditRadioEventHandler(formService, new NoOpCollaborativeFormMessageService());

        assertThat(handler.canHandle(input)).isTrue();

        handler.handle(form, input);
        assertThat(hasBeenExecuted.get()).isTrue();
    }
}