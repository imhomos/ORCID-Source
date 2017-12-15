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
package org.orcid.core.analytics;

public enum AnalyticsEventCategory {
    
    ORCID_PROFILE("orcid-profile"),
    RECORD("record"),
    OAUTH("oauth"),
    WORK("work"),
    SEARCH("search"),
    WORKS("works"),
    PERSON("person"),
    ORCID_BIO("orcid-bio"),
    FUNDING("funding"),
    ORCID_WORKS("orcid-works"),
    CLIENT("client"),
    NOTIFICATION_PERMISSION("notification-permission"),
    ACTIVITIES("activities"),
    PEER_REVIEWS("peer-reviews"),
    EXTERNAL_IDENTIFERS("external-identifiers"),
    AFFILIATIONS("affiliations"),
    RESEARCHER_URLS("researcher-urls"),
    EMPLOYMENTS("employments"),
    EDUCATIONS("educations"),
    PEER_REVIEW("peer-review"),
    RESOURCES("resources"),
    PERSONAL_DETAILS("personal-details"),
    GROUP_ID_RECORD("group-id-record"),
    EMPLOYMENT("employment"),
    WEBHOOK("webhook"),
    FUNDINGS("fundings"),
    EDUCATION("education"),
    KEYWORDS("keywords"),
    EMAIL("email"),
    OTHER_NAMES("other-names"),
    ADDRESS("address"),
    BIOGRAPHY("biography");
    
    private final String value;
    
    AnalyticsEventCategory(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

}
