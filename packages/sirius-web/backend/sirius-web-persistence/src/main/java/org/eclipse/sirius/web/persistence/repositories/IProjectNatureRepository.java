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
package org.eclipse.sirius.web.persistence.repositories;

import java.util.List;
import java.util.UUID;

import org.eclipse.sirius.components.annotations.Audited;
import org.eclipse.sirius.web.persistence.entities.ProjectNatureEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * * Persistence layer used to manipulate project's nature.
 *
 * @author frouene
 */
@Repository
public interface IProjectNatureRepository extends PagingAndSortingRepository<ProjectNatureEntity, UUID>, ListCrudRepository<ProjectNatureEntity, UUID> {

    @Audited
    @Override
    <S extends ProjectNatureEntity> S save(S projectNatureEntity);

    @Audited
    List<ProjectNatureEntity> findAllByProjectId(UUID projectId);

}
