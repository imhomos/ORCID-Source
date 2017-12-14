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
package org.orcid.frontend.web.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class AssetDirective implements TemplateDirectiveModel {

    //https://freemarker.apache.org/docs/pgui_datamodel_directive.html
    
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Iterator paramIter = params.entrySet().iterator();
        while (paramIter.hasNext()) {
            Map.Entry ent = (Map.Entry) paramIter.next();

            String paramName = (String) ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();
            System.out.println(paramValue.toString());
        }
    }

    public static class AssetUrlGeneratorWriter extends Writer {

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void flush() throws IOException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void close() throws IOException {
            // TODO Auto-generated method stub
            
        }
        
    }
}
