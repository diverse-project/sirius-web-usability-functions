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
package org.eclipse.sirius.components.starter.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * This POJO will contain the list of all the configuration properties provided by Sirius Components.
 *
 * @author sbegaudeau
 */
@ConfigurationProperties(prefix = "sirius.components")
public class SiriusComponentsConfigurationProperties {
    @NestedConfigurationProperty
    private final CorsConfigurationProperty cors;

    @NestedConfigurationProperty
    private final EditingContextConfigurationProperty editingContext;

    @NestedConfigurationProperty
    private final ImageRegistryConfigurationProperty imageRegistry;

    public SiriusComponentsConfigurationProperties(CorsConfigurationProperty cors, EditingContextConfigurationProperty editingContext, ImageRegistryConfigurationProperty imageRegistry) {
        this.cors = cors;
        this.editingContext = editingContext;
        this.imageRegistry = imageRegistry;
    }

    public CorsConfigurationProperty getCors() {
        return this.cors;
    }

    public EditingContextConfigurationProperty getEditingContext() {
        return this.editingContext;
    }

    public ImageRegistryConfigurationProperty getImageRegistry() {
        return this.imageRegistry;
    }
}
