/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.persistence.dao;

import org.orcid.persistence.jpa.entities.OrgDisambiguatedExternalIdentifierEntity;

public interface OrgDisambiguatedExternalIdentifierDao extends GenericDao<OrgDisambiguatedExternalIdentifierEntity, Long> {

    OrgDisambiguatedExternalIdentifierEntity findByDetails(Long orgDisambiguatedId, String identifier, String identifierType);
    
    boolean exists(Long orgDisambiguatedId, String identifier, String identifierType);    
}
