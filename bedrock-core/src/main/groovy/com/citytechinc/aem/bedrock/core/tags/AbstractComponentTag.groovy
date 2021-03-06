package com.citytechinc.aem.bedrock.core.tags

import com.citytechinc.aem.bedrock.api.node.ComponentNode
import org.apache.sling.api.resource.Resource

import javax.servlet.jsp.tagext.TagSupport

import static org.apache.sling.scripting.jsp.taglib.DefineObjectsTag.DEFAULT_RESOURCE_NAME

abstract class AbstractComponentTag extends TagSupport {

    /**
     * Should property value be inherited? Defaults to false.
     */
    private String inherit

    final void setInherit(String inherit) {
        this.inherit = inherit
    }

    protected final ComponentNode getComponentNode() {
        def resource = pageContext.getAttribute(DEFAULT_RESOURCE_NAME) as Resource

        resource.adaptTo(ComponentNode)
    }

    protected final boolean isInherit() {
        Boolean.valueOf(inherit)
    }
}
