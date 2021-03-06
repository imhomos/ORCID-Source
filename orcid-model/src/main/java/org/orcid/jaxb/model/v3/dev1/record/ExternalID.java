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
package org.orcid.jaxb.model.v3.dev1.record;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;
import org.orcid.jaxb.model.v3.dev1.common.TransientNonEmptyString;
import org.orcid.jaxb.model.v3.dev1.common.Url;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * New external identifier class
 * 
 * @author tom
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "type", "value", "normalized", "url", "relationship" })
public class ExternalID implements GroupAble, Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "external-id-type", namespace = "http://www.orcid.org/ns/common", required = true)
    protected String type;
    @XmlElement(name = "external-id-value", namespace = "http://www.orcid.org/ns/common", required = true)
    protected String value;
    @XmlElement(name = "external-id-normalized", namespace = "http://www.orcid.org/ns/common")
    protected TransientNonEmptyString normalized;
    @XmlElement(name = "external-id-url", namespace = "http://www.orcid.org/ns/common")
    protected Url url;
    @XmlElement(name = "external-id-relationship", namespace = "http://www.orcid.org/ns/common")
    protected Relationship relationship;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TransientNonEmptyString getNormalized() {
        return normalized;
    }

    public void setNormalized(TransientNonEmptyString normalized) {
        this.normalized = normalized;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    /**
     * If we have a normalized value, use that to generate Group ID;
     */
    @Override
    @JsonIgnore
    public String getGroupId() {
        String workIdVal = null;
        if (this.getNormalized() != null && !StringUtils.isEmpty(this.getNormalized().getValue())) {
            workIdVal = this.getNormalized().getValue();
        } else {
            workIdVal = this.value == null ? null : this.value;
        }
        String typeVal = this.type == null ? null : this.type;
        return workIdVal + typeVal;
    }

    @Override
    @JsonIgnore
    public boolean isGroupAble() {
        // Dont group if it is a part-of identifier
        if (Relationship.PART_OF.equals(relationship))
            return false;

        // Dont groups works where the external id is empty
        if (this.getValue() == null || this.getValue().isEmpty())
            return false;

        return true;
    }

    public static ExternalID fromMessageExtId(org.orcid.jaxb.model.message.WorkExternalIdentifier oldExtId) {
        ExternalID id = new ExternalID();
        id.setType(oldExtId.getWorkExternalIdentifierType().value());
        id.setValue(oldExtId.getWorkExternalIdentifierId().getContent());
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        if (this.getNormalized() != null && !StringUtils.isEmpty(this.getNormalized().getValue())) {
            result = prime * result + this.getNormalized().hashCode();
        } else {
            result = prime * result + ((value == null) ? 0 : value.hashCode());
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ExternalID other = (ExternalID) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (this.getNormalized() != null && !StringUtils.isEmpty(this.getNormalized().getValue())) {
            // if we have a normalized value, use that.
            if (!getNormalized().equals(other.getNormalized()))
                return false;
        } else {
            // otherwise check the provided value
            if (value == null) {
                if (other.value != null)
                    return false;
            } else if (!value.equals(other.value))
                return false;
        }
        return true;
    }

    public ExternalID clone() {
        ExternalID id = new ExternalID();
        id.type = this.getType();
        id.value = this.getValue();
        if (this.getNormalized() != null)
            id.setNormalized(this.getNormalized());
        if (this.getUrl() != null)
            id.url = new Url(this.getUrl().getValue());
        if (this.getRelationship() != null)
            id.relationship = this.getRelationship();
        return id;
    }

    @Override
    public String toString() {
        return "ExternalID [type=" + type + ", value=" + value + ", normalized=" + normalized + ", url=" + url + ", relationship=" + relationship + "]";
    }

}
