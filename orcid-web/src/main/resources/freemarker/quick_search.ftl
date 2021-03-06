<#--

    =============================================================================

    ORCID (R) Open Source
    http://orcid.org

    Copyright (c) 2012-2014 ORCID, Inc.
    Licensed under an MIT-Style License (MIT)
    http://orcid.org/open-source-license

    This copyright and license information (including a link to the full license)
    shall be included in its entirety in all copies or substantial portion of
    the software.

    =============================================================================

-->
<@public classes=['home']>
<@orcid.checkFeatureStatus featureName='HTTPS_IDS'>
    <div class="row" ng-controller="SearchCtrlV2" id="SearchCtrl" data-search-query="${searchQuery?html}">
</@orcid.checkFeatureStatus>
<@orcid.checkFeatureStatus featureName='HTTPS_IDS' enabled=false>
    <div class="row" ng-controller="SearchCtrl" id="SearchCtrl" data-search-query="${searchQuery?html}">
</@orcid.checkFeatureStatus>
    <div class="centered">
        <span id="ajax-loader-search" class="orcid-hide"><i class="glyphicon glyphicon-refresh spin x2 green"></i></span>
    </div>
	<div class="col-md-12">
		<#if noResultsFound??>
			<!-- no results -->
			<div id="no-results-alert" class="orcid-hide alert alert-error"><@spring.message "orcid.frontend.web.no_results"/></div>
		<#else>
			<#include "includes/search/search_results.ftl"/>
		</#if>
	</div>
</div>

</@public>