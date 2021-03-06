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
package org.orcid.utils.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;

public class BaseMessageTest {

    @SuppressWarnings("deprecation")
    @Test
    public void testEquals(){
        Date now = new Date();
        LastModifiedMessage lm1 = new LastModifiedMessage("blah", now);
        LastModifiedMessage lm2 = new LastModifiedMessage("blah", now);
        RetryMessage rm1 = new RetryMessage("blah", "2");
        BaseMessage rm2 = new RetryMessage("blah", "2");
        
        assertEquals(lm1,lm2);
        assertEquals(lm2,lm1);
        assertEquals(rm1,rm2);
        assertEquals(rm2,rm1);
        
        Date then = new Date();
        then.setYear(1900);
        LastModifiedMessage lm3 = new LastModifiedMessage("blah", then);
        assertNotEquals(lm1,lm3);

        RetryMessage rm3 = new RetryMessage(lm1.getMap());
        assertNotEquals(lm1,rm3);   
    }
}
