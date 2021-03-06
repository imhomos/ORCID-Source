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
package org.orcid.frontend.web.pagination;

import java.io.Serializable;
import java.util.List;

import org.orcid.pojo.WorkGroup;

public class WorksPage implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int nextOffset;
    
    private int totalGroups;
    
    private List<WorkGroup> workGroups;

    public List<WorkGroup> getWorkGroups() {
        return workGroups;
    }

    public void setWorkGroups(List<WorkGroup> workGroups) {
        this.workGroups = workGroups;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(int nextOffset) {
        this.nextOffset = nextOffset;
    }

    public int getTotalGroups() {
        return totalGroups;
    }

    public void setTotalGroups(int totalGroups) {
        this.totalGroups = totalGroups;
    }

}
