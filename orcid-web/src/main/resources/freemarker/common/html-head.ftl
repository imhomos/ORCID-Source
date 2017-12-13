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
<head>
    <meta charset="utf-8" />
    <title>${title!"ORCID"}</title>
    <meta name="description" content="">
    <meta name="author" content="ORCID">
    <meta name="_csrf" content="${(_csrf.token)!}"/>
    <meta name="_csrf_header" content="${(_csrf.headerName)!}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    
    <#if (noIndex)??>
    <meta name="googlebot" content="noindex">
    <meta name="robots" content="noindex">
    <meta name="BaiduSpider" content="noindex">
    </#if>
    
    <#include "/layout/google_analytics.ftl">
    
    <script type="text/javascript">
        var orcidVar = {};
        orcidVar.recaptchaKey = '${recaptchaWebKey}';
        orcidVar.baseDomainRmProtocall = '${baseDomainRmProtocall}';
        orcidVar.baseUri = '${baseUri}';
        orcidVar.baseUriHttp = '${baseUriHttp}';
        orcidVar.pubBaseUri = '${pubBaseUri}';
        
        <#if (workIdsJson)??>
        orcidVar.workIds = JSON.parse("${workIdsJson}");
        </#if>
      
        <#if (affiliationIdsJson)??>
        orcidVar.affiliationIdsJson = JSON.parse("${affiliationIdsJson}");
        </#if>
      
        <#if (fundingIdsJson)??>
        orcidVar.fundingIdsJson = JSON.parse("${fundingIdsJson}");
        </#if>
      
        <#if (peerReviewIdsJson)??>       
        orcidVar.PeerReviewIds = JSON.parse("${peerReviewIdsJson}");
        </#if>      
      
        <#if (showLogin)??>
        orcidVar.showLogin = ${showLogin};
        </#if>

        orcidVar.orcidId = '${(effectiveUserOrcid)!}';
        orcidVar.lastModified = '${(lastModifiedTime)!}';
        orcidVar.orcidIdHash = '${(orcidIdHash)!}';
        orcidVar.realOrcidId = '${realUserOrcid!}';
        orcidVar.jsMessages = JSON.parse("${jsMessagesJson}");
        orcidVar.searchBaseUrl = "${searchBaseUrl}";
        orcidVar.isPasswordConfirmationRequired = ${isPasswordConfirmationRequired?c};
        orcidVar.emailVerificationManualEditEnabled = ${emailVerificationManualEditEnabled?c};
        orcidVar.version = "${ver}";
        orcidVar.knowledgeBaseUri = "${knowledgeBaseUri}";
      
        <#if (oauth2Screens)??>
        orcidVar.oauth2Screens = true;
        <#else>
        
        orcidVar.oauth2Screens = false;
        </#if>
      
        <#if (originalOauth2Process)??>
        orcidVar.originalOauth2Process = true;
        <#else>
        orcidVar.originalOauth2Process = false;
        </#if>     
      
        orcidVar.oauthUserId = "${(oauth_userId?js_string)!}";
        orcidVar.memberSlug = "${(memberSlug?js_string)!}";
    </script>

    <#include "/macros/orcid_ga.ftl">
    
    <link rel="stylesheet" href="<@spring.url '/static/css/noto-sans-googlefonts.css' />"/> <!-- Src: //fonts.googleapis.com/css?family=Noto+Sans:400,700 -->
    <link rel="stylesheet" href="<@spring.url '/static/css/glyphicons.css' />"/>
    <link rel="stylesheet" href="<@spring.url '/static/css/social.css' />"/>
    <link rel="stylesheet" href="<@spring.url '/static/css/filetypes.css' />"/>    
    
    <!-- Always remember to remove Glyphicons font reference when bootstrap is updated -->
    <link rel="stylesheet" href="<@spring.url '/static/twitter-bootstrap/3.3.6/css/bootstrap.min.css' />"/>
    
    <#if locale?? && (locale == 'rl' || locale == 'ar' )>
    <!-- just a prototype to show what RTL, expect to switch the cdn to ours -->
    <!-- Load Bootstrap RTL theme from RawGit -->
    <link rel="stylesheet" href="<@spring.url '/static/css/bootstrap-rtl.min.css' />"> <!-- Src: //cdn.rawgit.com/morteza/bootstrap-rtl/v3.3.4/dist/css/bootstrap-rtl.min.css -->
    </#if>

    <link rel="stylesheet" href="<@spring.url '/static/css/orcid.new.css' />"/>
    <link rel="stylesheet" href="<@spring.url '/static/css/idpselect.css' />" />
    
    <#if springMacroRequestContext.requestUri?contains("/print")>
    <link rel="stylesheet" href="<@spring.url '/static/css/orcid-print.css' />"/>
    </#if>

    <link rel="stylesheet" href="<@spring.url '/static/css/jquery-ui-1.10.0.custom.min.css' />"/>
    
    <!-- this is a manually patched version, we should update when they accept our changes -->
    <script src="<@spring.url '/static/javascript/respond.src.js' />"></script>
    
    <!-- Respond.js proxy on external server -->
    <link href="<@spring.url '/static/html/respond-proxy.html' />" id="respond-proxy" rel="respond-proxy" />
    <link href="<@spring.url '/static/img/respond.proxy.gif' />" id="respond-redirect" rel="respond-redirect" />
    <script src="<@spring.url '/static/javascript/respond.proxy.js' />"></script>
        
    <style type="text/css">
        /* 
        Allow angular.js to be loaded in body, hiding cloaked elements until 
        templates compile.  The !important is important given that there may be 
        other selectors that are more specific or come later and might alter display.  
         */
        [ng\:cloak], [ng-cloak], .ng-cloak {
            display: none !important;
        }
    </style>    

    <link rel="shortcut icon" href="<@spring.url '/static/img/favicon.ico' />"/>
    <link rel="apple-touch-icon" href="<@spring.url '/static/img/apple-touch-icon.png' />" />  
    <link rel="stylesheet" href="<@spring.url '/static/css/noto-font.css' />"/> 

    <!-- ***************************************************** -->
    <!-- Ng2 Templates - BEGIN -->


    <@orcid.checkFeatureStatus 'ANGULAR2_DEV'> 
    <!-- NG2: Under development -->
    <#if springMacroRequestContext.requestUri?contains("/my-orcid") >
        <#include "/includes/ng2_templates/affiliation-ng2-template.ftl">
        <#include "/includes/ng2_templates/funding-ng2-template.ftl">
    </#if>
    </@orcid.checkFeatureStatus> 

    <!-- NG2: QA -->
    <@orcid.checkFeatureStatus 'ANGULAR2_QA'> 
    <#if springMacroRequestContext.requestUri?contains("/my-orcid") >
        <#include "/includes/ng2_templates/also-known-as-ng2-template.ftl">
        <#include "/includes/ng2_templates/also-known-as-form-ng2-template.ftl">
        <#include "/includes/ng2_templates/country-form-ng2-template.ftl">
        <#include "/includes/ng2_templates/country-ng2-template.ftl">
    </#if>
    </@orcid.checkFeatureStatus> 

    <#if springMacroRequestContext.requestUri?contains("/account") >
        <#include "/includes/ng2_templates/works-privacy-preferences-ng2-template.ftl">
    </#if>

    <#if springMacroRequestContext.requestUri?contains("/my-orcid") >
        
        <#include "/includes/ng2_templates/biography-ng2-template.ftl">
        
        <#include "/includes/ng2_templates/email-unverified-warning-ng2-template.ftl">
        <#include "/includes/ng2_templates/email-verification-sent-messsage-ng2-template.ftl">
        <#include "/includes/ng2_templates/keywords-form-ng2-template.ftl">
        <#include "/includes/ng2_templates/keywords-ng2-template.ftl">
        <#include "/includes/ng2_templates/modal-ng2-template.ftl">
        <#include "/includes/ng2_templates/thanks-for-registering-ng2-template.ftl">
        <#include "/includes/ng2_templates/thanks-for-verifying-ng2-template.ftl">
    </#if>

    <#if springMacroRequestContext.requestUri?contains("/account") || springMacroRequestContext.requestUri?contains("/developer-tools") || springMacroRequestContext.requestUri?contains("/inbox") || springMacroRequestContext.requestUri?contains("/my-orcid")>
        <#include "/includes/ng2_templates/name-ng2-template.ftl">
        <#include "/includes/ng2_templates/privacy-toggle-ng2-template.ftl">
        <#include "/includes/ng2_templates/widget-ng2-template.ftl">
    </#if>

    <!-- Ng2 Templates - END -->
    <!-- ***************************************************** -->
</head>
